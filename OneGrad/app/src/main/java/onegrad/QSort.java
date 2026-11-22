package onegrad;

import java.util.Arrays;
import java.util.Random;

public class QSort {

  private long rCount = 0L;
  private Random rand = new Random();

  public QSort () {
    rand.setSeed(System.currentTimeMillis());
  }

  public void sort (int [] arr) {
    rCount = 0L;
    doSort (arr, 0, arr.length-1);
  }

  private void doSort (int [] arr, int start, int end) {
    if (start >= end){
      return;
    }

    int mid = (start + end) / 2;
    int pivot = arr[mid];
    int pos1 = start;
    int pos2 = end;

    while (pos1 < pos2) {
      while (pos1 < mid && arr[pos1] < pivot){
        pos1++;
      }

      if (pos1 < mid){
        replace (arr, pos1, mid);
        mid = pos1;
      }

      while (pos2 > mid && arr[pos2] >= pivot){
        pos2--;
      }

      if (pos2 > mid){
        replace (arr, pos2, mid);
        mid = pos2;
      }
    }
    doSort (arr, start, mid-1);
    doSort (arr, mid+1, end);
  }

  private void replace (int [] arr, int from, int to){
    int tmp = arr[from];
    arr[from] = arr[to];
    arr[to] = tmp;
    rCount++;
  }

  public long getrCount() {return rCount;}

  public void shake(int [] arr) {

    for (int i = 0; i < arr.length; i++) {
      int from = Math.abs(rand.nextInt()) % 100;
      int to = Math.abs(rand.nextInt()) % 100;
      replace (arr, from, to);
    }    
//    System.out.println(String.format(" ==> Shaked %s", Arrays.toString(arr)));
  }

  public boolean validate (int [] arr, int [] sorted) {
    if (arr.length != sorted.length) {
      printErr(arr, sorted, String.format("wrong size %d , %d", arr.length, sorted.length));
    }
    for (int i = 0; i < arr.length; i++ ){
      if (arr [i] != sorted [i]){
        printErr(arr, sorted, "Not similar ");
      }
    }
    
    return true;
  }

  private void printErr (int [] arr, int [] sorted, String msg){
    System.out.println(String.format(" *** %s \t Found: %s, Expected: %s", msg, Arrays.toString(arr), Arrays.toString(sorted)));
  }

}
