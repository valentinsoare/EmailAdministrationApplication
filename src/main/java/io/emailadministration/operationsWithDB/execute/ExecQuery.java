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
            transaction.commit();

            if (resultList.isEmpty()) {
                return Collections.emptyList();
            }

            return resultList;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return Collections.emptyList();
    }
}
