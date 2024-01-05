package io.emailadministration.operationsWithDB;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface GeneralDataAccessObject<T> {
    T get(long id);
    Set<T> getAll();
    Set<T> getAll(long startId, long endId);

    boolean create(T t);
    List<Long> createAll(Collection<? extends T> c);

    boolean update(long id, T t);
    List<Long> updateAll(Collection<? extends T> c);

    boolean delete(long id);
    List<Long> deleteAll(Collection<Long> c);

    boolean checkIfElementExists(long id);
    boolean checkIfElementExists(T t);
}
