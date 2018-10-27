package com.sysins.beans;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "MACHINESTATES")
public class MachineStates {

	@EmbeddedId
	private Token token;
	
	
    @ElementCollection
    @CollectionTable(name = "MACHINESTATE", joinColumns = @JoinColumn(name = "token"))
    @Column(name = "machine_states")
	private List<MachineState> machineStates;

	public List<MachineState> getMachineStates() {
		return machineStates;
	}

	public void setMachineStates(List<MachineState> machineStates) {
		this.machineStates = machineStates;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public Token getToken() {
		return token;
	}

	protected MachineStates() {
	}

	public MachineStates(Token token, List<MachineState> machineStates) {
		super();
		this.token = token;
		this.machineStates = machineStates;
	}

	@Override
	public String toString() {
		return String.format("MachineState[token=%s, \"Machine States Length\"=%s']", token.toString(),
				machineStates.size());
	}
}
