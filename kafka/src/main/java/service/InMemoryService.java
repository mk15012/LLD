package service;

import repository.ConsumerRepository;
import repository.ProducerRepository;
import repository.TopicRepository;

public class InMemoryService {

    ProducerRepository producerRepository = new ProducerRepository();
    ConsumerRepository consumerRepository = new ConsumerRepository();
    TopicRepository topicRepository = new TopicRepository();
}
