package com.sysins.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysins.Repository.MachineStateRepository;
import com.sysins.beans.MachineState;
import com.sysins.beans.MachineStates;
import com.sysins.beans.Token;
import com.sysins.beans.Utilization;

@Service
public class MachineStateServiceImpl implements MachineStateService {

	@Autowired
	private MachineStateRepository machineStateRepository;

	public void setMachineStateRepository(MachineStateRepository machineStateRepository) {
		this.machineStateRepository = machineStateRepository;
	}

	@Override
	public void loadMachineState(MachineStates machineStates) {
		machineStateRepository.save(machineStates);
	}

	@Override
	public Utilization getUtilizationPercent(Token token) {
		Optional<MachineStates> machineStates = machineStateRepository.findById(token);
		Float totalTime = (float) 0.0, producingTime = (float) 0.0;
		Utilization utilization = null;
		if (machineStates.isPresent()) {
			System.out.println("Machine state is" + machineStates.get().toString());
			for (MachineState machineState : machineStates.get().getMachineStates()) {
				totalTime = totalTime + machineState.getDuration();
				if (machineState.getState().equals("producing")) {
					producingTime = producingTime + machineState.getDuration();
				}
				System.out.println("Machine state is" + machineState.toString());
			}
		}
		if (!producingTime.equals((float) 0.0)) {
			utilization = new Utilization((producingTime / totalTime) * 100);
		}
		return utilization;
	}

}
