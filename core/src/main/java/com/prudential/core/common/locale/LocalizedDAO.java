package com.prudential.core.common.locale;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.prudential.core.common.dao.AbstractDAO;

/**
 * Created by rawatv on 1/18/2017.
 */
@Service
public class LocalizedDAO extends AbstractDAO {
	private static final Logger logger = LoggerFactory.getLogger(LocalizedDAO.class);

	public <T extends LocalizedEntity> List<T> findAll(Class<T> clazz, Locale locale) {
		String entityName = null;
		entityName = extractClassName(clazz);

		List<String> localizedFields = localizedFields(clazz);

		StringBuilder query = new StringBuilder();
		query.append("SELECT e");

		int i = 1;
		for (i = 0; i < localizedFields.size(); i++) {
			query.append(", lv").append(i + 1).append(".").append("localizedValue");
		}

		query.append(" FROM ").append(entityName).append(" e");

		for (i = 0; i < localizedFields.size(); i++) {
			query.append(", LocalizedValue lv").append(i + 1);
		}

		query.append(", Locale l");

		query.append(" WHERE ");
		query.append(" l.language = '").append(locale.getLanguage()).append("'");
		query.append(" AND l.country = '").append(locale.getCountry()).append("'");

		for (i = 0; i < localizedFields.size(); i++) {
			query.append(" AND lv").append(i + 1).append(".locale.localeId").append(" = l.localeId");
		}

		i = 1;
		for (String localizedField : localizedFields) {
			if (localizedField.equalsIgnoreCase("TYPE")) {
				query.append(" AND lv").append(i).append(".field = '").append("TYPE'");
			} else {
				query.append(" AND lv").append(i).append(".field = '").append(localizedField).append("'");
			}

			query.append(" AND lv").append(i).append(".value = e.").append(localizedField);
			i++;
		}

		for (i = 0; i < localizedFields.size(); i++) {
			query.append(" AND e.id = lv").append(i + 1).append(".localizedEntity.id");
		}

		logger.debug(query.toString());
		List<Object[]> queryResults = em.createQuery(query.toString(), Object[].class).getResultList();
		List<T> results = new ArrayList<>();
		for (Object[] values : queryResults) {
			T entity = clazz.cast(values[0]);
			for (int j = 1; j < values.length; j++) {
				String value = (String) values[j];
				String fieldName = localizedFields.get(j - 1);
				entity.getLocalizedColumns().put(fieldName, value);
			}
			results.add(entity);
		}
		return results;
	}

	private <T extends LocalizedEntity> List<String> localizedFields(Class<T> clazz) {
		List<String> localizedFields = new ArrayList<>();

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			Localized l = field.getAnnotation(Localized.class);
			if (l != null) {
				localizedFields.add(field.getName());
			}
		}

		return localizedFields;
	}
}
