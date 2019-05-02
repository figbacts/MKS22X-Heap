import java.util.*;
public class MyHeap{
  public static void pushDown(int[]data,int size,int index){
    int parent = data[index];
    if (index * 2 + 2 < size){
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
  else if(index * 2 + 1 < size){
    int child1 = data[index * 2 + 1];
    if (child1 > data[index]){
    data[index * 2 + 1] = parent;
    data[index] = child1;
    pushDown(data,size, index * 2 +1);
    }
  }
  }
  public static void heapify(int[] data){
    for(int j = data.length/2; j > -1; j--){
      pushDown(data,data.length,j);
    }
  }
  public static void heapsort(int[] data){
    heapify(data);
    /*
    int big = data[0];
    data[0] = data[data.length-1];
    data[data.length-1] = big;
    pushDown(data,data.length -1,0);
    */

    for (int end = data.length -1; end > -1;end --){
      //System.out.println(Arrays.toString(data));
      int big = data[0];
      data[0] = data[end];
      data[end] = big;
      //System.out.println(Arrays.toString(data));
      pushDown(data,end, 0);
    }
  }
  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
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
          heapsort(data2);
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
    }
  }
}
