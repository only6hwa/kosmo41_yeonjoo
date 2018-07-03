import java.math.BigInteger;

//
// 매우 큰 정수 표현
//

public class D1_SoBIgInteger {

	public static void main(String[] args) {
		//long형으로 표현 간으한 값의 크기 출력
		System.out.println("최대 정수: " + Long.MAX_VALUE);
		System.out.println("최소 정수: " + Long.MAX_VALUE);
		System.out.println();
		
		//매우 큰 수를 BigInteger 인스턴스로 표현
		BigInteger big1 = new BigInteger("100000000000000000000");
		BigInteger big2 = new BigInteger("-99999999999999999999");
		
		//BigInteger 기반 덧셈 연산
		BigInteger r1 = big1.add(big2);
		System.out.println("덧셈결과: " + r1);
		
		//BigInteger 기반 곱셈 연산
		BigInteger r2 = big1.multiply(big2);
		System.out.println("곱셈결과: " + r2);
		System.out.println();
		
		//인스턴스에 저장된 값을 int형 정수로 반환
		int num = r1.intValueExact();
		System.out.println("From BigInteger: " + num);
	}

}
