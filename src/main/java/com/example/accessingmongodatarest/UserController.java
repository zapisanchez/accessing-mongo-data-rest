package com.example.accessingmongodatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {

    @Autowired
    private MongoTemplate mongoTemplate;

    private PersonRepository personRepository;

    public UserController()
    {
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        personRepository.save(user);
        return user;
    }
    //equivalent implementation using MongoTemplate for Create operation
    public User save(User user) {
        mongoTemplate.save(user);
        return user;
    }

    @GetMapping
    public List listUsers(){
        return personRepository.findAll();
    }
    //equivalent implementation using MongoTemplate for Read operation
    public List findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable String userId) {
        user.setId(userId);
        personRepository.save(user);
        return user;
    }
    //equivalent implementation using MongoTemplate for update operation
    public User update(User user){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(user.getId()));
        Update update = new Update();
        update.set("name", user.getName());
        update.set("lastName", user.getLastName());
        return mongoTemplate.findAndModify(query, update, User.class);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        personRepository.deleteById(userId);
        return userId;
    }
    //equivalent implementation using MongoTemplate for delete operation
    public void deleteById(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(userId));
        mongoTemplate.remove(query, User.class);
    }

    @GetMapping("/{userName}")
    public List findUsrByName(@PathVariable String userName) {
        return personRepository.findUserByName(userName);
    }
    //equivalent implementation using MongoTemplate
    public List findUserByName(String userName){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(userName));
        return mongoTemplate.find(query, User.class);
    }


    @GetMapping("{name}/usr")
    public User listUser(@PathVariable String idWallet){
        return personRepository.findUserByWalletId(idWallet);
    }

}
