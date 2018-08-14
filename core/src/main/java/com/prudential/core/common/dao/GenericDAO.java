package com.prudential.core.common.dao;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.util.ReflectionUtils;

import com.prudential.core.common.model.BillingSystemEntity;

public abstract class GenericDAO extends AbstractDAO {
    private static final Logger logger = LoggerFactory.getLogger(GenericDAO.class);

    protected GenericDAO() {
        super();
    }

    public final <T> void create(T entity) {
        em.persist(entity);
    }

    public void flush()
    {
    	em.flush();
    }
    
    public final <T extends BillingSystemEntity> void createOrUpdate(T entity) {
        if (entity.getId() == null) {
            em.persist(entity);
        }
        else {
            em.merge(entity);
        }
    }
    
    public <T> T findOrCreate(Class<T> entityClass, Object primaryKey) {
        T entity = em.find(entityClass, primaryKey);
        if ( entity != null ) {
            return entity;
        } else {
            try {
                entity = entityClass.newInstance();
                return entity;
            } catch ( Exception e ) {
                throw new RuntimeException(e);
            }
        }
    }

    public final <T> void update(T entity) {
        em.merge(entity);
    }

    public final <T> void delete(T entity) {
        em.remove(entity);
    }
    
    protected <T> List<T> findAll(Class<T> clazz) {
        logger.debug("Finding all {}", extractClassName(clazz));
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.select(root);
        
        TypedQuery<T> q = em.createQuery(cq);
        List<T> results = q.getResultList();

        logger.debug("Found {} entities: {}", results.size(), results);
        return results;
    }
    
    public <T> T findByID(Class<T> entityClass, Object primaryKey) {
         T entity = em.find(entityClass, primaryKey);
         
         return entity;
    }
    
    public void detatch(Object entity)
    {
    	em.detach(entity);
    	
    }
    
    protected <T> T findUnique(Class<T> entityClazz, String param, Object value) {
        logger.debug("Finding unique {}", extractClassName(entityClazz));
        
        String entityName = extractClassName(entityClazz);
        
        StringBuilder query = new StringBuilder();
        query.append("SELECT e ");
        query.append("FROM ").append(entityName).append(" e ");
        query.append("WHERE ");
        
        List<T> results = null;
        if (value != null) {
            query.append("e.").append(param).append(" = :").append(param);
            results = em.createQuery(query.toString(), entityClazz).setParameter(param, value).setMaxResults(10).getResultList();
        }
        else {
            query.append("e.").append(param).append(" is null");
            results = em.createQuery(query.toString(), entityClazz).setMaxResults(10).getResultList();
        }

        logger.debug("Found {} entities: {}", results.size(), results);
        
        if (results.size() != 1) {
            throw new BASDataException("1000", "Found ["+results.size()+"] entities, UNIQUE result expected for ["+query.toString()+"]");
        }
        
        return results.get(0);
    }
    
    @SuppressWarnings("unchecked")
    public <T> List<T> findBy(Class<T> entityClazz, String param, Object value) {
        String entityName = null;
        entityName = extractClassName(entityClazz);

        StringBuilder query = new StringBuilder();
        query.append("SELECT e ");
        query.append("FROM ").append(entityName).append(" e ");
        query.append("WHERE ");
        if (value != null) {
            query.append("e.").append(param).append(" = :").append(param);
            return em.createQuery(query.toString()).setParameter(param, value).setMaxResults(10).getResultList();
        }
        else {
            query.append("e.").append(param).append(" is null");
            return em.createQuery(query.toString()).setMaxResults(10).getResultList();
        }
    }
    
    @SuppressWarnings("unchecked")
    protected <T> List<T> findLike(Class<T> entityClazz, String param, Object value) {
        String entityName = null;
        entityName = extractClassName(entityClazz);

        StringBuilder query = new StringBuilder();
        query.append("SELECT e ");
        query.append("FROM ").append(entityName).append(" e ");
        query.append("WHERE ");
        
        query.append("UPPER(e.").append(param).append(") like UPPER(:").append(param).append(")");

        if (value instanceof String) {
            value = "%" + value.toString() + "%";
        }
        return em.createQuery(query.toString()).setParameter(param, value).setMaxResults(10).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    protected <T> List<T> findLike(Class<T> entityClazz, Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return findAll(entityClazz);
        }
        
        String entityName = null;
        entityName = extractClassName(entityClazz);

        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT e ");
        queryString.append("FROM ").append(entityName).append(" e ");
        queryString.append("WHERE ");
        
        addAdditionalParamsInFindLikeQuery(params);
        
        for (Iterator<Entry<String, Object>> itr = params.entrySet().iterator(); itr.hasNext(); ) {
            Entry<String, Object> entry = itr.next();
            String param = entry.getKey();
            String key = escapeKey(entry.getKey());
            Object value = entry.getValue();
            
            if (value == null) {
                queryString.append("e.").append(param).append(" is null");
                itr.remove();
            }
            else if (value instanceof String) {
                value = "%" + value.toString() + "%";
                entry.setValue(value);
                queryString.append("UPPER(e.").append(param).append(") like UPPER(:").append(key).append(")");
            }
            else {
                queryString.append("e.").append(param).append(" like :").append(param);
            }
            
            if (itr.hasNext()) {
                queryString.append(" AND ");
            }
            
        }
        
        Query query = em.createQuery(queryString.toString()); 
        for (Entry<String, Object> entry : params.entrySet()) {
            String key = escapeKey(entry.getKey());
            query.setParameter(key, entry.getValue());
        }
        
        return query.setMaxResults(10).getResultList();
    }
    
    protected final String escapeKey(String key) {
        if (key.contains(".")) {
            String first = key.substring(0, key.indexOf("."));
            String last = key.substring(key.indexOf(".") + 1);
            key = first + last.substring(0, 1).toUpperCase() + last.substring(1);
        }
        
        return key;
    }
    
    public void copySimpleProperties(Object source, Object target) {
        List<Field> fields = getAllFields(target);
        List<String> skipFields = new ArrayList<>();
        for (Field field : fields) {
            if (Collection.class.isAssignableFrom(field.getType())) {
                skipFields.add(field.getName());
            }
        }
        
        BeanUtils.copyProperties(source, target, skipFields.toArray(new String[skipFields.size()]));
    }
    
    @SuppressWarnings("rawtypes")
    public void copyObjectProperties(Object source, Object target, Class ... objectProperties) {
        List<Field> fields = getAllFields(target);
        List<Class> objectPropertyClasses = Arrays.asList(objectProperties);
        for (Field field : fields) {
            if (objectPropertyClasses.contains(field.getType())) {
                try {
                    Object propertyTarget = field.getType().newInstance();
                    TargetField sourceField = getField(field.getName(), source);
                    if (sourceField != null) {
                        if (sourceField.value != null) {
                            copySimpleProperties(sourceField.value, propertyTarget);
                            ReflectionUtils.makeAccessible(field);
                            ReflectionUtils.setField(field, target, propertyTarget);
                        }
                    }
                } catch (BeansException | InstantiationException | IllegalAccessException | NoSuchFieldException
                        | SecurityException | IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void copyListProperties(Object source, Object target, String property, Class listType) {
        try {
            TargetField targetField = getField(property, source);
            
            if (Collection.class.isAssignableFrom(targetField.field.getType())) {
                Collection sourceList = Collection.class.cast(targetField.value);
                List targetList = new ArrayList<>();
                for (Object sourceObject : sourceList) {
                    Object targetObject = listType.newInstance();
                    copySimpleProperties(sourceObject, targetObject);
                    targetList.add(targetObject);
                }
                
                targetField = getField(property, target);
                ReflectionUtils.makeAccessible(targetField.field);
                targetField.field.set(target, targetList);
            }
        } catch (IllegalArgumentException | IllegalAccessException | InstantiationException | NoSuchFieldException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    protected void addAdditionalParamsInFindLikeQuery(Map<String, Object> params) {
        // empty implementation
    }
    
    protected List<Field> getAllFields(Object value) {
        List<Field> fields = new ArrayList<>();
        
        Class<?> current = value.getClass();
        while(current.getSuperclass()!=null){
            try {
                Field[] declaredFields = current.getDeclaredFields();
                fields.addAll(Arrays.asList(declaredFields));
                current = current.getSuperclass();
            } catch (Exception e) {
                // ignore
            }
        }
        
        return fields;
    } 
    
    protected TargetField getField(String fieldName, Object source) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = null;
        Object value = source;
        
        if (fieldName.contains(".")) {
            String[] childFieldNames = fieldName.split("\\.");
            
            for (int i = 0; i< childFieldNames.length; i++) {
                String childFieldName = childFieldNames[i];
                Class<?> current = value.getClass();
                field = getDeclaredField(childFieldName, current);
                
                if (field == null) {
                    throw new NoSuchFieldException(childFieldName);
                }
                
                ReflectionUtils.makeAccessible(field);
                if (i < (childFieldNames.length - 1)) {
                    value = field.get(value);
                } 
                if (value == null) {
                    break;
                }
            }
        } else {
            field = getDeclaredField(fieldName, value.getClass());
            ReflectionUtils.makeAccessible(field);
            value = field.get(source);
        }
        
        return new TargetField(field, value);
    }
    
    
    
    protected Field getDeclaredField(String fieldName, Class<?> current) {
        Field field = null;
        
        while(current.getSuperclass()!=null){ // we don't want to process Object.class
            try {
                field = current.getDeclaredField(fieldName);
            } catch (Exception e) {
                // ignore
            }
            
            if (field != null) {
                break;
            }
            current = current.getSuperclass();
        }
        
        return field;
    }
    
    protected Timestamp endOfDay(Timestamp date) {
        Calendar cal = Calendar.getInstance();    
        cal.setTimeInMillis(date.getTime());
        cal.set(Calendar.HOUR_OF_DAY, 23); //set hour to last hour
        cal.set(Calendar.MINUTE, 59); //set minutes to last minute
        cal.set(Calendar.SECOND, 59); //set seconds to last second
        cal.set(Calendar.MILLISECOND, 999); //set milliseconds to last millisecond
        return new Timestamp(cal.getTimeInMillis());
    }
    
    
    protected Timestamp startOfDay(Timestamp date) {
        Calendar cal = Calendar.getInstance();    
        cal.setTimeInMillis(date.getTime());
        cal.set(Calendar.HOUR_OF_DAY, 00); //set hour to last hour
        cal.set(Calendar.MINUTE, 01); //set minutes to last minute
        cal.set(Calendar.SECOND, 00); //set seconds to last second
        cal.set(Calendar.MILLISECOND, 000); //set milliseconds to last millisecond
        return new Timestamp(cal.getTimeInMillis());
    }

    public class TargetField {
        private Field field;
        private Object value;
        
        TargetField(Field field, Object value) {
            super();
            this.field = field;
            this.value = value;
        }

		public Field getField() {
			return field;
		}

		public Object getValue() {
			return value;
		}
    }
}