package io.emailadministration.operationsWithDB;

public interface DepartmentDataAccessObject<T> {
    T get();
    boolean create(T o);
    boolean update(long id, T o);
    boolean delete();
    boolean checkIfElementExists();
}
