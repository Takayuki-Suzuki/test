<html>
<head>
<title>検索</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<s:form action="/emp">
<h1>検索</h1>
名：
  <input name="condition_name_STARTS" type="text" title="社員名"/>(前方一致)<br>
入社日：
  <input name="condition_hireDate_GE" type="text" title="入社日（開始）" />～
  <input name="condition_hireDate_LE" type="text" title="入社日（終了）" /><br>

  <input type="submit" name="list" value="検索" />
</s:form>
</body></html>