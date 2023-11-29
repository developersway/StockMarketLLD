package Services;

import java.util.ArrayList;

import Classes.InputClass;
import Classes.OutputClass;
import Interface.IServiceInterface;
import Shared.MiscOperation;

public class OperationServices implements IServiceInterface{
	
	public MiscOperation miscOperation;
	@Override
	public void BuySellStoreOutput(ArrayList<InputClass> buy, ArrayList<InputClass> sell, ArrayList<OutputClass> output) {
		for(int i = 0; i<buy.size(); i++)
		{
			ArrayList<InputClass> tempList1 = new ArrayList<>();
			for(int j = 0; j<sell.size();j++)
			{
				int buyTime = miscOperation.timeToSeconds(buy.get(i).getTime());
				int sellTime = miscOperation.timeToSeconds(sell.get(i).getTime());				
				if(buyTime >= sellTime)
					tempList1.add(sell.get(i));
			}
			InsertTransactionIntoOutput(buy.get(i) , sell, output, tempList1);
			
			if(buy.get(i).getQunatity() < 0)
				continue;
			
			ArrayList<InputClass> tempList2 = new ArrayList<>();
			for(int j = 0; j<sell.size();j++)
			{
				int buyTime = miscOperation.timeToSeconds(buy.get(i).getTime());
				int sellTime = miscOperation.timeToSeconds(sell.get(i).getTime());				
				if(buyTime < sellTime)
					tempList2.add(sell.get(i));
			}
			InsertTransactionIntoOutput(buy.get(i) , sell, output, tempList2);
			
		}
		
	}

	@Override
	public InputClass SerializeInput(String input) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void InsertTransactionIntoOutput(InputClass buy, ArrayList<InputClass> sell, ArrayList<OutputClass> output, ArrayList<InputClass>tempList)
	{
		miscOperation.sortByprice(tempList);
		for(int i = 0;i <tempList.size() && buy.getQunatity() > 0;i++)
			{
				if(buy.getQunatity() <= tempList.get(i).getQunatity())
				{
					int stockQuantity = buy.getQunatity();
					buy.setQunatity(0);
					int quantity = tempList.get(i).getQunatity() - stockQuantity;
					tempList.get(i).setQunatity(quantity);
					miscOperation.updateSellList(sell, tempList.get(i).getId(), quantity);
					output.add(new OutputClass(0,buy.getId(),tempList.get(i).getId(), 
							tempList.get(i).getPrice(), stockQuantity));
				}
				else
				{
					int stockQuantity = tempList.get(i).getQunatity();
					tempList.get(i).setQunatity(0);
					int quantity = buy.getQunatity() - stockQuantity;
					buy.setQunatity(quantity);
					miscOperation.updateSellList(sell, tempList.get(i).getId(), 0);
					output.add(new OutputClass(0,buy.getId(),tempList.get(i).getId(), 
							tempList.get(i).getPrice(), stockQuantity));
				}
			}			
				
		
	}
	
	

}
