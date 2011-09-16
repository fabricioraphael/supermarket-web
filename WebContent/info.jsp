<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
		<%
		String validates = null;
		%>
		
		<a class="oo"><b>Nome: </b><%=request.getAttribute("nome")%> <b>Perfil: </b> <%=request.getAttribute("perfil") %> <b>Mercado: </b> Extra  </a>
		<a class="ooo" onclick="<%request.setAttribute("validates", validates); %>" href="index.jsp">Sair</a> 

</body>
</html>