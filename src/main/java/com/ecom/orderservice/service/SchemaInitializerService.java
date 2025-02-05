package com.ecom.orderservice.service;

import com.ecom.orderservice.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SchemaInitializerService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void init() {
        // Creating the "users" collection with custom options if needed
        if (!mongoTemplate.collectionExists(Users.class)) {
            mongoTemplate.createCollection(Users.class, CollectionOptions.empty());
        }

        // Insert initial users if the collection is empty
        if (mongoTemplate.count(new Query(), Users.class) == 0) {
            insertSampleUsers();
        }
    }

    private void insertSampleUsers() {
        // Create some sample Users
        Users user1 = Users.builder().userName("john_doe").password("password123").build();
        Users user2 = Users.builder().userName("jane_doe").password("securePass456").build();
        Users user3 = Users.builder().userName("alice_smith").password("alicePass789").build();

        // Insert users into the "users" collection
        mongoTemplate.save(user1);
        mongoTemplate.save(user2);
        mongoTemplate.save(user3);
    }
}
