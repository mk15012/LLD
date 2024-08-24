package repository;

import dto.ParkingSlot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSlotRepository {

    static Map<String, ParkingSlot> parkingSlotLotMap;

    public ParkingSlotRepository() {
        parkingSlotLotMap = new HashMap<>();
    }

    public static Map<String, ParkingSlot> getParkingSlotMap() {
        return parkingSlotLotMap;
    }
}
