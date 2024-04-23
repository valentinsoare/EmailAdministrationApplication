package io.emailadministration.customdatastructureandoperationsonthem.datastructures;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
public class GenericComparator<T extends Comparable<T>> implements Comparator<T> {

    private boolean isReversed;

    public GenericComparator() {
        this.isReversed = false;
    }

    public GenericComparator(boolean isReversed) {
        this.isReversed = isReversed;
    }

    @Override
    public int compare(T o1, T o2) {
        if (isReversed) {
            int result = o1.compareTo(o2);

            if (result != 0) {
                return -result;
            }
        }

        return o1.compareTo(o2);
    }
}
