/**
 * HmsasServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hmsas;

public class HmsasServiceLocator extends org.apache.axis.client.Service implements hmsas.HmsasService {

    public HmsasServiceLocator() {
    }


    public HmsasServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HmsasServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for hmsasserverPort
    private java.lang.String hmsasserverPort_address = "http://172.24.176.217/hmsas/wsdl/hmsasserver.php";

    public java.lang.String gethmsasserverPortAddress() {
        return hmsasserverPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String hmsasserverPortWSDDServiceName = "hmsasserverPort";

    public java.lang.String gethmsasserverPortWSDDServiceName() {
        return hmsasserverPortWSDDServiceName;
    }

    public void sethmsasserverPortWSDDServiceName(java.lang.String name) {
        hmsasserverPortWSDDServiceName = name;
    }

    public hmsas.HmsasserverPortType gethmsasserverPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(hmsasserverPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return gethmsasserverPort(endpoint);
    }

    public hmsas.HmsasserverPortType gethmsasserverPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            hmsas.HmsasserverBindingStub _stub = new hmsas.HmsasserverBindingStub(portAddress, this);
            _stub.setPortName(gethmsasserverPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void sethmsasserverPortEndpointAddress(java.lang.String address) {
        hmsasserverPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (hmsas.HmsasserverPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                hmsas.HmsasserverBindingStub _stub = new hmsas.HmsasserverBindingStub(new java.net.URL(hmsasserverPort_address), this);
                _stub.setPortName(gethmsasserverPortWSDDServiceName());
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
        if ("hmsasserverPort".equals(inputPortName)) {
            return gethmsasserverPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:hmsas", "hmsasService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:hmsas", "hmsasserverPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("hmsasserverPort".equals(portName)) {
            sethmsasserverPortEndpointAddress(address);
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
