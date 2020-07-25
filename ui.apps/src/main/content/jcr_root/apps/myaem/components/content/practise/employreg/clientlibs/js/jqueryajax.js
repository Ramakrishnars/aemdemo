$(document).ready(function (){
	$('#btn').click(function(){


$.ajax({
	    type: 'POST',
	    url: '/bin/employreg',
	    data: {empid:empid,empname:empname,empsal:empsal,empaddr:empaddr},
	    success: function (result) {
	        alert('Sucees Jquey Cal');
	    }
		
		
	});
  });
	});