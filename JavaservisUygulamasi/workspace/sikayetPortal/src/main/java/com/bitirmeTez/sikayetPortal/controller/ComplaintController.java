package com.bitirmeTez.sikayetPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitirmeTez.sikayetPortal.exception.ResourceNotFoundException;
import com.bitirmeTez.sikayetPortal.model.Complaint;
import com.bitirmeTez.sikayetPortal.model.ResponseAPI;
import com.bitirmeTez.sikayetPortal.repository.ComplaintRepository;

@RestController
@RequestMapping("/complaintAPI")
public class ComplaintController {

	@Autowired
    private ComplaintRepository complaintRepository;
	
	public ComplaintController(ComplaintRepository complaintRepository)
    {
        this.complaintRepository = complaintRepository;
        
    }
	
	@GetMapping("/Complaint")
    public ResponseAPI<List<Complaint>> getAllUsers() throws ResourceNotFoundException {			
		List<Complaint> complaintList = (List<Complaint>) complaintRepository.findAll();						
		return new ResponseAPI<List<Complaint>>("Success", "Get All Complaints Successfully", complaintList );
    }
	
	
}
