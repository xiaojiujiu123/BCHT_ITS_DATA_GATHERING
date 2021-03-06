/**
 * TransServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bcht.webservice.rminf.client;

public class TransServiceLocator extends org.apache.axis.client.Service implements com.bcht.webservice.rminf.client.TransService {

    public TransServiceLocator() {
    }


    public TransServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TransServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Trans
    private java.lang.String Trans_address = "http://10.166.193.6:9080/rminf/services/Trans";

    public java.lang.String getTransAddress() {
        return Trans_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TransWSDDServiceName = "Trans";

    public java.lang.String getTransWSDDServiceName() {
        return TransWSDDServiceName;
    }

    public void setTransWSDDServiceName(java.lang.String name) {
        TransWSDDServiceName = name;
    }

    public com.bcht.webservice.rminf.client.Trans_PortType getTrans() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Trans_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTrans(endpoint);
    }

    public com.bcht.webservice.rminf.client.Trans_PortType getTrans(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.bcht.webservice.rminf.client.TransSoapBindingStub _stub = new com.bcht.webservice.rminf.client.TransSoapBindingStub(portAddress, this);
            _stub.setPortName(getTransWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTransEndpointAddress(java.lang.String address) {
        Trans_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.bcht.webservice.rminf.client.Trans_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.bcht.webservice.rminf.client.TransSoapBindingStub _stub = new com.bcht.webservice.rminf.client.TransSoapBindingStub(new java.net.URL(Trans_address), this);
                _stub.setPortName(getTransWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Trans".equals(inputPortName)) {
            return getTrans();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.tfc.tmri.com", "TransService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.tfc.tmri.com", "Trans"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Trans".equals(portName)) {
            setTransEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
