package com.abc.Traineedemo.exception;

public class TraineeNotExistingException extends RuntimeException{
	
	public TraineeNotExistingException() {
		
	}
	
	public TraineeNotExistingException(String message) {
		super(message);
	}

}
