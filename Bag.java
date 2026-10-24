public class Bag<T>{
    private static final int INITIAL_CAPACITY = 10;
    private T[] items;
    private int size;

    /*Constructor: Creates an empty bag with a starting capacity */
    @SuppressWarnings("unchecked")
    public Bag(){
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /*Add: adds an item into the bag. If array is full, it doubles the size then adds the item. */
    public void add(T item){
        if (size == items.length){
            grow();
        }
        items[size] = item;
        size++
    }

    public void remove(T item){
        int index = indexOf(item);
        if(indeex == -1){
            return;
        }
        items[index] = items[size - 1];
        items[size -1] = null;
        size--;
    }
    
    public boolean contains(T item){
        return indexOf(item) != -1;
    }

    public int count(T item){
        int total = 0;
        for (int i = 0; i < size; i++){
            if(isEqual(items[i], item)){
                total++
            }
        }
        return total;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){
        String result = "[";
        for (int i = 0; i < size; i++){
            result += items[i];
            if(i < size - 1){
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    // Private Helper Methods

    private int indexOf(T item){
        for(int i = 0; i < size; i++){
            if(isEqual(items[i], item)){
                return i;
            }
        }
        return -1;
    }

    
}
