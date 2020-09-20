package com.example.communicatingwithdeviceandroidwear;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Element;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.Wearable;

public class PhoneActivity extends AppCompatActivity implements DataApi.DataListener, GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {



    GoogleApiClient googleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        googleApiClient = new GoogleApiClient.Builder(this).addApi(Wearable.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onDataChanged(DataEventBuffer dataEventBuffer) {

        for(DataEvent event : dataEventBuffer){
            if(event.getType()== DataEvent.TYPE_CHANGED){
                DataItem item = event.getDataItem();
                if(item.getUri().getPath().compareTo("/data")==0){
                    DataMap dataMap = DataMapItem.fromDataItem(item).getDataMap();
                    dataMap.getString("friend");

                }
            }

        }

    }
}