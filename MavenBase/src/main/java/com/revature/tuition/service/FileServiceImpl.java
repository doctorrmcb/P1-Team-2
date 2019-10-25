package com.revature.tuition.service;

import java.io.File;
import java.io.InputStream;

import com.revature.tuition.dao.InitialInputDAOImpl;
import com.revature.tuition.pojo.InitialInput;
import com.revature.tuition.util.StreamFactory;

public class FileServiceImpl implements FileService {
	private static InitialInputDAOImpl initialInputDAO = new InitialInputDAOImpl();

	@Override
	public Boolean attachFile(int id, String target, InputStream is) {
		InitialInput initialInput = initialInputDAO.readInitialInput(id);

		if ("event".contentEquals(target)) {
			// File goes to event section of initialInput.
			File file = new File(initialInput.getEventFileName());
			file = StreamFactory.getFileCopy(file, is);
			initialInput.setEventAttachment(file);
		} else {
			// File goes to approval section of initialInput.
			File file = new File(initialInput.getApprovalFileName());
			file = StreamFactory.getFileCopy(file, is);
			initialInput.setApprovalAttachment(file);
		}
		boolean result = initialInputDAO.updateInitialInput(initialInput);
		return result;

	}

}
