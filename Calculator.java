public abstract class Calculator implements Multiplier,Divider {
    protected int total;
    Calculator()  {
        total=1;
    }
    public void multiply(int y){
        try{
            total=total*y;
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    public void divide(int y){
        try{
            total=total/y;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    abstract int calculate(); }