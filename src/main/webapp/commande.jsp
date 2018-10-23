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
        <title><s:property value="titre"/></title>
        <%@include file="/template/css.jsp" %>
        <link href="vendor/datatables/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="css/lightbox.css" rel="stylesheet">
    </head>
    <body>
        <div id="wrapper">
            <%@include file="/template/header.jsp" %>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Commande</h1>
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
                                        <form action="verifierCommande">
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <label>Dates de début de la location</label>
                                                </div>
                                                <div class="col-md-12">
                                                    <input id="dateDebut" name="dateDebut" class="form-control" placeholder="Date Min" type="date" value="<s:property value="dateDebut"/>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <label>Dates de fin de la location</label>
                                                </div>
                                                <div class="col-md-12">
                                                    <input id="dateFin" name="dateFin" class="form-control" placeholder="Date Max" type="date" value="<s:property value="dateFin"/>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <label>Date d'aquisition du client</label>
                                                </div>
                                                <div class="col-md-12">
                                                    <input id="dateAquisition" name="dateAquisition" class="form-control"  type="date" value="<s:property value="dateAquisition"/>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <label>Dates de retour </label>
                                                </div>
                                                <div class="col-md-12">
                                                    <input id="dateRetour" name="dateRetour" class="form-control"  type="date" value="<s:property value="dateRetour"/>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <label>Caution </label>
                                                </div>
                                                <div class="col-md-12">
                                                    <input id="quotient" name="quotient" class="form-control"  type="number" value="<s:property value="quotient"/>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <label>Remise de la commande</label>
                                                </div>
                                                <div class="col-md-12">
                                                    <input id="remiseGlobal" name="remiseGlobal" class="form-control"  type="number" value="<s:property value="remiseGlobal"/>">
                                                </div>
                                            </div>
                                            <input name="idClient" type="hidden" value="<s:property value="idClient"/>" />
                                            <input name="action" type="hidden" value="<s:property value="action"/>" />
                                            <button style="margin-top: 10px;margin-right: 15px" type="submit" class="btn btn-warning pull-right">Vérifier la commande selon les dates</button>
                                        </form>
                                    </div>
                                    <hr>
                                    <%@include file="/template/Success.jsp" %>
                                    <%@include file="/template/Erreur.jsp" %>
                                    <tr>
                                        <th>#</th>
                                        <th>D&eacute;signation</th>
                                        <th>Prix Loc.</th>
                                        <th>Qte</th>
                                        <th>Rem.</th>
                                        <th>Tot.Rem.</th>
                                        <th>Tot.Br</th>
                                        <th>Tot.Net</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listeCommandeStock" status="incr">
                                            <tr class="odd gradeX">
                                                <td class="text-center">
                                                    <button class="delete btn btn-default btn-sm" id="del<s:property value="%{#incr.index}"/>" style="color: red;">
                                                        <i class="fa fa-close" ></i>
                                                    </button>
                                                </td>
                                                <td> <s:property value="stock.designation"/> <span style="color: red"> <s:property value="description"/></span> </td> 
                                                <td><span class="pull-right"><s:property value="stock.getPL()"/></span></td>
                                                <td>
                                                    <span class="pull-right">
                                                        <input id="qte<s:property value="%{#incr.index}"/>" class="input-sm" type="number" min="0" value="<s:property value="quantiteCommande"/>" style="width: 75px">
                                                    </span>
                                                </td>
                                                <td>
                                                    <span class="pull-right">
                                                        <input id="rem_art_<s:property value="%{#incr.index}"/>" class="input-sm" type="number" min="0" value="<s:property value="remise"/>" style="width: 75px">
                                                    </span>
                                                </td>
                                                <td><s:property value="doubleToString(quantiteCommande*remise)"/></td>
                                                <td><s:property value="doubleToString(quantiteCommande*stock.prixLocation)"/></td>
                                                <td><s:property value="doubleToString((quantiteCommande*stock.prixLocation)-(quantiteCommande*remise))"/></td>
                                                <td>
                                                    <button id="<s:property value="%{#incr.index}"/>" class="modifier btn btn-default btn-sm"><i class="fa fa-edit"></i></button>
                                                </td>
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
                                        <p class="text-right"><s:property value="nombre_jour"/> </p>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-9">
                                        <p class="text-right"><strong class="">Caution :</strong></p>
                                    </div>
                                    <div class="col-md-3">
                                        <p class="text-right"><s:property value="doubleToString(quotient)"/> Ar </p>
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
                                        <p class="text-right"><s:property value="doubleToString(remiseGlobal)"/> Ar </p>
                                        <hr>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-9">
                                        <p class="text-right"><strong class="">Tot. net :</strong></p>
                                    </div>
                                    <div class="col-md-3">
                                        <p class="text-right"><strong><s:property value="doubleToString(total[0]+quotient)"/> Ar </strong></p>
                                    </div>
                                </div>
                                <a class="btn btn-success pull-right" id="validerCommande">Valider la commande</a>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-6 -->
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Hors Stocks</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>D&eacute;signation</th>
                                            <th>PU</th>
                                            <th>Qte</th>
                                            <th>Montant</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listeHorsStock" status="incr">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="libelle"  /> </td> 
                                                <td>
                                                    <span class="pull-right">
                                                        <s:property value="doubleToString(montant)"  />
                                                    </span>
                                                </td>
                                                <td>
                                                    <span class="pull-right">
                                                        <s:property value="quantite"  />
                                                    </span>
                                                </td>
                                                <td>
                                                    <span class="pull-right">
                                                        <s:property value="doubleToString(quantite*montant)"  />
                                                    </span>
                                                </td>
                                                <td class="text-center"> 
                                                    <button class="delete_hors_stock btn btn-default btn-sm" id="del<s:property value="%{#incr.index}"/>" style="color: red;">
                                                        <i class="fa fa-close" ></i>
                                                    </button>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                            <tr class="odd gradeX">
                                                <td> <input class="form-control" id="designation_HS" name="designation_HS" type="text" /> </td> 
                                                <td>
                                                    <span class="pull-right">
                                                        <input class="form-control" id="prix_HS" name="prix_HS" type="number" min="1"/>
                                                    </span>
                                                </td>
                                                <td>
                                                    <span class="pull-right">
                                                        <input class="form-control" id="quantite_HS" name="quantite_HS" type="number" min="1" />
                                                    </span>
                                                </td>
                                                <td colspan="2">
                                                    <button id="" type="submit" class="ajouter_hors_stock btn btn-default btn-sm">
                                                        <i class="fa fa-plus"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.panel-body -->
                        </div>
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
                                            <th>Rem. Art. (Ar)</th>
                                            <th>Image</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listeStock">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="designation"  /> </td> 
                                                <td><span class="pull-right"><s:property value="getPL()"  /></span></td>
                                                <td><span class="pull-right"><input id="addQte<s:property value="id"  />" name="quantite" class=" form-control input-sm" type="number" min="0" ></span></td>
                                                <td><span class="pull-right"><input id="addRemise<s:property value="id"  />" name="remise" class=" form-control input-sm" type="number" min="0" ></span></td>
                                                 <td>
                                                    <a id="img" href="<s:property value="image"/>" data-lightbox="image-1" data-title="<s:property value="designation" />"><img id="printImg" src="<s:property value="image"/>"  width="80px"> </a>
                                                </td>
                                                <td><button id="<s:property value="id"  />" type="submit" class="ajouter btn btn-default btn-sm"><i class="fa fa-plus"></i><i class="fa fa-shopping-cart"></i></button></td>
                                            </tr>
                                        </s:iterator>
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
    <script src="js/lightbox.js" ></script>
    <script>
        $(document).ready(function () {
            $('.modifier').on('click', function ()
            {
                var dateAquisition = document.getElementById("dateAquisition").value;
                var dateRetour = document.getElementById("dateRetour").value;
                var dateD = document.getElementById("dateDebut").value;
                var dateF = document.getElementById("dateFin").value;
                var remiseGlobal = document.getElementById("remiseGlobal").value;
                var quotient = document.getElementById("quotient").value;
                var id = this.getAttribute('id');
                
                var quantite = document.getElementById("qte" + id).value;
                quantite = quantite.split(".")[0];
                if (dateD != "" && dateF != "" && dateAquisition != "" && dateRetour != "") {
                    window.location.replace("modifCommande?idClient=<s:property value="idClient"/>&dateDebut=" + dateD + "&dateFin=" + dateF + "&dateAquisition=" + dateAquisition + "&dateRetour=" + dateRetour + "&remiseGlobal=" + remiseGlobal + "&quotient=" + quotient + "&quantite=" + quantite + "&remiseArticle=" +document.getElementById("rem_art_"+id).value+ "&idCommandeStock=" + id + "&action=<s:property value="action"/>")
                }
            });

            $('.ajouter').on('click', function ()
            {
                var dateAquisition = document.getElementById("dateAquisition").value;
                var dateRetour = document.getElementById("dateRetour").value;
                console.log(dateRetour);
                var dateD = document.getElementById("dateDebut").value;
                var dateF = document.getElementById("dateFin").value;
                var remiseGlobal = document.getElementById("remiseGlobal").value;
                var quotient = document.getElementById("quotient").value;
                var id = this.getAttribute('id');
                if (dateD != "" && dateF != "" && dateAquisition != "" && dateRetour != "") {
                    window.location.replace("addCommande?idClient=<s:property value="idClient"/>&dateDebut=" + dateD + "&dateFin=" + dateF + "&dateAquisition=" + dateAquisition + "&dateRetour=" + dateRetour + "&remiseGlobal=" + remiseGlobal + "&quotient=" + quotient + "&quantite=" + document.getElementById("addQte" + id).value +"&remiseArticle=" + document.getElementById("addRemise" + id).value + "&idStock=" + id + "&action=<s:property value="action"/>")
                }
            });

            $('.delete').on('click', function ()
            {
                var dateAquisition = document.getElementById("dateAquisition").value;
                var dateRetour = document.getElementById("dateRetour").value;
                var dateD = document.getElementById("dateDebut").value;
                var dateF = document.getElementById("dateFin").value;
                var remiseGlobal = document.getElementById("remiseGlobal").value;
                var quotient = document.getElementById("quotient").value;
                var id = this.getAttribute('id');
                var idCommandeStock = id.substring(3, id.length);
                if (dateD != "" && dateF != "" && dateAquisition != "" && dateRetour != "") {
                    window.location.replace("deleteCommande?idClient=<s:property value="idClient"/>&dateDebut=" + dateD + "&dateFin=" + dateF + "&dateAquisition=" + dateAquisition + "&dateRetour=" + dateRetour + "&remiseGlobal=" + remiseGlobal + "&quotient=" + quotient + "&idCommandeStock=" + idCommandeStock + "&action=<s:property value="action"/>")
                }
            });            
            
            $('.ajouter_hors_stock').on('click', function ()
            {
                var dateAquisition = document.getElementById("dateAquisition").value;
                var dateRetour = document.getElementById("dateRetour").value;
                var dateD = document.getElementById("dateDebut").value;
                var dateF = document.getElementById("dateFin").value;
                var remiseGlobal = document.getElementById("remiseGlobal").value;
                var quotient = document.getElementById("quotient").value;
                
                var designation_HS = document.getElementById("designation_HS").value;
                var prix_HS = document.getElementById("prix_HS").value;
                var quantite_HS = document.getElementById("quantite_HS").value;
                if (dateD != "" && dateF != "" && dateAquisition != "" && dateRetour != "") {
                    window.location.replace("addhorsStock?idClient=<s:property value="idClient"/>&dateDebut=" + dateD + "&dateFin=" + dateF + "&dateAquisition=" + dateAquisition + "&dateRetour=" + dateRetour + "&remiseGlobal=" + remiseGlobal + "&quotient=" + quotient + "&action=<s:property value="action"/>" + "&designation_HS=" + designation_HS + "&prix_HS=" + prix_HS + "&quantite_HS=" + quantite_HS)
                }
            });
            
            $('.delete_hors_stock').on('click', function ()
            {
                var dateAquisition = document.getElementById("dateAquisition").value;
                var dateRetour = document.getElementById("dateRetour").value;
                var dateD = document.getElementById("dateDebut").value;
                var dateF = document.getElementById("dateFin").value;
                var remiseGlobal = document.getElementById("remiseGlobal").value;
                var quotient = document.getElementById("quotient").value;
                var id = this.getAttribute('id');
                var indice = id.substring(3, id.length);
                if (dateD != "" && dateF != "" && dateAquisition != "" && dateRetour != "") {
                    window.location.replace("deletehorsStock?idClient=<s:property value="idClient"/>&dateDebut=" + dateD + "&dateFin=" + dateF + "&dateAquisition=" + dateAquisition + "&dateRetour=" + dateRetour + "&remiseGlobal=" + remiseGlobal + "&quotient=" + quotient + "&indiceHorsStock=" + indice + "&action=<s:property value="action"/>")
                }
            });

            $('#validerCommande').on('click', function () {
                if(confirm("Avez-vous verifier la commande? Si vous acceptez la commande sera valider.")){
                    var action = '<s:property value="action"/>';
                    var dateAquisition = document.getElementById("dateAquisition").value;
                    var dateRetour = document.getElementById("dateRetour").value;
                    var dateD = document.getElementById("dateDebut").value;
                    var dateF = document.getElementById("dateFin").value;
                    var remiseGlobal = document.getElementById("remiseGlobal").value;
                    var quotient = document.getElementById("quotient").value;
                    if (dateD != "" && dateF != "" && dateAquisition != "" && dateRetour != "") {
                        if (action == 'save') {
                            window.location.replace("validerCommandeClient?idClient=<s:property value="idClient"/>&dateDebut=" + dateD + "&dateFin=" + dateF + "&dateAquisition=" + dateAquisition + "&quotient=" + quotient + "&dateRetour=" + dateRetour + "&remiseGlobal=" + remiseGlobal + "&action=<s:property value="action"/>")
                        } else if (action == 'modif') {
                            window.location.replace("validerCommandeUpdate?idClient=<s:property value="idClient"/>&dateDebut=" + dateD + "&dateFin=" + dateF + "&dateAquisition=" + dateAquisition + "&quotient=" + quotient + "&dateRetour=" + dateRetour + "&remiseGlobal=" + remiseGlobal + "&action=<s:property value="action"/>")
                        }
                    }
                }
            });

            $('#panier').DataTable({
                responsive: true,
                paging: false
            });

            $('#stock').DataTable({
                responsive: true
            });
        });



    </script>
</html>
