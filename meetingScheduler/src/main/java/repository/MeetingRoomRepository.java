package repository;

import dto.MeetingRoom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingRoomRepository {

    static List<MeetingRoom> meetingRoomList;
    static Map<Long, MeetingRoom> meetingRoomMap;


    public MeetingRoomRepository() {
        meetingRoomList = new ArrayList<>();
        meetingRoomMap = new HashMap<>();
    }

    public static List<MeetingRoom> getMeetingRoomList() {
        return meetingRoomList;
    }

    public static Map<Long, MeetingRoom> getMeetingRoomMap() {
        return meetingRoomMap;
    }
}
