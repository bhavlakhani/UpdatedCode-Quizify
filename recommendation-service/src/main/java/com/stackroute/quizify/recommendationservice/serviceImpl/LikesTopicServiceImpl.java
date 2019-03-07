package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.LikesTopic;
import com.stackroute.quizify.recommendationservice.domain.Topic;
import com.stackroute.quizify.recommendationservice.domain.User;
import com.stackroute.quizify.recommendationservice.repository.LikesTopicRelationshipRepository;
import com.stackroute.quizify.recommendationservice.service.LikesTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

@Service
public class LikesTopicServiceImpl implements LikesTopicService {

    private LikesTopicRelationshipRepository likesTopicRelationshipRepository;

    @Autowired
    public LikesTopicServiceImpl(LikesTopicRelationshipRepository likesTopicRelationshipRepository) {
        this.likesTopicRelationshipRepository = likesTopicRelationshipRepository;
    }

    @Override
    public List<LikesTopic> getAllRelationships() {
        return likesTopicRelationshipRepository.getAllRelationships();
    }


    @Override
    public List<LikesTopic> createRelationship(User user) {
        long userId=user.getId();
        List<Topic> topicList=user.getTopics();
        ListIterator<Topic> topicsIterator = topicList.listIterator();
        System.out.println(topicsIterator.hasNext());
        while(topicsIterator.hasNext()){
            Topic topic=topicsIterator.next();
            System.out.println(topic.toString());
            long topicId=topic.getId();
            System.out.println("userId: "+userId+"topicId: "+topicId);
            likesTopicRelationshipRepository.createRelationship(userId,topicId);
        }
        return null;
    }

}
