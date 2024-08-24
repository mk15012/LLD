package service;

import dto.ParkingFloor;
import dto.ParkingLot;
import dto.ParkingSlot;
import dto.Ticket;
import dto.Vehicle;
import enums.DisplayType;
import enums.ParkingSlotStatus;
import enums.VehicleType;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSlotRepository;
import repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {

    ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
    ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
    TicketRepository ticketRepository = new TicketRepository();

    List<ParkingLot> parkingLotList = ParkingLotRepository.getParkingLotList();

    public void create_parkingLot(String parking_lot_id, int no_of_floors, int no_of_slots_per_floor) {
        List<ParkingFloor> parkingFloorList = new ArrayList<>(no_of_floors);

        for (int i = 0; i < no_of_floors; i++) {
            List<ParkingSlot> parkingSlotList = new ArrayList<>(no_of_slots_per_floor);
            for (int j = 0; j < no_of_slots_per_floor; j++) {
                ParkingSlot parkingSlot = new ParkingSlot(String.valueOf(j + 1), parking_lot_id, i + 1, ParkingSlotStatus.AVAILABLE, VehicleType.CAR);
                if (j == 0) {
                    parkingSlot.setVehicleType(VehicleType.TRUCK);
                } else if (j == 1 || j == 2) {
                    parkingSlot.setVehicleType(VehicleType.BIKE);
                }
                parkingSlotList.add(parkingSlot);
            }

            ParkingFloor parkingFloor = new ParkingFloor(i + 1, parking_lot_id, parkingSlotList);
            parkingFloorList.add(parkingFloor);
        }

        ParkingLot parkingLot = new ParkingLot(parking_lot_id, no_of_floors, no_of_slots_per_floor, parkingFloorList);
        ParkingLotRepository.getParkingLotRepositoryMap().put(parking_lot_id, parkingLot);
        parkingLotList.add(parkingLot);
        System.out.println("Created parking lot with " + no_of_floors + " floors and " + no_of_slots_per_floor + " slots per floor");
    }

    public void park_vehicle(Vehicle vehicle) {
        ParkingLot parkingLot = parkingLotList.get(0);
        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloorList();
        for (ParkingFloor parkingFloor : parkingFloorList) {
            if (ParkingFloorService.getFreeSlotsCount(parkingFloor, vehicle.getVehicleType()) > 0) {
                Ticket allotmentTicket = ParkingFloorService.allotSlot(parkingFloor, vehicle);
                if (allotmentTicket != null) {
                    System.out.println("Parked vehicle : " + vehicle.getRegNo() + "  Ticket ID: " + allotmentTicket.getId());
                    return;
                }
            }
        }
        System.out.println("Parking Lot Full");
    }

    public void unpark_vehicle(String ticketId) {
        Ticket ticket = TicketService.getTicketByTicketId(ticketId);
        ParkingSlot parkingSlot = ticket.getParkingSlot();
        Vehicle vehicle = ticket.getVehicle();
        ParkingSlotService.unallotSlot(parkingSlot);

        TicketService.deleteTicket(ticketId);
        System.out.println("Unparked vehicle with Registration Number: " + vehicle.getRegNo() + " and Color: " + vehicle.getColor());
    }

    public void display(DisplayType displayType, VehicleType vehicleType) {
        ParkingLot parkingLot = parkingLotList.get(0);
        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloorList();
        for (ParkingFloor parkingFloor : parkingFloorList) {
            if (displayType.equals(DisplayType.free_count)) {
                int freeSLotsCount = ParkingFloorService.getFreeSlotsCount(parkingFloor, vehicleType);
                System.out.print("No. of free slots for " + vehicleType + " on Floor " + parkingFloor.getFloorNumber() + ": " + freeSLotsCount);
            } else if (displayType.equals(DisplayType.free_slots)) {
                System.out.print("Free slots for " + vehicleType + " on Floor " + parkingFloor.getFloorNumber() + ": ");
                ParkingFloorService.getFreeSlots(parkingFloor, vehicleType);
            } else if (displayType.equals(DisplayType.occupied_slots)) {
                System.out.print("Occupied slots for " + vehicleType + " on Floor " + parkingFloor.getFloorNumber() + " : ");
                ParkingFloorService.getOccupiedSlots(parkingFloor, vehicleType);
            }
            System.out.println();
        }
    }
}