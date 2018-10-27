package com.example.jillian.eggheadedclasp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
//import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "hi", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onStart(){
        super.onStart();

        setUpBluetooth();
    }

//    @Override
//    public void onResume(){
//        super.onResume();
//
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 32){

            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "yesssss", Toast.LENGTH_SHORT).show();
            }

            else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "fuck", Toast.LENGTH_SHORT).show();
            }

        }

    }

    /* THE STUFF WE WROTE AND PROBABLY SCREWED UP*/
    public void setUpBluetooth(){
        BluetoothAdapter reader = BluetoothAdapter.getDefaultAdapter();
        if (reader == null)
            Toast.makeText(this, "Your device does not have bluetooth capabilities. You dum", Toast.LENGTH_SHORT).show();


        if (!reader.isEnabled()){
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            //onActivityResult(REQUEST_ENABLE_BT, )

            startActivityForResult(enableIntent,32);
            onActivityResult(32, 3, enableIntent);
        }

        Set<BluetoothDevice> pairedDevices = reader.getBondedDevices();



    }




}
