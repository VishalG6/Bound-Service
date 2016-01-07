package com.example.vishal.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final IBinder vishBinder = new MyLocalBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return vishBinder;
}

    public String getCurrentTime() {
        SimpleDateFormat aa= new SimpleDateFormat("hh:mm:ss a", Locale.ENGLISH);
        return (aa.format(new Date()));
    }
    public String getCurrentDate() {
        SimpleDateFormat aa= new SimpleDateFormat("EEEE dd/MM/yyyy ", Locale.ENGLISH);
        return (aa.format(new Date()));
    }
    public String getCurrentDayyear() {
        SimpleDateFormat aa= new SimpleDateFormat("d", Locale.ENGLISH);
        return (aa.format(new Date()));
    }
    public String getCurrentWeekyear() {
        SimpleDateFormat aa= new SimpleDateFormat("w", Locale.ENGLISH);
        return (aa.format(new Date()));
    }
    public class MyLocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }


}
