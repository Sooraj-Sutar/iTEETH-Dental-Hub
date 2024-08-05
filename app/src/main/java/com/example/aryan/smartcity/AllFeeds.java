package com.example.aryan.smartcity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class AllFeeds extends AppCompatActivity {
    private static int WELCOME_TIMEOUT=4000;
    ConnectivityManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (manager.getActiveNetworkInfo() != null && manager.getActiveNetworkInfo().isConnectedOrConnecting()) {
                    // progressBar.setVisibility(View.INVISIBLE);
                    startActivity(new Intent(AllFeeds.this, ComplaintActivity.class));
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    finish();
                } else {
                    buildAlert();

                }
            }
        }, WELCOME_TIMEOUT);
    }
    private void buildAlert() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("No Internet Connection!!!. Do you Want to Turn on?")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_SETTINGS));
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AlertDialog dialog = builder.create();
        dialog.show();
    }

}


