package org.localareadelivery.distributorapp.PickFromShopInventory;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.localareadelivery.distributorapp.OrderHistoryHD.PlaceholderFragment;
import org.localareadelivery.distributorapp.PickFromShopInventory.Confirmed.ConfirmedOrdersFragmentPFS;
import org.localareadelivery.distributorapp.PickFromShopInventory.Packed.PackedOrdersFragmentPFS;
import org.localareadelivery.distributorapp.PickFromShopInventory.Placed.PlacedOrdersFragmentPFS;

/**
 * Created by sumeet on 23/12/16.
 */


public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        if(position==0)
        {
            return PlacedOrdersFragmentPFS.newInstance();
        }
        else if(position==1)
        {
            return ConfirmedOrdersFragmentPFS.newInstance();
        }
        else if(position==2)
        {
            return PackedOrdersFragmentPFS.newInstance();
        }


        return PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return titlePlaced;
            case 1:
                return titleConfirmed;
            case 2:
                return titlePacked;
        }
        return null;
    }


    private String titlePlaced = "Placed (0/0)";
    private String titleConfirmed = "Confirmed (0/0)";
    private String titlePacked = "Packed (0/0)";


    public void setTitle(String title, int tabPosition)
    {
        if(tabPosition == 0){

            titlePlaced = title;
        }
        else if (tabPosition == 1)
        {

            titleConfirmed = title;
        }
        else if(tabPosition==2)
        {
            titlePacked = title;
        }

        notifyDataSetChanged();
    }



}
