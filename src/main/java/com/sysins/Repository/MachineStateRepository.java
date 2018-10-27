package com.sysins.Repository;

import org.springframework.data.repository.CrudRepository;
import com.sysins.beans.MachineStates;
import com.sysins.beans.Token;

public interface MachineStateRepository extends CrudRepository<MachineStates, Token> {
	
}
