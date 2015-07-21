<%@ page contentType="text/html; charset=gb2312" language="java"%>

<html>
  <head>
    <title>跳转......</title>
    <meta http-equiv="content-Type" content="text/html; charset=gb2312" />
  </head>
  <body>
    <form action="${param['formUrl']}" method="post" id="frm1">
    
      <input type="hidden" name="Mer_code" value="${param['Mer_code']}">
      
      <input type="hidden" name="Billno" value="${param['Billno']}">
      <input type="hidden" name="Amount" value="${param['Amount']}" >
      
      <input type="hidden" name="Date" value="${param['Date']}">
      <input type="hidden" name="Currency_Type" value="${param['Currency_Type']}">
      <input type="hidden" name="Gateway_Type" value="${param['Gateway_Type']}">
      <input type="hidden" name="Lang" value="${param['Lang']}">
      
      <input type="hidden" name="Merchanturl" value="${param['Merchanturl']}">
      <input type="hidden" name="FailUrl" value="${param['FailUrl']}">
      <input type="hidden" name="ErrorUrl" value="${param['ErrorUrl']}">
      
      <input type="hidden" name="Attach" value="${param['Attach']}">		<!-- 商户数据包 -->
      <input type="hidden" name="DispAmount" value="${param['DispAmount']}">
      <input type="hidden" name="OrderEncodeType" value="${param['OrderEncodeType']}">
      <input type="hidden" name="RetEncodeType" value="${param['RetEncodeType']}">
      
      <input type="hidden" name="Rettype" value="${param['Rettype']}">
      <input type="hidden" name="ServerUrl" value="${param['ServerUrl']}">
      <input type="hidden" name="SignMD5" value="${param['SignMD5']}">
      
    </form>
    
    <script language="javascript">
      document.getElementById("frm1").submit();
    </script>
    
  </body>
</html>
