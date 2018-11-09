package com.kapcite.bleindoorpositioning.ble.beacon.filter;

import com.kapcite.bleindoorpositioning.ble.beacon.Beacon;

import java.util.Collection;
import java.util.List;

public interface BeaconFilter<B extends Beacon> {

    boolean matches(B beacon);

    List<B> getMatches(Collection<B> beacons);

}
