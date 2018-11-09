package com.kapcite.bleindoorpositioning.ble.beacon.signal;

import com.kapcite.bleindoorpositioning.ble.beacon.Beacon;

public interface RssiFilter {

    float filter(Beacon beacon);

}
