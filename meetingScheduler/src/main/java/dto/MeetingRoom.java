package dto;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {

    private Long id;
    private String name;
    private int capacity;
    private List<Meeting> meetingList;

    public MeetingRoom(Long id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.meetingList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }
}
