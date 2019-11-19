package rest.api.playground.test.addproduct;

public class AddProductPayload {
	
	public AddProductPayload(String image , String shipping,String price, String name, String upc, String description,String model,String type,String url,String manufacturer)
	{
		this.image=image;
		this.shipping= shipping;
		this.price=price;
		this.name=name;
		this.upc=upc;
		this.description=description;
		this.model=model;
		this.type=type;
		this.url=url;
		this.manufacturer=manufacturer;
	}
	
	
	    private String image;

	    private String shipping;

	    private String price;

	    private String name;

	    private String upc;

	    private String description;

	    private String model;

	    private String type;
	    
	    private String url;

	    private String manufacturer;

	    public String getImage ()
	    {
	        return image;
	    }

	    public void setImage (String image)
	    {
	        this.image = image;
	    }

	    public String getShipping ()
	    {
	        return shipping;
	    }

	    public void setShipping (String shipping)
	    {
	        this.shipping = shipping;
	    }

	    public String getPrice ()
	    {
	        return price;
	    }

	    public void setPrice (String price)
	    {
	        this.price = price;
	    }

	    public String getName ()
	    {
	        return name;
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
