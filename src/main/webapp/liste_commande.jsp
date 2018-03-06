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
                        <h1 class="page-header">Liste des commandes</h1>
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
                                <form role="form" action="listcommande">
                                    <div class="form-group">
                                        <label>Client</label>
                                        <input name="client" class="form-control" placeholder="Client" value="<s:property value="getClient()"/>">
                                    </div>

                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <label>Date d'enregistrement de la commande Début / Fin </label>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <input name="dateDebut" class="form-control"min="0" placeholder="Date Min" type="date" value="<s:property value="dateDebut"/>">
                                            </div>
                                            <div class="col-md-6">
                                                <input name="dateFin" class="form-control"  placeholder="Date Max" type="date" value="<s:property value="dateFin"/>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <div class="col-md-12" style="margin-top: 15px;">
                                            <label>Date de la commande Début / Fin </label>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <input name="dateDebutCommande" class="form-control"min="0" placeholder="Date Min" type="date" value="<s:property value="dateDebutCommande"/>">
                                            </div>
                                            <div class="col-md-6">
                                                <input name="dateFinCommande" class="form-control"  placeholder="Date Max" type="date" value="<s:property value="dateFinCommande"/>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12" style="margin-top: 15px;">
                                                <div class="col-md-3">
                                                    <div class="col-md-12">
                                                        <label>Re&ccedil;u par le client : </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input type="checkbox" name="recu" data-toggle="toggle" data-on="Oui" data-off="Non" <s:if test="recu!=null">checked</s:if>>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="col-md-12">
                                                        <label>Retour : </label>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <input type="checkbox" name="retour" data-toggle="toggle" data-on="Oui" data-off="Non" <s:if test="retour!=null">checked</s:if>>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="col-md-12">
                                                        <label>Commande annulée : </label>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <input type="checkbox" name="annule" data-toggle="toggle" data-on="Oui" data-off="Non" <s:if test="annule!=null">checked</s:if>>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="col-md-12">
                                                        <label>Commande payé : </label>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <input type="checkbox" name="paye" data-toggle="toggle" data-on="Oui" data-off="Non" <s:if test="paye!=null">checked</s:if>>
                                                    </div>
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
                                            <th>Client</th>
                                            <th>Début de commande</th>
                                            <th>Fin de commande</th>
                                            <th>Date d'enre. du com.</th>
                                            <th>Fiche</th>
                                            <th>Modif.</th>
                                        </tr>
                                    </thead>
                                    <s:iterator value="listeCommande">
                                        <tbody>
                                            <tr class="odd gradeX">
                                                <td> <s:property value="getRef()"/> </td>
                                                <td> <s:property value="getClient().getNom()" /></td> 
                                                <td><span class="pull-right"><s:property value="dateDebut()"/></span></td>
                                                <td><span class="pull-right"><s:property value="dateFin()"/></span></td>
                                                <td><span class="pull-right"><s:property value="dateCommande()"/></span></td>
                                                <td><a type="button" class="btn btn-default center-block" href="fichecommande"><i class="fa fa-file-text-o"></i></a></td>
                                                <td><a type="button" class="btn btn-default center-block" href="commande?idClient=1&action=modif&idCommande=<s:property value="getId()"/>"><i class="fa fa-edit"></i></a></td>
                                            </tr>
                                        </tbody>
                                    </s:iterator>
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
    <script src="js/bootstrap-toggle.min.js"></script>

    <script>
        $(document).ready(function () {
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });


    </script>
</html>
