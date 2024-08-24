package dto;

import enums.ParkingSlotStatus;
import enums.VehicleType;

public class ParkingSlot {

    private String id;
    private String parkingLotId;
    private int parkingFloorNumber;
    private ParkingSlotStatus parkingSlotStatus;
    private VehicleType vehicleType;
    private Ticket ticket;


    public ParkingSlot(String id, String parkingLotId, int parkingFloorNumber, ParkingSlotStatus parkingSlotStatus, VehicleType vehicleType) {
        this.id = id;
        this.parkingLotId = parkingLotId;
        this.parkingFloorNumber = parkingFloorNumber;
        this.parkingSlotStatus = parkingSlotStatus;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getParkingFloorNumber() {
        return parkingFloorNumber;
    }

    public void setParkingFloorNumber(int parkingFloorNumber) {
        this.parkingFloorNumber = parkingFloorNumber;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
