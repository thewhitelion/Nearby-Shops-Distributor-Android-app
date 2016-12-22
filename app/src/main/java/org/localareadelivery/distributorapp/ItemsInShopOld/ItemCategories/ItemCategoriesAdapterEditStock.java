package org.localareadelivery.distributorapp.ItemsInShopOld.ItemCategories;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.localareadelivery.distributorapp.DaggerComponentBuilder;
import org.localareadelivery.distributorapp.Model.ItemCategory;
import org.localareadelivery.distributorapp.R;
import org.localareadelivery.distributorapp.RetrofitRESTContract.ItemCategoryService;
import org.localareadelivery.distributorapp.Utility.UtilityGeneral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sumeet on 19/12/15.
 */


public class ItemCategoriesAdapterEditStock extends RecyclerView.Adapter<ItemCategoriesAdapterEditStock.ViewHolder>{


    Map<Integer,ItemCategory> selectedItems = new HashMap<>();


    @Inject
    ItemCategoryService itemCategoryService;

    private List<ItemCategory> dataset;
    private Context context;
    private ItemCategoriesFragmentEditStock activity;
    private ItemCategory requestedChangeParent = null;
    private ReceiveNotificationsFromAdapter notificationReceiver;


    final String IMAGE_ENDPOINT_URL = "/api/Images";

    public ItemCategoriesAdapterEditStock(List<ItemCategory> dataset, Context context, ItemCategoriesFragmentEditStock activity, ReceiveNotificationsFromAdapter notificationReceiver) {


        DaggerComponentBuilder.getInstance()
                .getNetComponent().Inject(this);


        this.notificationReceiver = notificationReceiver;
        this.dataset = dataset;
        this.context = context;
        this.activity = activity;

        if(this.dataset == null)
        {
            this.dataset = new ArrayList<ItemCategory>();
        }

    }

    @Override
    public ItemCategoriesAdapterEditStock.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_item_category_edit_stock,parent,false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ItemCategoriesAdapterEditStock.ViewHolder holder, final int position) {


        holder.categoryName.setText(String.valueOf(dataset.get(position).getCategoryName()));
        holder.categoryDescription.setText(dataset.get(position).getDescriptionShort());


        if(selectedItems.containsKey(dataset.get(position).getItemCategoryID()))
        {
            holder.itemCategoryListItem.setBackgroundColor(context.getResources().getColor(R.color.gplus_color_2));
        }
        else
        {
            holder.itemCategoryListItem.setBackgroundColor(context.getResources().getColor(R.color.white));
        }



        String imagePath = UtilityGeneral.getImageEndpointURL(context)
                + dataset.get(position).getImagePath();

        Drawable placeholder = VectorDrawableCompat
                .create(context.getResources(),
                        R.drawable.ic_nature_people_white_48px, context.getTheme());

        Picasso.with(context).load(imagePath)
                .placeholder(placeholder)
                .into(holder.categoryImage);

    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);


    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements PopupMenu.OnMenuItemClickListener {


        private TextView categoryName,categoryDescription;

        @Bind(R.id.itemCategoryListItem) LinearLayout itemCategoryListItem;

        @Bind(R.id.categoryImage) ImageView categoryImage;

        @Bind(R.id.cardview)
        CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

            categoryImage = (ImageView) itemView.findViewById(R.id.categoryImage);
            categoryName = (TextView) itemView.findViewById(R.id.categoryName);
            categoryDescription = (TextView) itemView.findViewById(R.id.categoryDescription);

            itemCategoryListItem = (LinearLayout) itemView.findViewById(R.id.itemCategoryListItem);
        }






        @OnClick(R.id.itemCategoryListItem)
        public void itemCategoryListItemClick()
        {

            if (dataset == null) {

                return;
            }

            if(dataset.size()==0)
            {
                return;
            }

            notificationReceiver.notifyRequestSubCategory(dataset.get(getLayoutPosition()));
            selectedItems.clear();
        }





        @OnClick(R.id.more_options)
        void optionsOverflowClick(View v)
        {
            PopupMenu popup = new PopupMenu(context, v);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.item_category_item_overflow, popup.getMenu());
            popup.setOnMenuItemClickListener(this);
            popup.show();
        }


        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId())
            {


            }

            return false;
        }



    }// ViewHolderOrder Class declaration ends




    void showToastMessage(String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }




    public interface ReceiveNotificationsFromAdapter
    {
        // method for notifying the list object to request sub category
        public void notifyRequestSubCategory(ItemCategory itemCategory);
        public void notifyItemCategorySelected();
    }
}