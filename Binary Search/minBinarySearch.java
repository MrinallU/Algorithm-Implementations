import java.io.*; 
import java.util.*; 

public class minBinarySearch{
   public static boolean f(int x){
      return x*x <= 30;
      //function f(x) returns true or false
   }
   public static int lstTrue(int lo, int hi) {
      int res = lo-1;
      while (lo <= hi) {
         int mid = (lo+hi)/2; // find the middle of the current range
         if (f(mid)) {
            // if mid works, then all numbers smaller than mid also work
            // so we only care about the part after mid
            res = mid; // update the answer
            lo = mid+1; // cut the part before mid
            // notice that we already handled mid itself so we cut it as well
         } else {
            // if mid does not work, greater values would not work too
            // so we don't care about them
            hi = mid-1; // cut mid and after
         }
      }
    // now res is the answer
    // if res is l-1 that means no value in the range satisfies the condition
      return res;
   }
   public static void main(String[] args) throws IOException
   {
      System.out.println(lstTrue(2,10)); // 5
   }
}
