package com.prudential.core.cbi.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Auditsummary {
	
	 private String id;

	    private String startDateTime;

	    private String status;

	    private String endDateDateTime;

	    private String paymentType;

	    private String fileDirection;

	    private String fileName;

	    private String successCount;

	    private String failedCount;

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    public String getStartDateTime ()
	    {
	        return startDateTime;
	    }

	    public void setStartDateTime (String startDateTime)
	    {
	        this.startDateTime = startDateTime;
	    }

	    public String getStatus ()
	    {
	        return status;
	    }

	    public void setStatus (String status)
	    {
	        this.status = status;
	    }

	    public String getEndDateDateTime ()
	    {
	        return endDateDateTime;
	    }

	    public void setEndDateDateTime (String endDateDateTime)
	    {
	        this.endDateDateTime = endDateDateTime;
	    }

	    public String getPaymentType ()
	    {
	        return paymentType;
	    }

	    public void setPaymentType (String paymentType)
	    {
	        this.paymentType = paymentType;
	    }

	    public String getFileDirection ()
	    {
	        return fileDirection;
	    }

	    public void setFileDirection (String fileDirection)
	    {
	        this.fileDirection = fileDirection;
	    }

	    public String getFileName ()
	    {
	        return fileName;
	    }

	    public void setFileName (String fileName)
	    {
	        this.fileName = fileName;
	    }

	    public String getSuccessCount ()
	    {
	        return successCount;
	    }

	    public void setSuccessCount (String successCount)
	    {
	        this.successCount = successCount;
	    }

	    public String getFailedCount ()
	    {
	        return failedCount;
	    }

	    public void setFailedCount (String failedCount)
	    {
	        this.failedCount = failedCount;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [id = "+id+", startDateTime = "+startDateTime+", status = "+status+", endDateDateTime = "+endDateDateTime+", paymentType = "+paymentType+", fileDirection = "+fileDirection+", fileName = "+fileName+", successCount = "+successCount+", failedCount = "+failedCount+"]";
	    }

}
