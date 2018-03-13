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
        <link href="js/bootstrap-toggle.min.css" rel="stylesheet">
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
                                Fiche de la commande <s:property value="commande.getRef()"/>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="form-group">
                                    <label>Client</label>
                                    <input name="client" class="form-control" value="<s:property value="commande.getClient().getPrenom()"/> <s:property value="commande.getClient().getNom()"/>" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Date début</label>
                                    <input name="dateDebut" class="form-control" type="date" value="<s:property value="commande.dateDebut()"/>" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Date Fin</label>
                                    <input name="dateFin" class="form-control"  type="date" value="<s:property value="commande.dateFin()"/>" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Etat :</label>
                                    <label class="checkbox-inline">
                                        <s:if test="commande.isRecu()==false">
                                            <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-times"></i></button> Non reçu par le client
                                        </s:if>
                                        <s:else>
                                            <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-check"></i></button> Reçu par le client
                                        </s:else>
                                         
                                    </label>
                                    <label class="checkbox-inline">
                                        <s:if test="commande.isAnnule()==false">
                                            <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-times"></i></button> Non annulé
                                        </s:if>
                                        <s:else>
                                            <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-check"></i></button> Annulé
                                        </s:else>
                                    </label>
                                    <label class="checkbox-inline">
                                        <s:if test="commande.isRetour()==false">
                                            <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-times"></i></button> Non retour au stock
                                        </s:if>
                                        <s:else>
                                            <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-check"></i></button> Retour au stock
                                        </s:else>
                                    </label>
                                </div>
                                <a class="btn btn-default pull-left" href="#retour" data-toggle="modal">Retour en stock</a>
                                <div class="modal fade" id="retour" role="dialog">
                                    <div class="modal-dialog modal-lg">
                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <form method="POST" action="retourcommande">
                                                <div class="modal-header backg-brw">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Retour en stock</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <table width="100%" class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                            <tr>
                                                                <th>R&eacute;f.</th>
                                                                <th>Désignation</th>
                                                                <th>Qte.</th>
                                                                <th></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr class="odd gradeX">
                                                                <td> STO0001 </td>
                                                                <td> Baffle </td> 
                                                                <td><span class="pull-right"> 5</span></td>
                                                                <td><input class="form-control input-sm pull-right" type="number" style="width: 125px"  /></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Annuler</button>
                                                    <button class="btn btn-default base-background pull-right">Retour</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <a style='margin-left: 10px;' class="btn btn-default pull-left" href="#etat" data-toggle="modal">Modifier les états de la commande</a>
                                <div class="modal fade" id="etat" role="dialog">
                                    <div class="modal-dialog modal-lg">
                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <form method="POST" action="retourcommande">
                                                <div class="modal-header backg-brw">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Modifier les états de la commande</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="form-group">
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="col-md-12">
                                                                    <label>Re&ccedil;u par le client : </label>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <input type="checkbox" name="recu" data-toggle="toggle" data-on="Oui" data-off="Non" <s:if test="recu!=null">checked</s:if>>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="col-md-12">
                                                                    <label>Annulée : </label>
                                                                </div>
                                                                <div class="col-md-12">
                                                                    <input type="checkbox" name="annule" data-toggle="toggle" data-on="Oui" data-off="Non" <s:if test="annule!=null">checked</s:if>>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Annuler</button>
                                                    <button class="btn btn-default base-background pull-right">Modifier</button>
                                                </div>
                                            </form>
                                            </div>
                                        </div>
                                    </div>
                                    <a style='margin-left: 10px;' class="btn btn-default pull-left" >PDF</a>
                                    <a class="btn btn-success pull-right" href="#payer" data-toggle="modal">Payer la commande</a>
                                    <div class="modal fade" id="payer" role="dialog">
                                        <div class="modal-dialog modal-md">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <form method="POST" action="saveclient">
                                                    <div class="modal-header backg-brw">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title">Payer la commande</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <label>Quotient</label>
                                                            <input name="quotient" class="form-control" placeholder="Quotient">
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Annuler</button>
                                                        <button class="btn btn-success base-background pull-right">Payer</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
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
                                        <s:iterator value="listeCommandeStock">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="getRef()"/> </td>
                                                <td> <s:property value="getStock().getDesignation()"/> </td> 
                                                <td><span class="pull-right"><s:property value="getQuantiteCommande()"/> </span></td>
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                                <p class="text-right h4"><strong class="">Total :</strong> 50 000 Ar </p>
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
    <script src="js/bootstrap-toggle.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#dataTables-example').DataTable({
                responsive: true,
                paging: false
            });
        });
    </script>
</html>
