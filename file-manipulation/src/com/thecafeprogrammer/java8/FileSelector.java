package com.thecafeprogrammer.java8;

import java.io.File;

/**
 * This FileSelector class will select a file from user input, gathered via a BufferedReader in the Main class.  
 * @author Tony
 *
 */
public class FileSelector {

	private File selectedFile;

	/**
	 * A FileSelector will select a file, given a fileName.
	 * 
	 * 
	 * @param givenFileName	the path of a file name on the client
	 */
	public FileSelector(String givenFileName) {
		selectFile(givenFileName);
	}

	/**
	 * This method will store the File, letting the givenFileName be the path to the new File.
	 * Additionally, this method will check to see if the givenFileName is null, and if the givenFileName
	 * has no characters in the String at all.
	 * Furthermore, this checks for the existence of said File from the givenFileName.
	 * 
	 * The path of the file must be absolute, and doesn't support relative paths yet.
	 * Any alphanumeric or special character can be added, and thusly, there is error handling in this class
	 * that can be refactored.
	 * 
	 * @throws IllegalArgumentException when the path file has invalid input.
	 * @param givenFileName  the path of a file name on the client
	 */
	public void selectFile(String givenFileName) throws IllegalArgumentException {
		String copiedPath = givenFileName;
		if (copiedPath != null && !copiedPath.isEmpty()) 
		{
			if(new File(givenFileName).exists() && !new File(givenFileName).isDirectory())
			{
				File file = new File(copiedPath);
				selectedFile = file;
			}
			
			else 
			{
				throw new IllegalArgumentException("Path to file does not exist");
			}
			
		}
	}

	/**
	 * This method will access the selectedFile field of this class.
	 * @return a new File from the stored selectedFile 
	 */
	public File getSelectedFile() {
		return new File(selectedFile.getPath());
	}
	
}
