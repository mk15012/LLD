import service.InMemoryService;
import service.MeetingRoomService;
import service.MeetingService;
import service.SchedulerService;
import service.UserService;

public class MeetingApplication {
    public static void main(String[] args) {

        InMemoryService inMemoryService = new InMemoryService();

        UserService userService = new UserService();
        MeetingRoomService meetingRoomService = new MeetingRoomService();
        SchedulerService schedulerService = new SchedulerService();
        MeetingService meetingService = new MeetingService();

        userService.addUser("u1", "name1", "email1");
        userService.addUser("u2", "name2", "email2");
        userService.addUser("u3", "name3", "email3");
        userService.addUser("u4", "name4", "email4");
        userService.addUser("u5", "name5", "email5");
        userService.addUser("u6", "name6", "email6");

        meetingRoomService.addMeetingRoom(1L, "YUKUTA", 2);
        meetingRoomService.addMeetingRoom(2L, "RED", 4);

        meetingService.showAllMeetings();
        schedulerService.scheduleMeeting(3, 4);
        meetingService.showAllMeetings();
        schedulerService.scheduleMeeting(4, 5);
        schedulerService.scheduleMeeting(5, 6);
        meetingService.showAllMeetings();
        schedulerService.scheduleMeeting(3, 5);
        meetingService.showAllMeetings();
        schedulerService.scheduleMeeting(3, 4);

    }
}
