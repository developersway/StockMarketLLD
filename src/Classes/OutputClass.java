package Classes;

public class OutputClass {
	public OutputClass(int id, int buyId, int sellId, int price, int quatity) {
		super();
		this.id = id;
		this.buyId = buyId;
		this.sellId = sellId;
		this.price = price;
		this.quatity = quatity;
	}
	private int id;
	private int buyId;
	private int sellId;
	private int price;
	private int quatity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public int getSellId() {
		return sellId;
	}
	public void setSellId(int sellId) {
		this.sellId = sellId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuatity() {
		return quatity;
	}
	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
	
	
	
}
