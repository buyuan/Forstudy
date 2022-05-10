package LeetCode;

import java.io.File;
import java.io.IOException;

public class Statisctical {
	public static void main(String[] args) {
		
		File dir = new File("");
		try {
			//get the current path
			System.out.println(dir.getCanonicalPath()+"/bin/LeetCode");
			System.out.println(dir.getAbsolutePath()+"/bin/LeetCode");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = "./bin/LeetCode";
		File f = new File(path);
		File[] fList = f.listFiles();//get file
		String[] fnameList = f.list();//get file name
		int count1 =0;
		int count2=0;
		for(String x: fnameList) {		
			count2++;
			//System.out.println(x);
			if(x.startsWith("T")&&!x.startsWith("Te")) {
				count1++;
			}
		}
		System.out.printf("Totall %d  files\n",count2);
		System.out.printf("Totall %d class files\n",count1);
		
	}
}
