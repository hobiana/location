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
                        <h1 class="page-header">Nouvel Commande</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Liste des stocks</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <a 
                                        class="btn btn-default" 
                                        style="margin-bottom:15px"
                                        href="#ajoutClient" data-toggle="modal">
                                        Ajouter le stock
                                    </a>
                                    <%@include file="/template/Success.jsp" %>
                                    <%@include file="/template/Erreur.jsp" %>
                                    <div class="modal fade" id="ajoutClient" role="dialog">
                                        <div class="modal-dialog modal-md">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <form method="POST">
                                                    <div class="modal-header backg-brw">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title">Ajouter un client</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <label>Désignation</label>
                                                            <input name="designation" class="form-control" placeholder="Désignation">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Prix d'Achat</label>
                                                            <input name="prixAchat" class="form-control" placeholder="Prix d'Achat" type="number">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Prix de Location</label>
                                                            <input name="prixLocation" class="form-control" placeholder="Prix de Location" type="number">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Quantit&eacute;</label>
                                                            <input name="quantite" class="form-control" placeholder="Adresse" type="number">
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Annuler</button>
                                                        <button class="btn base-background pull-right">Ajouter</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <tr>
                                        <th>R&eacute;f.</th>
                                        <th>D&eacute;signation</th>
                                        <th>Prix de Location (Ariary)</th>
                                        <th>Quantités</th>
                                        <th>Entrée</th>
                                        <th>Sortie</th>
                                        <th>Modifier</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="odd gradeX">
                                            <td> REF0001 </td>
                                            <td> Assiette ronde </td> 
                                            <td><span class="pull-right">50 000</span></td>
                                            <td><span class="pull-right">100</span></td>
                                            <td class="center">
                                                <a type="button" 
                                                   class="btn btn-success btn-circle center-block"
                                                   href="inStock?idStock=1">
                                                    <i class="fa fa-sign-in"></i>
                                                </a>
                                            </td>
                                            <td class="center">
                                                <a type="button" 
                                                   class="btn btn-warning btn-circle center-block"
                                                   href="outStock?idStock=1">
                                                    <i class="fa fa-sign-out"></i>
                                                </a>
                                            </td>
                                            <td>
                                                <a type="button" 
                                                   class="btn btn-default center-block" 
                                                   href="updateStock?idStock=1">
                                                    <i class="fa fa-edit"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
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
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <%@include file="/template/Success.jsp" %>
                                    <%@include file="/template/Erreur.jsp" %>
                                    <tr>
                                        <th>R&eacute;f.</th>
                                        <th>D&eacute;signation</th>
                                        <th>Prix de Location (Ariary)</th>
                                        <th>Quantités</th>
                                        <th>Entrée</th>
                                        <th>Sortie</th>
                                        <th>Modifier</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="odd gradeX">
                                            <td> REF0001 </td>
                                            <td> Assiette ronde </td> 
                                            <td><span class="pull-right">50 000</span></td>
                                            <td><span class="pull-right">100</span></td>
                                            <td class="center">
                                                <a type="button" 
                                                   class="btn btn-success btn-circle center-block"
                                                   href="inStock?idStock=1">
                                                    <i class="fa fa-sign-in"></i>
                                                </a>
                                            </td>
                                            <td class="center">
                                                <a type="button" 
                                                   class="btn btn-warning btn-circle center-block"
                                                   href="outStock?idStock=1">
                                                    <i class="fa fa-sign-out"></i>
                                                </a>
                                            </td>
                                            <td>
                                                <a type="button" 
                                                   class="btn btn-default center-block" 
                                                   href="updateStock?idStock=1">
                                                    <i class="fa fa-edit"></i>
                                                </a>
                                            </td>
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
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
    </script>
</html>
