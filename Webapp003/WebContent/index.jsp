
<%@ page import="java.sql.Connection" %>
<%@ page import="com.srk.pkg.dbmanager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HOLAAA A TODOS PROYECTO WEBAPP003</h1>
<hr/>

<h1>Exercise forms</h1>
<hr/>
<form action="MyServlet">
<input type="submit" value="SEND">
<h1>Exercise DB Connexion</h1>
<hr/>
</form>

<%
	dbmanager db = new dbmanager();
	Connection conn = db.getConnection();
	if(conn == null){
		out.print("Conexion failed");
	}
	else
	{
		out.print("Conexion successed");
	}
	
%>
<h1>Exercise DB creation Table</h1>
<hr/>
<%
	dbmanager db2 = new dbmanager();
	db.createTable();
%>

<h1>exercise DB selection </h1>
<hr/>

<table>
<%
	dbmanager db3 = new dbmanager();
ResultSet result = null;
	result = db.selectTable();
	
	while(result.next()){
		
%>	
		<tr>
		<td><%= result.getString(1) %></td>
		<td><%= result.getString(2) %></td>
		</tr>
		
<% 			
	}
%>


</table>

<hr/>
<h1>EXERCISE OF INSERT</h1>
	<form action="dbexecutions">
		<table>
		<tr>
		<td><input type="text" name="first" id="first"></td>
		</tr>
		<tr>
		<td><input type="text" name="last" id="last"></td>
		<tr>
		<td><input type="Submit" value="SEND"></td>
		</tr>
		</table>
	</form>




</body>
</html>