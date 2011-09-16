<%@page import="br.com.faber.dao.*, br.com.faber.service.*, java.util.*"%>
<%@page import="br.com.faber.entity.*" %>

<table width="100%" border="0" cellpadding="2" cellspacing="2">
	<tr bgcolor="#086dc7"  style="text-align: center; font-family: verdana; font: bold;" >
			<td height="17px"  width="100px" >ID</td > <td width="30%">Nome Completo</td> <td width="25%">Endereço</td> <td width="auto">Telefone</td> <td width="25%">Email</td>
		</tr>

	<%
		List<Supplier> supplierList = (List<Supplier>) request.getAttribute("supliers");
		String metod="";
		int x=1;
		for (Supplier supplier : supplierList ){
			if(x%2==0){metod = "td_box2";}else{metod = "";}%>
		<tr  style="text-align: center; font-size: 13px" id="<%=metod%>">
			<td height="37px" width="100px"><a style="text-decoration: none; font: bold" href="#"> <%=supplier.getId()%></a></td > <td width="30%"><%=supplier.getNameComplete()%></td> <td width="25%"><%=supplier.getAddress()%></td> <td width="auto"><%=supplier.getPhone1()%></td>   <td width="25%"><%=supplier.getEmail()%></td>  
		</tr>
	
	  <%x++;}%>
</table>


















































































































<script type="text/javascript" language="javascript">
//<!-- 
//function IsMatchingChar(str){
  //  var myRegExp = /a/;
    //return myRegExp.test(str);
//}

//function TestGuess(){
	
	
  //  var guess = prompt("Enter a lower case character here","a");
    //var texto = document.form.texto.value;
 //   alert("Value digited " + texto);
   // if (IsMatchingChar(guess)){
    //	document.form.bot.value = texto.value;
      //  alert("The correct answer was " + guess);
    //}
   // else{
     //   alert("Sorry " + guess + " doesn't match");
   // }
//}
//function Calculate(form){
	//vCost = eval(form.valueCost.value);
//	var porc = prompt("Digite a porcentagem ", "25");
	//vVar = eval(porc);

	//vCharged= (vCost * vVar) / 100 + vCost ;
	//form.valueCharged.value = vCharged;
//}
//-->
</script>