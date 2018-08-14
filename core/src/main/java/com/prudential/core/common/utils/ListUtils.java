package com.prudential.core.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prudential.core.common.AbstractDTO;
import com.prudential.core.common.Transferrable;
import com.prudential.core.common.model.BillingSystemEntity;

public class ListUtils {
	private static final Logger LOG = LoggerFactory.getLogger(ListUtils.class);
	
	private ListUtils() {}

	public static <T extends AbstractDTO, U extends BillingSystemEntity & Transferrable<T>> void update(
			List<T> dtoCollection, List<U> entityCollection, Class<U> entityClazz) {
		
		if (dtoCollection == null) {
			entityCollection = null;
		}
		else {
			if (entityCollection == null) {
				entityCollection = new ArrayList<>();
			}
			
			for (T dto : dtoCollection) {
				U entity = null;
				if ((entity = contains(entityCollection, dto)) != null) {
					entity.update(dto);
				}
				else {
					try {
						entity = entityClazz.newInstance();
						entity.populate(dto);
						entityCollection.add(entity);
					} catch (InstantiationException | IllegalAccessException e) {
						LOG.warn("Error populating Entity {} from DTO {}", entity, dto, e);
					}
				}
			}
			
			for (Iterator<U> iterator = entityCollection.iterator(); iterator.hasNext();) {
				U entity = iterator.next();
				if (entity.getId() == null) {
					continue;
				}
				else if (!contains(dtoCollection, entity)) {
					iterator.remove();
				}
			}
		}
	}
	
	public static <T extends ListUpdatables> void updateListContents(List<T> master, List<? extends Object> updatedData, Class<T> clazz) {
		List<Integer> indexEntries = new ArrayList<>();
		
		if (updatedData == null) {
			master = null;
		}
		else {
			if (master == null) {
				master = new ArrayList<>();
			}
			
			for (Object updatedObject : updatedData) {
				T found = null; 
				int index = -1;
				
				if ((index = indexOf(master, updatedObject)) != -1) {
					found = master.get(index);
					found.update(updatedObject);
					indexEntries.add(index);
				}
				else {
					try {
						int lastIndex = master.size();
						found = clazz.newInstance();
						found.update(updatedObject);
						master.add(lastIndex, found);
						indexEntries.add(lastIndex);
					} catch (InstantiationException | IllegalAccessException e) {
						LOG.warn("Error populating {} from {}", found, updatedObject, e);
					}
				}
			}
			
			for (int i = master.size() - 1; i >= 0; i--) {
				if (!indexEntries.contains(i)) {
					master.remove(i);
				}
			}
		}
	}
	
	private static <T extends ListUpdatables> int indexOf(List<T> list, Object checkObject) {
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isSame(checkObject)) {
				return i;
			}
		}
		
		return -1;
	}

	private  static <T extends AbstractDTO, U extends BillingSystemEntity & Transferrable<T>> U contains(
			Collection<U> entityCollection, T dto) {
		
		U found = null;
		
		for (U entity : entityCollection) {
			if (dto.getId() != null && entity.getId().equals(dto.getId())) {
				found = entity; 
				break;
			}
		}
		return found;
	}

	private static <T extends AbstractDTO, U extends BillingSystemEntity & Transferrable<T>> boolean contains(
			Collection<T> dtoCollection, U entity) {
		
		boolean found = false;
		
		for (T dto : dtoCollection) {
			if (dto.getId() != null && dto.getId().equals(entity.getId())) {
				found = true;
				break;
			}
		}
		
		return found;
	}
}
