<html>
<head>
<title>検索結果一覧</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<%
out.println(request.getMethod());
out.println(request.getParameter("condition_name_STARTS"));
%>
<h1>検索結果一覧</h1>

名： ${f:h(condition_name_STARTS)}<br>
日： ${f:h(condition_hireDate_GE)} 　～　${f:h(condition_hireDate_LE)}<br>

<table border="1" >
  <thead>
    <tr>
      <th>${deptItems}名</th><th>入社日</th><th>部署名</th><th></th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="emp" varStatus="s" items="${empItems}">
      <tr style="background-color: ${s.index % 2 == 0 ? 'white' : 'lightblue'};">
        <td>${emp.name}</td>
        <td><fmt:formatDate value="${emp.hireDate}" type="DATE" dateStyle="FULL"/></td>
        <td>${emp.dept.name}</td>
        <td><a href="update/${f:u(emp.id)}" target="_blank"> 変更 </a></td>
      </tr>
    </c:forEach>
  </tbody>
</table>

</body></html>