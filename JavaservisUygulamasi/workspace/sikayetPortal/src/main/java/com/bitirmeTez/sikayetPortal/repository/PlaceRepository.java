package com.bitirmeTez.sikayetPortal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bitirmeTez.sikayetPortal.model.Place;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer>{

}
