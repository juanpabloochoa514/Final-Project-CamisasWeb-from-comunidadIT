package ModelShirt;

public class Shirt {
	private String name;
	private int price;
	private int id;
	//private String discountsusseful="HAY DESCUENTO";
	//private String discountnegative="NO HAY DESCUENTO";
	//private String description;
	
	public Shirt(String name , int price,int id) {
		this.name=name;
		this.price=price;
		this.id=id;
		
	}
	/*
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	*/
	/*
	public String getDiscountnegative() {
		return discountnegative;
	}
	public void setDiscountnegative(String discountnegative) {
		this.discountnegative=discountnegative;
	}
	public String getDiscountsusseful() {
		return discountsusseful;
	}
	public void setDiscountsusseful(String discountsusseful) {
		this.discountsusseful=discountsusseful;
	}
	*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
}
