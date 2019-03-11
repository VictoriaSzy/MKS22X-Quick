import java.util.* ;
import java.io.* ;

public class Quick {
  public static void main(String[] args) {
    int[]ary = { 2, 10, 15, 23, 0,  5} ;  //sorted :  {0,2,5,10,15,23}
    quickselect(ary , 0 ) ; // would return 0
    quickselect(ary , 1 ) ; // would return 2
    quickselect(ary , 2 ) ; // would return 5
    quickselect(ary , 3 ) ; // would return 10
    quickselect(ary , 4 ) ; // would return 15
    quickselect(ary , 5 ) ; // would return 23
  }

  /*return the value that is the kth smallest value of the array.
  */
  public static int quickselect(int[] data, int k) {
    System.out.println("We are beginning quickselect now!") ;
    if (k < 0 || k >= data.length) {
      throw new IllegalArgumentException("k is not a valid argument!") ;
    }
    return partition(data, 0, data.length - 1) ;
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
    int lim = end - start + 1 ;
    System.out.println("The limit is " + lim) ;
    Random a = new Random() ;
    int pivot = Math.abs(a.nextInt() % lim) ;
    pivot += start ;
    System.out.println("The pivot is: " + pivot) ;
    int temp = data[start] ;
    data[start] = data[pivot] ;
    data[pivot] = temp ;
    int s = start ;
    System.out.println("We are beginning to compare values now!") ;
    for (int i = start + 1 ; i < end + 1 ; i++) {
      if (data[i] < data[start]) {
        // it goes to the left!
        s++ ;
        temp = data[s] ;
        data[s] = data[i] ;
        data[i] = temp ;
      }
      if (data[i] > data[start]) {
        // it goes to the right

      }
    }
    temp = data[start] ;
    data[start] = data[s] ;
    data[s] = temp ;
    return s ;
  }
}
