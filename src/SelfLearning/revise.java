package SelfLearning;

public class revise {
   public static void main(String[] args){
	   Book h = new Book("JK");
	   modify1(h);
	   System.out.println(h.getA());
	   modify2(h);
	   System.out.println(h.getA());
   }
   public static class Book{
	   
	   String author;
	   public Book(String a) {
		   this.author = a;
	   }
	   public String getA() {
		   return author;
	   }
	public void setSuthor(String s) {
		this.author=s;
		
	}
   }
  public static void modify1(Book c) {
	  Book w = new Book("leo");
	  c =w;
  }
  
  public static void modify2(Book p) {
	  p.setSuthor("J");
  }
}
