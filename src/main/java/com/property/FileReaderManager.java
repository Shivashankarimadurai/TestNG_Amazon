package com.property;

import java.io.IOException;

public class FileReaderManager {
	
	private FileReaderManager() {
		
	}
	
	public static FileReaderManager getInstanceFileReaderManager() {
		FileReaderManager frm = new FileReaderManager();		
		return frm;		
	}
	
	public Configuration getInstanceConfiguration() throws IOException {
		Configuration cf = new Configuration();
		return cf;
		
	}
}
