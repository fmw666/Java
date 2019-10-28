import java.util.Arrays;

public class test1{
    public static void main(String[] args) {
        System.out.println("-- Test1 : Shape C&S calculate --");
        // create ReArrayList object
        ReArrayList array1 = new ReArrayList(2);
        array1.add(123);
        array1.add("hello");
        System.out.println(array1.get(1));
        System.out.println(array1.get(0));
        System.out.println(array1.get(2));
        array1.add('s');
        System.out.println(array1.get(3));
        System.out.println(array1.size());
        System.out.println(array1.capacity());
        System.out.println(array1.isEmpty());
        System.out.println("---");
        array1.clear();
        System.out.println(array1.get(1));
        System.out.println(array1.size());
        System.out.println(array1.capacity());
        System.out.println(array1.isEmpty());
        System.out.println();

        // create ReArrayList object
        ReDoubledArrayList array2 = new ReDoubledArrayList(3);
        array2.add(123);
        array2.add("hello");
        System.out.println(array2.get(1));
        System.out.println(array2.get(0));
        System.out.println(array2.get(2));
        array2.add('s');
        System.out.println(array2.get(3));
        System.out.println(array2.size());
        System.out.println(array2.capacity());
        array2.add(null);
        System.out.println(array2.size());
        System.out.println(array2.isEmpty());
        System.out.println("---");
        array2.clear();
        System.out.println(array2.get(1));
        System.out.println(array2.size());
        System.out.println(array2.capacity());
        System.out.println(array2.isEmpty());
    }
}

// ReList interface
interface ReList {
    public void add(Object obj);   // add item from arr's tail
    public Object get(int index);  // get index position's arr item
    public void clear();           // clear all the items
    public boolean isEmpty();      // judge the arr if have items
    public int size();             // get the number of arr's items
    public int capacity();         // get the capacity size
}


class ReArrayList implements ReList {
    private int incSize;
    private Object[] arr;
    
    public ReArrayList(int incSize) {
        if (incSize < 0) {
            this.incSize = 5;
        } else {
            this.incSize = incSize;
        }
        this.arr = new Object[this.incSize];
    }

    public void add(Object obj) {
        boolean ifAddObj = false;
        int arrLength = arr.length;
        for (int i = 0; i < arrLength; i++) {
            if (arr[i] == null) {
                arr[i] = obj;
                ifAddObj = true;
                break;
            }
        }
        if (!ifAddObj) {
            arr = Arrays.copyOf(arr, arrLength + incSize);
            arr[arrLength] = obj;
        }
    }

    public Object get(int index) {
        if (index >= arr.length) {
            System.err.println("Hint: index error!");
            return null;
        } else {
            return arr[index];
        }
    }

    public void clear() {
        arr = new Object[arr.length];
    }

    public boolean isEmpty() {
        for (Object obj : arr) {
            if (obj != null) {
                return false;
            }
        }
        return true;
    }
    
    public int size() {
        return arr.length;
    }

    public int capacity() {
        return arr.length * 4;
    }
}

class ReDoubledArrayList implements ReList {
    private int initSize;
    private Object[] arr;
    
    public ReDoubledArrayList(int initSize) {
        if (initSize < 0) {
            this.initSize = 10;
        } else {
            this.initSize = initSize;
        }
        this.arr = new Object[this.initSize];
    }

    public void add(Object obj) {
        boolean ifAddObj = false;
        int arrLength = arr.length;
        for (int i = 0; i < arrLength; i++) {
            if (arr[i] == null) {
                arr[i] = obj;
                ifAddObj = true;
                break;
            }
        }
        if (!ifAddObj) {
            arr = Arrays.copyOf(arr, arrLength * 2);
            arr[arrLength] = obj;
        }
    }

    public Object get(int index) {
        if (index >= arr.length) {
            System.err.println("Hint: index error!");
            return null;
        } else {
            return arr[index];
        }
    }

    public void clear() {
        arr = new Object[arr.length];
    }

    public boolean isEmpty() {
        for (Object obj : arr) {
            if (obj != null) {
                return false;
            }
        }
        return true;
    }
    
    public int size() {
        return arr.length;
    }

    public int capacity() {
        return arr.length * 4;
    }
}