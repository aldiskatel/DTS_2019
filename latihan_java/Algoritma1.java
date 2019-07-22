import java.util.Scanner;

public class Algoritma1{
	public static void main(String[] a){
		double jari,luas,keliling;
		Scanner inputan=new Scanner(System.in);
		System.out.print("Masukan jari-jari :");
		jari=inputan.nextDouble();
		luas=3.14*jari*jari;
		keliling=2*3.14*jari;

		System.out.println("Luas Lingkaran adalah " +luas);
		System.out.println("Keliling Lingkaran adalah "+keliling);
	}
}
