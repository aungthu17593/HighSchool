public abstract class shapes{

    protected String color;
    protected boolean filled;
    protected String bordertype;
    
 public abstract double area();
 
 public abstract double perimeter();
 
 public shapes()
  {
    color =  "green";
    filled =  true;
    bordertype = "line";
  }
  
  }