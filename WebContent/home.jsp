<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Sistema de Gerenciamento Web.</title>
		<link href="estilo.css" rel="stylesheet" type="text/css"/>
		<link href="menuestilos.css" rel="stylesheet" type="text/css"/>
		<script language="javascript" src="js/javascript.js"></script>
	</head>
	<body>
	
	
		<div id="container">
			<div id="cabecario"></div>
			
			<div id="info"> 
				<jsp:include page="info.jsp"></jsp:include>
			</div>
			
			<div id="esquerda">
					<jsp:include page="menu.jsp"></jsp:include>
			</div>
			<div id="corpo">
					<div id="class_corpo">
					</div>	
			</div>
			<div id="rodape">.</div>
		</div>

	</body>
</html>
