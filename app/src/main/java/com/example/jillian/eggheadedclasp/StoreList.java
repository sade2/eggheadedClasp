package com.example.jillian.eggheadedclasp;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.util.Log;

import java.util.ArrayList;
import java.util.Set;

public class StoreList{
    private final String IDENTIFIER = "eggheadClasp";
    //if first time run, create new file
    public StoreList() {

    }

    /**
     * Checks through all bluetooth devices to find all eggheadClasp devices
     * @param mBluetoothAdapter the bluetooth adapter to feed in to this method
     */
    public ArrayList<ArrayList<String>> findEggClasps(BluetoothAdapter mBluetoothAdapter){
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        ArrayList<ArrayList<String>> namesList = new ArrayList<>();
        if (pairedDevices.size() > 0) {
            boolean aFoundDevice = false;
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address

                //Check to see if a device has the correct identifier
                if(deviceName.substring(0,12).equals(IDENTIFIER)){
                    aFoundDevice = true;


                    ArrayList<String> subList = new ArrayList<>();
                    subList.add(deviceName);
                    //adds deviceName twice, because the user will be able to manually change one instance
                    subList.add(deviceName);
                    subList.add(deviceHardwareAddress);

                    //adds the sub array list to the larger array list of array lists
                    namesList.add(subList);

                }
            }
            if(!aFoundDevice){
                Log.w("WARN: ", "No bluetooth connections found");
            }
        }

        return namesList;
    }

}
