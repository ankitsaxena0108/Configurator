package com.prudential.core.common.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

import com.prudential.core.common.configuration.CoreConfiguration;

@MappedSuperclass
//@EntityListeners(AuditListener.class)
public abstract class BillingSystemEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @TableGenerator(name = "TABLE_GEN",
            table = CoreConfiguration.TABLE_AUTO_NUMBER,
            pkColumnName = "ID",
            valueColumnName = "VALUE",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    protected Long id;
    
    @Version
    @Column(name = "LAST_MODIFIED")
    private Timestamp lastModified;

    public BillingSystemEntity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BillingSystemEntity other = (BillingSystemEntity) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BillingSystemEntity [id=" + id + "]";
    }
}