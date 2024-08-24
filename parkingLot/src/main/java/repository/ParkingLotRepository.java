package repository;

import dto.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {

    static Map<String, ParkingLot> parkingLotRepositoryMap;
    static List<ParkingLot> parkingLotList;

    public ParkingLotRepository() {
        parkingLotRepositoryMap = new HashMap<>();
        parkingLotList = new ArrayList<>();
    }

    public static Map<String, ParkingLot> getParkingLotRepositoryMap() {
        return parkingLotRepositoryMap;
    }

    public static List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }
}
