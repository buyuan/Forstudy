package SelfLearning;

public class T2 extends Thread {
	public void run() {
		System.out.println("Hello,I am a thread!");
	}
	
	public static void main(String[] args) {
		T2 newT = new T2();
		newT.start();
	}
}
