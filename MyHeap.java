import java.util.*;
public class MyHeap{
  public static void pushDown(int[]data,int size,int index){
    if (2 * index + 1 >= size){
      return;
    }
    int parent = data[index];
    int child1 = data[index * 2 + 1];
    int child2 = data[index * 2 + 2];
    if (child1 > data[index] && child1 >= child2){
      data[index * 2 + 1] = parent;
      data[index] = child1;
      pushDown(data,size, index * 2 +1);
    }
    else if(child2 > data[index] && child2 > child1){
      data[index * 2 + 2] = parent;
      data[index] = child2;
      pushDown(data,size, index * 2 + 2);
    }
  }
  public static void heapify(int[] data){

  }
  public static void main(String[] args) {
    int [] ary = new int[] {8,14,17,9,0,7,12};
    System.out.println(Arrays.toString(ary));
    pushDown(ary,7,0);
    System.out.println(Arrays.toString(ary));
  }
}
