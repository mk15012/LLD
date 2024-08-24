package dao;

import entity.Story;
import entity.Task;

import java.util.List;

public interface StoryDao {

    Story getStory(String storyId) throws Exception;

    Story createStory(String description, String headline, List<Task> taskList);

    Story updateStory(String storyId, Story story) throws Exception;

    boolean deleteStory(String storyId) throws Exception;

}
