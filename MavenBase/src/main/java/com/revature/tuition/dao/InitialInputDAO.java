package com.revature.tuition.dao;

import com.revature.tuition.pojo.InitialInput;

public interface InitialInputDAO {

	public boolean createInitialInput(InitialInput initialInput);
	public InitialInput readInitialInput(int initialInputId);
	public boolean updateInitialInput(InitialInput initialInput);
	public boolean deleteInitialInput(int initialInputId);
	
}
