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
import com.myproject.dto.TouristDTO;
import com.myproject.service.TouristService;

@RestController
@RequestMapping("/tourist")
public class TouristController {

	@Autowired
	TouristService service;

	@GetMapping(value = "/getAll")
	public ResponseEntity<ResultDTO<List<TouristDTO>>> getTouristDTO(){
		
		ResultDTO<List<TouristDTO>> result = new ResultDTO<List<TouristDTO>>();
		List<TouristDTO> list = service.getTourist();
		
		if(list.size()>0) {
			result.setData(list);
			result.setSuccess(true);
			result.setCount(list.size());
		}
		else {
			result.setError("There are no tourists !");
			result.setSuccess(false);
		}
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/getTouristByName")
	public ResponseEntity<ResultDTO<List<TouristDTO>>> getTouristByName(@RequestBody TouristDTO request ){
		
		ResultDTO<List<TouristDTO>> result = new ResultDTO<List<TouristDTO>>();
		List<TouristDTO> list = new ArrayList<>();
		
		if(request.getTouristName() !=null) {
			list = service.getTouristByName(request);
			
			if(list.size()>0) {
				result.setData(list);
				result.setCount(list.size());
				result.setSuccess(true);
			}
			else {
				result.setError("No tourist with this name! ");
				result.setSuccess(false);
			}
		}
		else {
			result.setError("Put a name to get the results!");
			result.setSuccess(false);
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/insertTourist")
	public ResponseEntity<ResultDTO<Integer>> insertTourist(@RequestBody TouristDTO request ){
		
		ResultDTO<Integer> result = new ResultDTO<Integer>();
		
		if((request.getTouristName() !=null && !request.getTouristName().equals(""))
				&& (request.getTouristSurname()!=null && !request.getTouristSurname().equals(""))
				&& (request.getTouristEmail()!= null && !request.getTouristEmail().equals(""))
				&& request.getTouristBithdate()!=null) {
			int inserted = service.insertTourist(request);
			
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
			result.setError("Put data to insert a tourist!");
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/updateTourist")
	public ResponseEntity<ResultDTO<Integer>> updateTourist(@RequestBody TouristDTO request){
		
		ResultDTO<Integer> result = new ResultDTO<Integer>();
		
		if((request.getIdTourist()!=null && request.getIdTourist()!=0)
				&&(request.getTouristName() !=null && !request.getTouristName().equals(""))
				&& (request.getTouristSurname()!=null && !request.getTouristSurname().equals(""))
				&& (request.getTouristEmail()!= null && !request.getTouristEmail().equals(""))
				&& request.getTouristBithdate()!=null) {
			int updated = service.updateTourist(request);
			
			if(updated>0) {
				result.setData(updated);
				result.setSuccess(true);
			}
			else {
				result.setError("Update gone wrong !");	
			}
		}
		else {
			result.setError("Put data to update !");
		}
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/deleteTourist")
	public ResponseEntity<ResultDTO<Integer>> deleteTourist(@RequestBody TouristDTO request){
		
		ResultDTO<Integer> result = new ResultDTO<Integer>();
		
		if(request.getIdTourist()!=null && request.getIdTourist()!=0) {
			int deleted = service.deleteTourist(request);
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
