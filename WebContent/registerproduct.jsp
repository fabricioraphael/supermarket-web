<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="br.com.faber.util.StringUtil"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.Select"%><html>
<head>
<title>Sistema de Gerenciamento Web.</title>
<link href="estilo.css" rel="stylesheet" type="text/css" />
<link href="menuestilos.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="js/javascript.js"></script>

</head>
<body id="body">
<div id="container">
<div id="cabecario"></div>

<div id="info"><jsp:include page="info.jsp"></jsp:include></div>

<div id="esquerda"><jsp:include page="menu.jsp"></jsp:include></div>
<div id="corpo">
<div id="class_corpo">
<div class="form_cadastro"><!--<form name="form_1">-->
<form name="form_1" method="get" action="supplier.do">
<table border="0" cellpadding="3" cellspacing="2" width=45%>
	<tr>
		<td id="td_box">Nome Completo:*</td>
		<td><input name="nameProductComplete" type="text" size="40" maxlength="70" value="<%if (StringUtil.isNotNull(request.getAttribute("namePComplete"))){out.println(request.getAttribute("namePComplete"));} %>" /></td>
		<td id="td_box">Unidade Medida:*</td>
		<td>
		<center><select name="unit">
			<option value="Null">Null</option>
			<option value="Uni">Uni</option>
			<option value="Kg">Kg</option>
			<option value="L">L</option>
		</select></center>
		</td>
		<td id="td_box">Quantidade:*</td>
		<td><input name="quantity" type="text" size="15" maxlength="11"
			value="<%if (StringUtil.isNotNull(request.getAttribute("quantity"))){out.println(request.getAttribute("quantity"));} %>" />
		</td>
	</tr>
	<tr>
		<td id="td_box">Nome Abreviado:*</td>
		<td><input name="nameProductAbbreviated" type="text" size="40" maxlength="50" value="<%if (StringUtil.isNotNull(request.getAttribute("namePAbbreviated"))){out.println(request.getAttribute("namePAbbreviated"));} %>" /></td>
		<td id="td_box">Valor de Custo:*</td>
		<td><input name="valueCost" type="text" size="9" maxlength="11" value="<%if (StringUtil.isNotNull(request.getAttribute("valueCost"))){out.println(request.getAttribute("valueCost"));} %>" /></td>
		<td id="td_box">Valor Cobrado:*</td>
		<td><input name="valueCharged" type="text" size="9" maxlength="11" value="<%if (StringUtil.isNotNull(request.getAttribute("valueCharged"))){out.println(request.getAttribute("valueCharged"));} %>" />
		<input type="button" value="%" onclick="Calculate(this.form)" /></td>
		<td><input name="obsP" type="hidden" /></td>
	</tr>
	<!--   </form>	
							<form name="form_2" method="get" action="supplier.do"> -->
	<tr>
		<td id="td_box">Nome Fornecedor:*</td>
		<td><input name="nameSupplier" value="<%if (StringUtil.isNotNull(request.getAttribute("nameComplete"))){out.println(request.getAttribute("nameComplete"));}%>" type="text" size="40" maxlength="50" /></td>
		<td id="td_box">Pesquisar Fornecedor:</td>
		<td><input name="searchSupplier" type="submit" onclick="Pesquisa()" value="   Pesquisa   " /></td>
		<td id="td_box">Cadastrar Fornecedor:</td>
		<td><input name="registerSupplier" type="button" onclick="location.href='registersupplier.jsp'" value="   Cadastra   " />
		</td>
	</tr>
	</form>
	<form name="form_2">
	<tr>
		<td id="td_box">Endereco:</td>
		<td><input name="addressSupplier" value="<%if (StringUtil.isNotNull(request.getAttribute("address"))){out.println(request.getAttribute("address"));}%>" type="text" size="40" maxlength="50" /></td>
		<td id="td_box">Telefone 1:</td>
		<td><input name="phoneOneSupplier" value="<%if (StringUtil.isNotNull(request.getAttribute("phone1"))){out.println(request.getAttribute("phone1"));}%>" type="text" size="10" maxlength="8" /></td>
		<td id="td_box">Telefone 2:</td>
		<td><input name="phoneTwoSupplier" value="<%if (StringUtil.isNotNull(request.getAttribute("phone2"))){out.println(request.getAttribute("phone2"));}%>" type="text" size="10" maxlength="8" /></td>
	</tr>
	<tr>
		<td id="td_box">Email Fornecedor:</td>
		<td><input name="emailSupplier" value="<%if (StringUtil.isNotNull(request.getAttribute("email"))){out.println(request.getAttribute("email"));}%>" type="text" size="40" maxlength="50" /></td>
	</tr>
	<tr>
		<td id="td_box">Observacoes sobre o produto:</td>
		<td><textarea name="obsProduct" rows=7 cols=40></textarea></td>
	</tr>
	</form>
	<form name="form_envia" method="post" action="product.do">
	<tr>
		<td><input name="nameProductComplete" type="hidden" /></td>
		<td><input name="nameProductAbbreviated" type="hidden" /></td>
		<td><input name="unit" type="hidden" /></td>
		<td><input name="quantity" type="hidden" /></td>
		<td><input name="valueCost" type="hidden" /></td>
		<td><input name="valueCharged" type="hidden" /></td>
		<td><input name="nameSupplier" type="hidden" /></td>
		<td><input name="description" type="hidden" /></td>

		<td><input name="addressSupplier" type="hidden" /></td>
		<td><input name="phoneOneSupplier" type="hidden" /></td>
		<td><input name="phoneTwoSupplier" type="hidden" /></td>
		<td><input name="emailSupplier" type="hidden" /></td>
		<td><input name="unit_hidden" type="hidden"
			value="<%if (StringUtil.isNotNull(request.getAttribute("unit_hidden"))){out.println(request.getAttribute("unit"));} %>" /></td>
	</tr>
	<tr>
		<td></td>
		<td>
		<center>
			<input onclick="PickDataForm()" name="" type="submit" value="    Enviar    " />
			<input onclick="ResetForm()" name="" type="reset" value="    Limpar    " />
		</center>
		</td>
	</tr>
	<tr>
		<td></td>
		<td id="messages">
		<%if (StringUtil.isNotNull(request.getAttribute("msg"))){out.println(request.getAttribute("msg"));}%>
		</td>
	</tr>

	</form>
</table>
</div>
</div>
</div>
<div id="rodape">.</div>
</div>
</body>
</html>








