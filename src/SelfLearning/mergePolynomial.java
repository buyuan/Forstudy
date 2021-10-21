package SelfLearning;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class mergePolynomial {
	public static void main(String[] arg) {
		//�Ժ�����������ʽ�ķ���,Ŀǰ���ø�����ֵ����
		
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
		//��֪���ĸ�����ʽ��,����,�ĸ�����ʽ������,��ͣ
		while(indexA<sizeA&&indexB<sizeB) {
			if(expressionA.get(indexA).getExponentiation()>expressionB.get(indexB).getExponentiation()) {
				//A����ʽ�ĵ�һ����Ŀ�ݴ����
				expressionAns.add(expressionA.get(indexA));
				//��һ�����,��һ�δ���ڶ���
				indexA++;
			}else if(expressionA.get(indexA).getExponentiation()==expressionB.get(indexB).getExponentiation()) {
				//����,��ߴ���ͬ
				int coeAns = expressionA.get(indexA).getCoefficient()+expressionB.get(indexB).getCoefficient();		
				if(coeAns != 0) {
					expressionAns.add(new item(coeAns , expressionA.get(indexA).getExponentiation()));				
				}
				indexA++;
				indexB++;
			}else {
				//B����ʽ�ĵ�һ����Ŀ�ݴ����
				expressionAns.add(expressionB.get(indexB));
				indexB++;
			}
		}
		//���洦��������Ǹ�����ʽ,indexλ����Ȼ��Ҫ???��һ����������??
		while(indexA<sizeA) {
			//A ����ʽ����,˳������add����
			expressionAns.add(expressionA.get(indexA));
			indexA++;
			}
		while(indexB<sizeB) {
			//B ����ʽ����,˳������add����
			expressionAns.add(expressionB.get(indexB));
			indexB++;
			}
		
		
		return expressionAns;
	}
	
}


//���嵥�������,����д����ʽ���򷽷�;
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
		//toString��д���ݵ���ʽ
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
			//���Է���,С�ھ�������,�����ǽ���,Ŀǰ��û��Ϊʲô,�Ժ��ٸ��࿴Դ���
			return (this.exponentiation>i.exponentiation)? -1 :(this.exponentiation==i.exponentiation)? 0: 1;
			//return Integer.compare(this.exponentiation, i.getExponentiation());
		}

		
		
	}