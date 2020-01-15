<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dope 5earch</title>
</head>
<body style="background-position:center ;
			 background-image: url(&quot;https://i.pinimg.com/originals/0c/9e/86/0c9e86651e584f972b9089851887c6cb.png&quot;);"><font
      color="#FFFFFF"><br><br>
      <div><p align="center" ><img src="https://i.pinimg.com/originals/0e/b0/c8/0eb0c8cb70e9b06031ba8e7451510fc2.gif" width="200" height="100"></div>
      <br>
<%
String[][] orderList = (String[][]) request.getAttribute("query");
String[] outlines = (String[])request.getAttribute("outlines");
String[] outline2 = (String[])request.getAttribute("outline2");
//for(int i =0 ; i < orderList.length;i++)
	for(int i = orderList.length-1;i>-1;i--)
	{
		String url = orderList[i][1];%>
	<p align="center" ><a href='<%= url%>' style="color:#FFFFFF; text-decoration:none;font-size:25px;font-family:微軟正黑體" ><%= orderList[i][0] %></a>
	<br>
	<p align="center" ><a style="color:	#808080;"><I><%= outlines[i] %></I></a>
	<p align="center" ><a style="color:	#808080;font-size=0.5px"><I><%= outline2[i] %></I></a>
	</h>
	<br><br>
<%
};
%>
</body>
</html>