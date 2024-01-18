package io.emailadministration.operationsWithDB.execute;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.StoredProcedureQuery;

import java.util.Collections;
import java.util.List;

public class ExecQuery {
    private ExecQuery() {}

    public static <T> boolean ofInsert(EntityManager em, T element) {
        EntityTransaction transaction = null;

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            em.persist(element);

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return false;
    }

    public static <T> List<T> ofGet(EntityManager em, StoredProcedureQuery query, Class<T> typeOf) {
        EntityTransaction transaction = null;

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            List<T> resultList = query.getResultList();

            if (resultList.isEmpty()) {
                transaction.rollback();
                return Collections.emptyList();
            }

            transaction.commit();
            return resultList;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return Collections.emptyList();
    }

    public static <T> boolean ofDelete(EntityManager em, StoredProcedureQuery query, Class<T> typeOf) {
        EntityTransaction transaction = null;

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            boolean execute = query.execute();

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return false;
    }
}
