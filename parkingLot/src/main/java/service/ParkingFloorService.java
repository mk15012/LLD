package service;

import dto.ParkingFloor;
import dto.ParkingSlot;
import dto.Ticket;
import dto.Vehicle;
import enums.ParkingSlotStatus;
import enums.VehicleType;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingFloorService {

    static int getFreeSlotsCount(ParkingFloor parkingFloor, VehicleType vehicleType) {
        List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();
        int count = 0;
        for (ParkingSlot parkingSlot : parkingSlotList) {
            if (parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE) && parkingSlot.getVehicleType().equals(vehicleType)) {
                count++;
            }
        }
        return count;
    }

    static void getFreeSlots(ParkingFloor parkingFloor, VehicleType vehicleType) {
        List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();
        for (ParkingSlot parkingSlot : parkingSlotList) {
            if (parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE) && parkingSlot.getVehicleType().equals(vehicleType)) {
                System.out.print(parkingSlot.getId() + ",");
            }
        }
    }

    static void getOccupiedSlots(ParkingFloor parkingFloor, VehicleType vehicleType) {
        List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();
        for (ParkingSlot parkingSlot : parkingSlotList) {
            if (parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.UNAVAILABLE) && parkingSlot.getVehicleType().equals(vehicleType)) {
                System.out.print(parkingSlot.getId() + ",");
            }
        }
    }

    static Ticket allotSlot(ParkingFloor parkingFloor, Vehicle vehicle) {
        List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();

        List<ParkingSlot> availableParkingSlots = parkingSlotList.stream().filter(parkingSlot ->
                        parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE) &&
                                parkingSlot.getVehicleType().equals(vehicle.getVehicleType()))
                .collect(Collectors.toList());

        if (!availableParkingSlots.isEmpty()) {
            ParkingSlot parkingSlot = availableParkingSlots.get(0);
            Ticket ticket = ParkingSlotService.allotSlot(parkingSlot, vehicle);
            return ticket;
        } else {
            return null;
        }
    }

}
