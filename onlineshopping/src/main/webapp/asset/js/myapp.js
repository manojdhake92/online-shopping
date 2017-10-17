$(function(){
	//Solving Active Menu Problem
	switch(menu) {
		case  'About Us':
				$('#about').addClass('active');
				break;
		case  'Contact Us':
			  $('#contact').addClass('active');
			  break;
			
		case  'Manage Product':
			  $('#ManageProduct').addClass('active');
			  break;
			  
		case  'AllProducts':
			  $('#viewProducts').addClass('active');
			  break;
			
		default:
			$('#act_'+menu).addClass('active');
			break;
	}
	
	
	
});