c=0;
du="";
function escondediv(dv,n){		
	for(i=1;i<=n;i++){			
		if(i==dv ){
			if(du!=dv){
				document.getElementById('mdiv'+i).style.display="inline";
					du=dv;
			}else{
				du="";
					document.getElementById('mdiv'+i).style.display="none";
			}
		}else{
			document.getElementById('mdiv'+i).style.display="none";				  					
		}				
	}		
}

function reveza(qq){
	document.getElementById(qq).className="itens_menu_r";
}
function volta(qq){
	document.getElementById(qq).className="itens_menu";
}

function Calculate(form){
	
	vCost = eval(form.valueCost.value);
	var stg = prompt("Digite a porcentagem desejada", "20");
	porc = eval(stg);
	
	vCharged = (vCost*porc) / 100 + vCost;
	
	form.valueCharged.value = vCharged;
}

function Pesquisa(){
	document.form_2.unit.value = "Uni";
	
//	document.form_3.unit_hidden.value = document.form_1.nameProductComplete.value;
//	alert("Pesquisa clicked! name: " + document.form_3.unit_hidden.value);
//	document.form_principal.valueCharged.value = document.form_principal.valueCost.value;
	
}

//function Pesquisa2(){
//	document.form_1.nameProductComplete.value = document.form_3.unit_hidden.value;
//	alert("Pesquisa clicked! name: " + document.form_1.nameProductComplete.value);
//}

function PickDataForm(){
		document.form_envia.nameProductComplete.value = document.form_1.nameProductComplete.value;
		document.form_envia.nameProductAbbreviated.value = document.form_1.nameProductAbbreviated.value;
		document.form_envia.unit.value = document.form_1.unit.value;
		document.form_envia.quantity.value = document.form_1.quantity.value;
		document.form_envia.valueCost.value = document.form_1.valueCost.value;
		document.form_envia.valueCharged.value = document.form_1.valueCharged.value;
		document.form_envia.nameSupplier.value = document.form_1.nameSupplier.value;
		document.form_envia.description.value = document.form_2.obsProduct.value;
		document.form_envia.addressSupplier.value = document.form_2.addressSupplier.value;
		document.form_envia.phoneOneSupplier.value = document.form_2.phoneOneSupplier.value;
		document.form_envia.phoneTwoSupplier.value = document.form_2.phoneTwoSupplier.value;
		document.form_envia.emailSupplier.value = document.form_2.emailSupplier.value;
//		alert(
//				document.form_3.nameProductComplete.value + " " +
//				document.form_3.nameProductAbbreviated.value + " " +
//				document.form_3.unit.value + " " +
//				document.form_3.quantity.value + " " +
//				document.form_3.valueCost.value + " " +
//				document.form_3.valueCharged.value + " " +
//				document.form_3.nameSupplier.value + " " +
//				document.form_3.description.value + " " +
//				document.form_3.addressSupplier.value + " " +
//				document.form_3.phoneOneSupplier.value  + " " +
//				document.form_3.phoneTwoSupplier.value  + " " +
//				document.form_3.emailSupplier.value 
//		);
}

function ResetForm(){
	document.form_2.nameProductComplete.value = "";
	document.form_2.nameProductAbbreviated.value = "";
	document.form_2.unit.value = "";
	document.form_2.quantity.value = "";
	document.form_2.valueCost.value = "";
	document.form_2.valueCharged.value = "";
	document.form_2.nameSupplier.value = "";
	document.form_2.unit.value = "Null";
	
	document.form_4.addressSupplier.value = "";
	document.form_4.phoneOneSupplier.value = "";
	document.form_4.phoneTwoSupplier.value = "";
	document.form_4.emailSupplier.value = "";
	document.form_4.obsProduct.value = "";
}










