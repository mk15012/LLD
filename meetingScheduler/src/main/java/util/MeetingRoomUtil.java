package util;

import dto.MeetingRoom;
import repository.MeetingRoomRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MeetingRoomUtil {

    public List<MeetingRoom> getAvailableMeetingRooms(long startTime, long endTime) {

        List<MeetingRoom> meetingRoomList = MeetingRoomRepository.getMeetingRoomList();
        return meetingRoomList.stream()
                .filter(room -> room.getMeetingList().stream()
                .noneMatch(meeting -> meeting.getStartTime() < endTime && meeting.getEndTime() > startTime))
                .collect(Collectors.toList());
    }
}
