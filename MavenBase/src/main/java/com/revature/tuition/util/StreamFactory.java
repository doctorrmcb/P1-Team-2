package com.revature.tuition.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamFactory {

	private static FileInputStream fis;

	public static FileInputStream getFIS(File file) {

		try {
			fis = new FileInputStream(file);
			return fis;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static File getFileCopy(File file, InputStream inputStream) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inputStream.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return file;
	}
}
