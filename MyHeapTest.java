
import java.io.*;

class Customer {

    public int order;
    public static int type1Start = 100;
    public static int type2Start = 400;
    public static int type3Start = 700;
    public String TC;
    public int custId;

    public Customer() {
        this.order = type3Start++;
        this.TC = "";
    }

    public Customer(String TC) {
        this.order = type2Start++;
        this.TC = TC;
        this.custId = 0;
    }

    public Customer(int id) {
        this.order = type1Start++;
        this.TC = "";
        this.custId = id;
    }

    @Override
    public String toString() {
        return "Order: " + order + " TC: " + TC + " ID: " + custId + "\n";
    }
}

////////////////////////////////////////////////////////////////
class Heap {

    private Customer[] heapArray;
    private int maxSize;           // size of array
    private int currentSize;       // number of nodes in array

    public Heap(int max) {
        maxSize = max;
        currentSize = 0;
        heapArray = new Customer[maxSize];
    }

    public int left(int ind) {
        return (ind * 2) + 1;
    }

    public int right(int ind) {
        return (ind * 2) + 2;
    }

    public int parent(int ind) {
        if (ind == 0) {
            return 0;
        }
        return (ind - 1) / 2;
    }

    public void swap(int x, int y) {
        Customer temp = heapArray[x];
        heapArray[x] = heapArray[y];
        heapArray[y] = temp;

    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(Customer c) {
        // Inserts the customer inside of a min heap
        if (currentSize >= maxSize) {
            return false;
        } else {
            heapArray[currentSize++] = c;
            percolateUp(currentSize - 1);
            return true;
        }
    }

    public void percolateUp(int index) {
        // Percolate up the specific index to apply heap rules
        if (heapArray[parent(index)].order > heapArray[index].order) {
            swap(parent(index), index);
            percolateUp(parent(index));

        }
    }

    public Customer remove() {
        // Removes a Customer from the list
        if (currentSize == 0) {
            return null;
        } else {
            Customer tmp = heapArray[0];
            heapArray[0] = heapArray[currentSize--];
            percolateDown(0);
            return tmp;
        }
    }

    public void percolateDown(int index) {

        int left = (index * 2) + 1;
        int right = (index * 2) + 2;

        int largest = index;

        if (heapArray[left].order > heapArray[index].order) {
            largest = left;
        } else if (heapArray[right].order > heapArray[index].order) {
            largest = right;
        }

        if (largest != index) {
            Customer temp = heapArray[index];
            heapArray[index] = heapArray[largest];
            heapArray[largest] = temp;
            percolateDown(largest);
        }

    }

    // Displays the heap
    public void displayHeap() {
        System.out.print("heapArray: ");
        for (int m = 0; m < currentSize; m++) {
            if (heapArray[m] != null) {
                System.out.print(heapArray[m].order + " ");
            } else {
                System.out.print("-- ");
            }
        }
        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots + dots);

        while (currentSize > 0) {
            if (column == 0) {
                for (int k = 0; k < nBlanks; k++) {
                    System.out.print(' ');
                }
            }

            System.out.print(heapArray[j].order);

            if (++j == currentSize) {
                break;
            }

            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }
}

public class BankOrder {

    public static void main(String[] args) throws IOException {

        Heap theHeap = new Heap(100);
        Customer c1 = new Customer();
        System.out.println(c1);
        theHeap.insert(c1);
        Customer c2 = new Customer();
        System.out.println(c1);
        theHeap.insert(c2);
        Customer c3 = new Customer("1111");
        System.out.println(c3);
        theHeap.insert(c3);
        Customer c4 = new Customer(3259);
        System.out.println(c4);
        theHeap.insert(c4);
        Customer c5 = new Customer();
        System.out.println(c5);
        theHeap.insert(c5);
        Customer c6 = new Customer("2222");
        System.out.println(c6);
        theHeap.insert(c6);
        Customer c7 = new Customer(2594);
        System.out.println(c7);
        theHeap.insert(c7);
        Customer c8 = new Customer("3333");
        System.out.println(c8);
        theHeap.insert(c8);
        Customer c9 = new Customer(1234);
        System.out.println(c9);
        theHeap.insert(c9);
        Customer c10 = new Customer(5985);
        System.out.println(c10);
        theHeap.insert(c10);

        theHeap.displayHeap();

        theHeap.remove();
        theHeap.remove();

        theHeap.displayHeap();

    }
}
