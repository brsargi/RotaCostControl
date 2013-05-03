$(document).ready(function() {

	Entry.init();
});

var Entry = new function(){
	
	var totalCredit = 0.0;
	var totalDebit = 0.0;
	var total = 0.0;

	var entryJSON = null;
	var ok = null;
	var formEntryModal = null;
	var btnEntryCredit = null;
	var btnEntryDebit = null;
	var btnSaveEntry = null;
	var formEntryTitle = null;
	var inputNome = null;
	var dateEntry = null;
	var inputCategoria = null;
	var inputValor = null;
	var hiddenIdEntry = null;
	var entryType = null;
	var entryTable = null;
	var inputDateMonth = null;
	var confirmDeleteModal = null;
	var btnRemoveEntry = null;
	var entryId = null;
	var btnClose = null;
	
	var alertErrorValidation = null;
	
	this.init = function(){
		
		Entry.initVariable();
		
		Entry.refreshEntries();
		
		Entry.openModalCreditEntry();
		
		Entry.openModalDebitEntry();
		
		Entry.saveEntry();

		inputDateMonth.val(Entry.getFormatMonthDate(new Date()));
		
		Entry.initTable();
		
		Entry.removeEntry();
		
		Entry.closeForm();
		
		Entry.categoryAutoComplete();
	};
	
	this.initVariable = function(){
		
		ok = $("#ok");		
		
		formEntryModal = $("#formEntryModal");
		
		btnEntryCredit = $("#btnEntryCredit");
		
		btnEntryDebit = $("#btnEntryDebit");
		
		btnSaveEntry = $("#btnSaveEntry");

		dateEntry = $("#dateEntry").datepicker();
		
		$("#dpMonths").datepicker();
		
		formEntryTitle = $('#formEntryTitle');
		
		inputNome = $('#inputNome');
		
		inputCategoria = $('#inputCategoria');
		
		inputValor = $('#inputValor');
		
	    inputValor.maskMoney({showSymbol:true, decimal:",", thousands:""});
		
		hiddenIdEntry = $('#hiddenIdEntry');
		
		entryType = $('#entryType');
		
		inputDateMonth = $('#inputDateMonth');
		
		confirmDeleteModal = $('#confirmDeleteModal');
		
		btnRemoveEntry = $('#btnRemoveEntry');
		
		btnClose = $('.btnClose');
				
		alertErrorValidation = $('#alertErrorValidation');
	};
	
	this.convertToDouble = function(valor){
		
		return Number(valor.replace(",", "."));
	};
	
	this.refreshEntries = function(){

		ok.click(function(event) {
			
			Entry.reloadTable();
		});
	};	
	
	this.openModalCreditEntry = function(){
		
		btnEntryCredit.click(function(event){
			
			entryType.val('CREDIT');
			
			formEntryTitle.text("Lançar crédito");
			
			dateEntry.val(Entry.getFormatFullDate(new Date()));
			
    		alertErrorValidation.addClass("hide");
			
			formEntryModal.modal('show');
		});
	};
	
	this.openModalDebitEntry = function(){
		
		btnEntryDebit.click(function(event){
						
			entryType.val('DEBIT');
			
			formEntryTitle.text("Lançar débito");
			
			dateEntry.val(Entry.getFormatFullDate(new Date()));
			
    		alertErrorValidation.addClass("hide");
			
			formEntryModal.modal('show');
		});
		
	};
	
	this.saveEntry = function(){
		
		btnSaveEntry.click(function(event){
		
			if(hiddenIdEntry.val() > 0){
				
				Entry.update();
			}else{
				
				Entry.create();		
			}
		});
	};
	
	this.getFormatFullDate = function(date){
		
		return date.getDate() + "/" + (date.getMonth()+1) + "/" + date.getFullYear(); 
	};
	
	this.getFormatMonthDate = function(date){
		
		var month = ""+(date.getMonth()+1);
		
		if(month.length > 1){
			
			return month + "/" + (date.getFullYear()); 
		}else{
			
			return "0"+month + "/" + (date.getFullYear()); 
		}
		
	};
	
	this.formatUrlDate = function(){
		
			return inputDateMonth.val().replace("/", "-");
	};
	
	this.create = function(){
		
		var entry = new Object();
		entry.id = '';
		entry.name = inputNome.val();
		entry.cost = Entry.convertToDouble(inputValor.val());
		entry.date = dateEntry.val();
		entry.type = entryType.val();
		entry.categoryName = inputCategoria.val();
		
		var entryJSON = JSON.stringify(entry);

		$.ajax({
		    type: "POST",
		    dataType: "json",
		    url: Application.getContext()+"/rest/entry",
		    contentType: "application/json; charset=utf-8",
		    data: entryJSON,
		    success: function (result) {
		        		    	
		    	if(result.status == 'success'){
		    		
		    		//entryTable.fnAddData(result.entry);
		    		
		    		var type = result.entry.type;
		    		
		    		if(type == "CREDIT"){
		    			
		    			totalCredit = totalCredit + result.entry.cost;
		    			
		    			type = "<p class='totalGreen'>Crédito</p>";
		    		}else{
		    			
		    			totalDebit = totalDebit + result.entry.cost;
		    			
		    			type = "<p class='totalRed'>Débito</p>";
		    		}	
		    				    		
		    		entryTable.fnAddData([result.entry.name,
		    		                     result.entry.categoryName,
		    		                     type,
		    		                     Number(result.entry.cost).toFixed(2),
		    		                     result.entry.date,
		    		                     "<a class='edit' onClick='Entry.openEditEntry("+result.entry.id+")'>Editar</a>",
			    		                 "<a class='remove' onClick='Entry.openPopupRemoveEntry("+result.entry.id+")'>Remover</a>"]);
		    		
		    		total = totalCredit - totalDebit;
		    		
		    		Entry.changeColorTotal();
		    	
		    		Entry.clearForm();
					
					formEntryModal.modal('hide');

		    	}else{
		
		    		alertErrorValidation.removeClass("hide");
		    	}
		    }
		});
	};
	
	this.closeForm = function(){
		
		Entry.clearForm();
		
		formEntryModal.modal('hide');	
	};
	
	this.changeColorTotal = function(){
		
		$("#totalCredit").text("Total crédito: R$ " + totalCredit.toFixed(2));
		$("#totalDebit").text("Total débito: R$ " + totalDebit.toFixed(2));
		$("#total").text("Total: R$ " + total.toFixed(2));
		
		if(total < 0){
			
			$("#total").removeClass("totalGreen");
			$("#total").addClass("totalRed");
		}else{
			$("#total").removeClass("totalRed");
			$("#total").addClass("totalGreen");
		}
	};
	
	this.update = function(){
		
		var entry = new Object();
		entry.id = hiddenIdEntry.val();
		entry.name = inputNome.val();
		entry.cost = Entry.convertToDouble(inputValor.val());
		entry.date = dateEntry.val();
		entry.type = entryType.val();
		entry.categoryName = inputCategoria.val();
		
		var entryJSON = JSON.stringify(entry);

		$.ajax({
		    type: "PUT",
		    dataType: "json",
		    url: Application.getContext()+"/rest/entry",
		    contentType: "application/json; charset=utf-8",
		    data: entryJSON,
		    success: function (result) {
		        
		    	if(result.status == 'success'){
		    			
		    		Entry.reloadTable();
		    		
		    		Entry.clearForm();
					
					formEntryModal.modal('hide');
		    	}else{
		    		
		    		alertErrorValidation.removeClass("hide");
		    	}
		    }
		});
	};
	
	this.clearForm = function(){
		
		hiddenIdEntry.val('');
		inputNome.val('');
		inputValor.val('');
		dateEntry.val('');
		entryType.val('');
		inputCategoria.val('');
	};
	
	this.loadListEntries = function(){
		
		$.ajax({
		    type: "POST",
		    dataType: "text",
		    url: Application.getContext()+"/rest/list",
		    contentType: "text; charset=utf-8",
		    data: entryJSON,
		    success: function (result) {
		        alert(result.status);
		    }
		});
	};
	
	this.initTable = function(){
		 
		entryTable = $('#table_entries').dataTable({
			"sDom" : "<'row'<'span6'l><'span6'f>r>t<'row'<'span6'i><'span6'p>>",
			"sPaginationType" : "bootstrap",
			"aaSorting": [[4 , "asc" ]],
			"oLanguage" : {
						"oPaginate" : {
										"sNext" : "Próximo",
										"sPrevious" : "Anterior",
										"sLengthMenu" : "_MENU_ Lançamentos por página",
										"sSearch" : "Pesquisar",
										"sInfo" : "Total: _END_ lançamentos",
										"sInfoEmpty" : "Sem lançamentos"
		 	            }
			},
			"bJQueryUI": true,
			"bLengthChange": true,
			//"sAjaxSource": "/RotaCostControl/rest/entry/list/"+Entry.formatUrlDate(),
			//"sAjaxDataProp": "entries",
			"aoColumns": [
				null,
				null,
				null,
				null,
				null,
				{ "sClass" : "center" },
				{ "sClass" : "center" }
				
			],
	    });
		
		Entry.loadTable();
	};
	
	this.loadTable = function(){
		
		$.read(Application.getContext()+'/rest/entry/list/'+Entry.formatUrlDate(), function(response) {
			
			if(response.status == 'success') {
				
				totalCredit = 0.0;
				totalDebit = 0.0;
				
				var entries = response.entries;
				
				for(i in entries){
					
					var type = entries[i].type;
		    		
		    		if(type == "CREDIT"){
		    			totalCredit = totalCredit + entries[i].cost;
		    			type = "<p class='totalGreen'>Crédito</p>";
		    		}else{
		    			totalDebit = totalDebit + entries[i].cost;
		    			type = "<p class='totalRed'>Débito</p>";
		    		}
					
					entryTable.fnAddData([entries[i].name,
			    		                  entries[i].categoryName,
			    		                  type,
			    		                  Number(entries[i].cost).toFixed(2),
			    		                  entries[i].date,
			    		                  "<a class='edit' onClick='Entry.openEditEntry("+entries[i].id+")'>Editar</a>",
			    		                  "<a class='remove' onClick='Entry.openPopupRemoveEntry("+entries[i].id+")'>Remover</a>"]);
					
				};
				
				total = totalCredit - totalDebit;
				
				Entry.changeColorTotal();
			};
		});
	};
	
	this.openEditEntry = function(id){

		$.read(Application.getContext()+'/rest/entry/'+id, function(response) {
			
			if(response.status == 'success') {
				
				var entry = response.entry;
		
				formEntryTitle.text("Atualizar lançamento");
				
				hiddenIdEntry.val(entry.id);
				inputNome.val(entry.name);
				inputValor.val(entry.cost);
				dateEntry.val(entry.date);
				entryType.val(entry.type);
				inputCategoria.val(entry.categoryName);
				
	    		alertErrorValidation.addClass("hide");
				
				formEntryModal.modal('show');
			}
		});
	};
	
	this.openPopupRemoveEntry = function(id, name){
		
		entryId = id;
		
		$('#contentPopupDeleteEntry').text("Deseja remover o lançamento ?");
		
		confirmDeleteModal.modal("show");
	};
	
	this.removeEntry = function(){
		
		btnRemoveEntry.click(function(event){
		
			$.destroy({
				  url: Application.getContext()+'/rest/entry/delete/'+entryId,
				  success: function (response) {
				    
					  if(response.status == 'success'){
						
						  Entry.reloadTable();
					  }
				  }
			});
			
			confirmDeleteModal.modal('hide');
		});
	};
	
	this.reloadTable = function() {
		
		entryTable.fnClearTable();
		
		Entry.loadTable();
	};	
	
	this.closeForm = function(){
		
		btnClose.click(function(){
						
			Entry.clearForm();
		});
	};
	
	this.categoryAutoComplete = function() {

		inputCategoria.typeahead({
			source: function (query, process) {
				return $.ajax({
					url: Application.getContext()+"/rest/category/list",
					dataType: "json",
					success: function(data) {

						var arrayResult = [];

						$.map(data.categories, function(item){
							arrayResult.push(item.name);
						});

						return process($(arrayResult));						
					}
				});
		    },
		    minLength: 3,
		    items: 10
		});

	}; //END function "initFields"
};