package com.revature.tuition.service;

import java.io.InputStream;

public interface FileService {
	public Boolean attachFile(int id, String target, InputStream is);
}
