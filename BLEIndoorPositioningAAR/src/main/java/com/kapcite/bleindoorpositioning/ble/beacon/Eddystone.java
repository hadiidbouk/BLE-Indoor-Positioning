package com.kapcite.bleindoorpositioning.ble.beacon;

import com.kapcite.bleindoorpositioning.ble.advertising.EddystoneAdvertisingPacket;
import com.kapcite.bleindoorpositioning.location.provider.BeaconLocationProvider;
import com.kapcite.bleindoorpositioning.location.provider.EddystoneLocationProvider;

/**
 * Created by steppschuh on 15.11.17.
 */

public class Eddystone<P extends EddystoneAdvertisingPacket> extends Beacon<P> {

    public static final int CALIBRATION_DISTANCE_DEFAULT = 0;

    public Eddystone() {
        this.calibratedDistance = CALIBRATION_DISTANCE_DEFAULT;
    }

    @Override
    public BeaconLocationProvider<Eddystone<P>> createLocationProvider() {
        return new EddystoneLocationProvider<>(this);
    }

    @Override
    public void applyPropertiesFromAdvertisingPacket(P advertisingPacket) {
        super.applyPropertiesFromAdvertisingPacket(advertisingPacket);
        setCalibratedRssi(advertisingPacket.getMeasuredPowerByte());
    }
}
