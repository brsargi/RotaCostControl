<%@ tag language="java" pageEncoding="UTF-8"%>

<div id="formEntryModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	  	<input type="hidden" name="entryType" id="entryType" />
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="formEntryTitle">Lançar crédito</h3>
	  </div>
			
		<div class="modal-body">
			<div id="alertErrorValidation" class="alert alert-error hide">
  				<p id="messageErrorValidation">Valores inválidos no formulário. Favor preencher com valores corretos.</p>
			</div>
			
			<div class="form-horizontal">
				<input type="hidden" id="hiddenIdEntry"/>
				<div id="categoriaCG" class="control-group">
					<label class="control-label" for="inputNome">Categoria</label>
					<div class="controls">
						<input type="text" id="inputCategoria" placeholder="Categoria">
					</div>
				</div>
				
				<div id="nomeCG" class="control-group">
					<label class="control-label" for="inputNome">Nome</label>
					<div class="controls">
						<input type="text" id="inputNome" placeholder="Nome">
					</div>
				</div>
				<div id="valorCG" class="control-group">
					<label class="control-label" for="inputValor">Valor</label>
					<div class="controls">
						<input type="text" id="inputValor" placeholder="Valor">
					</div>
				</div>
				<div id="dataCG" class="control-group">
					<label class="control-label" for="inputData">Data</label>
					<div class="controls">
						<input type="text" value="" data-date-format="dd/mm/yyyy" id="dateEntry">
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
		    <button class="btnClose btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
		    <button id="btnSaveEntry" class="btn btn-primary">Salvar</button>
	 	</div>
	</div>