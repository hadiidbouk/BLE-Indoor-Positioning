package com.kapcite.bleindoorpositioning.location;

import com.kapcite.bleindoorpositioning.location.provider.LocationProvider;

public interface LocationListener {

    void onLocationUpdated(LocationProvider locationProvider, Location location);

}
