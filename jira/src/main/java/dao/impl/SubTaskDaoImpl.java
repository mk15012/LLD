package dao.impl;

import dao.SubTaskDao;
import entity.SubTask;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class SubTaskDaoImpl implements SubTaskDao {

    private final Map<String, SubTask> subTaskMap;

    public SubTaskDaoImpl() {
        this.subTaskMap = new HashMap<>();
    }

    @Override
    public SubTask getSubTask(String subTaskId) throws Exception {
        validateSubTask(subTaskId);
        return subTaskMap.get(subTaskId);
    }

    @Override
    public SubTask addSubTask(String parentTaskId, String description, String headline, Date deadLine) {
        SubTask subTask = new SubTask(parentTaskId, description, headline, deadLine);
        String subTaskId = UUID.randomUUID().toString();
        subTask.setId(subTaskId);
        subTaskMap.put(subTaskId, subTask);
        return subTask;
    }
    
    @Override
    public SubTask updateSubTask(String subTaskId, SubTask subTask) throws Exception {
        validateSubTask(subTaskId);
        return subTaskMap.put(subTaskId, subTask);
    }


    @Override
    public boolean deleteSubTask(String subTaskId) throws Exception {
        validateSubTask(subTaskId);
        subTaskMap.remove(subTaskId);
        return true;
    }

    private void validateSubTask(String subTaskId) throws Exception {
        if (!subTaskMap.containsKey(subTaskId)) {
            throw new Exception("Invalid subTaskId");
        }
    }
}
