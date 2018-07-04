import java.util.*;
//
// 리스트만 갖는 양방향 반복자
//

class A8_ListIteratorCollection {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Toy","Box","Robot","Box");
		list = new ArrayList<>(list);
		
		// 반복자
		ListIterator<String> litr = list.listIterator();
		String str;
		
		//왼쪽에서 오른쪽으로
		while(litr.hasNext()) {
			str = litr.next();
			System.out.print(str + '\t');
			
			if(str.equals("Toy"))
				litr.add("Toy2");
		}
		System.out.println(); 
		
		//오른쪽에서 왼쪽으로
		
		 while(litr.hasPrevious()) {
			str = litr.previous();
			System.out.print(str + '\t');
			
			if(str.equals("Robot"))
				litr.add("Robot2");
		}
		System.out.println(); 
		
		//다시 왼쪽에서 오른쪽으로
		for(Iterator<String> itr = list.iterator(); itr.hasNext();)
			System.out.print(itr.next() + '\t');
		System.out.println();
	}

}
