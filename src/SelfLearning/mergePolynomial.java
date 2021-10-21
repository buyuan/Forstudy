package SelfLearning;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class mergePolynomial {
	public static void main(String[] arg) {
		//以后加入输入多项式的方法,目前先用给定的值计算
		
		//4X^4+3X^3-2X^2+1
		List<item> expressionA = new LinkedList<item>();
		expressionA.add(new item(-2,2));
		expressionA.add(new item(4,4));
		expressionA.add(new item(3,3));
		expressionA.add(new item(1,0));
		for(item i:expressionA) {
			String trac = i.toString()+"+";
			System.out.print(trac);
		}
		System.out.println();
		Collections.sort(expressionA);
		for(item i:expressionA) {
			String trac = i.toString()+"+";
			System.out.print(trac);
		}
		System.out.println();
		//-7x^3+1
		List<item> expressionB = new LinkedList<item>();
		expressionB.add(new item(-7,3));
		expressionB.add(new item(1,0));
		
		//Ans should be 4X^4-4X^3-2X^2+2
		List<item> ans = mergePoly(expressionA, expressionB);
		for(item i:ans) {
			String trac = i.toString()+"+";
			System.out.print(trac);
		}
		
		
	}
//poly plus pre-criteria: Polynomial in descending order
	public static List<item> mergePoly(List<item> expressionA, List<item> expressionB){
		List<item> expressionAns = new LinkedList<item>();
		int sizeA = expressionA.size();
		int sizeB = expressionB.size();
		int indexA=0, indexB=0;
		//不知道哪个多项式长,所以,哪个多项式拿完了,就停
		while(indexA<sizeA&&indexB<sizeB) {
			if(expressionA.get(indexA).getExponentiation()>expressionB.get(indexB).getExponentiation()) {
				//A多项式的第一个项目幂次最高
				expressionAns.add(expressionA.get(indexA));
				//第一项处理完,下一次处理第二项
				indexA++;
			}else if(expressionA.get(indexA).getExponentiation()==expressionB.get(indexB).getExponentiation()) {
				//正好,最高次相同
				int coeAns = expressionA.get(indexA).getCoefficient()+expressionB.get(indexB).getCoefficient();		
				if(coeAns != 0) {
					expressionAns.add(new item(coeAns , expressionA.get(indexA).getExponentiation()));				
				}
				indexA++;
				indexB++;
			}else {
				//B多项式的第一个项目幂次最高
				expressionAns.add(expressionB.get(indexB));
				indexB++;
			}
		}
		//下面处理更长的那个多项式,index位置仍然重要???这一步的作用是??
		while(indexA<sizeA) {
			//A 多项式更长,顺着往后add就行
			expressionAns.add(expressionA.get(indexA));
			indexA++;
			}
		while(indexB<sizeB) {
			//B 多项式更长,顺着往后add就行
			expressionAns.add(expressionB.get(indexB));
			indexB++;
			}
		
		
		return expressionAns;
	}
	
}


//定义单项的类型,并重写多项式排序方法;
	class item implements Comparable<item>{ 
		Integer coefficient;
		Integer exponentiation;
		public item(Integer coefficient, Integer exponentiation) {
			this.coefficient=coefficient;
			this.exponentiation=exponentiation;
		}
		public Integer getCoefficient() {
			return coefficient;
		}
		public void setCoefficient(Integer coefficient) {
			this.coefficient = coefficient;
		}
		public Integer getExponentiation() {
			return exponentiation;
		}
		public void setExponentiation(Integer exponentiation) {
			this.exponentiation = exponentiation;
		}	
		//toString改写成幂的形式
		@Override
		public String toString() {
			if (this.coefficient==-1) {
				return "-X^" + this.exponentiation;
			}else if(this.coefficient==1) {
				return  "X^" + this.exponentiation;
				
			}else {
				return this.coefficient + "X^" + this.exponentiation;
			}			
		}
		//
		@Override
		public int compareTo(item i) {
			//测试发现,小于就是升序,大于是降序,目前还没懂为什么,以后再更多看源码吧
			return (this.exponentiation>i.exponentiation)? -1 :(this.exponentiation==i.exponentiation)? 0: 1;
			//return Integer.compare(this.exponentiation, i.getExponentiation());
		}

		
		
	}