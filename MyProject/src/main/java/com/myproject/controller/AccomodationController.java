package com.myproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.dto.AccomodationDTO;
import com.myproject.dto.ResultDTO;
import com.myproject.service.AccomodationService;

@RestController
@RequestMapping("/accomodation")
public class AccomodationController {

	@Autowired
	AccomodationService service;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<ResultDTO<List<AccomodationDTO>>> getAccomodation(){
		
		ResultDTO<List<AccomodationDTO>> result = new ResultDTO<List<AccomodationDTO>>();
		
		List<AccomodationDTO> list = service.getAccomodation();
		
		if(list.size()>0) {
			result.setData(list);
			result.setSuccess(true);
			result.setCount(list.size());
		}
		else {
			result.setError("There are no accomodations !");
			result.setSuccess(false);
		}
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/getAccomodationByType")
	public ResponseEntity<ResultDTO<List<AccomodationDTO>>> getAccomodationByType(@RequestBody AccomodationDTO request ){
		
		ResultDTO<List<AccomodationDTO>> result = new ResultDTO<List<AccomodationDTO>>();
		List<AccomodationDTO> list = new ArrayList<>();
		
		if(request.getAccomodationType() !=null && !request.getAccomodationType().equals("")) {
			list = service.getAccomodationByType(request);
			
			if(list.size()>0) {
				result.setData(list);
				result.setCount(list.size());
				result.setSuccess(true);
			}
			else {
				result.setError("No accomodation with this type! ");
				result.setSuccess(false);
			}
		}
		else {
			result.setError("Put a accomodation type to get the results!");
			result.setSuccess(false);
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/insertAccomodation")
	public ResponseEntity<ResultDTO<Integer>> insertAccomodation(@RequestBody AccomodationDTO request ){
		
		ResultDTO<Integer> result = new ResultDTO<Integer>();
		
		
		if((request.getAccomodationType() !=null && !request.getAccomodationType().equals(""))
				&& (request.getAddress() !=null && !request.getAddress().equals(""))
				&& request.getCost()!=0 && request.getRoomNumber() !=0) {
			int inserted = service.insertAccomodation(request);
			
			if(inserted>0) {
				result.setData(inserted);
				result.setSuccess(true);
			}
			else {
				result.setError("Insert gone wrong! ");
				result.setSuccess(false);
			}
		}
		else {
			result.setError("Put the data to insert !");
			result.setSuccess(false);
		}
		return ResponseEntity.ok(result);

	}
	
	@PostMapping(value = "/updateAccomodation")
	public ResponseEntity<ResultDTO<Integer>> updateAccomodation(@RequestBody AccomodationDTO request){
		
		ResultDTO<Integer> result = new ResultDTO<Integer>();
		
		if((request.getIdAccomodation()!=null && request.getIdAccomodation()!=0)
				&&(request.getAccomodationType() !=null && !request.getAccomodationType().equals(""))
				&& (request.getAddress() !=null && !request.getAddress().equals(""))
				&& request.getCost()!=0 && request.getRoomNumber() !=0) {
			int updated = service.updateAccomodation(request);
			if(updated >0) {
				result.setData(updated);
				result.setSuccess(true);
			}
			else {
				result.setError("Update gone wrong !");
				}
		}
		else {
			result.setError("Put the needed data to update !");
			}
	
		return ResponseEntity.ok(result);
	
	}
	
	@PostMapping(value = "/deleteAccomodation")
	public ResponseEntity<ResultDTO<Integer>> deleteAccomodation(@RequestBody AccomodationDTO request){
		
		ResultDTO<Integer> result = new ResultDTO<Integer>();
		
		if(request.getIdAccomodation()!=null && request.getIdAccomodation()!=0) {
			int deleted = service.deleteAccomodation(request);
			if(deleted>0) {
				result.setData(deleted);
				result.setSuccess(true);
			}
			else {
				result.setError("Delete gone wrong !");
			}
		}
		else {
			result.setError("Put a valid Id to delete !");
		}
		
		return ResponseEntity.ok(result);
	}
}