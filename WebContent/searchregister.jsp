<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="br.com.faber.util.StringUtil"%><html>
<head>
		<title>Sistema de Gerenciamento Web.</title>
		<link href="estilo.css" rel="stylesheet" type="text/css"/>
		<link href="menuestilos.css" rel="stylesheet" type="text/css"/>
		<script language="javascript" src="js/javascript.js"></script>
		<script language="javascript" src="js/jquery.min.js"></script>
		<script language="javascript" src="js/search.js"></script>
	</head>
	<body id="body">
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
						<div id="topp">
							<div id="form_top">
										<table  width="100%"  cellpadding="2" cellspacing="2">
											<tr>
												<td id="td_box" style="border: 0.5px; border-style: solid; border-color: #075eac">Listar:</td>
												<td style="border: 0.5px; border-style: solid; border-color: #075eac">  
													<select name="selectList">
														<option value="1">Cliente </option>
														<option value="2">Fornecedor </option>
														<option value="3">Funcionario </option>
													</select>
												</td>
												<td id="td_box" style="border: 0.5px; border-style: solid; border-color: #075eac">Filtro de Pesquisa:</td>
												<td style="border: 0.5px; border-style: solid; border-color: #075eac">
													<input name="opt" value="1" type="radio" checked>Todos  
													<input name="opt" value="2" type="radio">ID 
													<input name="opt" value="3" type="radio">Nome
													<input name="opt" value="4" type="radio">Endereço
												</td>
											</tr>										
											<tr>
												<td id="td_box" style="border: 0.5px; border-style: solid; border-color: #075eac">ID: </td> <td style="border: 0.5px; border-style: solid; border-color: #075eac"> <input id="idTxt" name="idTxt" type="text" size="10" maxlength="10" /></td>
											</tr>										
											<tr>
												<td id="td_box" style="border: 0.5px; border-style: solid; border-color: #075eac">Nome: </td> <td style="border: 0.5px; border-style: solid; border-color: #075eac"> <input id="nameTxt" name="nameTxt" type="text" size="50" maxlength="70" /></td>
											</tr>										
											<tr>
												<td id="td_box" style="border: 0.5px; border-style: solid; border-color: #075eac">Endereço: </td> <td style="border: 0.5px; border-style: solid; border-color: #075eac"> <input id="addressTxt" name="addressTxt" type="text" size="50" maxlength="70" /></td>
											</tr>
											<tr>
												<td> </td><td align="right"> <input id="pesquisar" type="submit" value=" Pesquisar "/></td> <td> <input type="reset" value="  Limpar  "/></td>
											</tr>
										</table>
							</div>
						</div>
						<div id="barra_top">
							</div>
						<div id="bott">
							<div id="resultado">
							</div>
						
							<div id="result_bot">
								<%Integer i = 0; if(request.getAttribute("selectList") != null){i = (Integer) request.getAttribute("selectList");}else{i=0;}%>
								<%if(i == 2){ %>
									<iframe marginwidth="0" marginheight="0" scrolling="auto" frameborder="0" src ="viewsupplier.jsp" width="100%" height="100%">ifail</iframe>
								<%}%>
								<%if(StringUtil.isNotNull(request.getAttribute("msg"))){out.println("<center>" + request.getAttribute("msg"));}else if(i == 0){out.print("Nenhum Registro Selecionado, ou parâmetro de busca inválido.");}%>
							</div>
						</div>
				</div>
			</div>
			<div id="rodape">.</div>
		</div>

	</body>
</html>