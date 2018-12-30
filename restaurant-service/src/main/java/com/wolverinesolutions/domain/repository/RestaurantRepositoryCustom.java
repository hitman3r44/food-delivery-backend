package com.wolverinesolutions.domain.repository;

import com.wolverinesolutions.domain.Restaurant;

import java.util.List;

public interface RestaurantRepositoryCustom {

    List<Restaurant> findByNameContains(String restaurantName);

}
