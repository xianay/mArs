package org.ars.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * base dataSource
 * @author Administrator
 *
 */
public abstract class PropertiesSupport extends ArrayList<String>{
	
	private static final long serialVersionUID = 1L;
	private String file;
	
	public PropertiesSupport(String file) {
		this.file = file;
		build();
	}
	
	public String getFile() {
		return file;
	}
	
	/**
	 * set properties file path
	 * @param file
	 */
	public void setFile(String file) {
		this.file = file;
	}
	
	/**
	 * read plane.properties to List(ArrayList)
	 */
	private void build(){
		URL url = Thread.currentThread().getContextClassLoader().getResource(file);
		FileReader reader = null;
		BufferedReader buf = null;
		try {
			reader = new FileReader(new File(url.toURI()));
			buf = new BufferedReader(reader);
			if(buf.ready()){
				String line = buf.readLine();
				while(line!=null){
					this.add(line);
					line = buf.readLine();
				}
			}
		} catch (Exception e) {		
			e.printStackTrace();
		} 
	}
}
