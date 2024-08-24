package dto;

import java.util.ArrayList;
import java.util.List;

public class Consumer {

    private String consumerId;
    List<String> topicIdList;

    public Consumer(String consumerId) {
        this.consumerId = consumerId;
        this.topicIdList = new ArrayList<>();
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public List<String> getTopicIdList() {
        return topicIdList;
    }

    public void setTopicIdList(List<String> topicIdList) {
        this.topicIdList = topicIdList;
    }
}
