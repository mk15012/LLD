package service;

import dto.Consumer;
import repository.ConsumerRepository;
import repository.TopicRepository;

import java.util.List;

public class ConsumerService {

    public Consumer createConsumer(String consumerId) {
        Consumer consumer = new Consumer(consumerId);
        ConsumerRepository.getConsumerMap().put(consumerId, consumer);
        return consumer;
    }

    public void consume(String consumerId) {

        List<String> topicIdList = ConsumerRepository.getConsumerMap().get(consumerId).getTopicIdList();
        for (String topicId : topicIdList) {
            int currOffset = TopicRepository.getTopicMap().get(topicId).getConsumerOffset().get(consumerId);
            if (currOffset > TopicRepository.getTopicMap().get(topicId).getMessage().size() - 1)
                continue;

            String message = TopicRepository.getTopicMap().get(topicId).getMessage().get(currOffset);
            TopicRepository.getTopicMap().get(topicId).getConsumerOffset().put(consumerId, currOffset + 1);
            System.out.println(consumerId + " received " + message);
        }
    }

    public void subscribeToTopic(String consumerId, String topicId) {
        TopicRepository.getTopicMap().get(topicId).getConsumerList().add(consumerId);
        TopicRepository.getTopicMap().get(topicId).getConsumerOffset().put(consumerId, 0);
        ConsumerRepository.getConsumerMap().get(consumerId).getTopicIdList().add(topicId);
    }

    public void pullMessages() {
        while (true) {
            ConsumerRepository.getConsumerMap().keySet().forEach(consumerID -> consume(consumerID));
        }
    }

}
