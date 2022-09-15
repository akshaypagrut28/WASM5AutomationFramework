package vtiger.Practice;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		
		Random r = new Random();
		int value = r.nextInt(2000);
		System.out.println(value);

	}

}
