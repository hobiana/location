<%-- 
    Document   : essai
    Created on : 24 janv. 2018, 21:24:27
    Author     : Hobiana
--%>


<!DOCTYPE html>
<%@taglib  prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title><s:property value="titre" /></title>
        <%@include file="/template/css.jsp" %>
        <link href="vendor/datatables/css/dataTables.bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div id="wrapper">
            <%@include file="/template/header.jsp" %>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Modification du stock <s:property value="stock.reference" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Modification du stock > <s:property value="stock.designation" />
                            </div>
                            <%@include file="/template/Erreur.jsp" %>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <form action="modifStock">
                                    <div class="form-group">
                                        <label>Référence</label>
                                        <input name="reference" class="form-control" placeholder="Référence" value="<s:property value="stock.reference" />">
                                    </div>
                                    <div class="form-group">
                                        <label>Désignation</label>
                                        <input name="designation" class="form-control" placeholder="Désignation" value="<s:property value="stock.designation" />">
                                    </div>
                                    <div class="form-group">
                                        <label>Prix de Location unitaire (Ariary)</label>
                                        <input name="prixLocation" type="number" min="2000" class="form-control" placeholder="Prix de Location" value="<s:property value="stock.prixLocation" />">
                                    </div>
                                    <div class="form-group">
                                        <label>Prix de casse unitaire (Ariary)</label>
                                        <input name="prixCasse" class="form-control" placeholder="Prix de Casse" type="number" value="<s:property value="stock.prixCasse" />">
                                    </div>
                                    <input name="idStock" type="hidden" value="<s:property value="stock.id" />"/>
                                    <button type="submit" class="btn btn-default">Modifier</button>
                                </form>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
            </div> 
        </div>
    </body>
    <%@include file="/template/footer.jsp" %>
</html>
