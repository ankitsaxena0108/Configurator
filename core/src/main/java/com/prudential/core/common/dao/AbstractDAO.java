package com.prudential.core.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.prudential.core.common.service.DataAccessException;


public class AbstractDAO {
    @PersistenceContext
    protected EntityManager em;

    protected <T> String extractClassName(Class<T> entityClazz) {
        String entityName;
        try {
            entityName = entityClazz.newInstance().getClass().getSimpleName();
        } catch (Exception e) {
            throw new DataAccessException("Failed to find Entity", e);
        }
        return entityName;
    }
}
