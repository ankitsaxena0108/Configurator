package com.prudential.core.common.locale;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.prudential.core.common.model.BillingSystemEntity;

/**
 * Created by rawatv on 1/18/2017.
 */
@Entity
@Table(name = "LOC_LOCALIZED_ENTITY")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class LocalizedEntity extends BillingSystemEntity {

    private static final long serialVersionUID = 1L;

    private transient Map<String, String> localizedColumns = new HashMap<>();

    public LocalizedEntity() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Localized l = field.getAnnotation(Localized.class);
            if (l != null) {
                localizedColumns.put(field.getName(), null);
            }
        }
    }

    public String getLocalizedValue(String fieldName) {
        return localizedColumns.get(fieldName);
    }

    

    public Map<String, String> getLocalizedColumns() {
        return localizedColumns;
    }

    public void setLocalizedColumns(Map<String, String> localizedColumns) {
        this.localizedColumns = localizedColumns;
    }
}
