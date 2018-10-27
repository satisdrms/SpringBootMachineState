package com.sysins.beans;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class MachineState   implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1302512897039278410L;

	@NotNull
	private String state;

	@NotNull
	private Integer duration;


	public void setState(String state) {
		this.state = state;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getState() {
		return state;
	}

	public Integer getDuration() {
		return duration;
	}

	protected MachineState() {
	}

	public MachineState(String state, Integer duration) {
		super();
		this.state = state;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return String.format("MachineState[ state='%s', duration='%d']", state, duration);
	}
}
