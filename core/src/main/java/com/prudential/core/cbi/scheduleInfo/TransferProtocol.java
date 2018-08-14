package com.prudential.core.cbi.scheduleInfo;

public class TransferProtocol
{
	private String ip;
	private String portNumber;

    private String filelocation;

    private String protocolType;

    private String userId;

    private String password;

    public String getPortNumber ()
    {
        return portNumber;
    }

    public void setPortNumber (String portNumber)
    {
        this.portNumber = portNumber;
    }

    public String getFilelocation ()
    {
        return filelocation;
    }

    public void setFilelocation (String filelocation)
    {
        this.filelocation = filelocation;
    }

    public String getProtocolType ()
    {
        return protocolType;
    }

    public void setProtocolType (String protocolType)
    {
        this.protocolType = protocolType;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }
    

    public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [portNumber = "+portNumber+", filelocation = "+filelocation+", protocolType = "+protocolType+", userId = "+userId+", password = "+password+"]";
    }
}
