package dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Topic {
    private String topicId;
    private List<String> producerList;
    private List<String> consumerList;
    private List<String> message;
    private Map<String, Integer> consumerOffset;

    public Topic(String topicId) {
        this.topicId = topicId;
        this.producerList = new ArrayList<>();
        this.consumerList = new ArrayList<>();
        message = new ArrayList<>();
        consumerOffset = new ConcurrentHashMap<>();
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public List<String> getProducerList() {
        return producerList;
    }

    public void setProducerList(List<String> producerList) {
        this.producerList = producerList;
    }

    public List<String> getConsumerList() {
        return consumerList;
    }

    public void setConsumerList(List<String> consumerList) {
        this.consumerList = consumerList;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Map<String, Integer> getConsumerOffset() {
        return consumerOffset;
    }

    public void setConsumerOffset(Map<String, Integer> consumerOffset) {
        this.consumerOffset = consumerOffset;
    }
}
