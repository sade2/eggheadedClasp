package com.example.jillian.eggheadedclasp;


import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
//        parent = (LinearLayout) findViewById(R.id.ll_parentLayout);
//
//        for (int i = 0; i < 5; i++){
//            Button b1 = new Button(MainActivity.this);
//            b1.setId(i+1);
//            b1.setText("egg");
//            b1.setTag(i);
//            parent.addView(b1);
//            b1.setOnClickListener(MainActivity.this);
//        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] arrSpinner = new String[]{"1","2","3","4","5"};
        Spinner s = (Spinner) findViewById(R.id.Bspinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "hi", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

//                setContentView(R.layout.activity_main);
//                parent = (LinearLayout) findViewById(R.id.ll_parentLayout);


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

        // Set<BluetoothDevice> pairedDevices = reader.getBondedDevices();



    }


    @Override
    public void onClick(View v) {

//        Button b1 = new Button(MainActivity.this);
//        int i = 4;
//        b1.setId(R.id.b1);
//        b1.setText("egg");
//        b1.setTag(2);
//        parent.addView(b1);
//        b1.setOnClickListener(MainActivity.this);
//
//        String str = v.getTag().toString();
//        if (str.equals("0")){
//            Toast.makeText(getApplicationContext(),"click button 1", Toast.LENGTH_SHORT).show();
//        }
//        else if (str.equals("1")){
//            Toast.makeText(getApplicationContext(),"click button 2", Toast.LENGTH_SHORT).show();
//        }
//        else if (str.equals("2")){
//            Toast.makeText(getApplicationContext(),"click button 3", Toast.LENGTH_SHORT).show();
//        }
//        else if (str.equals("3")){
//            Toast.makeText(getApplicationContext(),"click button 4", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(getApplicationContext(),"click button 5", Toast.LENGTH_SHORT).show();
//        }
    }



    //      public void onClickConnect(View view) {
//                //get the spinner from the xml.
//                Spinner dropdown = findViewById(R.id.Bspinner);
//
//                // Create an ArrayAdapter using the string array and a default spinner layout
//                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                        R.array.planets_array, android.R.layout.simple_spinner_item);
//                // Specify the layout to use when the list of choices appears
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                // Apply the adapter to the spinner
//                spinner.setAdapter(adapter);
//                ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.ListView,StringArray);
//                ListView listView = (ListView) findViewById(R.id.listview);
//                listView.setAdapter(adapter);
//
//                class ListDisplay extends Activity {
//                    // Array of strings...
//                    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
//                            "WebOS","Ubuntu","Windows7","Max OS X"};
//
//                    @Override
//                    protected void onCreate(Bundle savedInstanceState) {
//                        super.onCreate(savedInstanceState);
//                        setContentView(R.layout.activity_main);
//
//                        ArrayAdapter adapter = new ArrayAdapter<String>(this,
//                                R.layout.activity_listview, mobileArray);
//
//                        ListView listView = (ListView) findViewById(R.id.mobile_list);
//                        listView.setAdapter(adapter);
//                    }
//                }

//                setContentView(R.layout.activity_main);
//                parent = (LinearLayout) findViewById(R.id.ll_parentLayout);


    //      }
    //});
}