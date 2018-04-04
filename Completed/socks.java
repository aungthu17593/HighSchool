import java.util.Scanner;

public class socks
{
public static void main (String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Input number of red socks");
  int nr= inp.nextInt();
  System.out.println("Input number of white  socks");
  int nw= inp.nextInt();
  System.out.println("Input number of blue socks");
  int nb= inp.nextInt();
  int N= nr+nw+nb;
  System.out.println("Input number of socks you pull out");
  int m= inp.nextInt();
  System.out.println("Input number of trials");
  int trial= inp.nextInt();
  
  int count, success, r,w,b;
  count = 0; success=0;
  
  double[] socks = new double [N];
  
  for (int i=0; i<nr; i++){
  socks[i]=1;
  }
  for (int i=nr; i<nr+nw; i++){
  socks[i]=2;
  }
  for (int i=nr+nw; i<N; i++){
  socks[i]=3;
  }
  
  while(count<trial)
  {
  r=0; b=0;w=0;
  socks= foo.shuffle(socks, N);
    
    for(int i=0; i<m; i++)
    {
    if(socks[i]==1) r=1;
    else if (socks[i]==2) w=1;
    else if (socks[i]==3) b=1;
    }
    
    if (r==w && w==b) success++;
  
  count++;
  }
  
  double p = (double) success/trial;
  System.out.println("Probability of having every color of socks is "+p);
  }}