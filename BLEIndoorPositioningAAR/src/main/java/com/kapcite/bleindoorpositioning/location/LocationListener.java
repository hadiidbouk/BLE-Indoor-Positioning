package com.kapcite.bleindoorpositioning.location;

import com.kapcite.bleindoorpositioning.location.provider.LocationProvider;

/**
 * Created by steppschuh on 21.11.17.
 */

public interface LocationListener {

    void onLocationUpdated(LocationProvider locationProvider, Location location);

}
