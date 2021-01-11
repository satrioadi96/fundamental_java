package dasar.tesTeknikal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuVendingMachine {

	public Scanner scan;

	public static void main(String[] args) throws NullPointerException, InputMismatchException {
		// TODO Auto-generated method stub
		MenuVendingMachine mvm = new MenuVendingMachine();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			mvm.isiMenu();
			System.out.print("\nApakah Anda ingin kembali ke menu? (Y/T)\n>> ");
			String jawab = scan.next();
			
			switch (jawab) {
			case "Y":
				continue;
				
			case "T":
				System.out.println("\nTerima kasih telah mengunjungi Vending Machine Kami.");
				System.exit(0);
				break;
			}
		}
		
	
		
	}
	
	public void isiMenu() {
		Scanner scan1 = new Scanner(System.in);
		int itemYangAda = 0;
		
		// -----------------------------------------------------
		
		String[][] listMakananHarga = new String[5][3];
		
		listMakananHarga[0][0] = "Biskuit";
		listMakananHarga[0][1] = "6000";
		listMakananHarga[0][2] = "5";
		
		listMakananHarga[1][0] = "Chips";
		listMakananHarga[1][1] = "8000";
		listMakananHarga[1][2] = "5";
		
		listMakananHarga[2][0] = "Oreo";
		listMakananHarga[2][1] = "10000";
		listMakananHarga[2][2] = "5";
		
		listMakananHarga[3][0] = "Tango";
		listMakananHarga[3][1] = "12000";
		listMakananHarga[3][2] = "5";
		
		listMakananHarga[4][0] = "Cokelat";
		listMakananHarga[4][1] = "15000";
		listMakananHarga[4][2] = "5";
		
		// -----------------------------------------------------
		
		Integer[] uangVending = new Integer[5];
		
		uangVending[0] = 2000;
		uangVending[1] = 5000;
		uangVending[2] = 10000;
		uangVending[3] = 20000;
		uangVending[4] = 50000;
		
		// -----------------------------------------------------


		String menu0 = "\n\n   Selamat Datang di Mesin Vending\n"
				+"=====================================\n"
				+"  Pilih angka dari menu dibawah ini :   \n"
				+"---------------------------------------\n"
				+"(1)\tBeli Makanan\n"
				+"(2)\tStok Makanan Tersedia\n";

		System.out.print(menu0 + "\n>> ");
		int pilih0 = scan1.nextInt();

		switch (pilih0) {
		case 1:

			String beli0 = "\n\n    Pilih item makanan :   \n"
					+"---------------------------------------\n";
			System.out.print(beli0);
			for (int i = 0; i < listMakananHarga.length; i++) {
				String daft = "(" + (i + 1) + ")\t" 
						+ listMakananHarga[i][0] + "\t(Harga: "
						+ listMakananHarga[i][1] + ")";
				System.out.println(daft);
			}
			System.out.print("\n>> ");
			int pilih = scan1.nextInt();

			if ( pilih <= 5 && pilih >= 1) {
				String item0 = "\n\nMasukkan banyaknya item makanan dari "+ listMakananHarga[pilih-1][0] +" :   \n";
				System.out.print(item0 + "\n>> ");
				int banyakItem = scan1.nextInt();
				int stokTersedia = Integer.valueOf(listMakananHarga[pilih-1][2]);
				
				
				if (stokTersedia == 0) {
					System.out.println("Stok sudah habis! Silahkan membeli di lain hari.\nTerima kasih.");
					System.exit(0);
				} else {
					for (int i = 0; i < listMakananHarga.length; i++) {
						itemYangAda = Integer.valueOf(listMakananHarga[pilih][2]);
						itemYangAda -= banyakItem;
					}
		
					int total = Integer.valueOf(listMakananHarga[pilih][1]) * banyakItem;
		
					String hasil = "\nHarga 1 item "+ listMakananHarga[pilih][0] +" adalah " + listMakananHarga[pilih][1] + "."
							+ "\nBanyaknya item adalah " + banyakItem + "."
							+ "\nTotal harga adalah " + total + "."
							;
					System.out.println(hasil);
		
					String kembali0 = "\n\nMasukkan uang Anda yang akan dibayar :";
					System.out.print(kembali0 + "\n>> ");
					int uangAnda = scan1.nextInt();
		
					int sisa = uangAnda - total;
					if (sisa >= 0) {
						String kembalian = "\n\nUang Anda kembali sebesar " + sisa + "."
								+ "\nRincian kembalian: ";
						System.out.println(kembalian);
			
						for (int i = 0; i < uangVending.length; i++) {
							int lembar = sisa / uangVending[i];
							
							System.out.println("\n- " + lembar + " lembar uang " + uangVending[i]);
							
							sisa -= (lembar * uangVending[i]);
							
							if (sisa > 1000) {
								continue;
							} else {
								System.out.println("Peringatan! Tidak tersedia uang 1000 dari Vending!");
							}
							
						}
					
						System.out.println("\nPesanan Selesai.");
			
					} else {
						String keluar0 = "/nUang Anda tidak mencukupi./nUang Anda akan dikeluarkan kembali."
								+"/nSilahkan masukkan Uang Anda agar cukup untuk membayar";
						System.out.println(keluar0);
			
					}

				}
	
			} else {
				System.out.println("\nInput yang dimasukkan salah!\nSilahkan dicoba kembali.");
				break;
			}

			break;

		case 2:
			for (int i = 0; i < listMakananHarga.length; i++) {
				String dataItem = "Sisa stok dari " + listMakananHarga[i][0] + " adalah " + listMakananHarga[i][2];
				System.out.println(dataItem);
			}

			break;

		default:
			System.out.println("\nInput yang dimasukkan salah!\nSilahkan dicoba kembali");
			break;
		}
	}


}
