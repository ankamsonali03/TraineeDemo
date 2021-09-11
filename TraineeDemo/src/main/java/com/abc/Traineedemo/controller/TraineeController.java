package com.abc.Traineedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abc.Traineedemo.entity.Trainee;
import com.abc.Traineedemo.exception.TraineeNotExistingException;
import com.abc.Traineedemo.service.TraineeService;

@Controller
@RequestMapping("/trainee")
public class TraineeController {
	
	@Autowired
	public TraineeService traineeService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getTraineeDetails(@PathVariable("id") int TraineeId){
		ResponseEntity<Object> respEntity=null;
		
		try {
			Trainee trainee=traineeService.fetchTraineeById(TraineeId);
			respEntity=new ResponseEntity<>(trainee,HttpStatus.OK);
		}catch(TraineeNotExistingException e) {
			respEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		return respEntity;
	}
	
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<Object> getTraineeByName(@PathVariable("name") String traineeName){
		ResponseEntity<Object> respEntity=null;
		List<Trainee> trainee=traineeService.fetchTraineeByName(traineeName);
		respEntity=new ResponseEntity<>(trainee,HttpStatus.OK);
		
		return respEntity;
	}
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Trainee>> getallTrainee(){
		List<Trainee> trainee=traineeService.fetchAllTrainees();
		return new ResponseEntity<>(trainee,HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTrainee(@RequestBody Trainee trainee){
		traineeService.updateTrainee(trainee);
		return new ResponseEntity<>("Updated Suceessfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTrainee(@PathVariable("id") int traineeId)
	{
		traineeService.deleteTrainee(traineeId);
		return new ResponseEntity<>("Treainee deleted",HttpStatus.OK);
	}
	
	
	
}
