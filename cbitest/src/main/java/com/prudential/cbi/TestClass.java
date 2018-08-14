package com.prudential.cbi;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClass {

	public static void main(String[] args) {
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); Calendar cal =
		 * Calendar.getInstance(); System.out.println(dateFormat.format(cal.getTime()));
		 */
		TestClass tc = new TestClass();
		//tc.moveFile("D:\\Prudential\\BillingSystem\\move\\MBB0001.CTD",
		//		"D:\\Prudential\\BillingSystem\\move\\backup\\MBB00012.CTD");
		
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String time = dateFormat.format(now);
		File dir = new File("D:\\Prudential\\BillingSystem\\move\\"+time);
		dir.mkdir();
		
		File[] files = new File("D:\\Prudential\\BillingSystem\\move").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 

		for (File file : files) {
		    if (file.isFile()) {
		        System.out.println(file.getName());
		    	file.renameTo(new File(dir+"\\"+file.getName()));

		        
		    }
		}

	}

	public boolean moveFile(String sourcePath, String targetPath) {

		boolean flag = true;

		try {

			Files.move(Paths.get(sourcePath), Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);

		} catch (Exception e) {

			flag = false;
			e.printStackTrace();
		}

		return flag;
	}

}
