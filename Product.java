//Product class 

public class Product 
{

    //Variable Declaration.

    private String name;                                                
    private int stockLevel;
    private double price;

    //Constructor to create objects

    public Product(String nameN, int stockLevelN, double priceN)
    {
        this.name = nameN;
        this.stockLevel = stockLevelN;
        this.price = priceN;
    }

    //Method to re-price a product.

     public void setPrice(double priceN)
    {
        price = priceN; 
    }

    //Method to Buy the Products and return the value of stock bought.

    public double buyStock(int QtyIN)
    {   
        stockLevel += QtyIN;
        return QtyIN*price;
    }
    
    //Method to sell the products and return true if enough stock is available else return false.

    public boolean sell(int sale)
    {
        if(sale <= stockLevel)
        {
            stockLevel -= sale;
            return true;
        }
        else 
        {
        System.out.println("\n");
        System.out.println("Insufficient Stock");
        System.out.println("No changes made to the Stock"); 

        return false;
        }
    }
    
    //Method to return the name of the product.

    public String getName()
    {
        return name;
    }

    //Method to return the stocklevel of teh product.

    public int getStockLevel()
    {
        return stockLevel;
    }

    //Method to return the price of the Product.

    public double getPrice()
    {
        return price;
    }
   
}
