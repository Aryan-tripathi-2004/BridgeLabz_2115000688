import java.util.*;

class IsPrime{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number till that you want to find prime numbers: ");
		int num = sc.nextInt();
		
		for(int i=2;i<=num;i++){
			boolean isPrime = true;
			for(int j=2;j<i;j++){
				if(i%j==0){
					isPrime = false;
				}
			}
			if(isPrime) System.out.print(i+", ");
		}
	}
}