package com.abc.Traineedemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.Traineedemo.entity.Trainee;
import com.abc.Traineedemo.exception.TraineeNotExistingException;
import com.abc.Traineedemo.repository.TraineeRepository;

@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	private TraineeRepository traineeRepository;
	@Override
	public Trainee fetchTraineeById(int traineeId) {
		Optional<Trainee> optionalTrainee=traineeRepository.findById(traineeId);
		if(optionalTrainee.isEmpty()) {
			throw new TraineeNotExistingException("Trainee not Existing:" +traineeId);
		}
		Trainee trainee=optionalTrainee.get();
		return trainee;
	}

	@Override
	public List<Trainee> fetchAllTrainees() {
		List<Trainee> traineeList=traineeRepository.findAll();
		return traineeList;
	}

	@Override
	public List<Trainee> fetchTraineeByName(String traineeName) {
		return traineeRepository.findByName(traineeName);
	}

	@Override
	public void updateTrainee(Trainee trainee) {
		traineeRepository.save(trainee);
	}

	@Override
	public void deleteTrainee(int traineeId) {
		traineeRepository.deleteById(traineeId);
		
	}
		

}
