package strategy;

import dto.MeetingRoom;

public interface SchedulerStrategy {

    MeetingRoom getMeetingRoom(long startTime, long endTime);

}
