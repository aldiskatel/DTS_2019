import java.util.Scanner;

public class Algoritma1{
	public static void main(String[] args){
		Double jari, luas, keliling;
		Scanner inputan = new Scanner(System.in);
		System.out.println("Masukkan jari-jari: ");
		jari = inputan.nextDouble();
		luas = 3.14*jari*jari;
		keliling = 2*3.14*jari;

		System.out.println("==========HASILNYA ADALAH==========");
		System.out.println("Luas lingkaran adalah "+luas);
		System.out.println("Keliling lingkaran adalah "+keliling);
		System.out.println("===================================");
	}
}

