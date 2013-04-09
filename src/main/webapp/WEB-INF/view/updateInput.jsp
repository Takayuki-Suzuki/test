<html>
<head>
<title>社員変更</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style TYPE="text/css">
</style>
</head>
<body>
<s:form action="/emp">
<html:hidden property="id"/>
<html:hidden property="versionNo"/>

<h1>変更</h1>
<html:errors/>
名*： <html:text property="name"/><br />
入社日  ： <html:text property="hireDate"/><br />
部　署 ：
  <html:select property="deptId">
  <html:option value=""></html:option>
    <c:forEach var="dept" items="${deptItems}">
      <html:option value="${f:h(dept.id)}">${f:h(dept.name)}</html:option>
    </c:forEach>
  </html:select>

<br />
<input type="submit" name="showConfirm" value="確認" />
</s:form>
</body></html>