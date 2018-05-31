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
                                                    <label>Date de début de la location</label>
                                                </div>
                                                <div class="col-md-12">
                                                    <input id="dateDebut" name="dateDebut" class="form-control" placeholder="Date Min" type="date" value="<s:property value="dateDebut"/>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <label>Dates de fin de la location</label
                                                    <label>Date de fin de la location</label>
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
                                        <th>Location (Ariary/Unité)</th>
                                        <th>Qte</th>
                                        <th>Desc.</th>
                                        <th>Nouv. Qte.</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listeCommandeStock" status="incr">
                                            <tr class="odd gradeX">
                                                <td class="text-center"> <button class="delete btn btn-default btn-sm" id="del<s:property value="%{#incr.index}"/>" style="color: red;"><i class="fa fa-close" ></i></button></td>
                                                <td> <s:property value="stock.designation"/> </td> 
                                                <td><span class="pull-right"><s:property value="stock.getPL()"/></span></td>
                                                <td><span class="pull-right"><s:property value="quantiteCommande"/></span></td>
                                                <td><span style="color: red"><s:property value="description"/></span></td>
                                                <td><span class="pull-right"><input id="qte<s:property value="%{#incr.index}"/>" name="quantite" class="input-sm" type="number" min="0" style="width: 75px"></span></td>
                                                <td><button id="<s:property value="%{#incr.index}"/>" class="modifier btn btn-default btn-sm"><i class="fa fa-edit"></i></button></td>
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                                    <p class="text-right h4"><strong class="">Total :</strong> <s:property value="getTotalS()"/> Ar </p>
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
                                        <s:iterator value="listeStock">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="designation"  /> </td> 
                                                <td><span class="pull-right"><s:property value="getPL()"  /></span></td>
                                                <td><span class="pull-right"><input id="addQte<s:property value="id"  />" name="quantite" class="input-sm" type="number" min="0" style="width: 75px" ></span></td>
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
    <script>
        $(document).ready(function () {
            $('.modifier').on('click', function ()
            {
                var dateAquisition = document.getElementById("dateAquisition").value;
                var dateRetour = document.getElementById("dateRetour").value;
                var dateD = document.getElementById("dateDebut").value;
                var dateF = document.getElementById("dateFin").value;
                if (dateD != "" && dateF != "" && dateAquisition != "" && dateRetour != "") {
                    window.location.replace("modifCommande?idClient=<s:property value="idClient"/>&dateDebut=" + dateD + "&dateFin=" + dateF + "&dateAquisition=" + dateAquisition + "&dateRetour=" + dateRetour + "&quantite=" + document.getElementById("qte" + this.getAttribute('id')).value + "&idCommandeStock=" + document.getElementById(this.getAttribute('id')).value + "&action=<s:property value="action"/>")
                }
            });

            $('.ajouter').on('click', function ()
            {
                var dateAquisition = document.getElementById("dateAquisition").value;
                var dateRetour = document.getElementById("dateRetour").value;
                console.log(dateRetour);
                var dateD = document.getElementById("dateDebut").value;
                var dateF = document.getElementById("dateFin").value;
                var id = this.getAttribute('id');
                if (dateD != "" && dateF != "" && dateAquisition != "" && dateRetour != "") {
                    window.location.replace("addCommande?idClient=<s:property value="idClient"/>&dateDebut=" + dateD + "&dateFin=" + dateF + "&dateAquisition=" + dateAquisition + "&dateRetour=" + dateRetour + "&quantite=" + document.getElementById("addQte" + id).value + "&idStock=" + id + "&action=<s:property value="action"/>")
                }
            });

            $('.delete').on('click', function ()
            {
                var dateAquisition = document.getElementById("dateAquisition").value;
                var dateRetour = document.getElementById("dateRetour").value;
                var dateD = document.getElementById("dateDebut").value;
                var dateF = document.getElementById("dateFin").value;
                var id = this.getAttribute('id');
                var idCommandeStock = id.substring(3, id.length);
                if (dateD != "" && dateF != "" && dateAquisition != "" && dateRetour != "") {
                    window.location.replace("deleteCommande?idClient=<s:property value="idClient"/>&dateDebut=" + dateD + "&dateFin=" + dateF + "&dateAquisition=" + dateAquisition + "&dateRetour=" + dateRetour + "&idCommandeStock=" + idCommandeStock + "&action=<s:property value="action"/>")
                }
            });

            $('#validerCommande').on('click', function () {
                var action = '<s:property value="action"/>';
                var dateAquisition = document.getElementById("dateAquisition").value;
                var dateRetour = document.getElementById("dateRetour").value;
                var dateD = document.getElementById("dateDebut").value;
                var dateF = document.getElementById("dateFin").value;
                if (dateD != "" && dateF != "" && dateAquisition != "" && dateRetour != "") {
                    if (action == 'save') {
                        window.location.replace("validerCommandeClient?idClient=<s:property value="idClient"/>&dateDebut=" + dateD + "&dateFin=" + dateF + "&dateAquisition=" + dateAquisition + "&dateRetour=" + dateRetour + "&action=<s:property value="action"/>")
                    } else if (action == 'modif') {
                        window.location.replace("validerCommandeUpdate?idClient=<s:property value="idClient"/>&dateDebut=" + dateD + "&dateFin=" + dateF + "&dateAquisition=" + dateAquisition + "&dateRetour=" + dateRetour + "&action=<s:property value="action"/>")
                    }
                }
            });

            $('#panier').DataTable({
                responsive: true,
                "paging": false
            });

            $('#stock').DataTable({
                responsive: true
            });
        });



    </script>
</html>
