package com.prudential.core.cbi.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class AuditObject {

	 private String category;

	    private String fromDate;

	    private String status;

	    private String paymentType;

	    private String name;

	    private String fileDirection;

	    private Auditsummary[] auditsummary;

	    private String toDate;

	    public String getCategory ()
	    {
	        return category;
	    }

	    public void setCategory (String category)
	    {
	        this.category = category;
	    }

	    public String getFromDate ()
	    {
	        return fromDate;
	    }

	    public void setFromDate (String fromDate)
	    {
	        this.fromDate = fromDate;
	    }

	    public String getStatus ()
	    {
	        return status;
	    }

	    public void setStatus (String status)
	    {
	        this.status = status;
	    }

	    public String getPaymentType ()
	    {
	        return paymentType;
	    }

	    public void setPaymentType (String paymentType)
	    {
	        this.paymentType = paymentType;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public String getFileDirection ()
	    {
	        return fileDirection;
	    }

	    public void setFileDirection (String fileDirection)
	    {
	        this.fileDirection = fileDirection;
	    }

	    public Auditsummary[] getAuditsummary ()
	    {
	        return auditsummary;
	    }

	    public void setAuditsummary (Auditsummary[] auditsummary)
	    {
	        this.auditsummary = auditsummary;
	    }

	    public String getToDate ()
	    {
	        return toDate;
	    }

	    public void setToDate (String toDate)
	    {
	        this.toDate = toDate;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [category = "+category+", fromDate = "+fromDate+", status = "+status+", paymentType = "+paymentType+", name = "+name+", fileDirection = "+fileDirection+", auditsummary = "+auditsummary+", toDate = "+toDate+"]";
	    }
	
}
