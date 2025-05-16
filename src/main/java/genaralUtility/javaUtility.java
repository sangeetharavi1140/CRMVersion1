package genaralUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class javaUtility {
	//this method return random numbers
	public int getRandomNumber()
	{
		Random r=new Random();
		
	return	r.nextInt(1000);
	}
	//getting systemdate
	public String systemDate()
	{
		Date d=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-mm-yyyy hh mm ss");
		String date = formatter.format(d);
		return date;
	}

}
