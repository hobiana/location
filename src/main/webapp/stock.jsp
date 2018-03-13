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
                        <h1 class="page-header">Stocks</h1>
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
                                <form role="form" action="stock">
                                    <div class="form-group">
                                        <label>Désignation</label>
                                        <input name="designation" class="form-control" placeholder="Désignation" value="<s:property value="getDesignation()"/>">
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <label>Prix de Location unitaire Min / Max</label>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <input name="prixLocationMin" class="form-control" min="0" placeholder="Prix de Location Min" type="number"value="<s:property value="prixLocationMin"/>">
                                            </div>
                                            <div class="col-md-6">
                                                <input name="prixLocationMax" class="form-control" min="0" placeholder="Prix de Location Max" type="number" value="<s:property value="prixLocationMax"/>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <label>Quantités Min / Max</label>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <input name="quantiteMin" class="form-control" min="0" placeholder="Quantité Min" type="number" value="<s:property value="quantiteMin"/>">
                                            </div>
                                            <div class="col-md-6">
                                                <input name="quantiteMax" class="form-control" min="0" placeholder="Quantité Max" type="number" value="<s:property value="quantiteMax"/>">
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
                                                <form method="POST" action="newStock">
                                                    <div class="modal-header backg-brw">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title">Ajouter stock</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <label>Désignation</label>
                                                            <input name="designation" class="form-control" placeholder="Désignation">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Prix d'Achat unitaire</label>
                                                            <input name="prixAchat" class="form-control" placeholder="Prix d'Achat" type="number">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Prix de Location unitaire</label>
                                                            <input name="prixLocation" class="form-control" placeholder="Prix de Location" type="number">
                                                        </div>    
                                                        <div class="form-group">
                                                            <label>Prix de casse unitaire</label>
                                                            <input name="prixCasse" class="form-control" placeholder="Prix de Casse" type="number">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Quantit&eacute;</label>
                                                            <input name="quantite" class="form-control" placeholder="Quantité" type="number">
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Annuler</button>
                                                        <button class="btn btn-default base-background pull-right">Ajouter</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <tr>
                                        <th>R&eacute;f.</th>
                                        <th>D&eacute;signation</th>
                                        <th>Location (Ariary/unite)</th>
                                        <th>Qte</th>
                                        <th>Entrée</th>
                                        <th>Sortie</th>
                                        <th>Modifier</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listeStock">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="getRef()"  /> </td>
                                                <td> <s:property value="designation"  /> </td> 
                                                <td><span class="pull-right"><s:property value="getPL()"  /></span></td>
                                                <td><span class="pull-right"><s:property value="quantite()"  /></span></td>
                                                <td class="center">
                                                    <a type="button" 
                                                       class="btn btn-success btn-circle center-block"
                                                       href="inStock?idStock=<s:property value="id"  />">
                                                        <i class="fa fa-sign-in"></i>
                                                    </a>
                                                </td>
                                                <td class="center">
                                                    <a type="button" 
                                                       class="btn btn-warning btn-circle center-block"
                                                       href="outStock?idStock=<s:property value="id"  />">
                                                        <i class="fa fa-sign-out"></i>
                                                    </a>
                                                </td>
                                                <td>
                                                    <a type="button" 
                                                       class="btn btn-default center-block" 
                                                       href="toupdateStock?idStock=<s:property value="id"  />">
                                                        <i class="fa fa-edit"></i>
                                                    </a>
                                                </td>
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
