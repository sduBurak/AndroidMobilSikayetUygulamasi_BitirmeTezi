package com.bitirmeTez.sikayetPortal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bitirmeTez.sikayetPortal.model.Attachment;

@Repository
public interface AttachmentRepository extends CrudRepository<Attachment, Integer>{

}
