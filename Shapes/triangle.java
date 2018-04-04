public class triangle extends shape{

  private double len1;
  private double len2;
  private double len3;
  
  public double area();
  {
    double s = this.perimeter();
    return(Math.sqrt(s*(s-len1)*(s-len2)*(s-len3)));
    
  public double perimeter();
  {
  return(len1+len2+len3);
  }
  }
  }