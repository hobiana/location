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
                        <h1 class="page-header">Liste des entrées de stocks</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Recherche avancée
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <form role="form">
                                    <div class="form-group">
                                        <label>Désignation</label>
                                        <input name="designation" class="form-control" placeholder="Désignation" value="<s:property value="getDesignation()"/>">
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <label>Prix d'Achat Min / Max</label>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <input name="prixAchatMin" class="form-control" placeholder="Prix d'Achat Min" type="number" min="0" value="<s:property value="prixAchatMin"/>">
                                            </div>
                                            <div class="col-md-6">
                                                <input name="prixAchatMax" class="form-control" placeholder="Prix d'Achat Max" type="number" min="0" value="<s:property value="prixAchatMax"/>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <label>Quantités Min / Max</label>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <input name="quantiteMin" class="form-control" placeholder="Quantité Min" type="number" min="0" value="<s:property value="quantiteMin"/>">
                                            </div>
                                            <div class="col-md-6">
                                                <input name="quantiteMax" class="form-control" placeholder="Quantité Max" type="number" min="0" value="<s:property value="quantiteMax"/>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <label>Dates  Min / Max</label>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <input name="dateMin" class="form-control" placeholder="Date Min" type="date" value="<s:property value="dateMin"/>">
                                            </div>
                                            <div class="col-md-6">
                                                <input name="dateMax" class="form-control" placeholder="Date Max" type="date" value="<s:property value="dateMax"/>">
                                            </div>
                                        </div>
                                    </div>
                                    <button style="margin-top: 15px;" type="submit" class="btn btn-default">Rechercher</button>
                                </form>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Liste des stocks</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <%@include file="/template/Success.jsp" %>
                                        <%@include file="/template/Erreur.jsp" %>
                                        <tr>
                                            <th>R&eacute;f.</th>
                                            <th>D&eacute;signation</th>
                                            <th>Prix d'Achat (Ariary)</th>
                                            <th>Quantités</th>
                                            <th>Date</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listeEntree">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="getRef()"  /> </td>
                                                <td> <s:property value="stock.designation"  /> </td> 
                                                <td><span class="pull-right"><s:property value="prixAchat()"  /></span></td>
                                                <td><span class="pull-right"><s:property value="quantite()"  /></span></td>
                                                <td><span class="pull-right"><s:property value="getDateString()"  /></span></td>
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
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
    <script src="vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/js/dataTables.bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
    </script>
</html>
