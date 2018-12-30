package com.wolverinesolutions.service;

import com.wolverinesolutions.domain.Restaurant;

import java.util.List;


public interface RestaurantInfoService {

    List<Restaurant> findAllRestaurant();

    Restaurant findRestaurantById(String restaurantId);

    List<Restaurant> findRestaurantsByNameContains(String restaurantName);

    Iterable<Restaurant> findAllItems(String restaurantId);

    void createRestaurant(Restaurant restaurant);

    void createRestaurants(List<Restaurant> restaurants);


    // TODO
    // get active items only
    // add sorting and pagination
    // find restaurants in one city
    // find restaurants near one location
}
