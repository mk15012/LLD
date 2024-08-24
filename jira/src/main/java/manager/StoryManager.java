package manager;

import entity.Story;
import entity.Task;

import java.util.List;

public interface StoryManager {

    Story getStory(String storyId) throws Exception;

    Story createStory(String description, String headline, List<Task> taskList) throws Exception;

    Story updateStory(String storyId, Story story) throws Exception;

    boolean deleteStory(String storyId) throws Exception;

}
