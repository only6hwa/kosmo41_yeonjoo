import java.awt.print.Printable;

interface Printable1 {
	void print();
}

class Papers1 {
	private String con;
	public Papers1(String s) { 
		con = s; 
	}
	
	public Printable1 getPrinter() {
		return new Printer1();
	}
	
	private class Printer1 implements Printable1 {
		public void print() {
			System.out.println(con);
		}
	}
}

public class B2_UseMemberInner {

	public static void main(String[] args) {
		Papers1 p = new Papers1("서류 내용 : 배부르고 졸려 --zz");
		Printable1 prn = p.getPrinter();
		prn.print();

	}

}
