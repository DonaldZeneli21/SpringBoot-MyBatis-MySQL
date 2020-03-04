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

import com.myproject.dto.ReservationDTO;
import com.myproject.dto.ResultDTO;
import com.myproject.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ReservationService service;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<ResultDTO<List<ReservationDTO>>> getReservation(){
		
		ResultDTO<List<ReservationDTO>> result = new ResultDTO<List<ReservationDTO>>();
		List<ReservationDTO> list = service.getReservation();
		
		if(list.size()>0) {
			result.setData(list);
			result.setSuccess(true);
			result.setCount(list.size());
		}
		else {
			result.setError("There are no reservations!");
			result.setSuccess(false);
		}
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/getReservationByDate")
	public ResponseEntity<ResultDTO<List<ReservationDTO>>> getReservationByDate(@RequestBody ReservationDTO request ){
		
		ResultDTO<List<ReservationDTO>> result = new ResultDTO<List<ReservationDTO>>();
		List<ReservationDTO> list = new ArrayList<>();
		
		if(request.getReservationDate() !=null) {
			list = service.getReservationByDate(request);
			
			if(list.size()>0) {
				result.setData(list);
				result.setCount(list.size());
				result.setSuccess(true);
			}
			else {
				result.setError("No reservation with this date! ");
				result.setSuccess(false);
			}
		}
		else {
			result.setError("Put a reservation date to get the results!");
			result.setSuccess(false);
		}
		return ResponseEntity.ok(result);
	}
}
