package SelfLearning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test {
	public static final String filePath = "C:/Users/cbuyu/Desktop/largeDG.txt";
	//public static final String fileName = "test.txt";
	public static void main(String[] args) throws IOException {
	File file = new File(filePath);
	System.out.println(file.isFile());
	System.out.println(file.exists());
	try {
		FileInputStream fis = new FileInputStream(filePath);
		String line;
		InputStreamReader isr = new InputStreamReader(fis);// 字符流
		 
        BufferedReader br = new BufferedReader(isr); // 缓冲
		 while ((line = br.readLine()) != null) {// 字符不等于空
	            System.out.println(line);// 一行一行地输出
	        }
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

