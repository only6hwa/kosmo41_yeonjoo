
public class Quiz5 {

	public static void main(String[] args) {
		
		System.out.println("---------------");
		
		for(int i = 2; i <= 9; i++) 
			{	
			if ( i % 2 == 0 ) { 
				for(int j = 1; j<=i ; j++)
					if ( j % 2 == 0 )
					System.out.println(i + " x " + j + " = " + (i * j));
			}
				System.out.println("---------------");
		}
	}
}


