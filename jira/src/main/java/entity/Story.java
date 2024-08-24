package entity;

import enums.Status;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Story {

    private String id;
    private String userId;
    private String title;
    private String description;
    private List<Task> taskList;
    private Status status;
    private Date createdOn;

    public Story(String title, String description, List<Task> taskList) {
        this.title = title;
        this.description = description;
        this.taskList = taskList;
    }
}
