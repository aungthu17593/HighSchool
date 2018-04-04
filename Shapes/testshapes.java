public class testshapes{

  shapes[] x = new shapes [3]
  x[0]= new rectangle();
  x[1] = new rectangle();
  x[2] = new triangle();
  }
  
  public double totarea()
  {
    double area = 0.0;
    for(int i=0; i<10; i++)
    {
    area +=x[i]-area;
    }
    return (area);
    }
    
  