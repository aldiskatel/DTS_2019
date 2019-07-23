import java.util.Scanner;

public class Algoritma2{
	public static void main(String[] args){
		Double bil1, bil2;
		Scanner inputan = new Scanner(System.in);
		System.out.println("Masukkan Bilangan 1: ");
		bil1 = inputan.nextDouble();
		
		System.out.println("Masukkan Bilangan 2: ");		
		bil2 = inputan.nextDouble();

		if(bil1>=bil2){
		System.out.println(bil1+"==========BILANGAN 1 LEBIH ATAU SAMA BESAR BILANGAN 2=========="+bil2);
		
		}else{
		System.out.println(bil1+"============BILANGAN 1 TIDAK LEBIH BESAR BILANGAN 2============"+bil2);
		}
							
	}
}

