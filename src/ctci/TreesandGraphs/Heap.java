package ctci.TreesandGraphs;

import java.util.Arrays;

/**
 * Created by joetomjob on 8/10/19.
 */
public class Heap {
    private int capacity = 10;
    private int size = 0;
    int[] heap = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2*parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2*parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex-1) / 2;
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= size;
    }

    private int leftChild(int parentIndex) {
        return heap[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return heap[getRightChildIndex(parentIndex)];
    }

    private int parent(int childIndex) {
        return heap[getParentIndex(childIndex)];
    }

    private void swap(int indexone, int indextwo) {
        int tmp = heap[indexone];
        heap[indexone] = heap[indextwo];
        heap[indextwo] = tmp;
    }

    public void ensureExtraCapacity(){
        if(size == capacity) {
            capacity = 2 * capacity;
            heap = Arrays.copyOf(heap, capacity);
        }
    }

    private int peek(){
        if(size == 0) throw new IllegalStateException();
        return heap[0];
    }

    private int poll(){
        if(size == 0) throw new IllegalStateException();
        int tmp = heap[0];
        heap[0] = heap[size-1];
        heapifyDown();
        return tmp;
    }

    private void add (int k) {
        ensureExtraCapacity();
        heap[size] = k;
        size++;
        heapifyUp();
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if(heap[index] < heap[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size -1;
        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void printHeap(){
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            System.out.print('\t');
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(1);
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);

        h.printHeap();
    }

}
