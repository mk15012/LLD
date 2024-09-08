package strategy.impl;

import dto.MeetingRoom;
import strategy.SchedulerStrategy;
import util.MeetingRoomUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinCapacityBasedScheduler implements SchedulerStrategy {

    @Override
    public MeetingRoom getMeetingRoom(long startTime, long endTime) {

        MeetingRoomUtil meetingRoomUtil = new MeetingRoomUtil();
        List<MeetingRoom> availableMeetingRooms = meetingRoomUtil.getAvailableMeetingRooms(startTime, endTime);

        int maxCapacity = availableMeetingRooms.stream()
                .mapToInt(MeetingRoom::getCapacity)
                .max()
                .orElse(0);

        availableMeetingRooms = availableMeetingRooms.stream()
                .filter(room -> room.getCapacity() == maxCapacity)
                .sorted(Comparator.comparingLong(MeetingRoom::getId))
                .collect(Collectors.toList());

        if (availableMeetingRooms.isEmpty()) {
            return null;
        }

        return availableMeetingRooms.get(0);
    }

}
