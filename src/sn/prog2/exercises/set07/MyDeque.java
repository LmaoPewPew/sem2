package sn.prog2.exercises.set07;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyDeque<T> implements Iterable<T> {

    private final T[] arrT;
    private int first;
    private int last;

    public MyDeque(int index) {
        arrT = (T[]) new Object[index];
    }

    public boolean isEmpty() {
        boolean output = true;
        for (int i = 0; i < arrT.length; i++) {
            if (arrT[i] != null) {
                output = false;
                break;
            }
        }
        return output;
    }

    public boolean isFull() {
        boolean output = true;
        for (int i = 0; i < arrT.length; i++) {
            if (arrT[i] == null) {
                output = false;
                break;
            }
        }
        return output;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < arrT.length; i++) {
            if (arrT[i] != null) size++;
        }
        return size;
    }

    public int capacity() {
        return arrT.length;
    }

    public T get(int i) {
        return arrT[i];
    }

    public void addFirst(T elem) {

        if (isFull()) {
            first = first < 1 ? arrT.length - 1 : --first;
            last = last == 0 ? arrT.length - 1 : first - 1;
        } else {
            if (first == 0) first = arrT.length - 1;
            else --first;
        }
        arrT[first] = elem;
    }

    public T getFirst() {
        return arrT[first];
    }

    public T getLast() {
        return arrT[last];
    }

    public T removeFirst() {
        T t = arrT[first];
        arrT[first] = null;
        first = first >= arrT.length - 1 ? 0 : first + 1;
        return t;
    }

    public T removeLast() {
        T t = arrT[last];
        arrT[last] = null;
        last = last < 1 ? arrT.length - 1 : --last;
        return t;
    }

    public void addLast(T elem) {
        if (isFull()) {
            last = last >= arrT.length - 1 ? 0 : ++last;
            first = first == arrT.length - 1 ? 0 : last + 1;
        } else {
            if (isEmpty()) last = first = 0;
            else last = last >= arrT.length - 1 ? 0 : ++last;
        }

        arrT[last] = elem;
    }

    @Override
    public String toString() {
        String out = "{ ";
        int start = first;

        for (int i = 0; i < arrT.length; i++) {
            if (arrT[start] != null) out += String.format("%s ", arrT[start]);
            start = ++start % arrT.length;
        }
        return out + "}";
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
