<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<div class="form_cadastro">
						<form method="POST" action="client.do">
							<table   border="0" cellpadding="3" cellspacing="2" width=45%>
								<tr>
									<td bgcolor="#c5ccea">Nome:* </td> <td><input name="nameClient" type="text" size="50" maxlength="50"/></td>
									<td bgcolor="#c5ccea">Nascimento:* </td> <td><input name="birthClient" type="text" size="10" maxlength="10"/></td>
								</tr>	
								<tr>
									<td bgcolor="#c5ccea">Endereço: </td> <td><input name="addressClient" type="text" size="50" maxlength="50"/></td>
									<td bgcolor="#c5ccea">Telefone: </td>  <td><input name="phoneClient" type="text" size="10" maxlength="8"/> </td>
								</tr>
								<tr>
									<td bgcolor="#c5ccea">Email:</td> <td><input  name="emailClient" type="text" size="50" maxlength="50"/></td>
									<td bgcolor="#c5ccea">Celular:</td> <td><input name="celularClient" type="text" size="10" maxlength="8"/></td>
								</tr>
								<tr>
									<td bgcolor="#c5ccea">Obs:</td>  <td><textarea name="obsClient" rows=7 cols=64></textarea></td>
								</tr>
								<tr>
									<td>  </td> <td><center><input name="" type="submit" value="Enviar"/>  <input  name="" type="reset" value="Limpar"/></center></td>
								</tr>
								<tr>
									<td></td> <td id="messages">  <%if(request.getAttribute("msg") != null){out.print(request.getAttribute("msg"));} %>  </td> 
								</tr>
							</table>
						</form>
					</div>	
				</div>
			</div>
			<div id="rodape">.</div>
		</div>

	</body>
</html>