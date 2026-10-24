public class Bag<T> {
    // Instance Variables
    private static final int INITIAL_CAPACITY = 10;
    private T[] items;
    private int size;

    /* Constructor: Creates an empty bag with a starting capacity */
    @SuppressWarnings("unchecked")
    public Bag() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /*
     * Add: adds an item into the bag. If array is full, it doubles the size then
     * adds the item.
     */
    public void add(T item) {
        if (size == items.length) {
            grow();
        }
        items[size] = item;
        size++;
    }

    /* Remove: removes an item from the bag. */
    public void remove(T item) {
        int index = indexOf(item);
        if (index == -1) {
            return;
        }
        items[index] = items[size - 1];
        items[size - 1] = null;
        size--;
    }

    /* Contains: checks if an item is in the bag. */
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    /* Count: counts the number of occurrences of an item in the bag. */
    public int count(T item) {
        int total = 0;
        for (int i = 0; i < size; i++) {
            if (isEqual(items[i], item)) {
                total++;
            }
        }
        return total;
    }

    public int size() {
        return size;
    }

    /* IsEmpty: checks if the bag is empty. */
    public boolean isEmpty() {
        return size == 0;
    }

    /* ToString: returns a string representation of the bag. */
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += items[i];
            if (i < size - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    // Private Helper Methods
    /*
     * indexOf: returns the index of the first occurrence
     * of an item in the bag, or -1 if not found.
     */
    private int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (isEqual(items[i], item)) {
                return i;
            }
        }
        return -1;
    }

    /* isEqual: checks if two items are equal. */
    private boolean isEqual(T a, T b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }

    @SuppressWarnings("unchecked")
    /* grow: doubles the size of the array when it is full. */
    private void grow() {
        T[] newItems = (T[]) new Object[items.length * 2];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    public static void main(String[] args) {
        System.out.println("------ Bag Class Test ---\n");

        // Create an instance of Bag Class
        Bag<String> bag = new Bag<>();

        // Populate the bag with items
        bag.add("apple");
        bag.add("banana");
        bag.add("apple");

        // Print the bag contents
        System.out.println("Bag contents: " + bag.toString());
        System.out.println("Bag size: " + bag.size());
        System.out.println();

        // Test the contains method
        System.out.println("Bag contains 'apple': " + bag.contains("apple"));
        System.out.println("Bag contains 'banana': " + bag.contains("banana"));
        System.out.println();

        // Test the count method
        System.out.println("Count of 'apple': " + bag.count("apple"));
        System.out.println("Count of 'banana': " + bag.count("banana"));
        System.out.println();

        // Test the remove method
        bag.remove("apple");
        System.out.println("Bag contents after removing 'apple': " + bag.toString());
        System.out.println();

        // Test the isEmpty method
        System.out.println("Is the bag empty? " + bag.isEmpty());
        System.out.println();

        // Test the remove method for an item not in the bag
        bag.remove("orange");
        System.out.println("Bag contents after trying to remove 'orange': " + bag.toString());
        System.out.println();

        // print the bag contents and size
        System.out.println("Bag contents: " + bag.toString());
        System.out.println("Bag size: " + bag.size());
        System.out.println();

        // Test the contains method for an item not in the bag
        System.out.println("Bag contains 'orange': " + bag.contains("orange"));
        System.out.println();

        // Test the count method for an item not in the bag
        System.out.println("Count of 'banana': " + bag.count("banana"));
        System.out.println();

        System.out.println("------ End of Bag Class Test ---\n");
    }

}
