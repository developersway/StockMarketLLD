package Shared;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import Classes.InputClass;

public class MiscOperation {
	
	public int timeToSeconds(String time)
	{
		int hour = 0, minutes = 0;
		try {
			SimpleDateFormat format = new SimpleDateFormat("H:m");
			Date timeq = format.parse(time);
			hour = timeq.getHours();
			minutes = timeq.getMinutes(); 
		}
		catch(Exception e)
		{
			
		}
		return hour*60 + minutes;
	}
	
	public void sortByprice(ArrayList<InputClass> listToBeSorted)
	{
		Collections.sort(listToBeSorted, (o1, o2) -> o1.getPrice() - o2.getPrice());
	}
	
	public void updateSellList(ArrayList<InputClass> Sell, int id, int quantity)
	{
		for(int i=0;i<Sell.size();i++)
		{
			if(Sell.get(i).getId() == id)
				Sell.get(i).setQunatity(quantity);
				
		}
	}
}
