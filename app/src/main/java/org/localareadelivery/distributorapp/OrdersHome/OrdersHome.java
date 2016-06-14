package org.localareadelivery.distributorapp.OrdersHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import org.localareadelivery.distributorapp.DeliveryVehicleSelf.DeliveryVehicleActivity;
import org.localareadelivery.distributorapp.OrdersHomeDelivery.HomeDelivery;
import org.localareadelivery.distributorapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrdersHome extends AppCompatActivity {


    RelativeLayout ordersHomeDelivery;
    RelativeLayout orderDeliveryVehicles;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_home);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @OnClick(R.id.order_home_delivery)
    void homeDeliveryClick()
    {
        this.startActivity(new Intent(this, HomeDelivery.class));
    }


    @OnClick(R.id.order_edit_delivery_vehicles)
    void deliveryVehiclesClick(View view)
    {
        Intent intent = new Intent(this, DeliveryVehicleActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }
}