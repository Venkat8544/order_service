package com.ecom.orderservice.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@Builder
public class Users {
    @Id
    private String id;
    private String userName;
    private String password;
}
