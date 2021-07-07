package com.bitirmeTez.sikayetPortal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bitirmeTez.sikayetPortal.model.Complaint;

@Repository
public interface ComplaintRepository extends CrudRepository<Complaint, Integer> {
	

}
