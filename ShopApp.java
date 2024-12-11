/** This is a javadoc style of comments
 *   @author Shyam Vijay Jagani 
 *  @version 21/12/2023
 * 
*/

//import all java utilities.

import java.util.*;

//class declaration.

public class ShopApp
{   
    
//scanner declaration

    static Scanner sc = new Scanner(System.in);

    //Main Method

    public static void main(String[] args) 
    {
        
        //array to store the objects.

        Product[] shop = new Product[5];

        //object creation.

        shop[0] = new Product("Laptops     ", 12, 1299.99);
        shop[1] = new Product("Smartphones ", 20, 549.99);
        shop[2] = new Product("Smartwatches", 47, 99.99);
        shop[3] = new Product("Tablets     ", 35, 159.99);
        shop[4] = new Product("Headphones  ", 69, 14.99);    
        
        //variable declaration.

        int ProName = 0;
        int Qty = 0, i = 0;
        double Price = 0;
        char x = 'x';

        //calling the method to display the student number.

        studentNumber();
        
        // calling the Method to display the menu of the app.

        menuSwitchMethod(ProName, Qty, Price, shop, i, x);
        
    }

//method to display the student number.

    static void studentNumber()
    {
        System.out.println("\n");
        System.out.println("Student No.: 2611208");
        System.out.println("Student Name: Shyam Vijay Jagani");
        System.out.println("\n");
    }


//Method to display the menu.

    static void menuSwitchMethod(int ProName, int Qty, double Price, Product[] shop, int i, char x)
    {   
        do
        {
            
            System.out.println("Application Menu");
            System.out.println("");
            System.out.println("1. Display all Products");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. Re-Price a Stock Item");
            System.out.println("5. Display total Stock value");
            System.out.println("6. Exit App");
            System.out.println("");
            System.out.print("Select the Option you want to continue with from the Menu.: ");
            i = sc.nextInt();
            System.out.println("");
            
            //using switch statement to call different methods depending on user input.

            switch(i)
            {
                case 1:
                System.out.println("1. Product List");
                displayProducts(shop);
                break;

                case 2:
                buyStockMethod(ProName, Qty, shop, i, x);
                break;

                case 3:
                sellMethod(ProName, Qty, shop, i, x);
                break;

                case 4:
                setPriceMethod(ProName, Price, shop, i, x);
                break;

                case 5:
                totalValueMethod(shop);
                break;

                case 6:
                System.out.println("The app has now been exited.");
                System.out.println("\n");
                break;

                default:
                System.out.println("!!!!!Please Enter a valid Number!!!!!");
                System.out.println("");
               
                break;
            }
        }while(i != 6);

    }

//method to display all products.

    static void displayProducts(Product[] shop)
    {
        
        //using a for loop to display all the products.

        System.out.println("");   
        for(int i = 0; i < shop.length;i++)
            {
                System.out.println((i+1)+". Name: "+shop[i].getName()+" | Stock: "+shop[i].getStockLevel()+" | Price: £"+shop[i].getPrice());
            }
        System.out.println("");
    }

//method to buy stock, add to current and then display of the stock bought.

    static void buyStockMethod(int ProNameN, int QtyN, Product[] shopN, int iB, char xB)
    {
        System.out.println("");
        System.out.println("2. Buy Stock");
        displayProducts(shopN);
        
        //using a do-while loop so the user can buy and add more than one products to the stock.

        do
        {
            
            System.out.print("Enter the product Bought: ");
            ProNameN = sc.nextInt();
            while(ProNameN < 1 || ProNameN > 5)
            {
                System.out.print("Invalid Input, Enter valid Product: ");
                ProNameN = sc.nextInt();
            }

            //if-else statement to select the correct product from the array.

            if(ProNameN == 1)
            iB = 0;

            else if(ProNameN == 2)
            iB = 1;

            else if(ProNameN == 3)
            iB = 2;

            else if(ProNameN == 4)
            iB = 3;

            else if(ProNameN == 5)
            iB = 4;

            System.out.println("");
            System.out.println((iB+1)+". Name: "+shopN[iB].getName()+" | Stock: "+shopN[iB].getStockLevel());
            System.out.println("");
            System.out.print("Enter the quantity Bought: ");
            QtyN = sc.nextInt();

            System.out.println("");
            System.out.println("The Value of the stock Bought is £" + shopN[iB].buyStock(QtyN));
            System.out.println("The New Stock is " +shopN[iB].getStockLevel());
            System.out.println("");
            System.out.print("Would you like to buy the stock of another Product? (y/n): ");
            xB = sc.next().charAt(0);
            xB = Character.toLowerCase(xB);

            //input validation for yes or no.

            while(xB != 'y' && xB != 'n')
            {
                System.out.print("Invalid Input Enter Either 'y' for 'Yes' or 'n' for 'No': ");
                xB = sc.next().charAt(0);
                xB = Character.toLowerCase(xB);
            }
        }while(xB == 'y');
        System.out.println("\n");
    }

//method to sell the stock and edit the stockLevel variable.


        static void sellMethod(int ProNameN, int QtyN, Product[] shopN, int iS, char xS)
    {
        System.out.println("\n");
        System.out.println("3. Sell Stock");
        displayProducts(shopN);
        
        //using a do-while loop so the user can sell more than one products from the stock.
    
        do
        {
            System.out.print("Enter the product Sold: ");
            ProNameN = sc.nextInt();
            while(ProNameN < 1 || ProNameN > 5)
            {
                System.out.print("Invalid Input, Enter valid Product: ");
                ProNameN = sc.nextInt();
            }

            //if-else statement to select the correct product from the array.

            if(ProNameN == 1)
            iS = 0;

            else if(ProNameN == 2)
            iS = 1;

            else if(ProNameN == 3)
            iS = 2;

            else if(ProNameN == 4)
            iS = 3;

            else if(ProNameN == 5)
            iS = 4;

            System.out.println("\n");
            System.out.println((iS+1)+". Name: "+shopN[iS].getName()+" | Stock: "+shopN[iS].getStockLevel());
            System.out.print("Enter the quantity Sold: ");
            QtyN = sc.nextInt();

            System.out.println(shopN[iS].sell(QtyN));
            System.out.println("\n");
            System.out.println("The New Stock is "+shopN[iS].getStockLevel());
            System.out.println("\n");
            System.out.print("Would you like to sell another Product? (y/n): ");
            xS = sc.next().charAt(0);
            xS = Character.toLowerCase(xS);

            //input validation for yes or no.

            while(xS != 'y' && xS != 'n')
            {
                System.out.print("Invalid Input Enter Either 'y' for 'Yes' or 'n' for 'No': ");
                xS = sc.next().charAt(0);
                xS = Character.toLowerCase(xS);
            }
        
        }while(xS == 'y');
        System.out.println("\n");
    }

    //method to re-price the stock to user inputted price.

    static void setPriceMethod(int ProNameN, double PriceN, Product[] shopN, int iP, char xP)
    {
        System.out.println("\n");
        System.out.println("4. Re-Price a Stock Item");
        displayProducts(shopN);

        //using a do-while loop so the user can edit the price of more than one products from the stock.       

        do
        {
            System.out.print("Enter the product to change price: ");
            ProNameN = sc.nextInt();
            while(ProNameN < 1 || ProNameN > 5)
            {
                System.out.print("Invalid Input, Enter valid Product: ");
                ProNameN = sc.nextInt();
            }

            //if-else statement to select the correct product from the array.

            if(ProNameN == 1)
            iP = 0;

            else if(ProNameN == 2)
            iP = 1;

            else if(ProNameN == 3)
            iP = 2;

            else if(ProNameN == 4)
            iP = 3;

            else if(ProNameN == 5)
            iP = 4;

            System.out.println("\n");
            System.out.println((iP+1)+". Name: "+shopN[iP].getName()+" | Price: £"+shopN[iP].getPrice());

            System.out.print("Enter the new price of the Product: £");
            PriceN = sc.nextDouble();

            shopN[iP].setPrice(PriceN);
            System.out.println("\n");
            System.out.println("The New Price is £"+shopN[iP].getPrice());
            System.out.println("\n");
            System.out.print("Would you like change the price of another Product? (y/n): ");
            xP = sc.next().charAt(0);
            xP = Character.toLowerCase(xP);

            //input validation for yes or no.

            while(xP != 'y' && xP != 'n')
            {
                System.out.print("Invalid Input Enter Either 'y' for 'Yes' or 'n' for 'No': ");
                xP = sc.next().charAt(0);
                xP = Character.toLowerCase(xP);
            }
        
        }while(xP == 'y');
        System.out.println("\n");    

    }

//method to display the total value of stock in the current inventory.
    
    static void totalValueMethod(Product[] shopN)
    {
        double totalValue = 0;

        System.out.println("\n");
        System.out.println("5. Total Stock Value");
        System.out.println("\n");
        for(int i = 0; i < shopN.length; i++)
        {
        totalValue += shopN[i].getPrice()*shopN[i].getStockLevel();

        }
        System.out.println("The total Stock Value is: £"+ totalValue);
        System.out.println("\n");
    }


}