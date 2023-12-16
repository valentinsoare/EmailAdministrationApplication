package io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}
