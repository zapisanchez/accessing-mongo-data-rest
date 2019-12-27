package com.example.accessingmongodatarest;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<User, String> {

    @Query(value = "{'wallets.id': ?0}", fields = "{'wallets' : 0}")
    User findUserByWalletId(String walletId);

    List findUserByName(String name);

//    List<User> findByName(@Param("name") String name);
//    List<User> findByLastName(@Param("name") String name);
//    Optional<User> findById(@Param("id") String id);

}
