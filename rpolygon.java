public class rpolygon { 

    protected int nosides;
    protected double length;
    protected twoD center;
    protected twoD[] vertices;
    
    public rpolygon(int n, double l, twoD C)
    {
      nosides=n;
      length=l;
      center= new twoD (C);
      vertices= new twoD[n];
    }
    
    public rpolygon(int n)
    {
      this(n,1.0,new twoD(0.0,0.0));
       vertices= new twoD[n];
    }
    
    public rpolygon(int n, double l)
    {
      this(n,l,new twoD(0.0,0.0));
      vertices= new twoD[n];
    }
    
    public rpolygon()
    {
      this(4,1.0,new twoD(0.0,0.0));
       vertices= new twoD[4];
    }
    
    public double getn()
    {
      return(nosides);
    }
    
    public double getlength()
    {
      return(length);
    }
    
    public twoD getcenter()
    {
      return(center);
    }
    
    public void set_n(int n)
    {
      nosides=n;
      return;
    }
    
    public void set_length(double l)
    {
      length=l;
      return;
    }
    
    public void set_center(twoD C)
    {
      center=new twoD(C);
      return;
    }
    
    public boolean equals (Object P)
    { 
      boolean result=false;
      if (this.getClass() != P.getClass())
      {
        return(false);
      }
      else
      {
        rpolygon that= (rpolygon) P;
        result=(this.getn()==that.getn()) && (this.getlength()==that.getlength()) && ((this.getcenter()).equals(that.getcenter()));
        return(result);
      }
      
    }

    public String toString()
    {
      String retstr;
      retstr= "("+nosides+" "+length+" "+center+")";
      return(retstr);
    }
    
    public double perimeter()
    {
      double p= nosides*length;
      return(p);
    }
    
    public double area()
    {
      double p=this.perimeter();
      double ap=(length/2)/Math.tan(Math.PI/nosides);
      double A=0.5*ap*p;
      return (A); 
    }
    
    public double radius()
    {
      return(length/(2*Math.sin(Math.PI/nosides)));
    }
    
    public twoD[] getvertices()
    {
      twoD[] V = new twoD[nosides];
      double r= this.radius();
      double x = center.getx(); 
      double y = center.gety();
      V[0] = new twoD(x,y+r);
      double theta = (2*Math.PI/nosides);
      int n=1;
      
      while (n<nosides)
      {
        V[n]=V[n-1].rotate(theta, center);
        n++;
      }
      return(V);  
    }
    
    }
    
    