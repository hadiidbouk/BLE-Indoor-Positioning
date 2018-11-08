package com.kapcite.bleindoorpositioning.ble.beacon.signal;

import com.kapcite.bleindoorpositioning.ble.beacon.Beacon;

/**
 * Created by leon on 03.01.18.
 */

public interface RssiFilter {

    float filter(Beacon beacon);

}
