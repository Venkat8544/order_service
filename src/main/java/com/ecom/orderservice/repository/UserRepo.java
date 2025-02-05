package com.ecom.orderservice.repository;

import com.ecom.orderservice.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<Users,String> {

  Users findByUserName(String username);
}
