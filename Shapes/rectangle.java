public class rectangle extends shapes{

    private double len;
    private double width;
    
  public double area()
  {
    return(len*width);
  }
  
  public double perimeter()
  {
    return(2.0*(len+width));
  }
  }