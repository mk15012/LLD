package repository;

import dto.Meeting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingRepository {

    static List<Meeting> meetingList;
    static Map<String, Meeting> meetingMap;


    public MeetingRepository() {
        meetingList = new ArrayList<>();
        meetingMap = new HashMap<>();
    }

    public static List<Meeting> getMeetingList() {
        return meetingList;
    }

    public static Map<String, Meeting> getMeetingMap() {
        return meetingMap;
    }
}
