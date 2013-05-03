$(document).ready(function() {

	Account.init();
});

var Account = new function(){
	
	var inputEmail = null;
	var inputConfirmEmail = null;
	var inputPassword = null;
	var inputConfirmPassword = null;
	var inputEmailMessage = null;
	var inputConfirmEmailMessage = null;
	var inputPasswordMessage = null;
	var inputConfirmPasswordMessage = null;
	var emailControlGroup = null;
	var confirmEmailControlGroup = null;
	var passwordControlGroup = null;
	var confirmPasswordControlGroup = null;
	var btnCreateAccount = null;
	var createAccountSuccess = null;
	
	this.init = function(){
		
		inputEmail = $('#inputEmail');
		
		inputConfirmEmail = $('#inputConfirmEmail');
		
		inputPassword = $('#inputPassword');
		
		inputConfirmPassword = $('#inputConfirmPassword');
		
		inputEmailMessage = $('#inputEmailMessage');
		
		inputConfirmEmailMessage = $('#inputConfirmEmailMessage');
		
		inputPasswordMessage = $('#inputPasswordMessage');
		
		inputConfirmPasswordMessage = $('#inputConfirmPasswordMessage');
		
		emailControlGroup = $('#emailControlGroup');
		
		confirmEmailControlGroup = $('#confirmEmailControlGroup');
		
		passwordControlGroup = $('#passwordControlGroup');
		
		confirmPasswordControlGroup = $('#confirmPasswordControlGroup');
		
		btnCreateAccount = $('#btnCreateAccount');
		
		createAccountSuccess = $('#createAccountSuccess');
		
		Account.createAccount();
	};
	
	this.createAccount = function(){
		
		btnCreateAccount.click(function(event){
			
			Account.clearValidation();
			
			if(Account.validateForm() == true){
				
				Account.createUser();
			}
		});
	};
	
	this.createUser = function(){
		
		$.create(
				  Application.getContext()+"/rest/user",
				  { email: inputEmail.val(),
					password : inputPassword.val()  },
				  
					function (response) {
					
						if(response.status == 'success'){
													
							createAccountSuccess.removeClass('hide');
						}else{
							
							if(response.message == 'exist'){
								
								alert("Email já cadastrado em nossa base.");
								
							}else if(response.message == 'email'){
								
								alert("Falha ao enviar email. Por favor tente mais tarde.");
							}else if(response.message == 'validation'){
								
								alert("Erro de validação de dados. Favor fornecer dados válidos");
							}
								
						}
					}
		);
	};
	
	this.validateForm = function(){
		
		var result = true;
		
		if(inputEmail.val() == null || inputEmail.val() == ""){
			
			emailControlGroup.addClass('error');
			inputEmailMessage.text("O email é obrigatório");
			inputEmailMessage.removeClass("hide");
			result = false;
		}
		
		if(inputConfirmEmail.val() == null || inputConfirmEmail.val() == ""){
			
			confirmEmailControlGroup.addClass('error');
			inputConfirmEmailMessage.text("A confirmação do email é obrigatória");
			inputConfirmEmailMessage.removeClass("hide");
			
			result = false;
		}
		
		if(inputPassword.val() == null || inputPassword.val() == ""){
			
			passwordControlGroup.addClass('error');
			inputPasswordMessage.text("A senha é obrigatória"); 
			inputPasswordMessage.removeClass("hide");
			
			result = false;
		}
		
		if(inputConfirmPassword.val() == null || inputConfirmPassword.val() == ""){
			
			confirmPasswordControlGroup.addClass('error');
			inputConfirmPasswordMessage.text("A confirmação da senha é obrigatória");
			inputConfirmPasswordMessage.removeClass("hide");
			
			result = false;
		}
		
		if(inputConfirmEmail.val() != inputEmail.val()){
			
			confirmEmailControlGroup.addClass('error');
			inputConfirmEmailMessage.text("O email de confirmação está diferente");
			inputConfirmEmailMessage.removeClass("hide");
			
			result = false;
		}
		
		if(inputConfirmPassword.val() != inputPassword.val()){
			
			confirmPasswordControlGroup.addClass('error');
			inputConfirmPasswordMessage.text("A senha está diferente");
			inputConfirmPasswordMessage.removeClass("hide");
			
			result = false;
		}
		
		return result;
	};
	
	this.clearValidation = function(){
		
		emailControlGroup.removeClass('error');
		inputEmailMessage.addClass("hide");
		
		confirmEmailControlGroup.removeClass('error');
		inputConfirmEmailMessage.addClass('hide');
		
		passwordControlGroup.removeClass('error');
		inputPasswordMessage.addClass('hide');
		
		confirmPasswordControlGroup.removeClass('error');
		inputConfirmPasswordMessage.addClass('hide');
	};
};