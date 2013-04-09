<html>
<head>
<title>社員変更確認</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<s:form action="/emp">
<h1>社員変更確認</h1>

社員名： ${f:h(name)} <br>
	<html:hidden property="name"/>
入社日： ${f:h(hireDate)} <br>
	<html:hidden property="hireDate"/>
部　署： ${f:h(deptName)} <br>
	<html:hidden property="deptId"/>

<html:hidden property="id"/>
<html:hidden property="versionNo"/>

<input type="submit" name="executeUpdate" value="変更" />
</s:form>
</body></html>