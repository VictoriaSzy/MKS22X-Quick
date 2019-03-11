import java.util.* ;
import java.io.* ;

public class Quick {
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
    Random a = new Random() ;
    int pivot = a.nextInt() % lim ;
    pivot += start ;
    //System.out.println("The pivot is: " + pivot) ;
    int temp = data[start] ;
    data[start] = data[pivot] ;
    data[pivot] = temp ;
    int s = start ;
    for (int i = start + 1 ; i < end + 1 ; i++) {
      if (data[i] < data[start]) {
        // it goes to the left!
        s++ ;
        temp = data[s] ;
        data[s] = data[i] ;
        data[i] = temp ;
      }
    }
    temp = data[start] ;
    data[start] = data[s] ;
    data[s] = temp ;
    return s ;
  }
}
