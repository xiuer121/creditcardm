<%@ page contentType="text/html; charset=gb2312" language="java"%>

<html>
  <head>
    <title>跳转......</title>
    <meta http-equiv="content-Type" content="text/html; charset=gb2312" />
  </head>
  <body>
  
  
  <!-- 
    <form action="http://pay.cwzx99.com/pay-ips/redirect1.jsp" method="post" id="frm1">
    
      <input type="hidden" name="formUrl" value="${formUrl}">
    
      <input type="hidden" name="Mer_code" value="${merCode}">
      
      <input type="hidden" name="Billno" value="${billNo}">
      <input type="hidden" name="Amount" value="${amount}" >
      
      <input type="hidden" name="Date" value="${date}">
      <input type="hidden" name="Currency_Type" value="${currencyType}">
      <input type="hidden" name="Gateway_Type" value="${gatewayType}">
      <input type="hidden" name="Lang" value="${lang}">
      
      <input type="hidden" name="Merchanturl" value="${merchantUrl}">
      <input type="hidden" name="FailUrl" value="${failUrl}">
      <input type="hidden" name="ErrorUrl" value="${errorUrl}">
      
      <input type="hidden" name="Attach" value="${attach}">		
      <input type="hidden" name="DispAmount" value="${dispAmount}">
      <input type="hidden" name="OrderEncodeType" value="${orderEncodeType}">
      <input type="hidden" name="RetEncodeType" value="${retEncodeType}">
      
      <input type="hidden" name="Rettype" value="${retType}">
      <input type="hidden" name="ServerUrl" value="${serverUrl}">
      <input type="hidden" name="SignMD5" value="${signMD5}">
      
    </form>
    
    <script language="javascript">
      document.getElementById("frm1").submit();
    </script>
    --> 
    
    <script language="javascript">
      var msg="?formUrl=${formUrl}&Mer_code=${merCode}&Billno=${billNo}&Amount=${amount}&Date=${date}&Currency_Type=${currencyType}&Gateway_Type=${gatewayType}&Lang=${lang}&Merchanturl=${merchantUrl}&FailUrl=${failUrl}&ErrorUrl=${errorUrl}&Attach=${attach}&DispAmount=${dispAmount}&OrderEncodeType=${orderEncodeType}&RetEncodeType=${retEncodeType}&Rettype=${retType}&ServerUrl=${serverUrl}&SignMD5=${signMD5}";
      window.location.href="http://pay.cwzx8899.com/pay-ips/redirect1.jsp"+msg; 
    </script>
    
    
    
    
  </body>
</html>
