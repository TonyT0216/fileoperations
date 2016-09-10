package com.thecafeprogrammer.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * The class FileManipulator takes in a File, and manipulates the output of the contents of it.  
 * 
 * The primary concern of this class as a whole is to read information that is stored in a File, and pass that information 
 * over to its respective FileProcessor, which will actually output the data.
 * 
 * This class implements a FileInput interface.  
 * @author Tony Toscano
 *
 */
public class FileManipulator implements FileInput {
	
	private FileProcessor processOutput; // As of now, FileManipulator depends on a FileProcessor field to send input to be processed into output.

	public FileManipulator() 
	{
		
	}

	/**
	 * 
	 * @param fileName
	 */
	@Override
	public void readFile(String fileName) 
	{
		try {
			processOutput = new FileProcessor();
			FileReader in = new FileReader(fileName);
			BufferedReader br = new BufferedReader(in);
			processOutput.writeFile(br);
			br.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param fileName
	 */
	public void readFileInReverse(String fileName) 
	{
		Stack<String> temp = new Stack <String>();
		try
		{
			FileReader in = new FileReader(fileName);
			BufferedReader br = new BufferedReader(in);
			String line;
			line = br.readLine();
			while(line != null)
			{
				temp.push(line);
				line = br.readLine();
			}
	
			br.close();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		stackReversal(temp);
		for(String str : temp)
		{
			System.out.println(str.toString());
		}
		

	}
	
	@Override
	public void streamFile(String fileName) 
	{
		try (Stream<String> readStream = Files.lines(Paths.get(fileName), Charset.defaultCharset())) {
			readStream.forEach(System.out::println);
			readStream.close();
			
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void streamFileInReverse(String fileName) 
	{
		try (Stream<String> readStream = Files.lines(Paths.get(fileName), Charset.defaultCharset())) {
			reverse(readStream);
			readStream.close();
			
		}

		catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * This method reverses a Stream and places the reversed Stream into a Deque.
	 * 
	 * 
	 * @param input
	 * @return
	 * @author Stuart Marks
	 */
	@SuppressWarnings("unchecked")
	private <T> Stream <T> reverse(Stream<T> input)
	{
		Deque <String> output = input.collect(Collector.of(
				ArrayDeque::new,
				(deq, t) -> deq.addFirst((String) t),
				(d1,d2) -> { d2.addAll(d1); return d2; }));
		output.forEach(System.out::println);
		return (Stream<T>) output;
	}
	
	private void stackReversal(Stack<String> stack)
	{
		if(stack.size() == 0) return;
		String s = getLast(stack);
		stackReversal(stack);
		stack.push(s);
	}

	private String getLast(Stack<String> stack) 
	{
		String s = stack.pop();
		if(stack.size() == 0)
		{
			return s;
		}
		
		else 
		{
			String s2 = getLast(stack);
			stack.push(s);
			return s2;
		}
	}
}
