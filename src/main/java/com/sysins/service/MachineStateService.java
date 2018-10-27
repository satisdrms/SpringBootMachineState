package com.sysins.service;

import com.sysins.beans.MachineStates;
import com.sysins.beans.Token;
import com.sysins.beans.Utilization;

public interface MachineStateService {
	public void loadMachineState(MachineStates machineState);

	public Utilization getUtilizationPercent(Token token);
}
