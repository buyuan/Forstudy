package SelfLearning;

public class City {
    public static void main(String[] args) {
       Town t = new Town("BJ", 123.2,123.9);
    	
	}
}
class Town {
	String name;
	double latitude;
	double longitude;
	public Town(String name,double latitude, double longitude ) {	
		System.out.println(name+ latitude+ longitude);
	}
}
