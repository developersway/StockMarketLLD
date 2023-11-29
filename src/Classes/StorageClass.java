package Classes;

import java.util.*;

public class StorageClass {
	private ArrayList<InputClass> sellList = new ArrayList<>();
	private List<InputClass> buyList = new ArrayList<>();
	
	public ArrayList<InputClass> getSellList() {
		return sellList;
	}
	public void setSellList(ArrayList<InputClass> sellList) {
		this.sellList = sellList;
	}
	public List<InputClass> getBuyList() {
		return buyList;
	}
	public void setBuyList(List<InputClass> buyList) {
		this.buyList = buyList;
	}
}
