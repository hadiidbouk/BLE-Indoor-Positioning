package com.kapcite.bleindoorpositioning.location.provider;

import com.kapcite.bleindoorpositioning.ble.beacon.IBeacon;

public class IBeaconLocationProvider<B extends IBeacon> extends BeaconLocationProvider<B> {

    public IBeaconLocationProvider(B beacon) {
        super(beacon);
    }

    @Override
    public void updateLocation() {
        //AdvertisingPacket advertisingPacket = beacon.getLatestAdvertisingPacket();
        //location = new Location();
        // TODO: get location from advertising packets
    }

}
