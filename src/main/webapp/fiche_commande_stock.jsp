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
                        <h1 class="page-header">Fiche de la commande <s:property value="commande.getRef()"/></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Fiche de la commande 
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
                                    <label>Date d&&eacute;but de location</label>
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
                                    <label>Dur&&eacute;e en jour(s)</label>
                                    <input class="form-control" value="<s:property value="commande.nombreJour()"/>" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Etat :</label>
                                    <label class="checkbox-inline">
                                        <s:if test="commande.isPrepare()==false">
                                            <button type="button" class="btn btn-danger btn-sm btn-circle"><i class="fa fa-times"></i></button> Commande non pr&eacute;par&eacute;e
                                        </s:if>
                                        <s:else>
                                            <button type="button" class="btn btn-success btn-sm btn-circle"><i class="fa fa-check"></i></button> Commande pr&eacute;par&eacute;e
                                        </s:else>
                                    </label>
                                    <label class="checkbox-inline">
                                        <s:if test="commande.isRecu()==false">
                                            <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-times"></i></button> Non re&ccedil;u par le client
                                        </s:if>
                                        <s:else>
                                        <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-check"></i></button> Re&ccedil;u par le client
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
                                <hr>
                                <s:if test="commande.isRetour()==false">
                                    <s:if test="commande.isRecu()==false">
                                        <a style='margin-left: 10px;' href="recuparclient?idCommande=<s:property value="idCommande"/>&recu=true" class="btn btn-default pull-left" >Re&ccedil;u par le client</a>
                                    </s:if>
                                    <s:else>
                                        <a style='margin-left: 10px;' href="recuparclient?idCommande=<s:property value="idCommande"/>&recu=false" class="btn btn-warning pull-left" >Non re&ccedil;u par le client</a>
                                    </s:else>
                                </s:if>
                               
                                <s:if test="commande.isRecu()==true&&commande.isRetour()==false">
                                <a style='margin-left: 10px;' class="btn btn-success pull-left" href="#retour" data-toggle="modal">Retour en stock</a>
                                </s:if>
                                <div class="modal fade" id="retour" role="dialog">
                                    <div class="modal-dialog modal-lg">
                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <form method="POST" action="retourcommande" onsubmit="setValueStruts()">
                                                <div class="modal-header backg-brw">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Retour en stock</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="row" style="padding:10px">
                                                        <h5>Hors Stock &agrave; retourner</h5>
                                                        <table width="100%" class="table table-striped table-bordered table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>D&eacute;signation</th>
                                                                    <th>Qte</th>
                                                                    <th>Qte. &agrave; retourner</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <s:set var="counter" value="0"/>
                                                                <s:iterator value="listeHorsStock" status="status">
                                                                    <s:if test="retour_HS==true">
                                                                    <tr class="odd gradeX">
                                                                        <td> <s:property value="libelle"/> </td>
                                                                        <td> <span class="pull-right"><s:property value="doubleToString(quantite)"/></span> </td>
                                                                        <td><input class="form-control input-sm pull-right" id="cmd_hs_<s:property value="%{#counter}"/>" ></td>
                                                                            <s:hidden name="listHorsStockRetour[%{counter}].idHorsStock" value="%{id}"/> 
                                                                            <s:hidden name="listHorsStockRetour[%{counter}].valueHorsStockRetour"/>
                                                                    </tr>
                                                                    <s:set var="counter" value="%{#counter+1}"/>
                                                                    </s:if>
                                                                </s:iterator>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <div class="row" style="padding:10px">
                                                        <h5>Stock &aacute; retourner</h5>
                                                        <table width="100%" class="table table-striped table-bordered table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>R&eacute;f.</th>
                                                                    <th>D&eacute;signation</th>
                                                                    <th>Qte. command&eacute;e</th>
                                                                    <th>Qte. &agrave; retouner</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <s:iterator value="listeCommandeStock" status="status">
                                                                    <tr class="odd gradeX">
                                                                        <td> <s:property value="getRef()"/> </td>
                                                                        <td> <s:property value="getStock().getDesignation()"/> </td>
                                                                        <td><span class="pull-right"> <s:property value="quantiteCommande()"/></span></td>
                                                                        <td><input class="form-control input-sm pull-right" id="cmd<s:property value="%{#status.index}"/>" ></td>
                                                                            <s:hidden name="listProduitRetour[%{#status.index}].idProduit" value="%{id}"/> 
                                                                            <s:hidden name="listProduitRetour[%{#status.index}].valueProduitRetour"/>

                                                                    </tr>
                                                                </s:iterator>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <input name="idCommande" type="hidden" value="<s:property value="idCommande"/>" >
                                                    <button type="button" class="btn btn-danger pull-left" data-dismiss="modal">Annuler</button>
                                                    <button class="btn btn-default base-background pull-right">Valider le retour de la commande</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>       
                                <s:if test="commande.isRecu()==true">
                                <a style='margin-left: 10px;' href="downloadBS?idCommande=<s:property value="idCommande"/>" class="btn btn-default pull-left" >Bon de Sortie</a>
                                </s:if>
                                <s:if test="commande.isRetour()==true">
                                    <a style='margin-left: 10px;' href="downloadBR?idCommande=<s:property value="idCommande"/>" class="btn btn-default pull-left" >Bon de Reception</a>
                                </s:if>
                            </div>
                            <!-- /.col-lg-12 -->
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Liste des Hors Stocks</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example1">
                                    <thead>
                                        <tr>
                                            <th>D&eacute;signation</th>
                                            <th>Qte.</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listeHorsStock">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="libelle"/> </td>
                                                <td> <s:property value="doubleToString(quantite)"/> </td>
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Liste des articles</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <s:if test="action.equals('preparation')">
                                    <s:if test="commande.isPrepare()==false">
                                        <a class="btn btn-success" href="commandeprepare?idCommande=<s:property value="idCommande"/>&prepare=true">Commande pr&eacute;par&eacute;e</a>
                                    </s:if>
                                    <s:else>
                                        <a class="btn btn-danger" href="commandeprepare?idCommande=<s:property value="idCommande"/>&prepare=false">D&eacute;faire la pr&eacute;paration</a>
                                    </s:else>
                                </s:if>
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>R&eacute;f.</th>
                                            <th>D&eacute;signation</th>
                                            <th>Qte.</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listeCommandeStock">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="getRef()"/> </td>
                                                <td> <s:property value="getStock().getDesignation()"/> </td>
                                                <td><span class="pull-right"> <s:property value="quantiteCommande()"/> </span></td>
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.panel-body -->
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
                        $('#dataTables-example1').DataTable({
                            responsive: true,
                            paging: false
                        });
                        /*
                         $("#cmd0").click(function(){
                         alert("The paragraph was clicked.");
                         });*/
                    });
                    function setValueStruts() {
                        //listProduitRetour_0__valueProduitRetour
                        var size = <s:property value="listeCommandeStock.size()"/>;
                        for (var i = 0; i < size; i++) {
                            var val = document.getElementById('cmd' + i).value;
                            var inputStruts = document.getElementById('listProduitRetour_' + i + '__valueProduitRetour');
                            inputStruts.value = val;
                        }
                        var hs_size = <s:property value="listeHorsStock.size()"/>;
                        for (var i = 0; i < hs_size; i++) {
                            var val = document.getElementById('cmd_hs_' + i).value;
                            var inputStruts = document.getElementById('listHorsStockRetour_' + i + '__valueHorsStockRetour');
                            inputStruts.value = val;
                        }
                    }
                </script>
                </html>
