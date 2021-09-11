package com.abc.Traineedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.Traineedemo.entity.Trainee;

public interface TraineeRepository extends JpaRepository{
	public List<Trainee> findByName(String traineeName);

}
