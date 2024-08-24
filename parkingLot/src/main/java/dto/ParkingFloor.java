package dto;

import java.util.List;

public class ParkingFloor {

    private int floorNumber;
    private String parkingLotId;
    private List<ParkingSlot> parkingSlotList;

    public ParkingFloor(int floorNumber, String parkingLotId, List<ParkingSlot> parkingSlotList) {
        this.floorNumber = floorNumber;
        this.parkingLotId = parkingLotId;
        this.parkingSlotList = parkingSlotList;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }
}
