package interestStrategy;

import dto.MeetingRoom;

public interface SchedulerStrategy {

    public MeetingRoom getMeetingRoom(long startTime, long endTime);

}
