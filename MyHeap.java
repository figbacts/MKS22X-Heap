public class MyHeap{
  private static void pushDown(int[]data,int size,int index){
    if (2 * index + 1 >= size){
      return;
    }
    int child1 = data[index * 2 + 1];
    int child2 = data[index * 2 + 2];
    if (child1 > data[index]){
      data[index * 2 + 1] = data[index];
      data[index] = child1;
    }
    
  }
  public static void heapify(int[]){

  }
}
