package Asignacion4.interfaces;

import Asignacion4.excepciones.ListException;

import java.util.Iterator;

public interface IList<T> {
    public void append(T o) throws ListException;
    public void insert(T o, int i) throws ListException;
    public T get(int i) throws ListException;
    public T remove(int i) throws ListException;
    public boolean empty() throws ListException;
    public int size();
    public Iterator<T> iterator();

    public int indexOf(T o);

    public void clear();

    public boolean remove(T o);

}
