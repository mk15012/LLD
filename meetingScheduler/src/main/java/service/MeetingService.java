package service;

import dto.Meeting;
import repository.MeetingRepository;

import java.util.List;
import java.util.Objects;

public class MeetingService {

    public Meeting addMeeting(String id, String description, Long meetingRoomId, long startTime, long endTime) {
        Meeting meeting = new Meeting(id, description, meetingRoomId, startTime, endTime);
        MeetingRepository.getMeetingList().add(meeting);
        MeetingRepository.getMeetingMap().put(id, meeting);
        return meeting;
    }

    public Meeting getMeeting(String id) {
        Meeting meeting = MeetingRepository.getMeetingMap().get(id);
        if (Objects.isNull(meeting)) {
            System.out.println("Invalid Meeting");
        }
        return meeting;
    }

    public void showAllMeetings() {
        List<Meeting> meetingList = MeetingRepository.getMeetingList();
        if (meetingList.isEmpty()) {
            System.out.println("No scheduled meetings");
        }

        for(Meeting meet : meetingList) {
            System.out.println(meet.toString());
        }
    }

}
