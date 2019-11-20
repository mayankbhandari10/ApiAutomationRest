package rest.api.playground.test.addproduct;

public class AddProductPayload {

	public AddProductPayload(String name , String type, int price,int shipping, String upc, String description,String model,String url,String manufacturer,String image)
	{
		this.name=name;
		this.type=type;
		this.price=price;
		this.shipping= shipping;
		this.upc=upc;
		this.description=description;
		this.manufacturer=manufacturer;
		this.model=model;
		this.url=url;
		this.image=image;
	}	

	private String name;
	private String type;
	private int price;
	private int shipping;
	private String upc;
	private String description;
	private String manufacturer;
	private String model;
	private String url;
	private String image;

	public String getImage ()
	{
		return image;
	}

	public String getName ()
	{
		return name;
	}

	public void setImage (String image)
	{
		this.image = image;
	}

	public int getShipping ()
	{
		return shipping;
	}

	public void setShipping (int shipping)
	{
		this.shipping = shipping;
	}

	public int getPrice ()
	{
		return price;
	}

	public void setPrice (int price)
	{
		this.price = price;
	}


	public void setName (String name)
	{
		this.name = name;
	}

	public String getUpc ()
	{
		return upc;
	}

	public void setUpc (String upc)
	{
		this.upc = upc;
	}

	public String getDescription ()
	{
		return description;
	}

	public void setDescription (String description)
	{
		this.description = description;
	}

	public String getModel ()
	{
		return model;
	}

	public void setModel (String model)
	{
		this.model = model;
	}

	public String getType ()
	{
		return type;
	}

	public void setType (String type)
	{
		this.type = type;
	}

	public String getUrl ()
	{
		return url;
	}

	public void setUrl (String url)
	{
		this.url = url;
	}

	public String getManufacturer ()
	{
		return manufacturer;
	}

	public void setManufacturer (String manufacturer)
	{
		this.manufacturer = manufacturer;
	}
	@Override
	public String toString()
	{
		return "AddProductPayload [image = "+image+", shipping = "+shipping+", price = "+price+", name = "+name+", upc = "+upc+", description = "+description+", model = "+model+", type = "+type+", url = "+url+", manufacturer = "+manufacturer+"]";
	}
}
