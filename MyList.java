public interface MyList<E> {

    
    public boolean add(E data);


    public boolean add(int index, E data);


    public void clear();


    public boolean contains(E data);


    public E get(int index);


    public int indexOf(E data);


    public int lastIndexOf(E data);


    public boolean isEmpty();


    public E remove(int index);


    public void trimToSize();


    public int size();

}