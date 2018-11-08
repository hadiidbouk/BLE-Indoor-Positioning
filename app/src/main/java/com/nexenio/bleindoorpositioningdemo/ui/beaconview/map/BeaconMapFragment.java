package com.nexenio.bleindoorpositioningdemo.ui.beaconview.map;


import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kapcite.bleindoorpositioning.IndoorPositioning;
import com.kapcite.bleindoorpositioning.ble.beacon.Beacon;
import com.kapcite.bleindoorpositioning.ble.beacon.BeaconUpdateListener;
import com.kapcite.bleindoorpositioning.location.Location;
import com.kapcite.bleindoorpositioning.location.LocationListener;
import com.kapcite.bleindoorpositioning.location.provider.LocationProvider;

import com.nexenio.bleindoorpositioningdemo.R;
import com.nexenio.bleindoorpositioningdemo.location.AndroidLocationProvider;
import com.nexenio.bleindoorpositioningdemo.ui.beaconview.BeaconViewFragment;

public class BeaconMapFragment extends BeaconViewFragment {

    private BeaconMap beaconMap;

    public BeaconMapFragment() {
        super();
        beaconFilters.add(uuidFilter);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_beacon_map;
    }

    @Override
    protected LocationListener createDeviceLocationListener() {
        return new LocationListener() {
            @Override
            public void onLocationUpdated(LocationProvider locationProvider, Location location) {
                if (locationProvider instanceof IndoorPositioning) {
                    beaconMap.setDeviceLocation(location);
                    beaconMap.setPredictedDeviceLocation(IndoorPositioning.getLocationPredictor().getLocation());
                    beaconMap.fitToCurrentLocations();
                } else if (locationProvider instanceof AndroidLocationProvider) {
                    // TODO: remove artificial noise
                    //location.setLatitude(location.getLatitude() + Math.random() * 0.0002);
                    //location.setLongitude(location.getLongitude() + Math.random() * 0.0002);
                }
            }
        };
    }

    @Override
    protected BeaconUpdateListener createBeaconUpdateListener() {
        return new BeaconUpdateListener() {
            @Override
            public void onBeaconUpdated(Beacon beacon) {
                beaconMap.setBeacons(getBeacons());
            }
        };
    }

    @CallSuper
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = super.onCreateView(inflater, container, savedInstanceState);
        beaconMap = inflatedView.findViewById(R.id.beaconMap);
        beaconMap.setBeacons(getBeacons());
        return inflatedView;
    }

}
