package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * this class contains all the java specific generic methods
 * @author Akshay P
 *
 */
public class JavaUtility {
	
	/**
	 * this metod will generate random number for every execution
	 * @return
	 */
	public int getRandomNumber() {
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	
	/**
	 * this method will generate the system date and it will return the value
	 * @return
	 */
	
	public String getSystemDate() {
		
		Date date = new Date();
		String d = date.toString();
		return d;
	}
	
	/**
	 * this method will generate the current date and time in specific format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String  currentDateAndTime= date+" "+month+" "+year+" "+" "+time;
		return currentDateAndTime;
	}
	

}
