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
                        <h1 class="page-header"><a href="listcommande" ><i class="fa fa-arrow-left"></i></a> Fiche de la commande <s:property value="commande.getRef()"/></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Fiche de la commande <s:property value="commande.getRef2()"/>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <%@include file="/template/Success.jsp" %>
                                <%@include file="/template/Erreur.jsp" %>
                                <div class="form-group">
                                    <label>Client</label>
                                    <input name="client" class="form-control" value="<s:property value="commande.getClient().getPrenom()"/> <s:property value="commande.getClient().getNom()"/>" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Date d'acquisition</label>
                                    <input name="dateDebut" class="form-control" type="date" value="<s:property value="commande.dateAcquisition()"/>" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Date début de location</label>
                                    <input name="dateDebut" class="form-control" type="date" value="<s:property value="commande.dateDebut()"/>" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Date Fin de location</label>
                                    <input name="dateFin" class="form-control"  type="date" value="<s:property value="commande.dateFin()"/>" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Date de retour des articles</label>
                                    <input name="dateDebut" class="form-control" type="date" value="<s:property value="commande.dateRetour()"/>" readonly>
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
                                    <label class="checkbox-inline">
                                        <s:if test="commande.isPaye()==false">
                                            <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-times"></i></button> Non payé
                                            </s:if>
                                            <s:else>
                                            <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-check"></i></button> <s:property value="pourcentage_reste_a_payer" />% Payé
                                            </s:else>
                                    </label>
                                </div>
                                <s:if test="commande.isAnnule()==false">
                                    <s:if test="commande.isPaye()==false">
                                    <a style='margin-left: 10px;' onclick="confirmAnnulation()" class="btn btn-danger pull-left" >Annuler la commande</a>
                                    </s:if>
                                    <a style='margin-left: 10px;' href="downloadPDF?idCommande=<s:property value="idCommande"/>" class="btn btn-default pull-left" >Facture</a>
                                    <a style='margin-left: 10px;' href="downloadQuotient?idCommande=<s:property value="idCommande"/>" class="btn btn-default pull-left" >Facture Caution</a>
                                    <a class="btn btn-success pull-right" href="paiement?idCommande=<s:property value="idCommande" />">Paiement</a>
                                </s:if>
                                

                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Hors Stock</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="hors_stock">
                                    <thead>
                                        <tr>
                                            <th>Désignation</th>
                                            <th>PU</th>
                                            <th>Qte</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listeHorsStock">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="libelle"/> </td>
                                                <td><span class="pull-right"> <s:property value="doubleToString(montant)"/> </span></td> 
                                                <td><span class="pull-right"><s:property value="quantite"/> </span></td>
                                                <td><span class="pull-right"><s:property value="doubleToString(quantite*montant)"/> </span></td>
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.panel-body -->
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Liste des commandes</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>R&eacute;f.</th>
                                            <th>Désignation</th>
                                            <th>Prix de casse</th>
                                            <th>Qte.</th>
                                            <th>Remise</th>
                                            <th>PU</th>
                                            <th>Tot.Rem.</th>
                                            <th>Montant</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listeCommandeStock">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="getRef()"/> </td>
                                                <td> <s:property value="getStock().getDesignation()"/> </td>
                                                <td><span class="pull-right"><s:property value="prixCasse()"/> </span></td>
                                                <td><span class="pull-right"> <s:property value="quantiteCommande()"/> </span></td> 
                                                <td><span class="pull-right"> <s:property value="doubleToString(remise)"/> </span></td> 
                                                <td><span class="pull-right"><s:property value="getStringPrixLocation()"/> </span></td>
                                                <td><span class="pull-right"> <s:property value="doubleToString(remise*quantiteCommande)"/> </span></td> 
                                                <td><span class="pull-right"> <s:property value="doubleToString((prixLocation*quantiteCommande)-(remise*quantiteCommande))"/> </span></td> 
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                                <div class="col-md-12">
                                    <div class="col-md-9">
                                        <p class="text-right"><strong class="">Tot. Hors Stock :</strong></p>
                                    </div>
                                    <div class="col-md-3">
                                        <p class="text-right"><s:property value="doubleToString(total[3])"/> Ar </p>
                                        <hr>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-9">
                                        <p class="text-right"><strong class="">Nb. Jrs :</strong></p>
                                    </div>
                                    <div class="col-md-3">
                                        <p class="text-right"><s:property value="commande.nombreJour()"/> </p>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-9">
                                        <p class="text-right"><strong class="">Caution :</strong></p>
                                    </div>
                                    <div class="col-md-3">
                                        <p class="text-right"><s:property value="doubleToString(facture.quotient)"/> Ar </p>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-9">
                                        <p class="text-right"><strong class="">Tot. brute :</strong></p>
                                    </div>
                                    <div class="col-md-3">
                                        <p class="text-right"><s:property value="doubleToString(total[1])"/> Ar </p>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-9">
                                        <p class="text-right"><strong class="">Tot. rem. Art. :</strong></p>
                                    </div>
                                    <div class="col-md-3">
                                        <p class="text-right"><s:property value="doubleToString(total[2])"/> Ar </p>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-9">
                                        <p class="text-right"><strong class="">Remise commande :</strong></p>
                                    </div>
                                    <div class="col-md-3">
                                        <p class="text-right"><s:property value="doubleToString(commande.getRemiseGlobal())"/> Ar </p>
                                        <hr>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-9">
                                        <p class="text-right"><strong class="">Tot. net :</strong></p>
                                    </div>
                                    <div class="col-md-3">
                                        <p class="text-right"><strong><s:property value="doubleToString(total[0]+facture.quotient+total[3])"/> Ar </strong></p>
                                    </div>
                                </div>
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
            $('#hors_stock').DataTable({
                responsive: true,
                paging: false
            });
        });
        function setValueStruts() {
            //listProduitRetour_0__valueProduitRetour
            var size = <s:property value="listeCommandeStock.size()"/>
            for (var i = 0; i < size; i++) {
                var val = document.getElementById('cmd' + i).value;
                var inputStruts = document.getElementById('listProduitRetour_' + i + '__valueProduitRetour');
                inputStruts.value = val;
            }
        }
        function confirmAnnulation(){
             if(confirm("Etes-vous sûr de vouloir annulée la commande? L'annulation est irreversible.")){
                 window.location.replace("annulecommande?idCommande=<s:property value="idCommande"/>&annule=true")
             }
        }
    </script>
</html>
