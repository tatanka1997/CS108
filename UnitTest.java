public class UnitTest{
    public static void main(String args[])  {
        MiniCalculator m=new MiniCalculator();
        m.multiply(5);
        if(m.calculate()!=5)
            System.out.println("\n\tFailed to multiply");
        else
            System.out.println("\n\tSuccess to multiply");
        m.divide(2);
        if(m.calculate()!=2)
            System.out.println("\n\tFailed to divide");
        else
            System.out.println("\n\tSuccess to multiply");    } }