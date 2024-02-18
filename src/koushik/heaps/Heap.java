package koushik.heaps;
import java.util.*;
public class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;
    public Heap(){
        list = new ArrayList<>();
    }
    private void swap(int ind1, int ind2){
        T temp=list.get(ind1);
        list.set(ind1,list.get(ind2));
        list.set(ind2,temp);
    }
    private int parent(int ind){
        return (ind-1)/2;
    }
    private int left(int ind){
        return (ind*2)+1;
    }
    private int right(int ind){
        return (ind*2)+2;
    }
    public void insert(T val){
        list.add(val);
        upHeap(list.size()-1);
    }
    public void insert(ArrayList<T> arr){
        for(T i : arr){
            insert(i);
        }
    }
    private void upHeap(int ind){
        if(ind == 0){
            return;
        }
        int p = parent(ind);
        if(list.get(ind).compareTo(list.get(p))<0){
            swap(ind,p);
            upHeap(p);
        }
    }
    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Heap is Empty");
        }
        T temp=list.get(0);
        T last=list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
            downHeap(0);
        }
        return temp;
    }
    private void downHeap(int ind){
        int min=ind;
        int left=left(ind);
        int right=right(ind);
        if(left<list.size() && list.get(min).compareTo(list.get(left))>0){
            min=left;
        }
        if(right<list.size() && list.get(min).compareTo(list.get(right))>0){
            min=right;
        }
        if(min!=ind){
            swap(min,ind);
            downHeap(min);
        }
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
