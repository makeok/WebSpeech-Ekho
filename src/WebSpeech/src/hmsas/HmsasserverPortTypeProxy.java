package hmsas;

public class HmsasserverPortTypeProxy implements hmsas.HmsasserverPortType {
  private String _endpoint = null;
  private hmsas.HmsasserverPortType hmsasserverPortType = null;
  
  public HmsasserverPortTypeProxy() {
    _initHmsasserverPortTypeProxy();
  }
  
  public HmsasserverPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initHmsasserverPortTypeProxy();
  }
  
  private void _initHmsasserverPortTypeProxy() {
    try {
      hmsasserverPortType = (new hmsas.HmsasServiceLocator()).gethmsasserverPort();
      if (hmsasserverPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hmsasserverPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hmsasserverPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hmsasserverPortType != null)
      ((javax.xml.rpc.Stub)hmsasserverPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public hmsas.HmsasserverPortType getHmsasserverPortType() {
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType;
  }
  
  public java.lang.Object get_awsqcdata_toarray(java.lang.String begdate0, java.lang.String enddate0, java.lang.String quyunamestr0, java.lang.String elementstr0, java.lang.String stanumstr0, java.lang.String abnormalflag, java.lang.String username, java.lang.String userpass) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.get_awsqcdata_toarray(begdate0, enddate0, quyunamestr0, elementstr0, stanumstr0, abnormalflag, username, userpass);
  }
  
  public java.lang.Object getdatatoarray_addqc(java.lang.String datatable0, java.lang.String begdate0, java.lang.String enddate0, java.lang.String elementstr0, java.lang.String stanumstr0, java.lang.String username, java.lang.String userpass) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.getdatatoarray_addqc(datatable0, begdate0, enddate0, elementstr0, stanumstr0, username, userpass);
  }
  
  public java.lang.Object getdatatoarray(java.lang.String datatable0, java.lang.String begdate0, java.lang.String enddate0, java.lang.String elementstr0, java.lang.String stanumstr0, java.lang.String username, java.lang.String userpass) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.getdatatoarray(datatable0, begdate0, enddate0, elementstr0, stanumstr0, username, userpass);
  }
  
  public java.lang.Object getdatatoarray_for_condition(java.lang.String datatable0, java.lang.String begdate0, java.lang.String enddate0, java.lang.String elementstr0, java.lang.String stanumstr0, java.lang.String conditionstr, java.lang.String orderbystr, java.lang.String username, java.lang.String userpass) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.getdatatoarray_for_condition(datatable0, begdate0, enddate0, elementstr0, stanumstr0, conditionstr, orderbystr, username, userpass);
  }
  
  public java.lang.Object rainaddupdata(java.lang.String raindatatable, java.lang.String rainbegdate, java.lang.String rainenddate, java.lang.String rainelement, java.lang.String rainstanum, java.lang.String rainusername, java.lang.String rainuserpass) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.rainaddupdata(raindatatable, rainbegdate, rainenddate, rainelement, rainstanum, rainusername, rainuserpass);
  }
  
  public java.lang.Object minvalue_elementdata(java.lang.String mindatatable, java.lang.String minbegdate, java.lang.String minenddate, java.lang.String minelement, java.lang.String minstanum, java.lang.String minusername, java.lang.String minuserpass) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.minvalue_elementdata(mindatatable, minbegdate, minenddate, minelement, minstanum, minusername, minuserpass);
  }
  
  public java.lang.Object maxvalue_elementdata(java.lang.String maxdatatable, java.lang.String maxbegdate, java.lang.String maxenddate, java.lang.String maxelement, java.lang.String maxstanum, java.lang.String maxusername, java.lang.String maxuserpass) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.maxvalue_elementdata(maxdatatable, maxbegdate, maxenddate, maxelement, maxstanum, maxusername, maxuserpass);
  }
  
  public java.lang.Object avgvalue_elementdata(java.lang.String avgdatatable, java.lang.String avgbegdate, java.lang.String avgenddate, java.lang.String avgelement, java.lang.String avgstanum, java.lang.String avgusername, java.lang.String avguserpass) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.avgvalue_elementdata(avgdatatable, avgbegdate, avgenddate, avgelement, avgstanum, avgusername, avguserpass);
  }
  
  public java.lang.String getdatatofileforweb(java.lang.String datatable1, java.lang.String begdate1, java.lang.String enddate1, java.lang.String elementstr1, java.lang.String stanumstr1, java.lang.String downfilename1, java.lang.String fileusernameweb, java.lang.String fileuserpassweb) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.getdatatofileforweb(datatable1, begdate1, enddate1, elementstr1, stanumstr1, downfilename1, fileusernameweb, fileuserpassweb);
  }
  
  public java.lang.Object getflashdata(java.lang.String datatable, java.lang.String begintime, java.lang.String endtime, java.lang.String elefields, java.lang.String limitnum, java.lang.String flashuser, java.lang.String flashpassword) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.getflashdata(datatable, begintime, endtime, elefields, limitnum, flashuser, flashpassword);
  }
  
  public java.lang.Object getstationinfo(java.lang.String provincestr, java.lang.String statypestr, java.lang.String quyustr, java.lang.String elenumstr, java.lang.String stanumstr, java.lang.String fieldstr, java.lang.String updatatime, java.lang.String minlon, java.lang.String maxlon, java.lang.String minlat, java.lang.String maxlat) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.getstationinfo(provincestr, statypestr, quyustr, elenumstr, stanumstr, fieldstr, updatatime, minlon, maxlon, minlat, maxlat);
  }
  
  public java.lang.Object getwarninfo(java.lang.String warncode, java.lang.String warnbegintime, java.lang.String warnendtime, java.lang.String warnstationnum, java.lang.String elementvalue, java.lang.String warnlevel, java.lang.String warnelementstr, java.lang.String warnuser, java.lang.String warnpasswd) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.getwarninfo(warncode, warnbegintime, warnendtime, warnstationnum, elementvalue, warnlevel, warnelementstr, warnuser, warnpasswd);
  }
  
  public java.lang.Object getradiometricsdata_fenceng(java.lang.String stanumstr, java.lang.String begdate, java.lang.String enddate, java.lang.String cengstr, java.math.BigInteger temperatureflag, java.math.BigInteger vaporDensityflag, java.math.BigInteger liquidflag, java.math.BigInteger relativeHumidityflag, java.lang.String username, java.lang.String userpass) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.getradiometricsdata_fenceng(stanumstr, begdate, enddate, cengstr, temperatureflag, vaporDensityflag, liquidflag, relativeHumidityflag, username, userpass);
  }
  
  public java.lang.Object getlatestdata(java.lang.String datatable) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.getlatestdata(datatable);
  }
  
  public java.lang.Object gettablefieldsinfo(java.lang.String fieldtable, java.lang.String fieldstr) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.gettablefieldsinfo(fieldtable, fieldstr);
  }
  
  public java.lang.String check_user_and_type_and_date_beg_end_legalornot(java.lang.String datatable0, java.lang.String begdate0, java.lang.String enddate0, java.lang.String username, java.lang.String userpass) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.check_user_and_type_and_date_beg_end_legalornot(datatable0, begdate0, enddate0, username, userpass);
  }
  
  public java.lang.String combination_dbname_tbname_to_string(java.lang.String datatable0, java.lang.String begdate0, java.lang.String enddate0, java.lang.String dbnamedatadb, java.lang.String nowdatestorelimit, java.lang.String alldbtbnamestr) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.combination_dbname_tbname_to_string(datatable0, begdate0, enddate0, dbnamedatadb, nowdatestorelimit, alldbtbnamestr);
  }
  
  public java.lang.Object get_mon_extremevalue(java.lang.String quyuname1Str, java.lang.String staname1Str, java.lang.String stanum1Str, java.lang.String monnum1Str, java.lang.String field1Str) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.get_mon_extremevalue(quyuname1Str, staname1Str, stanum1Str, monnum1Str, field1Str);
  }
  
  public java.lang.Object get_sx_dflow_hdanger(java.lang.String provcodestr, java.lang.String hdangerdnamestr, java.lang.String countynamestr, java.lang.String searchconditionstr, java.lang.String fieldsstr) throws java.rmi.RemoteException{
    if (hmsasserverPortType == null)
      _initHmsasserverPortTypeProxy();
    return hmsasserverPortType.get_sx_dflow_hdanger(provcodestr, hdangerdnamestr, countynamestr, searchconditionstr, fieldsstr);
  }
  
  
}