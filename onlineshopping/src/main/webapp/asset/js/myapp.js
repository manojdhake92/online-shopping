$(function(){
	//Solving Active Menu Problem
	switch(menu) {
		case  'About Us':
				$('#about').addClass('active');
				break;
		case  'Contact Us':
			$('#contact').addClass('active');
			break;
		default:
			$('#viewProducts').addClass('active');
			$('#act_'+menu).addClass('active');
			break;
	}
	
	
	
});