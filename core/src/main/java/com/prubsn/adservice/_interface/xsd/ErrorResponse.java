package com.prubsn.adservice._interface.xsd;

public class ErrorResponse {

	  private java.lang.String resCode;

	    private java.lang.String resString;

		public java.lang.String getResCode() {
			return resCode;
		}

		public void setResCode(java.lang.String resCode) {
			this.resCode = resCode;
		}

		public java.lang.String getResString() {
			return resString;
		}

		public void setResString(java.lang.String resString) {
			this.resString = resString;
		}

		@Override
		public String toString() {
			return "ErrorResponse [resCode=" + resCode + ", resString=" + resString + "]";
		}
	    
	    
		
		
}
