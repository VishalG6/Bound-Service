package com.example.vishal.boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyService vishService;
    boolean isBound = false;

    public void showTime(View view){
        String currentTime = vishService.getCurrentTime();
        TextView timeText = (TextView) findViewById(R.id.timeText);
        timeText.setText(currentTime);

        String currentDate = vishService.getCurrentDate();
        TextView dateText = (TextView) findViewById(R.id.dateText);
        dateText.setText(currentDate);

        String currentDayyear = vishService.getCurrentDayyear();
        TextView dayyearText = (TextView) findViewById(R.id.dayyearText);
        dayyearText.setText("DAY IN YEAR: "+currentDayyear);

        String currentWeekyear = vishService.getCurrentWeekyear();
        TextView weekyearText = (TextView) findViewById(R.id.weekyearText);
        weekyearText.setText("WEEK IN YEAR: "+currentWeekyear);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, MyService.class);
        bindService(i, vishConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection vishConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyLocalBinder binder = (MyService.MyLocalBinder) service;
            vishService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };

}
