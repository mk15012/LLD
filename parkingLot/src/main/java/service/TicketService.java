package service;

import dto.ParkingSlot;
import dto.Ticket;
import dto.Vehicle;
import repository.TicketRepository;

public class TicketService {

    static Ticket generateTicket(ParkingSlot parkingSlot, Vehicle vehicle) {
        String ticketId = generateTicketId(parkingSlot);
        Ticket ticket = new Ticket(ticketId, vehicle, parkingSlot);
        TicketRepository.getTicketMap().put(ticketId, ticket);
        return ticket;
    }

    static String generateTicketId(ParkingSlot parkingSlot) {
        return parkingSlot.getParkingLotId() + "_" + parkingSlot.getParkingFloorNumber() + "_" + parkingSlot.getId();
    }

    static Ticket getTicketByTicketId(String ticketId) {
        if(!TicketRepository.getTicketMap().containsKey(ticketId)) {
            throw new RuntimeException("INVALID TICKET");
        }
        return TicketRepository.getTicketMap().get(ticketId);
    }

    static void deleteTicket(String ticketId){
        TicketRepository.getTicketMap().remove(ticketId);
    }
}
