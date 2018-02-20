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
                        <h1 class="page-header">Nouvelle Commande</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Commandes</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="panier">
                                    <thead>
                                    <div class="row">
                                        <%@include file="/template/Success.jsp" %>
                                        <%@include file="/template/Erreur.jsp" %>
                                        <form action="verifierDate">
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <label>Dates de début de la commande</label>
                                                </div>
                                                <div class="col-md-12">
                                                    <input name="dateDebut" class="form-control" placeholder="Date Min" type="date" value="<s:property value="dateDebut"/>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <label>Dates de fin de la commande</label>
                                                </div>
                                                <div class="col-md-12">
                                                    <input name="dateFin" class="form-control" placeholder="Date Max" type="date" value="<s:property value="dateFin"/>">
                                                </div>
                                            </div>
                                        </form>
                                        <button style="margin-top: 10px;margin-right: 15px" type="submit" class="btn btn-warning pull-right">Vérifier les dates</button>
                                    </div>
                                    <hr>
                                    <%@include file="/template/Success.jsp" %>
                                    <%@include file="/template/Erreur.jsp" %>
                                    <tr>
                                        <th>#</th>
                                        <th>D&eacute;signation</th>
                                        <th>Location (Ariary/Unité)</th>
                                        <th>Qte</th>
                                        <th>Desc.</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="odd gradeX">
                                            <td> <a href="deleteCommande" style="color: red"><i class="fa fa-close" ></i></a> </td>
                                            <td> Assiette ronde </td> 
                                            <td><span class="pull-right">50 000</span></td>
                                            <td><span class="pull-right">100</span></td>
                                            <td><span class="pull-right"> stock insuffisant</span></td>
                                            <form action="modifCommande">
                                                <td><span class="pull-right"><input name="quantite" class="input-sm" type="number" min="0" value="5" style="width: 75px"></span></td>
                                                <td><a class="btn btn-default btn-sm"><i class="fa fa-plus"></i></a></td>
                                            </form>
                                        </tr>
                                    </tbody>
                                </table>
                                <a class="btn btn-success pull-right" href="saveCommande?idClient=1&dateDebut=2017-01-01&dateFin=2017-02-01">Valider la commande</a>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-6 -->
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Liste des stocks</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="stock">
                                    <thead>
                                        <tr>
                                            <th>D&eacute;signation</th>
                                            <th>Location (Ariary/unité)</th>
                                            <th>Qte</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="odd gradeX">
                                            <td> Assiette ronde </td> 
                                            <td><span class="pull-right">50 000</span></td>
                                    <form action="addCommande">
                                        <td><span class="pull-right"><input name="quantite" class="input-sm" type="number" min="0" style="width: 75px" ></span></td>
                                        <td><a class="btn btn-default btn-sm"><i class="fa fa-plus"></i><i class="fa fa-shopping-cart"></i></a></td>
                                    </form>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-6 -->
                </div>
            </div> 
        </div>
    </body>
    <%@include file="/template/footer.jsp" %>
    <script src="vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/js/dataTables.bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#panier').DataTable({
                responsive: true,
                "paging": false
            });
        });
        $(document).ready(function () {
            $('#stock').DataTable({
                responsive: true
            });
        });
    </script>
</html>
