package service;

import dto.Meeting;
import dto.MeetingRoom;
import interestStrategy.MaxCapacityBasedScheduler;
import interestStrategy.SchedulerStrategy;

import java.util.Objects;

public class SchedulerService {

    SchedulerStrategy schedulerStrategy = new MaxCapacityBasedScheduler();
    MeetingService meetingService = new MeetingService();
    MeetingRoomService meetingRoomService = new MeetingRoomService();

    public void scheduleMeeting(long startTime, long endTime) {
        MeetingRoom meetingRoom = schedulerStrategy.getMeetingRoom(startTime, endTime);
        if (Objects.isNull(meetingRoom)) {
            System.out.println("No meeting room available");
            return;
        }

        Meeting meeting = meetingService.addMeeting("meet1", "DISCUSSION", meetingRoom.getId(), startTime, endTime);
        meetingRoomService.addMeetToMeetingRoom(meeting, meetingRoom.getId());
        System.out.println("Meeting scheduled from " + startTime + " to " + endTime);
    }
}
