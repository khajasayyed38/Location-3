package com.locationweb3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locationweb3.entity.Location;

public interface Locationrepository extends JpaRepository<Location, Long> {

}
