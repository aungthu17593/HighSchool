
public class twoD
{
  private double x;
  private double y;
  public static int noofobjects=0;
  
  public twoD(double xc, double yc)
    {
     x=xc;
     y=yc;
     noofobjects++;
    }
  public twoD(double xc)
  {
      x=xc;
      y=0.0;
      noofobjects++;
   }
   public twoD() 
   {
      this(0.0,0.0);
      noofobjects++;
   }
   
  public double getx()
  {   return (x);
  } 
  
  public double gety()
  {   return (y);
  } 
  
  public boolean equals(Object G)
  {
      double e=0.0000001;
      boolean result= false;
      if (this.getClass()!=G.getClass())
      {
      return(false);
      }
      else
      {
      twoD O =(twoD) G;
      result=(Math.abs(x-O.getx())<e) && (Math.abs(y-O.gety())<e);
      return (result);
      }
    }
  
  public double dist(twoD B)
  {
    double val;
    val=Math.sqrt(Math.pow((this.x-B.getx()),2)+Math.pow((this.y-B.gety()),2));
    return (val);
   } 
   
  public void set_x (double xval)
  {
    x=xval;
    return;
   }
  public void set_y (double yval)
  {
    y=yval;
    return;
   }
  
  public String toString()
  {
    String retstr;
    retstr="("+String.format("%.2f",x)+", "+String.format("%.2f",y)+")";
    return(retstr);
   }
   
  public twoD midpoint(twoD w)
  {
   return (new twoD((x+w.x)/2.0,(y+w.y)/2.0)); 
  }
  
  public twoD(twoD sp)
  {
    this(sp.x,sp.y);
  }
  
  public twoD rotate(double theta)
  {
    double a,b;
    a=x*Math.cos(theta)-y*Math.sin(theta);
    b=x*Math.sin(theta)+y*Math.cos(theta);
    twoD R= new twoD(a,b);
    return(R);
  }
  
    public twoD rotate(double theta, twoD center)
  {
    double tx= x-center.getx();
    double ty= y-center.gety();
    double a,b;
    a=tx*Math.cos(theta)-ty*Math.sin(theta);
    b=tx*Math.sin(theta)+ty*Math.cos(theta);
    twoD R= new twoD(a+center.getx(),b+center.gety());
    return(R);
  }
  
  public double area(twoD P1, twoD P2)
  {
    double a,b,c,s,area;
    a=P1.dist(P2);
    b=P2.dist(this);
    c=this.dist(P1);
    s=(a+b+c)/2;
    area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
    return(area);
  }
  
   public static twoD midpoint(twoD P, twoD Q)
   {
    return (new twoD((P.x+Q.x)/2.0,(P.y+Q.y)/2.0));  
    }
    
   public static double area(twoD P1, twoD P2, twoD P3)
   {
    double a,b,c,s,area;
    a=P1.dist(P2);
    b=P2.dist(P3);
    c=P3.dist(P1);
    s=(a+b+c)/2;
    area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
    return(area);
   }
   
   public static twoD transform(twoD P, double vshift, double hshift)
   {
   double a=P.x-hshift;
   double b=P.y+vshift;
   return(new twoD(a,b));
   }
   
   public static twoD[] rotateline(twoD A, twoD B, twoD O, double theta)
   {
    twoD[] point= new twoD [2];
    point[0]=A.rotate(theta, O);
    point[1]=B.rotate(theta, O);
    return(point); 
   }
   
   public static twoD[] rotateline(twoD[] point, twoD O, double theta)
   {
    twoD[] p1=new twoD [2];
    p1[0]=point[0].rotate(theta,O);
    p1[1]=point[1].rotate(theta,O);
    return(p1);
   }
   
   }