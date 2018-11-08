package com.kapcite.bleindoorpositioning.ble.advertising;

import com.kapcite.bleindoorpositioning.ble.beacon.Beacon;

import java.util.Arrays;

/**
 * Created by steppschuh on 15.11.17.
 */

public abstract class AdvertisingPacket {

    protected byte[] data;
    protected int rssi;
    protected long timestamp;

    public AdvertisingPacket(byte[] data) {
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public static AdvertisingPacket from(byte[] data) {
        AdvertisingPacket advertisingPacket = null;
        if (IBeaconAdvertisingPacket.meetsSpecification(data)) {
            advertisingPacket = new IBeaconAdvertisingPacket(data);
        } else if (EddystoneAdvertisingPacket.meetsSpecification(data)) {
            advertisingPacket = new EddystoneAdvertisingPacket(data);
        }
        return advertisingPacket;
    }

    public abstract Class<? extends Beacon> getBeaconClass();

    public boolean dataEquals(AdvertisingPacket advertisingPacket) {
        if (advertisingPacket == null) {
            return false;
        }
        return Arrays.equals(data, advertisingPacket.data);
    }

    @Override
    public String toString() {
        return AdvertisingPacketUtil.toHexadecimalString(data);
    }

    /*
        Getter & Setter
     */

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
