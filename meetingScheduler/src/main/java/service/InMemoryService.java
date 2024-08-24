package service;

import repository.MeetingRepository;
import repository.MeetingRoomRepository;
import repository.UserRepository;

public class InMemoryService {

    MeetingRoomRepository meetingRoomRepository = new MeetingRoomRepository();
    MeetingRepository meetingRepository = new MeetingRepository();
    UserRepository userRepository = new UserRepository();

}
