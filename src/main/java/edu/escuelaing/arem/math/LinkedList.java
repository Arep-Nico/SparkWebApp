package edu.escuelaing.arem.math;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
* @author Nicolas Cardenas
* @version: 22/01/2019
*/
public class LinkedList<T> implements List<T>, Iterable<T>, Serializable, Cloneable, Collection<T> {

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1L;
    private Head head;
    private int size;

    /**
    * Constructor de una LinkedList
    */
    public LinkedList() {
        this.head = new Head(null, null);
        this.size = 0;
    }

    /**
     * Agregar un elemento a la lista
     * @param data T value
     * @return boolean
     */
    @Override
    public boolean add(T data) {
        Node node = new Node(data, null);
        
        if (size == 0) {
            head.setFirst(node);
            head.setLast(node);
            size += 1;
            return true;
        } else if (size > 0) {
            Node last = head.getLast();
            last.setNext(node);
            head.setLast(node);
            size += 1;
            return true;
        }
        return false;
    }

    /**
     * Agregar un elemento a la lista
     * 
     * @param element elemento de tipo T a agregar
     * @param index posicion donde de insertaran el elemento
     * 
     */
    @Override
    public void add(int index, T element) {
        Node node = new Node(element, null);
        Node temp = head.getFirst();

        if (index < 0 || index > this.size) {
            throw new Error("out of range");
        } else if (index == 0) {
            node.setNext(temp);
            head.setFirst(node);
        } else {
            for (int i = 0; i < size; i++) {
                Node temp2 = temp.getNext();
                if ( (i+1) == index) {
                    Node dat = new Node(element, temp2);
                    temp.setNext(dat);
                }
                temp = temp2;
            }
        }
        size += 1;
    }

    /**
     * Agregar todos los elementos de la coleccion
     * 
     * @param c coleccion de elementos
     * 
     * @param index posicion donde de insertaran los elementos
     * 
     * @return boolean
     */

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {

        int temp = index;

        for(T e : c ){
            this.add(temp, e);
            temp += 1;
        }
        size += temp;
        return false;
    }

    /**
     * Obtener el elemento de la posicion
     * 
     * @param index posicion del elemento
     * 
     * @return T element 
     */
    @Override
    public T get(int index) {
        int i = 0;
        Node res = head.getFirst();
        while (i != index ) {
            res = res.getNext();
            i ++;
        }
        return res.getData();
    }

    /**
     * Obtener el indice de un objeto
     * 
     * @param o para buscar en la lista
     * 
     * @return index posicion del elemento 
     */
    @Override
    public int indexOf(Object o) {
        int res = -1;
        int i = 0;
        Node temp = head.getFirst();
        while (i < size + 1) {
            if (temp.getData().equals(o)) {
                temp = temp.getNext();
                return i;
            }
            i++;
        }
        return res;
    }


    /**
     * Retorna la ultima posicion del objeto en la lista 
     * @param o elemento a buscar
     * @return last el ultimo elemento de la lista 
     */
    @Override
    public int lastIndexOf(Object o) {
        int res = -1;
        int i = 0;
        Node temp = head.getFirst();
        while (i < size + 1) {
            if (temp.getData().equals(o)) {
                temp = temp.getNext();
                res = i;
            }
            i++;
        }
        return res;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    /**
     * Remueve el elemento de la posicion dada
     * @param index posicion del elemento
     * @return elemeto a eliminar
     */
    @Override
    public T remove(int index) {
        if (0 < index && index < size)
            throw new Error("Out of range");
        int i = 0;
        Node temp = head.getFirst();
        while (i != index -1) {
            temp = temp.getNext();
            i++;
        }
        Node res = temp.getNext();
        temp.setNext(res.getNext());
        size -=1 ;
        return res.getData();
    }

    /**
     * Cambiar el valor de una posicion de la lista
     * @param index posicion de cambio
     * @param element elemento a cambiar
     * @return elemento de la posicion antes del cambio
     */
    @Override
    public T set(int index, T element) {
        Node temp = head.getFirst();
        int i = 0;
        while (i != index ) {
            temp = temp.getNext();
            i++;
        }
        T res = temp.getData();
        temp.setData(element);
        return res;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * Agrega una coleccion de elementos a la lista
     * @param c coleccion de elementos para agregar
     * @return retorna si fue posible agregar los elementos
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean res = true;
        for (T e : c) {
            res &= add(e);
        }
        return res;
    }

    /**
     * Limpia la lista 
     */
    @Override
    public void clear() {
        head.setFirst(null);
        head.setLast(null);
        size = 0;
    }

    /**
     * Retorna true si el elemeto esta en la lista
     * @param o elemento a encontrar
     * @return retorna true si se encuentra el elemento en la lista, de lo contrario retorna false
     */
    @Override
    public boolean contains(Object o) {
        if (indexOf(o) != -1)
            return true;
        return false;
    }

    /**
     * Retorna true si los elemetos estan en la lista
     * 
     * @param c elementos a encontrar
     * @return retorna true si se encuentran los elementos en la lista, de lo contrario
     *         retorna false
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        boolean res = true;
        for (Object object : c) {
            res &= contains(object);
        }
        return res;
    }

    /**
     * Retorna true si esta la lista vacia
     * @return retorna si la lista esta vacia o no.
     */
    @Override
    public boolean isEmpty() {
        return head.getFirst().equals(null);
    }

    /**
     * Retorna un iterador
     * @return Retorna un iterator 
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> res = new Iterator<T>() {
            private Node now = head.getFirst();

            @Override
            public boolean hasNext() {
                if (now != null)
                    return true;
                return false;
            }

            @Override
            public T next() {
                T data = now.getData();
                now = now.getNext();
                return data;
            }
        };
        return res;
    }

    /**
     * Elimina un elemento de la lista
     * @param o elemento a eliminar
     * @return retorna si fue posible eliminar el elemento
     */
    @Override
    public boolean remove(Object o) {
        boolean res = false;
        int i = indexOf(o);
        if (i != -1) {
            res = true;
            remove(i);
            size -= 1;
        }        
        return res;
    }

    /**
     * Eliminar todos los elementos de una coleccion
     * 
     * @param c coleccion de elementos
     * @return retorna si fue posible eliminar los elementos
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean res = false;
        for (Object object : c) {
            res &= remove(object);
        }
        return res;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Retorna el tamaño de la lista
     * @return retorna el tamaño de la lista
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Convierte la lista a un Array
     * @return retorna un Array
     */
    @Override
    public Object[] toArray() {
        Object[] res = new Object[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = get(i);
        }
        return res;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * Node class
     */
    private class Node {

        private T data;
        private Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Retorna el valor de elemento
         * 
         * @return retorna el elemento
         */
        public T getData() {
            return data;
        }

        /**
         * Cambia el valor del elemento
         * @param data elemento para cambiar el anterios
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * Obtener un Nodo
         * @return retorna el nodo vecino
         */
        public Node getNext() {
            return next;
        }

        /**
         * Cambia la referencia del vecino
         * @param next nodo para cambiar la referencia
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }

    /**
     * Head
     */
    private class Head {
        private Node first;
        private Node last;

        /**
         * Constructor del Head
         * @param fisrt el primer nodo
         * @param last el ultimo nodo
         */
        Head(Node fisrt, Node last) {
            this.first = fisrt;
            this.last = last;
        }

        /**
         * Retorna la referencia del primer nodo
         * @return retorna un nodo
         */
        public Node getFirst() {
            return first;
        }

        /**
         * Cambia la referencia del primer nodo
         * @param first
         */
        public void setFirst(Node first) {
            this.first = first;
        }

        /**
         * Obtiene la referencia del ultimo nodo
         * @return retorna un nodo
         */
        public Node getLast() {
            return last;
        }

        /**
         * Cambia la referencia del ultimo nodo
         * @param last un nodo
         */
        public void setLast(Node last) {
            this.last = last;
        }
    }
}