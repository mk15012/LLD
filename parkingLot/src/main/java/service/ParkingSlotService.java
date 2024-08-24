package service;

import dto.ParkingSlot;
import dto.Ticket;
import dto.Vehicle;
import enums.ParkingSlotStatus;

public class ParkingSlotService {

    static Ticket allotSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.UNAVAILABLE);
        Ticket ticket = TicketService.generateTicket(parkingSlot, vehicle);
        parkingSlot.setTicket(ticket);
        return ticket;
    }

    static void unallotSlot(ParkingSlot parkingSlot) {
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
        parkingSlot.setTicket(null);
    }
}
