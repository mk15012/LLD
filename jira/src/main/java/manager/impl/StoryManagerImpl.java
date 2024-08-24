package manager.impl;

import dao.StoryDao;
import dao.UserDao;
import entity.Story;
import entity.Task;
import manager.StoryManager;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class StoryManagerImpl implements StoryManager {

    StoryDao storyDao;
    UserDao userDao;

    @Override
    public Story getStory(String storyId) throws Exception {
        return storyDao.getStory(storyId);
    }

    @Override
    public Story createStory(String description, String headline, List<Task> taskList) throws Exception {
        return storyDao.createStory(description, headline, taskList);
    }


    @Override
    public Story updateStory(String storyId, Story story) throws Exception {
        return storyDao.updateStory(storyId, story);
    }

    @Override
    public boolean deleteStory(String storyId) throws Exception {
        storyDao.deleteStory(storyId);
        return true;
    }

}
