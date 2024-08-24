package service;

import dto.Meeting;
import dto.MeetingRoom;
import repository.MeetingRoomRepository;

import java.util.Objects;

public class MeetingRoomService {

    public void addMeetingRoom(Long id, String name, int capacity) {
        MeetingRoom meetingRoom = new MeetingRoom(id, name, capacity);
        MeetingRoomRepository.getMeetingRoomList().add(meetingRoom);
        MeetingRoomRepository.getMeetingRoomMap().put(id, meetingRoom);
    }

    public MeetingRoom getMeetingRoom(String id) {
        MeetingRoom meetingRoom = MeetingRoomRepository.getMeetingRoomMap().get(id);
        if (Objects.isNull(meetingRoom)) {
            System.out.println("Invalid Meeting Room");
        }
        return meetingRoom;
    }

    public void addMeetToMeetingRoom(Meeting meeting, Long id) {
        MeetingRoom meetingRoom = MeetingRoomRepository.getMeetingRoomMap().get(id);
        meetingRoom.getMeetingList().add(meeting);
    }
}
