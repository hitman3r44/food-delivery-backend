package com.wolverinesolutions.domain.repository;

import com.wolverinesolutions.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String>, RestaurantRepositoryCustom {
}
