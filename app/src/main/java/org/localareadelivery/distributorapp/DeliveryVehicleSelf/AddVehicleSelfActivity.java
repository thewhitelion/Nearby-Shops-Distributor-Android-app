package org.localareadelivery.distributorapp.DeliveryVehicleSelf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.localareadelivery.distributorapp.ApplicationState.ApplicationState;
import org.localareadelivery.distributorapp.DaggerComponentBuilder;
import org.localareadelivery.distributorapp.Model.Shop;
import org.localareadelivery.distributorapp.ModelStats.DeliveryVehicleSelf;
import org.localareadelivery.distributorapp.R;
import org.localareadelivery.distributorapp.RetrofitRESTContract.VehicleSelfService;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddVehicleSelfActivity extends AppCompatActivity implements View.OnClickListener, Callback<DeliveryVehicleSelf> {

    DeliveryVehicleSelf deliveryVehicleSelf;

    @Inject
    VehicleSelfService vehicleSelfService;

    TextView addVehicleSelf;

    // address Fields


    @Bind(R.id.vehicleName)
    EditText vehicleName;




    public AddVehicleSelfActivity() {

        DaggerComponentBuilder.getInstance()
                .getNetComponent().Inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle_self);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Bind Views

        addVehicleSelf = (TextView) findViewById(R.id.addVehicleSelf);

        addVehicleSelf.setOnClickListener(this);


    }



    void getDataFromViews()
    {


        Shop shop = ApplicationState.getInstance().getCurrentShop();

        deliveryVehicleSelf = new DeliveryVehicleSelf();

        deliveryVehicleSelf.setVehicleName(vehicleName.getText().toString());
        deliveryVehicleSelf.setShopID(shop.getShopID());

    }


    @Override
    public void onClick(View v) {

        getDataFromViews();


        if(deliveryVehicleSelf !=null)
        {
            Call<DeliveryVehicleSelf> call = vehicleSelfService.postVehicle(deliveryVehicleSelf);

            call.enqueue(this);

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);

    }




    void showToastMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(Call<DeliveryVehicleSelf> call, Response<DeliveryVehicleSelf> response) {


        if (response != null && response.code() == 201) {
            showToastMessage("Added Successfully !");
        }
        else
        {
            showToastMessage("Unsuccessful !");
        }

    }

    @Override
    public void onFailure(Call<DeliveryVehicleSelf> call, Throwable t) {

        showToastMessage("Add Vehicle Failed. Try again !");

    }
}
