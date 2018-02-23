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
                        <h1 class="page-header">Fiche Commande</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Fiche de la commande CMD00001
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="form-group">
                                    <label>Client</label>
                                    <input name="client" class="form-control" value="WAWA" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Date début</label>
                                    <input name="dateDebut" class="form-control" type="date" value="2017-01-01" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Date Fin</label>
                                    <input name="dateFin" class="form-control"  type="date" value="2017-01-01" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Etat :</label>
                                    <label class="checkbox-inline">
                                        <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-check"></i></button>Reçu par le client
                                    </label>
                                    <label class="checkbox-inline">
                                        <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-check"></i></button>Annulé
                                    </label>
                                    <label class="checkbox-inline">
                                        <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-times"></i></button>efa niverina taty @ stock
                                    </label>
                                </div>
                                <a class="btn btn-success pull-right">Payer la commande</a>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Liste des commandes</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <%@include file="/template/Success.jsp" %>
                                        <%@include file="/template/Erreur.jsp" %>
                                        <tr>
                                            <th>R&eacute;f.</th>
                                            <th>Désignation</th>
                                            <th>Qte.</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="odd gradeX">
                                            <td> STO0001 </td>
                                            <td> Baffle </td> 
                                            <td><span class="pull-right"> 5</span></td>
                                        </tr>
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
