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
                        <h1 class="page-header"><s:property value="title_page" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <s:property value="title_panel" />
                            </div>
                            <%@include file="/template/Erreur.jsp" %>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <form action="<s:property value="action" />">
                                    <div class="form-group">
                                        <label>Quantités</label>
                                        <input name="quantite" type="number" min="1" class="form-control" placeholder="Quantités" value="">
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <input name="description" class="form-control" placeholder="Description" >
                                    </div>
                                    <s:if test="action.equals('ajoutStock')">
                                        <div class="form-group">
                                            <label>Prix d'Achat unitaire (Ariary)</label>
                                            <input name="prixAchat" type="number" min="0" class="form-control" placeholder="Prix d'Achat">
                                        </div>
                                    </s:if>
                                    <input name="idStock" type="hidden" value="<s:property value="idStock" />"/>
                                    <button type="submit" class="btn btn-default">Ajouter</button>
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
