package Asignacion4.implementaciones;

import Asignacion4.excepciones.ListException;
import Asignacion4.interfaces.IList;
import java.util.Iterator;

public class ArrayList<T> implements IList<T>, Iterable<T> {

    protected int nElementos;
    private final int tamLista;
    private final T lista[];

    public ArrayList(int tmLista, T[] lista) {
        this.tamLista = tmLista;
        this.lista = lista;
    }

    private class ListIterator implements Iterator<T> {
        private int actual = 0;

        @Override
        public boolean hasNext(){
            return actual < nElementos;
        }

        @Override
        public T next(){
            return (T)lista[actual++];
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList(Class<T> tipoDato, int tamLista){
        this.tamLista = tamLista;
        nElementos = 0;
        lista = (T[]) java.lang.reflect.Array.newInstance(tipoDato, tamLista);
    }


    @Override
    public void append(T o) throws ListException {
        if (nElementos >= tamLista)
                throw new ListException("Lista llena");

        lista[nElementos] = o;
        nElementos++;
    }

    @Override
    public void insert(T o, int i) throws ListException {
        if (nElementos >= tamLista)
            throw new ListException("Lista llena");

        if (i < 0 || i >= nElementos)
            throw new ListException("Indice fuera del limite");

        for (int j = nElementos; j > i; j--)
            lista[j] = lista[j-1];

        lista[i] = o;
        nElementos++;
    }

    @Override
    public T get(int i) throws ListException {
        if (empty())
            throw new ListException("Lista vacia");
        if (i < 0 || i >= nElementos)
            throw new ListException("Indice fuera del limite");

        return lista[i];
    }

    @Override
    public T remove(int i) throws ListException {
        T o = get(i);
        for (int j = i; j < nElementos -1; j++)
            lista[j] = lista[j+1];

        nElementos--;
        return o;
    }

    @Override
    public boolean empty() throws ListException {
        return nElementos == 0;
    }

    @Override
    public int size() {
        return nElementos;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < nElementos; i++) {
            s += lista[i];
            if (i < nElementos - 1) s += ", ";
        }
        s += "]";
        return s;
    }

    @Override
    public int indexOf(T o) {
        for (int i = 0; i < nElementos; i++) {
            if (lista[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < nElementos; i++) {
            lista[i] = null;
        }
        nElementos = 0;
    }

    @Override
    public boolean remove(T o) {
        int index = indexOf(o);

        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }
}
