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
import com.myproject.dto.ResultDTO;
import com.myproject.dto.TravelDTO;
import com.myproject.service.TravelService;

@RestController
@RequestMapping("travel")
public class TravelController {

	@Autowired
	TravelService service;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<ResultDTO<List<TravelDTO>>> getTravel(){
		
		ResultDTO<List<TravelDTO>> result = new ResultDTO<List<TravelDTO>>();
		List<TravelDTO> list = service.getTravel();
		
		if(list.size()>0) {
		result.setData(list);
		result.setSuccess(true);
		result.setCount(list.size());
		}
		else {
			result.setError("There are no travels !");
			result.setSuccess(false);
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/getTravelByDates")
	public ResponseEntity<ResultDTO<List<TravelDTO>>> getTravelByDates(@RequestBody TravelDTO request ){
		
		ResultDTO<List<TravelDTO>> result = new ResultDTO<List<TravelDTO>>();
		List<TravelDTO> list = new ArrayList<>();
		
		if(request.getDateFrom() !=null || request.getDateTo()!=null) {
			list = service.getTravelByDates(request);
			
			if(list.size()>0) {
				result.setData(list);
				result.setCount(list.size());
				result.setSuccess(true);
			}
			else {
				result.setError("No travels with this dates! ");
				result.setSuccess(false);
			}
		}
		else {
			result.setError("Put a date to get the results!");
			result.setSuccess(false);
		}
		return ResponseEntity.ok(result);
	}
}
