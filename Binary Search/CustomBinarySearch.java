import java.util.Arrays;

class Main {
  static boolean check(int ans ,int prevNum){
    if(ans < prevNum) return true; // Custom condition
    return false; 
  }

  static int customBinarySearch(int [] arr){
    int l = 0; int r = arr.length - 1; int prevNum = 1000000000;int ans = 100000000;  
    
  while(l <= r){
    int mid = (l + r) / 2;
      if(check(arr[mid], prevNum)){
        l = mid + 1;  // Find the maximum possible value
       ans = mid; 
      } else{
       r = mid - 1;  // reverse to find min value
       
      }
  }
    return ans;
  }

  public static void main(String[] args) {
    int [] arr = {1, 5, 7, 9, 2, 6};
    Arrays.sort(arr);

    int ans = customBinarySearch(arr);  
    System.out.println(Arrays.toString(arr)); 
    System.out.println(arr[ans]);
  }
}
