import java.io.*; 
import java.util.*; 

public class test{
   public static boolean f(int x){
      return x*x >= 30;
      //function f(x) returns true or false
   }
   public static int fstTrue(int lo, int hi) {
      for (hi ++; lo < hi; ) {
         // returns smallest x in [lo,hi] that satisfies f
         // hi+1 if no x satisfies f
         int mid = (lo+hi)/2;
         if(f(mid)) hi = mid; else lo = mid+1;
      }
      return lo;
   }
   public static void main(String[] args) throws IOException
   {
      System.out.println(fstTrue(2,10)); // 6
   }
}
