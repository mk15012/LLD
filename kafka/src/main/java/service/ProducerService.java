package service;

import dto.Producer;
import repository.ProducerRepository;
import repository.TopicRepository;

public class ProducerService {

    public void createProducer(String producerId) {
        Producer producer = new Producer(producerId);
        ProducerRepository.getProducerMap().put(producerId, producer);
    }

    public boolean publish(String producerId, String message, String topicId) {
        TopicRepository.getTopicMap().get(topicId).getMessage().add(message);
        TopicRepository.getTopicMap().get(topicId).getProducerList().add(producerId);
        return true;

    }
}
