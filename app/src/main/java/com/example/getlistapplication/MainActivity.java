package com.example.getlistapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView;;

        PackageManager packageManager=this.getPackageManager();
        List<ApplicationInfo> applist = packageManager.getInstalledApplications(0);
        Iterator<ApplicationInfo> it=applist.iterator();
        while(it.hasNext()){
            ApplicationInfo pk=(ApplicationInfo)it.next();

            String appname = packageManager.getApplicationLabel(pk).toString();

            ArrayList<String> installedapplist = new ArrayList<>();
            installedapplist.add(appname);
            Log.e("name",installedapplist+"");

            textView = findViewById(R.id.tv);
            for (int i=0; i<installedapplist.size(); i++){
                textView.append(installedapplist.get(i)+"\n");
            }
        }

    }
}