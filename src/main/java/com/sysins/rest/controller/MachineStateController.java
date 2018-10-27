package com.sysins.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sysins.RandomTokenGenerator.RandomString;
import com.sysins.beans.MachineState;
import com.sysins.beans.MachineStates;
import com.sysins.beans.Token;
import com.sysins.beans.Utilization;
import com.sysins.service.MachineStateService;

@RestController
public class MachineStateController {

	@Autowired
	private MachineStateService machineStateService;

	public void setMachineStateRepository(MachineStateService machineStateService) {
		this.machineStateService = machineStateService;

	}

	@RequestMapping(value = "/getutilizationpercent", method = RequestMethod.GET)
	@ResponseBody
	public Utilization getUtilizationPercent(@RequestParam(name = "token", required = true) String token) {
		Token tokenObj = new Token(token);
		Utilization utlization=machineStateService.getUtilizationPercent(tokenObj);
		return utlization;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/loadmachinestate", consumes = "application/json")
	@ResponseBody
	public Token loadJson(@RequestBody List<MachineState> machineStates) {
		Token tokenObj = new Token(RandomString.getInstance().nextString());
		MachineStates ormMachineStates = new MachineStates(tokenObj, machineStates);
		machineStateService.loadMachineState(ormMachineStates);
		return tokenObj;
	}

}
