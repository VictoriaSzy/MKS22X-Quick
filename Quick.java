import java.util.* ;
import java.io.* ;

public class Quick {
  public static void main(String[] args) {
    int[]ary = { 2, 10, 15, 23, 0,  5} ;  //sorted :  {0,2,5,10,15,23}
    String res = "" ;
    for (int i : ary) {
      res += i + ", " ;
    }
    System.out.println("********************************TESTING QUICKSELECT!********************************") ;
    System.out.println(res) ;
    System.out.println("We are running quickselect and finding the 0th smallest element!\n" + quickselect(ary, 0 )) ; // would return 0
    System.out.println(quickselect(ary, 1)) ; // would return 2
    System.out.println("Expected: 2\n\n") ;
    System.out.println(quickselect(ary, 2)) ; // would return 5
    System.out.println("Expected: 5\n\n") ;
    System.out.println(quickselect(ary, 3)) ; // would return 10
    System.out.println("Expected: 10\n\n") ;
    System.out.println(quickselect(ary, 4)) ; // would return 15
    System.out.println("Expected: 15\n\n") ;
    System.out.println(quickselect(ary, 5)) ; // would return 23
    System.out.println("Expected: 23\n\n") ;
    System.out.println("\n*******Here is a new array!!*******") ;
    int[] aa = {1, 6, 4, 3, 5, 2} ;
    String re = "" ;
    for (int i : aa) {
      re += i + ", " ;
    }
    System.out.println(re) ;
    System.out.println(quickselect(aa, 0)) ; // would return 1
    System.out.println("Expected: 1\n\n") ;
    System.out.println(quickselect(aa, 1)) ; // would return 2
    System.out.println("Expected: 2\n\n") ;
    System.out.println(quickselect(aa, 2)) ; // would return 3
    System.out.println("Expected: 3\n\n") ;
    System.out.println(quickselect(aa, 3)) ; // would return 4
    System.out.println("Expected: 4\n\n") ;
    System.out.println(quickselect(aa, 4)) ; // would return 5
    System.out.println("Expected: 5\n\n") ;
    System.out.println(quickselect(aa, 5)) ; // would return 4
    System.out.println("Expected: 6\n\n") ;

    System.out.println("********************************TESTING QUICKSORT!********************************") ;
    int[] b = {} ;
  }

  /*Modify the array to be in increasing order.
  */
  public static void quicksort(int[] data) {
    if (data.length > 0) quicksortH(data, 0, data.length - 1) ;
  }
  // helper method for quicksort
  public static void quicksortH(int[] data, int start, int end) {
    if (start >= end) return;
    int a = partition(data, start, end) ;
    System.out.println("Position of pivot is: " + a) ;
    boolean b1 = a > start ;
    boolean b2 = a < end ;
    System.out.println("a > start: " + b1) ;
    System.out.println("a < end: " + b2) ;
    if (a > start) quicksortH(data, start, a - 1) ;
    if (a < end) quicksortH(data, a + 1, end) ;
  }

  /*return the value that is the kth smallest value of the array.
  */
  public static int quickselect(int[] data, int k) {
    //System.out.println("We are beginning quickselect now!") ;
    if (k < 0 || k >= data.length) {
      throw new IllegalArgumentException("k is not a valid argument!") ;
    }
    int p = partition(data, 0, data.length - 1) ;
    while (p != k) {
      // if it's greater than
      if (k > p) p = partition(data, p, data.length - 1) ;
      else {
        // if it's less than
        p = partition(data, 0, p) ;
      }
    }
    return data[p] ;
  }

  /*Modify the array such that:
  *1. Only the indices from start to end inclusive are considered in range
  *2. A random index from start to end inclusive is chosen, the corresponding
  *   element is designated the pivot element.
  *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
  *4. all elements in range that are larger than the pivot element are placed after the pivot element.
  *@return the index of the final position of the pivot element.
  */
  public static int partition(int [] data, int start, int end) {
   /*int lim = start + end ;
   lim = lim / 2 ;
   int pivot = lim ;
   int pivot = ((end - start) / 2) + 1 ; */
   if (start == end) return start ;
   int p = (start + end) / 2 ; // start at median or middle
   int pivot = data[p] ;
   //System.out.println("The pivot's value is: " + pivVal) ;
   int temp = data[start] ;
   data[start] = pivot ;
   data[p] = temp ;
   p = start ;
   start++ ;
   ///// while loop begins
   while (start != end) {
     if (data[start] >= pivot) {
       swap(start, end, data) ;
       end-- ;
     }
     else {
       start++ ;
     }
   }
   // done with while loop
   if (data[p] < data[start]) start-- ;
   // final steps
   data[p] = data[start] ;
   data[start] = pivot ;
   return start ;
 }
  // helper method to move around values
  public static void swap(int a, int b, int[] data) {
    int temp = data[a] ;
    data[a] = data[b] ;
    data[b] = temp ;
  }
}
