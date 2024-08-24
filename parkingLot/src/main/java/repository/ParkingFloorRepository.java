package repository;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {

    static Map<String, ParkingFloorRepository> parkingFloorRepositoryMap;

    public ParkingFloorRepository() {
        parkingFloorRepositoryMap = new HashMap<>();
    }

    public static Map<String, ParkingFloorRepository> getParkingFloorRepositoryMap() {
        return parkingFloorRepositoryMap;
    }
}
