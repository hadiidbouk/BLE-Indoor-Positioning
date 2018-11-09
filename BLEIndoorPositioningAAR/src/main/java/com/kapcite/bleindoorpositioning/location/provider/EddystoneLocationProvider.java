package com.kapcite.bleindoorpositioning.location.provider;

import com.kapcite.bleindoorpositioning.ble.beacon.Eddystone;

public class EddystoneLocationProvider<B extends Eddystone> extends BeaconLocationProvider<B> {

    public EddystoneLocationProvider(B beacon) {
        super(beacon);
    }

    @Override
    public void updateLocation() {
        //AdvertisingPacket advertisingPacket = beacon.getLatestAdvertisingPacket();
        //location = new Location();
        // TODO: get location from advertising packets
    }

}
