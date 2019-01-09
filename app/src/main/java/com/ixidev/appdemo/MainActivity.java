package com.ixidev.appdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ixidev.startappgdprdialog.GDPRCallback;
import com.ixidev.startappgdprdialog.GDPRDialog;

public class MainActivity extends AppCompatActivity implements GDPRCallback {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new GDPRDialog(this)
                .create(this, new Runnable() {
                    @Override
                    public void run() {

                    }
                });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onInitStartAppSdk() {
        // TODO: 09/01/2019 initial StartAppSDK
        //  StartAppSDK.init(this, "StartaApp APP ID", false);
        Log.d(TAG, "onInitStartAppSdk: ");
    }

    @Override
    public void onPersonalizedAdsConsentChange(boolean isGranted) {
// TODO: 09/01/2019
        /*
         StartAppSDK.setUserConsent(this,
                "pas",
                System.currentTimeMillis(),
                isGranted);
         */

        Log.d(TAG, "onPersonalizedAdsConsentChange: isGranted =" + isGranted);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.ads_item) {
            GDPRDialog.showGdprDialog(null, this, this);
        }
        return super.onOptionsItemSelected(item);
    }
}
