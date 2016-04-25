package com.aragon.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.aragon.aidl.ICustom;
import com.aragon.aidl.Person;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    ICustom iCustom;
    MyConn conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bind(View view){
        Intent intent = new Intent();
        intent.setAction("com.aragon.aidl.BinderService");
        conn = new MyConn();
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void pay(View view){
        try {
            iCustom.logPrint();
            Person prePerson = new Person(12,1,"--whs");
            Person person = iCustom.getPerson(prePerson);
            if (null != person){
                Log.e(TAG, "person name = " + person.getName());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    private class MyConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iCustom = ICustom.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    @Override
    protected void onDestroy() {
        if(conn!=null){
            unbindService(conn);
            conn = null;
        }
        super.onDestroy();
    }
}
