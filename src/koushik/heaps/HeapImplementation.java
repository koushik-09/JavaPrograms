package koushik.heaps;

import java.util.ArrayList;
import java.util.Arrays;

public class HeapImplementation {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.insert(10);
        heap.insert(4);
        heap.insert(3);
        heap.insert(19);
        heap.insert(1);
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(6);
//        list.add(10);
//        list.add(7);
//        list.add(8);
        heap.insert(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        while(!heap.isEmpty()){
            try{
                System.out.println(heap.remove());
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
