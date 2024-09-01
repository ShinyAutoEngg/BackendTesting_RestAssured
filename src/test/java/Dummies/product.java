package Dummies;

public class product 
{
	String productName;
	int weight;
	
	public product(String productName,	int weight)
	{
		this.productName=productName;
		this.weight=weight;
	}
	
	public String getProdName()
	{
		return productName;
	}
	public void setProdName(String prodName)
	{
		this.productName=prodName;
	}
	public int getWeight()
	{
		return weight;
	}
	public void setWeight(int weig)
	{
		this.weight=weig;
	}
	
	
}
