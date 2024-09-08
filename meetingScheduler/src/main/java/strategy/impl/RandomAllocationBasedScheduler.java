package strategy.impl;

import dto.MeetingRoom;
import strategy.SchedulerStrategy;
import util.MeetingRoomUtil;

import java.util.List;

public class RandomAllocationBasedScheduler implements SchedulerStrategy {

    @Override
    public MeetingRoom getMeetingRoom(long startTime, long endTime) {

        MeetingRoomUtil meetingRoomUtil = new MeetingRoomUtil();
        List<MeetingRoom> availableMeetingRooms = meetingRoomUtil.getAvailableMeetingRooms(startTime, endTime);

        if (availableMeetingRooms.isEmpty()) {
            return null;
        }

        return availableMeetingRooms.get(0);
    }

}
