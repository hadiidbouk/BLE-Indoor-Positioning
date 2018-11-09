package com.kapcite.bleindoorpositioning.location.provider;

import com.kapcite.bleindoorpositioning.ble.beacon.Beacon;
import com.kapcite.bleindoorpositioning.location.Location;

public abstract class BeaconLocationProvider<B extends Beacon> implements LocationProvider {

    protected B beacon;
    protected Location location;

    public BeaconLocationProvider(B beacon) {
        this.beacon = beacon;
    }

    protected abstract void updateLocation();

    protected boolean shouldUpdateLocation() {
        return location == null;
    }

    protected boolean canUpdateLocation() {
        return true;
    }

    @Override
    public Location getLocation() {
        if (shouldUpdateLocation() && canUpdateLocation()) {
            updateLocation();
        }
        return location;
    }

    public boolean hasLocation() {
        Location location = getLocation();
        return location != null && location.hasLatitudeAndLongitude();
    }

}
