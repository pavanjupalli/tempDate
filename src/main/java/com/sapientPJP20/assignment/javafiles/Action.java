package com.sapientPJP20.assignment.javafiles;

import java.io.Serializable;

public class Action implements Serializable{
	
	private String inputOne;
	
	private String inputTwo;
	
	private String operation;
	
	private String output;
	
	private String sessionId;
	

	public Action() {
		super();
	}
	
	

	public Action(String inputOne, String inputTwo, String operation, String output, String sessionId) {
		super();
		this.inputOne = inputOne;
		this.inputTwo = inputTwo;
		this.operation = operation;
		this.output = output;
		this.sessionId = sessionId;
	}



	public String getSessionId() {
		return sessionId;
	}



	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}



	public String getInputOne() {
		return inputOne;
	}

	public void setInputOne(String inputOne) {
		this.inputOne = inputOne;
	}

	public String getInputTwo() {
		return inputTwo;
	}

	public void setInputTwo(String inputTwo) {
		this.inputTwo = inputTwo;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}



	@Override
	public String toString() {
		return "Action [inputOne=" + inputOne + ", inputTwo=" + inputTwo + ", operation=" + operation + ", output="
				+ output + ", sessionId=" + sessionId + "]";
	}

}
