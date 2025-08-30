package com.intellect.journalApp.repository;

import com.intellect.journalApp.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.User;


import java.util.List;

public class UserRepositoryImpl {



    @Autowired
    private MongoTemplate mongoTemplate;


    public List<UserEntity> getUserForSA(){

        Query query=new Query();
        query.addCriteria(Criteria.where("name").is("pam"));

        List<UserEntity> users = mongoTemplate.find(query, UserEntity.class);

        return users;
    }
}
