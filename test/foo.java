public class foo{

    public static double mysqrt(double z)
    {
     return (mysqrt(z,0.000001, z/2.0));
    }
    
    public static double mysqrt(double z, double epsilon)
    {
      return (mysqrt(z, epsilon, z/2.0));
    }  
   
    public static double mysqrt(double z, double epsilon, double initial)
    {
      double xn, xn1,error;
      xn1=0;
      error=epsilon+1;
    
      while (error>epsilon)
      {
       xn = initial;
       xn1 = xn + (1/(2*xn))*(z-xn*xn);
      error = (xn1-xn)/z;
      initial=xn1;
      }
      
      return (xn1);
    }
    
    public static double[][] matrixmultiply (double[][] x, double[][] y, int m, int n, int p)
    {
    double[][] z = new double [m][p];
    
    for (int i=0; i<m; i++){
    for (int j=0; j<p; j++){
      for (int k=0; k<n ; k++)
      {
      z[i][j] += x[i][k]*y[k][j];
      }
    }}
    
    return (z);
    }
    
    public static double[] shuffle (double[] a,int n)
    {
      int x; double y=0;
       for (int i=0;i<n;i++)
        {
        x = (int)(Math.random()*(n-1-i));    
        y = a[n-1-i];  
        a[n-1-i] = a[x];
        a[x] = y;
        }
        
        return (a);
        }
     
     public static int sumdigits (int n)
      {
        if (n<10) return(n);
        else
      {
        return((n%10)+sumdigits(n/10));
      }
       }
     public static long Convert (long N, long rin, long rout)
     {
      long temp, digits, decimal, number, remainder, output,k, temp1;
      long test=10;
      temp=0; decimal=0; output=0; temp1=N;k=0; digits=0;
      while (true)
      {
        temp1 = temp1-test;
        digits++;
        test*=10; 
        if (temp1<0) break;
      }
      
      if (!(rin==10))
        {
        for (long i=0; i<digits; i++)
        {
        number = (long)(((N%Math.pow(10,i+1))-temp)/(Math.pow(10,i)));
        temp = number;
        decimal +=  number*(Math.pow(rin,i));
        }}
      else
      {
      decimal = N;
      }
      
     while (decimal>0)
     {
     remainder = decimal%rout;
     decimal = decimal/rout;
     output += remainder*(Math.pow(10,k));
     k++;
     }
     
     return (output);
     }
     
   public static long fibo_rec(int n)
   {
    if (n==0) return (0);
    else if (n==1) return (1);
    else return (fibo_rec(n-1)+fibo_rec(n-2));
   }

   public static long fibo_norec(int n)
   {
    long a,b, c;
     a=0; b=1;  c=0;
    if (n==0) return(a);
    else if (n==1) return(b);
    else{
    for (int i=1; i<n; i++)
    { 
      c=a+b;
      a=b;
      b=c;
     }
     return(c); 
    }}

    public static boolean palindrome (String word)
    {
      int n= word.length();
      if (n<=1) return(true);
      else if (word.charAt(0)!=word.charAt(n-1))
      {
        return(false);
      }
        else
      {
        return (palindrome(word.substring(1,n-1)));
      }}
 }
   
   