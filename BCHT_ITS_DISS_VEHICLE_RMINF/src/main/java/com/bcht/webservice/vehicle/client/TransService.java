/**
 * TransService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bcht.webservice.vehicle.client;

public interface TransService extends javax.xml.rpc.Service {
    public java.lang.String getTransAddress();

    public com.bcht.webservice.vehicle.client.Trans_PortType getTrans() throws javax.xml.rpc.ServiceException;

    public com.bcht.webservice.vehicle.client.Trans_PortType getTrans(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
