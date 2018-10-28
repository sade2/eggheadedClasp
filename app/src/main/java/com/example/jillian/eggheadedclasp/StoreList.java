package com.example.jillian.eggheadedclasp;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.util.Log;

import java.util.ArrayList;
import java.util.Set;

public class StoreList{
    private final String IDENTIFIER = "eggheadClasp";
    private ArrayList<ArrayList<String>> namesList = new ArrayList<>();

    public StoreList(BluetoothAdapter mBluetoothAdapter) {
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
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

            //What if the user has never paired a egghead device before?
            if(!aFoundDevice){
                Log.w("WARN: ", "No bluetooth connections found");
            }
        }
    }

    /**
     * Adds an additional connection to the arraylist in the case that a new one is identified
     * @param name The name of the bluetooth device
     * @param userChangedName The specific user name of the device (if n/a, just use regular name)
     * @param mac The mac address
     */
    public void addConnection(String name, String userChangedName, String mac){
        ArrayList<String> toAdd = new ArrayList<>();
        toAdd.add(name);
        toAdd.add(userChangedName);
        toAdd.add(mac);

        namesList.add(toAdd);
    }

    /**
     * Gets the number of connections
     * @return how many total connections there are
     */
    public int numOfConnections(){
        return namesList.size();
    }

    /**
     * Gets the full list of lists of bluetooth connections
     * @return The full nameList array
     */
    public ArrayList<ArrayList<String>> getNamesList(){
        return namesList;
    }

    /**
     * Returns a list of specific parameters of an array list, i.e. a list of all mac addresses
     * @param category Which category to choose (1 = name, 2 = user defined name, 3 = mac address)
     * @return An array list of the selected category
     */
    public ArrayList<String> getCategoryList(int category){
        ArrayList<String> categoryList = new ArrayList<>();
        if(category<4){

            for(int i = 0; i < namesList.size(); i++){
                categoryList.add(namesList.get(i).get(category));
            }
        }
        return categoryList;
    }

}
