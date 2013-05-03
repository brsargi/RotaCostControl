$(document).ready(function() {

	MenuSite.init();
});

var MenuSite = new function(){
	
	var menuHome = null;
	var menuAccount = null;
	var menuContact = null;
	
	this.init = function(){
		
		menu = $('.interactive_menu');
		
		menuHome = $('#home');
		
		menuAccount = $('#account');
		
		menuContact = $('#contact');
		
		MenuSite.selectMenuByPage();
	};
	
	this.selectMenuByPage = function(){
		
		var arrayPage = window.location.toString().split("/");
		
		var page = arrayPage[arrayPage.length-1];
		
		if(page == 'index.jsp'){
			
			menuHome.addClass("active");

		}else if(page == 'create-account.jsp'){
			
			menuAccount.addClass("active");

		}else if(page == 'contact.jsp'){
			
			menuContact.addClass("active");
		}else{
			
			menuHome.addClass("active");
		}
	};
};