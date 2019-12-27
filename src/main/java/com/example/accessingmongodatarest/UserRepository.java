package com.example.accessingmongodatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List findAll() {
        return mongoTemplate.findAll(User.class);
    }

    public User save(User department) {
        mongoTemplate.save(department);
        return department;
    }

    public User update(User user){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(user.getId()));
        Update update = new Update();
        update.set("name", user.getName());
        update.set("lastName", user.getLastName());
        return mongoTemplate.findAndModify(query, update, User.class);
    }

    public List findUserByName(String deptName){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(deptName));
        return mongoTemplate.find(query, User.class);
    }

    public void deleteById(String deptId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(deptId));
        mongoTemplate.remove(query, User.class);
    }
}