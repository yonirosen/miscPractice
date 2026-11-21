package onegrad;

import java.util.Arrays;

public class QSort {

  public QSort () {

  }

  public void sort (int [] arr) {
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
  }

  public boolean validate (int [] arr, int [] sorted) {
    if (arr.length != sorted.length) {
      printErr(arr, sorted, String.format("wrong size %d , %d", arr.length, sorted.length));
    }

    
    return true;
  }

  private void printErr (int [] arr, int [] sorted, String msg){
    System.out.println(String.format(" *** %s \t Found: %s, Expected: %s", msg, Arrays.toString(arr), Arrays.toString(sorted)));
  }

}
