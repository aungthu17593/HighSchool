public class drpolygon extends rpolygon{

    private String color;
    private boolean isfilled;
    
    public drpolygon (String col, boolean fv)
    {
      color=col;
      isfilled=fv;
    }
    
    public drpolygon (int n, double x)
    {
      nosides=n;
      length=x;
      color="red";
      isfilled=false;
    }
     
    public String getcolor()
    {
      return(color);
    }
    
    public boolean isfilled()
    {
      return(isfilled);
    }
    
    public void set_color(String c)
    {
      color=c;
      return;
    }
    
    public void set_fill(boolean w)
    {
      isfilled=w;
      return;
    }
    
    }