package dasar.oop;

public class KelasMethodInputOutput {
	
	public int kalikali(int a,int b,int c) {
		int hasil = a + (b/c);
		return hasil;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		KelasMethodInputOutput kmio = new KelasMethodInputOutput();
		int hasilkali = kmio.kalikali(80, 60, 3);
		System.out.println(hasilkali);

	}

}
