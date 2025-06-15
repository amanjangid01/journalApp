package com.intellect.journalApp.repository;


import com.intellect.journalApp.entity.JournalEntry;
import com.intellect.journalApp.entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, ObjectId> {

    UserEntity findByUserName(String userName);

    void deleteByUserName(String userName);
}
