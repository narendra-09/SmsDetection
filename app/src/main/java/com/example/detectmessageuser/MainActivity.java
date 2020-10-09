package com.example.detectmessageuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private int REQUEST_CODE_PERMISSIONS=1;
private String[] REQUIRED_PERMISSIONS=new String[]{"android.permission.RECEIVE_SMS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkingPermissions();

    }

    private void checkingPermissions() {
        if(allPermissionsGranted())
        {

            Toast.makeText(this, "granted", Toast.LENGTH_SHORT).show();
        }
        else
        {
            ActivityCompat.requestPermissions(this,REQUIRED_PERMISSIONS,REQUEST_CODE_PERMISSIONS);
        }
    }

    private boolean allPermissionsGranted() {
        for(String permission : REQUIRED_PERMISSIONS){
            if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode== REQUEST_CODE_PERMISSIONS)
        {
            if(allPermissionsGranted())
            {
                Toast.makeText(this, "granted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Not granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}