$(document).ready(function(){
								
	// Invoke when type radio button is changed
	$('input:radio[name="type"]').change(function(){	

		if($(this).val() == 'M'){														
			alert('M');
		}
		if($(this).val() == 'BU'){														
			alert('BU');
		}
	});				 
});