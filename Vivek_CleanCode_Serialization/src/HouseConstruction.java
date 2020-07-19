import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
class Cost
{
    String material;
    int area;
    String automation;
    int price;
    Cost(String material,int area,String automation)
    {
        this.material=material;
        this.area=area;
        this.automation=automation;
        this.price=0;
    }
    int calculateCost()
    {
        if(material.equalsIgnoreCase("standard"))
        {
            if(automation.equalsIgnoreCase("fully"))
                price+=1900*area;//1200->standard&&700->fully
            else
                price+=1200*area;
        }
        else if(material.equalsIgnoreCase("above standard"))
        {
            if(automation.equalsIgnoreCase("fully"))
                price+=2200*area;//1500->high standard&&700->fully
            else
                price+=1500*area;
        }
        else if(material.equalsIgnoreCase("high standard"))
        {
            if(automation.equalsIgnoreCase("fully"))
                price+=2500*area;//1800->high standard&&700->fully
            else
                price+=1800*area;
        }
        return price;
    }
}
public class HouseConstruction
{
    private static Scanner scanner;
	private static ObjectOutputStream objectOutputStream;

	public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Enter material type");
        String material= scanner.nextLine();
        System.out.println("Enter area");
        int area= scanner.nextInt();
        System.out.println("Enter automation type");
        String automation=scanner.next();
        Cost cost=new Cost(material,area,automation);
        int finalPrice=cost.calculateCost();
        try
        {
            FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\Vivek\\Desktop\\Output.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.write(finalPrice);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}