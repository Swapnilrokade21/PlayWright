package base;

public class Testjava {

	public static void main(String[] args) {
		String s = "Swapnil Rokade";
		String arr[] = s.split(" ");

		for(int j=0;j<arr.length;j++)
		{
			
			String word = arr[j];
			String rev= "";
			for(int i=word.length()-1;i>=0;i--)
			{
				rev = rev+word.charAt(i);
			}
			
			System.out.print(rev+" ");
			
		}

	}

}
