package com.prudential.core.common.locale;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name="COR_LOCALE")
public class Locale implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "LOCALE_ID")
    private long localeId;

    @Column
    private String language;

    @Column
    private String country;

    @Version
    @Column(name="LAST_MODIFIED")
    private Timestamp lastModified;
    
    public Locale() {
        super();
    }

    public Locale(java.util.Locale locale) {
        this.language = locale.getLanguage();
        this.country = locale.getCountry();
    }

    public long getLocaleId() {
        return localeId;
    }

    public void setLocaleId(long localeId) {
        this.localeId = localeId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    @Override
    public String toString() {
        return "Locale [language=" + language + ", country=" + country + "]";
    }
}
