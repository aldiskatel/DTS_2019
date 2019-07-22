import java.util.Scanner;

public class Algoritma2{
	public static void main(String[] a){
		double x,y;
		Scanner inputan=new Scanner(System.in);
		System.out.print("Masukan input 1 :");
		x=inputan.nextDouble();
		Scanner inputan2=new Scanner(System.in);
		System.out.print("Masukan input 2 :");
		y=inputan2.nextDouble();

		if(x >= y){
			System.out.println(x+" Lebih besar atau sama dengan "+y);
		}else{
			System.out.println(x+" Tidak Lebih besar atau Tidak sama dengan "+y);
		}
	}
}
