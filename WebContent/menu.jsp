<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
					<script>
						n_divs='5'
					</script>

					<div class="titulo_menu"><a href="home.jsp" class="link_menu"  >Principal</a></div>

					<div class="titulo_menu"  ><a href="javascript:void(escondediv('1',n_divs))" class="link_menu" >Cadastro</a></div>
					<div id="mdiv1"  style="display:none">
						<table border="0">
						   	<tr><td id="um" class="itens_menu" ><a href="registerproduct.jsp" onmouseover="reveza('um')" onmouseout="volta('um')" class="link_smenu">Produto</a></td></tr>
							<tr><td id="dois" class="itens_menu" ><a href="registerclient.jsp" onmouseover="reveza('dois')" onmouseout="volta('dois')" class="link_smenu">Cliente</a></td></tr>
							<tr><td id="tres" class="itens_menu" ><a href="registersupplier.jsp" onmouseover="reveza('tres')" onmouseout="volta('tres')" class="link_smenu">Fornecedor</a></td></tr>
							<tr><td id="quatro" class="itens_menu" ><a href="#" onmouseover="reveza('quatro')" onmouseout="volta('quatro')" class="link_smenu">Funcionario</a></td></tr>
						</table>
					</div>

					<div class="titulo_menu"><a href="javascript:void(escondediv('2',n_divs))" class="link_menu">Pesquisa</a></div>
					<div id="mdiv2"  style="display:none">
					   	<table border="0">
							<tr><td id="cinco" class="itens_menu" ><a href="#" onmouseover="reveza('cinco')" onmouseout="volta('cinco')" class="link_smenu">Produto</a></td></tr>
							<tr><td id="seis" class="itens_menu" ><a href="searchregister.jsp" onmouseover="reveza('seis')" onmouseout="volta('seis')" class="link_smenu">Cadastrado</a></td></tr>
						</table>
					</div>

					<div class="titulo_menu"><a href="javascript:void(escondediv('3',n_divs))" class="link_menu">Deleta</a></div>
					<div id="mdiv3"  style="display:none">
						<table border="0">
							<tr><td id="sete" class="itens_menu" ><a href="#" onmouseover="reveza('sete')" onmouseout="volta('sete')" class="link_smenu">Produto</a></td></tr>
							<tr><td id="oito" class="itens_menu" ><a href="#" onmouseover="reveza('oito')" onmouseout="volta('oito')" class="link_smenu">Cadastrado</a></td></tr>
						</table>
					</div>

					<div class="titulo_menu"><a href="javascript:void(escondediv('4',n_divs))" class="link_menu">Configuracoes</a></div>
					<div id="mdiv4"  style="display:none">
						<table border="0">
							<tr><td id="nove" class="itens_menu" ><a href="#" onmouseover="reveza('nove')" onmouseout="volta('nove')" class="link_smenu">Altera Senha</a></td></tr>
							<tr><td id="dez" class="itens_menu" ><a href="#" onmouseover="reveza('dez')" onmouseout="volta('dez')" class="link_smenu">Dados Cadastrais</a></td></tr>
						</table>
					</div>

					<div class="titulo_menu"><a href="javascript:void(escondediv('5',n_divs))" class="link_menu">Painel de Controle</a></div>
					<div id="mdiv5"  style="display:none">
						<table border="0">
							<tr><td id="onze" class="itens_menu" ><a href="#" onmouseover="reveza('onze')" onmouseout="volta('onze')" class="link_smenu">Feixar Caixa</a></td></tr>
							<tr><td id="doze" class="itens_menu" ><a href="#" onmouseover="reveza('doze')" onmouseout="volta('doze')" class="link_smenu">Financeiro</a></td></tr>
						</table>
					</div>
</body>
</html>