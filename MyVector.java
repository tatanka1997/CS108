import java.util.Arrays;

public class MyVector<E> extends MyAbstractList<E> implements MyList<E> {

    // Instance variables
    private E array[];
    private int increment;

    /**
     * No-arg constructor
     */
    @SuppressWarnings("unchecked")
    public MyVector() {
        array = (E[]) new Object[10];
        size = 0;
        increment = 0;
    }

    /**
     * Parameterized constructor
     *
     * @param initCapacity
     * - initial capacity of the vector
     */
    @SuppressWarnings("unchecked")
    public MyVector(int initCapacity) {
        array = (E[]) new Object[initCapacity];
        size = 0;
        increment = 0;
    }

    /**
     * Parameterized constructor
     *
     * @param initCapacity
     * - initial capacity of the vector
     * @param capIncrement
     * - capacity increment
     */
    @SuppressWarnings("unchecked")
    public MyVector(int initCapacity, int capIncrement) {
        array = (E[]) new Object[initCapacity];
        size = 0;
        increment = capIncrement;
    }

    /**
     * This method returns the string "Program 6, FullNameHere".
     *
     * @return String
     */
   
    public int getCapacity() {
        return array.length;
    }

    /**
     * This method returns the capacity increment of the vector
     *
     * @return int
     */
    public int getIncrement() {
        return increment;
    }

    /**
     * Appends the specified element to the end of this list
     *
     * @param data
     * - element to be inserted
     * @return boolean
     */
    @Override
    public boolean add(E data) {
        return add(size, data);
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements by adding one to their indices.
     *
     * @param index
     * - index at which the specified element is to be inserted
     * @param data
     * - element to be inserted
     * @return boolean
     * @throws IndexOutOfBoundsException
     * - if the index is out of range (index < 0 || index > size())
     */
    @Override
    public boolean add(int index, E data) {
        // Check if index is valid
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index out of bounds: " + index + ", size: " + size);

        // Get capacity
        int capacity = getCapacity();

        // Check if array requires expanding
        if (size >= capacity) {
            // Create a new array using capacity increment, if it is set then
            // the new capacity will be (array.length + increment). If capacity
            // increment is not set then the new capacity will be double the
            // current capacity

            // Check whether capacity increment is set
            if (increment == 0)
                array = Arrays.copyOf(array, array.length * 2);
            else
                array = Arrays.copyOf(array, array.length + increment);
        }

        // Shift the elements at index and any subsequent elements by 1
        // position
        for (int i = size - 1; i >= index; i--)
            array[i + 1] = array[i];

        // Set data at index
        array[index] = data;

        // Increment size by 1
        size += 1;

        return true;
    }

    /**
     * Removes all of the elements from this list
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        // Get capacity of the current array
        int capacity = getCapacity();

        // To clear vector, initialize array using the new keyword
        array = (E[]) new Object[capacity];

        // Set size to zero
        size = 0;
    }

    /**
     * Returns true if this list contains the specified element
     *
     * @param data
     * - element to be inserted
     * @return boolean
     */
    @Override
    public boolean contains(E data) {
        // Iterate array to find data
        for (int i = 0; i < size; i++) {
            // Check if element at ith index is same as data
            if (array[i].equals(data))
                return true;
        }

        // Default return
        // If data is not found in the above iteration then return false
        return false;
    }

    /**
     * Returns the element at the specified position in this list
     *
     * @param index
     * - index of element to return
     * @return E
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1)
                result.append(", ");
        }

        return result.toString() + "]";
    }
    @Override
    public E get(int index) {
        return array[index];
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list Return, or -1 if this list does not contain the element
     *
     * @param data
     * - element to be inserted
     * @return int
     */
    @Override
    public int indexOf(E data) {
        // Iterate array to find the first occurrence of data
        for (int i = 0; i < size; i++) {
            // Check if element at ith index is same as data
            if (array[i].equals(data))
                return i;
        }

        // Default return
        // If data is not found in the above iteration then return -1
        return -1;
    }

    /**
     * Returns the index of the last matching of the element in this list Return
     * -1 if no match
     *
     * @param data
     * - element to be inserted
     * @return int
     */
    @Override
    public int lastIndexOf(E data) {
        // Iterate array to find the last occurrence of data
        for (int i = size - 1; i >= 0; i--) {
            // Check if element at ith index is same as data
            if (array[i].equals(data))
                return i;
        }

        // Default return
        // If data is not found in the above iteration then return -1
        return -1;
    }

    /**
     * Returns true if this list contains no elements
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements by subtracting one from their indices.
     *
     * @param index
     * - index of the element to be removed
     * @return E - the element that was removed from the list
     * IndexOutOfBoundsException - if the index is out of range (index <
     * 0 || index >= size())
     */
    @Override
    public E remove(int index) {
        // Check if index is valid
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds: " + index + ", size: " + size);

        // Get data at index
        E data = array[index];

        // Shift any subsequent elements after index by 1 position
        for (int i = index; i < size - 1; i++)
            array[i] = array[i + 1];

        // Set data at (size)th index as null
        array[size] = null;

        // Decrement size by 1
        size -= 1;

        // Return data removed
        return data;
    }

    /**
     * Trims the capacity of this MyVector instance to be the list's current
     * size. An application can use this operation to minimize the storage of a
     * MyVector instance.
     */
    @Override
    public void trimToSize() {
        // Check if size is less than capacity
        if (size < getCapacity()) {
            // Create a new array using the current size
            array = Arrays.copyOf(array, size);
        }
    }

    /**
     * Returns the number of elements in this list
     *
     * @return int
     */
    @Override
    public int size() {
        return super.size();
    }
}
