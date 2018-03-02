package com.bcht.webservice.rminf.client.result;

public class Body {
  Object entity;

@SuppressWarnings({ "unchecked"})
public <X> X getEntity() {
	return (X)entity;
}

public void setEntity(Object entity) {
	this.entity = entity;
}
  
}
