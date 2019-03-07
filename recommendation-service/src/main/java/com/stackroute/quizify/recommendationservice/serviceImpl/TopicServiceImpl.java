package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Topic;
import com.stackroute.quizify.recommendationservice.repository.TopicRepository;
import com.stackroute.quizify.recommendationservice.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> getAll() {
        return topicRepository.getAllNodes();
    }

    @Override
    public List<Topic> getTopicsByCategory(long categoryId) {
        return topicRepository.getTopicsByCategory(categoryId);
    }
}
