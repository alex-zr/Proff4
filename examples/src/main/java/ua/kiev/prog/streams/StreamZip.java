package ua.kiev.prog.streams;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class StreamZip {

    public static void main(String[] args) {
        Stream res = zip(Stream.of(1,2,3), Stream.of(5,6,7,8));
        res.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();
        Iterator<T> iteratorRes = new Iterator<T>() {
            private boolean first = false;
            @Override
            public boolean hasNext() {
                return iteratorFirst.hasNext() && iteratorSecond.hasNext();
            }

            @Override
            public T next() {
                first = !first;
                if (first) {
                    return iteratorFirst.next();
                } else {
                    return iteratorSecond.next();
                }
            }
        };
        Iterable<T> iterable = () -> iteratorRes;
        return StreamSupport.stream(iterable.spliterator(), first.isParallel() || second.isParallel());
    }

}
