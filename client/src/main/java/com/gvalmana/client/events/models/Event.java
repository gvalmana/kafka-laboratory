package com.gvalmana.client.events.models;

import java.util.Date;


abstract public class Event<T> {

	private String id;
	private Date date;
	private EventTypes type;
	private T data;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public EventTypes getType() {
		return type;
	}
	public void setType(EventTypes type) {
		this.type = type;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
