package dao.impl;

import dao.StoryDao;
import entity.Story;
import entity.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class StoryDaoImpl implements StoryDao {

    private final Map<String, Story> storyMap;

    public StoryDaoImpl() {
        this.storyMap = new HashMap<>();
    }

    @Override
    public Story getStory(String storyId) throws Exception {
        validateStory(storyId);
        return storyMap.get(storyId);
    }

    @Override
    public Story createStory(String description, String headline, List<Task> taskList) {
        Story story = new Story(description, headline, taskList);
        String storyId = UUID.randomUUID().toString();
        story.setId(storyId);
        storyMap.put(storyId, story);
        return story;
    }

    @Override
    public Story updateStory(String storyId, Story story) throws Exception {
        validateStory(storyId);
        return storyMap.put(storyId, story);
    }


    @Override
    public boolean deleteStory(String storyId) throws Exception {
        validateStory(storyId);
        storyMap.remove(storyId);
        return true;
    }

    private void validateStory(String storyId) throws Exception {
        if (!storyMap.containsKey(storyId)) {
            throw new Exception("Invalid storyId");
        }
    }
}
