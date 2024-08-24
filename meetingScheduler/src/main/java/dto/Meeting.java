package dto;


public class Meeting {

    private String id;
    private String description;
    private Long meetingRoomId;
    private long startTime;
    private long endTime;

    public Meeting(String id, String description, Long meetingRoomId, long startTime, long endTime) {
        this.id = id;
        this.description = description;
        this.meetingRoomId = meetingRoomId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(Long meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Meeting {" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", meetingRoomId=" + meetingRoomId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
