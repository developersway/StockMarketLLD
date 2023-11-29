package Interface;

import java.util.ArrayList;

import Classes.InputClass;
import Classes.OutputClass;

public interface IServiceInterface {
	public void BuySellStoreOutput(ArrayList<InputClass> buy, ArrayList<InputClass> sell, ArrayList<OutputClass> output);
	
	public InputClass SerializeInput(String input);
}
