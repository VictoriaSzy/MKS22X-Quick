import java.util.* ;
import java.io.* ;

public class Quick {
  public static void main(String[] args) {
    // Mr. K's Driver
    /*System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Quick.quicksort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }*/
    /*
    int[]ary = { 2, 10, 15, 23, 0,  5} ;  //sorted :  {0,2,5,10,15,23}
    System.out.println("********************************TESTING QUICKSELECT!********************************") ;
    System.out.println(Arrays.toString(ary)) ;
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
    System.out.println(Arrays.toString(aa)) ;
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
    int[] b = { 53, 62, 774, 21, 6, 26, 89, 689, 2 } ;
    System.out.println("The size of array b is: " + b.length) ;
    System.out.println("Here is how the array looks initially: \n" + Arrays.toString(b)) ;
    System.out.println("We are going to run quicksort now!") ;
    quicksort(b) ;
    System.out.println("quicksort has finished! Here is how b looks now: \n") ;
    System.out.println(Arrays.toString(b)) ;
    int[] c = {124, 14, 32, 53, 2551, 524, 11, 43, 353, 22551, 221156777, 55, 3356, 67, 90, 649, 877, 878, 7535, 8869, 98769 } ;
    System.out.println("The size of array c is: " + c.length) ;
    System.out.println("Here is how the array looks initially: \n" + Arrays.toString(c)) ;
    System.out.println("We are going to run quicksort now!") ;
    quicksort(c) ;
    System.out.println("quicksort has finished! Here is how c looks now: \n") ;
    System.out.println(Arrays.toString(c)) ;*/
  }
  private static int[] partitionDutch(int[] data, int lo, int hi) {
    /*return an array [lt,gt]
    index:          lt             i                    gt
        |-----------|--------------|---------------------|----------|
  regions:    r1           r2                r3               r4
    r1 are less than the pivot
    r2 are equal to the pivot
    r3 are UNKNOWN!
    r4 are greater than the pivot*/
    int lt = lo, gt = hi ;
    int i = lt + 1 ;
    int piv = lo ;
    while (i <= gt) {
      if (data[i] == data[piv]) i++ ;
      // we don't need to move that element
      else if (data[i] < data[piv]) {
        swap(lt, i, data) ;
        lt++ ;
        i++ ;
        piv++ ;
      }
      else {
        // it's greater than the pivot
        swap(gt, i, data) ; // swap the end
        gt-- ;
      }
    }
    return new int[] {lt, gt} ;
  }
  /*Modify the array to be in increasing order.
  */
  public static void quicksort(int[] data) {
    if (data.length > 0) quicksortH(data, 0, data.length - 1) ;
  }
  // helper method for quicksort
  public static void quicksortH(int[] data, int start, int end) {
    if (start >= end) return;
    int[] a = partitionDutch(data, start, end) ;
    //System.out.println("Dutch partitioning shows us: " + Arrays.toString(a)) ;
    quicksortH(data, start, a[0] - 1) ;
    quicksortH(data, a[1] + 1, end) ;
  }
  //////////////// OLD VERSION OF quicksortH BEFORE partitionDutch:
  /*
  public static void quicksortH(int[] data, int start, int end) {
    if (start >= end) return;
    int a = partition(data, start, end) ;
    //System.out.println("Position of pivot is: " + a)
    quicksortH(data, start, a - 1) ;
    quicksortH(data, a + 1, end) ;
  }
  */

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
  /*
  I was confused on how to make the pivot the median number and then got a stack overflow error from it
  so I made finding the pivot separate.
  */
  public static int makePivot(int[] data, int start, int end) {
    int pivot = 0 ;
    int half = data[(start + end) / 2] ;
    boolean a = data[start] > data[end] ;
    boolean b = data[start] < half ;
    boolean c = data[start] < data[end] ;
    boolean d = data[start] > half ;
    if ( a && b || c && d ) pivot = start ;
    /// otherwise we keep going
    else {
      a = data[end] > data[start] ;
      b = data[end] < half ;
      c = data[end] < data[start] ;
      d = data[end] > half ;
      if (a && b || c && d ) pivot = end ;
      else {
        pivot = (start + end) / 2 ;
      }
    }
    return pivot ;
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
    //int lim = end - start + 1 ;
    //System.out.println("The limit is " + lim) ;
    //int pivot = (int) Math.abs(Math.random() * lim) ;
    Random r = new Random() ;
    int pivot = makePivot(data, start, end) ;
    //System.out.println("The pivot is: " + pivot) ;
    if (start == end) return start ;
    swap(pivot, start, data) ;
    pivot = start ;
    start++ ;
    while (start != end) {
      int a = -1 ;
      if ( data[start] == data[pivot] ) a = r.nextInt(2) ;
      if ( data[start] < data[pivot] || a == 0) {
        // if it's less than pivot
        start++;
      }
      else if (data[start] > data[pivot] || a == 1 ) {
        swap(start, end, data) ;
        end-- ;
      }
    }
    /////////// while loop ends
    // finals swaps
    if (data[pivot] > data[start]) {
      // if the pivot is bigger than start
      swap(start, pivot, data) ;
      return start ;
    }
    else {
      swap(start - 1, pivot, data) ;
      return start - 1 ;
    }
 }
  // helper method to move around values
  public static void swap(int a, int b, int[] data) {
    int temp = data[a] ;
    data[a] = data[b] ;
    data[b] = temp ;
  }
}
