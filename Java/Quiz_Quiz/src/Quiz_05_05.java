// Quiz 05 05

// 구구단을 출력하되 짝수단만 출력하도록 프로그램을 작성하라.
// 단, 2단은 2*2까지만, 4단은 4*4까지만....8단은 8*8까지만 출력해야 한다.
// ( 단, for문에서 2씩 증가하는 것 안됨 !!!! )


public class Quiz_05_05 {

	public static void main(String[] args) {
		
		System.out.println("짝수 구구단 출력");
		
		for(int i=1; i<9; i++) {
			for(int j=1; j<9; j++) {
				if ((i%2) == 0 && i >= j) {
				System.out.println(i + " x " + j + " = " + ( i * j ));
				} 
			} System.out.println("-------------");	
		} 
	}
}
