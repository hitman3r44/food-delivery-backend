package com.wolverinesolutions.service.impl;

import com.wolverinesolutions.domain.Restaurant;
import com.wolverinesolutions.domain.repository.RestaurantRepository;
import com.wolverinesolutions.service.RestaurantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RestaurantInfoServiceImpl implements RestaurantInfoService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantInfoServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> findAllRestaurant() {
        return this.restaurantRepository.findAll();
    }

    @Override
    public Restaurant findRestaurantById(String restaurantId) {
        return (Restaurant) this.restaurantRepository.findAllById(Collections.singleton(restaurantId));
    }

    @Override
    public List<Restaurant> findRestaurantsByNameContains(String restaurantName) {
        return this.restaurantRepository.findByNameContains(restaurantName);
    }

    @Override
    public Iterable<Restaurant> findAllItems(String restaurantId) {
        return this.restaurantRepository.findAllById(Collections.singleton(restaurantId));
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        this.restaurantRepository.save(restaurant);
    }

    @Override
    public void createRestaurants(List<Restaurant> restaurants) {
        this.restaurantRepository.saveAll(restaurants);
    }
}
