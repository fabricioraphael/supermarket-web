 $(document).ready(function() {
	 $("#pesquisar").click(function(){
		 var id = $("#idTxt").attr('value');
		 var nome = $("#nameTxt").attr('value');
		 var endereco = $("#addressTxt").attr('value');
		 
		 $.ajax({
		  url: 'searchregister.do',
		  type: 'POST',
		  data: 'idTxt='+id+'&nameTxt='+nome+'&addressTxt='+endereco,
		  
		  success: function(data) {
		    $('#resultado').html(data);
		  }
		});
 	});
 });