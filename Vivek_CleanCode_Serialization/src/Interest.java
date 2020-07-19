import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Scanner;
class Calculate
{
    int principal;
    int rate;
    int time;
    double simpleInterest;
    double compoundInterest;
    Calculate(int principal,int rate,int time)
    {
        this.principal=principal;
        this.rate=rate;
        this.time=time;
    }
    public double SimpleInterest()
    {
        simpleInterest=(principal*rate*time)/100;
        return simpleInterest;
    }
    public double CompoundInterest()
    {
        double value=Math.pow((1-rate/100),time);
        compoundInterest=principal*(value-1);
        return compoundInterest;
    }
}
public class Interest
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int principal=s.nextInt();
        int rate=s.nextInt();
        int time=s.nextInt();
        Calculate calculate=new Calculate(principal,rate,time);
        double si=calculate.SimpleInterest();
        double ci=calculate.CompoundInterest();
        try
        {
            FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\Vivek\\Desktop\\Output.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeDouble(si);
            objectOutputStream.writeDouble(ci);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }}