import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MergingIterator implements Iterator<Integer> {
    private final List<Iterator<Integer>> iterators;
    private int currentIndex;

    public MergingIterator(List<Iterator<Integer>> iterators) {
        this.iterators = iterators;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < iterators.size()) {
            if (iterators.get(currentIndex).hasNext()) {
                return true;
            }
            currentIndex++; // move to the next iterator
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iterators.get(currentIndex).next();
    }
}
