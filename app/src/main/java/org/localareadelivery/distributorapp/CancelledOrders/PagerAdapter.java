package org.localareadelivery.distributorapp.CancelledOrders;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.localareadelivery.distributorapp.CancelledOrders.CancelledByShop.FragmentCancelledByShop;
import org.localareadelivery.distributorapp.CancelledOrders.ReturnedByDeliveryGuy.FragmentReturnedByDG;
import org.localareadelivery.distributorapp.DeliveryGuyDashboard.OutForDelivery.PendingHandoverFragment;
import org.localareadelivery.distributorapp.DeliveryGuyDashboard.PendingHandover.PendingAcceptFragment;

/**
 * Created by sumeet on 15/11/16.
 */

public class PagerAdapter extends FragmentPagerAdapter {


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a AccountsSelectionFragment (defined as a static inner class below).

        if(position==0)
        {
            return FragmentReturnedByDG.newInstance();

        }else if(position == 1)
        {
            return FragmentCancelledByShop.newInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {

            case 0:
                return titleReturnedByDG;
            case 1:
                return titleCancelledByShop;
            case 2:
                return titleCancelledByEndUser;
        }
        return null;
    }



    private String titleReturnedByDG = "Returned By Delivery ( 0/0 )";
    private String titleCancelledByShop = "Cancelled By Shop ( 0/0 )";
    private String titleCancelledByEndUser = "Cancelled By End-User ( 0/0 )";


    public void setTitle(String title, int tabPosition)
    {
        if(tabPosition == 0){

            titleReturnedByDG = title;
        }
        else if (tabPosition == 1)
        {
            titleCancelledByShop = title;

        }
        else if(tabPosition == 2)
        {
            titleCancelledByEndUser = title;
        }

        notifyDataSetChanged();
    }



}
