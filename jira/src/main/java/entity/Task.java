package entity;

import enums.Status;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Task {

    private String id;
    private String parentStoryId;
    private String userId;
    private String title;
    private String description;
    private Status status;
    private Date createdOn;
    private Date deadLine;
    private List<SubTask> subTaskList;

    public Task(String description, String title, Date deadLine) {
        this.description = description;
        this.title = title;
        this.subTaskList = new ArrayList<>();
        this.createdOn = new Date();
        this.status = Status.CREATED;
        this.deadLine = deadLine;
    }

    public Task(String title, String description, Date deadLine, String parentStoryId) {
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.parentStoryId = parentStoryId;
    }
}
