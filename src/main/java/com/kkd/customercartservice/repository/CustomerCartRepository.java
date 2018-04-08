package com.kkd.customercartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kkd.customercartservice.modal.CustomerCartDetails;

public interface CustomerCartRepository extends MongoRepository<CustomerCartDetails, String> {

}
