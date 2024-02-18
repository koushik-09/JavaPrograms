package koushik.programs.sorting;

import java.util.ArrayList;
import koushik.heaps.Heap;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {-9,-8,-7,-6,-5,-4,-3,-2,-1};
        heapSort(arr);
    }
    public static void heapSort(int[] arr){
        Heap<Integer> heap = new Heap<>();
        if(arr.length==0){
            System.out.println("No Elements");
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : arr){
            list.add(i);
        }
        heap.insert(list);
        while(!heap.isEmpty()){
            try{
                System.out.print(heap.remove()+" ");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
