<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="utf-8">
<title>Meu Dinheiro - Lançamentos</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
</head>
<body>
	<c:import url="/pages/template/top-menu.jsp"></c:import>
	<div id="content" class="container">
		<div class="well">
			<div class="row-fluid">
				<div class="span12">
					<legend>
						<h3>Lançamentos</h3>
					</legend>
				</div>
			</div>

			<div class="row-fluid">
				<div class="span12">
					<label>Mês </label>
					<form class="form-inline">
						<div class="input-append date" id="dpMonths" data-date="" data-date-format="mm/yyyy" data-date-viewmode="years" data-date-minviewmode="months">
							<input id="inputDateMonth"size="16" type="text" value="">
							<span class="add-on"><i class="icon-calendar"></i></span>
				  		</div>
				  	<button id="ok" type="button" class="btn btn-primary" data-loading-text="Carregando...">Ok</button>
					</form>
				</div>
			</div>

			<div class="row-fluid">
				<div class="span12">
					<div class="btn-group">
						<button id="btnEntryCredit" class="btn btn-success">Lançar crédito</button>
						<button id="btnEntryDebit" class="btn btn-danger">Lançar débito</button>
					</div>
					<div class="pull-right">
						<div>
							<strong><p id="totalCredit" class="totalGreen" align="left">Total crédito: </p></strong>
						</div>
						<div>
							<strong><p id="totalDebit" class="totalRed" align="left">Total débito: </p></strong>
						</div>
						<div>
							<strong><p id="total" align="left">Total: </p></strong>
						</div>
					</div>
				</div>
			</div>
			<br />
			<div class="row-fluid">
				<div class="span12">
					<tags:table-tag id="table_entries" />
				</div>
			</div>
		</div>
	</div>
	<hr />
	<footer>
		<p>© Company 2013</p>
	</footer>

	<!-- Modal -->
	<tags:form-modal-tag></tags:form-modal-tag>

	<div id="confirmDeleteModal" class="modal hide fade">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h3>Aviso</h3>
		</div>
		<div class="modal-body">
			<p id="contentPopupDeleteEntry"></p>
		</div>
		<div class="modal-footer">
			<button class="btnClose btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
		    <button id="btnRemoveEntry" class="btn btn-primary">Sim</button>
		</div>
	</div>
	
	<!-- imports -->
	<link href="/css/bootstrap.css" rel="stylesheet">
	<tags:resource-tag type="css" value="bootstrap/css/bootstrap.min.css"></tags:resource-tag>
	<tags:resource-tag type="css" value="bootstrap/css/bootstrap-responsive.min.css"></tags:resource-tag>
	<tags:resource-tag type="css" value="css/datatable.css"></tags:resource-tag>
	<tags:resource-tag type="css" value="datatable/media/css/jquery.dataTables.css"></tags:resource-tag>
	<tags:resource-tag type="css" value="datepicker/css/datepicker.css"></tags:resource-tag>
	<tags:resource-tag type="css" value="css/application.css"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="js/jquery.js"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="datatable/media/js/jquery.dataTables.min.js"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="js/datatable.js"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="bootstrap/js/bootstrap.min.js"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="datepicker/js/bootstrap-datepicker.js"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="js/jquery.rest.js"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="js/maskmoney.js"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="js/application.js"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="js/application/entries/entry.js"></tags:resource-tag>
</body>
</html>