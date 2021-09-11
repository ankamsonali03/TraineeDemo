package com.abc.Traineedemo.service;

import java.util.List;

import com.abc.Traineedemo.entity.Trainee;

public interface TraineeService {
	
	
	public Trainee fetchTraineeById(int TraineeId);
	
	public List<Trainee> fetchAllTrainees();
	
	public List<Trainee> fetchTraineeByName(String traineeName);
	
	public void updateTrainee(Trainee trainee);
	
	public void deleteTrainee(int traineeId);
	
}
