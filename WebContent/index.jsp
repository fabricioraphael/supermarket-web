<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="login_estilo.css" rel="stylesheet" type="text/css"/>	
		<title>Titulo Login!!</title>
		<style type="text/css">
			body{background-color: #D4D0C8;}
		</style>
		
	</head>
	<body>
	<div id="container">
		<div id="cabecario">
		</div>
		<div id="menu">
			<div id="class_menu">
				<form method="POST" action="login.do">
				Login:* <input type="text" name="login" value="" size="10"/>
				Senha:* <input type="password" name="password" value="" size="10"/>
				<input type="submit" value="Enter."/>
				<td id="messages"><% if(request.getAttribute("msg") != null){out.print(request.getAttribute("msg"));}%></td>
				</form>
			</div>
		</div>
		<div id="corpo">
			<center>
			<div id="corpo_image">
			</div>			
			</center>
		</div>
		<div id="rodape">
			.
		</div>
	</div>
	</body>
</html>

<!--<object width="550" height="400">
		<param name="movie" value="imagens/ani.swf">
		<embed src="imagens/ani.swf" width="1450" height="170">
		</embed>
		</object> -->