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

import com.myproject.dto.DestinationDTO;
import com.myproject.dto.ResultDTO;
import com.myproject.service.DestinationService;

@RestController
@RequestMapping("/destination")
public class DestinationController {

	@Autowired
	DestinationService service;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<ResultDTO<List<DestinationDTO>>> getDestination() {
		
		ResultDTO<List<DestinationDTO>> result = new ResultDTO<List<DestinationDTO>>();
		
		List<DestinationDTO> list = service.getDestination();
		
		if(list.size()>0) {
			result.setData(list);
			result.setSuccess(true);
			result.setCount(list.size());
		}
		else {
			result.setError("There are no destinations !");
			result.setSuccess(false);
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/getDestinationByCountry")
	public ResponseEntity<ResultDTO<List<DestinationDTO>>> getDestinationByCountry(@RequestBody DestinationDTO request ){
		
		ResultDTO<List<DestinationDTO>> result = new ResultDTO<List<DestinationDTO>>();
		List<DestinationDTO> list = new ArrayList<>();
		
		if(request.getCountryName() !=null && !request.getCountryName().equals("")) {
			list = service.getDestinationByCountry(request);
			
			if(list.size()>0) {
				result.setData(list);
				result.setCount(list.size());
				result.setSuccess(true);
			}
			else {
				result.setError("No destination with this country! ");
				result.setSuccess(false);
			}
		}
		else {
			result.setError("Put a destination country to get the results!");
			result.setSuccess(false);
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/insertDestination")
	public ResponseEntity<ResultDTO<Integer>> insertDestination(@RequestBody DestinationDTO request ){
		
		ResultDTO<Integer> result = new ResultDTO<Integer>();

		
		if((request.getCountryName() !=null && !request.getCountryName().equals(""))
				&& (request.getCityName() !=null && !request.getCityName().equals(""))) {
			int inserted = service.insertDestination(request);
			
			if(inserted>0) {
				result.setData(inserted);
				result.setSuccess(true);
			}
			else {
				result.setError("Insert of destination gone wrong! ");
				result.setSuccess(false);
			}
		}
		else {
			result.setError("Put a destination country and city to insert !");
			result.setSuccess(false);
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/updateDestination")
	public ResponseEntity<ResultDTO<Integer>> updateDestination(@RequestBody DestinationDTO request ){
		
		ResultDTO<Integer> result = new ResultDTO<Integer>();

		
		if((request.getCountryName() !=null && !request.getCountryName().equals(""))
				&& (request.getCityName() !=null && !request.getCityName().equals(""))) {
			int updated = service.updateDestination(request);
			
			if(updated>0) {
				result.setData(updated);
				result.setSuccess(true);
			}
			else {
				result.setError("Update of destination gone wrong! ");
				result.setSuccess(false);
			}
		}
		else {
			result.setError("Put a destination country and city to update !");
			result.setSuccess(false);
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/deleteDestination")
	public ResponseEntity<ResultDTO<Integer>> deleteDestination(@RequestBody DestinationDTO request ){
		
		ResultDTO<Integer> result = new ResultDTO<Integer>();

		
		if(request.getIdDestination()!=null && request.getIdDestination() !=0) {
			int deleted = service.deleteDestination(request);
			
			if(deleted>0) {
				result.setData(deleted);
				result.setSuccess(true);
			}
			else {
				result.setError("Delete of destination gone wrong! ");
				result.setSuccess(false);
			}
		}
		else {
			result.setError("Put a valid id to delete !");
		}
		return ResponseEntity.ok(result);
}
}
