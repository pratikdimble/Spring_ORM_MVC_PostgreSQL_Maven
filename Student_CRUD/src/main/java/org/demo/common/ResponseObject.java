package org.demo.common;

import java.util.List;

public class ResponseObject<T> 
{
    private String status;
    private String error;
    private String message;
    private T object;
    public  List<T> list;
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}
	public String getError() 
	{
		return error;
	}
	public void setError(String error)
	{
		this.error = error;
	}
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public T getObject()
	{
		return object;
	}
	public void setObject(T object) 
	{
		this.object = object;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
