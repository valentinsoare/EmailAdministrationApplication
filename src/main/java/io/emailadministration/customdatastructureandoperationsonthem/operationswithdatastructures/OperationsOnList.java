package io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures;


import java.lang.reflect.Field;
import java.util.*;

public class OperationsOnList {

    private OperationsOnList() {}

    /**
     * Retrieve all fields from a class even if there are inherited fields on a deep class hierarchy.
     */
    public static <T> List<Field> getAllFields(List<Field> result, Class<T> givenClass) {
        if (givenClass == null) {
            return Collections.emptyList();
        }

        result.addAll(Arrays.asList(givenClass.getDeclaredFields()));

        if (givenClass.getSuperclass() != null) {
            getAllFields(result, givenClass.getSuperclass());
        }

        return result;
    }

    public static <T extends Comparable<T>> int binarySearch(T searchElement, List<T> givenList) {
        int start = 0, end = givenList.size();

        while (start < end) {
            int midPoint = (start + end) / 2;

            if (givenList.get(midPoint).equals(searchElement)) {
                return midPoint;
            } else if (searchElement.compareTo(givenList.get(midPoint)) > 0) {
                end = midPoint;
            } else {
                start = midPoint + 1;
            }
        }

        return -1;
    }
}
