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
                                    <label>Date début</label>
                                    <input name="dateDebut" class="form-control" type="date" value="<s:property value="commande.dateDebut()"/>" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Date Fin</label>
                                    <input name="dateFin" class="form-control"  type="date" value="<s:property value="commande.dateFin()"/>" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Durée en jour(s)</label>
                                    <input class="form-control" value="<s:property value="commande.nombreJour()"/>" readonly>
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
                                                <td><span class="pull-right"> <s:property value="quantiteCommande()"/> </span></td>
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
    <script src="js/bootstrap-toggle.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#dataTables-example').DataTable({
                responsive: true,
                paging: false
            });
            /*
            $("#cmd0").click(function(){
                alert("The paragraph was clicked.");
            });*/
        });
        function setValueStruts(){
            //listProduitRetour_0__valueProduitRetour
            var size = <s:property value="listeCommandeStock.size()"/>
            for(var i=0;i<size;i++){
                var val = document.getElementById('cmd'+i).value;
                var inputStruts = document.getElementById('listProduitRetour_'+i+'__valueProduitRetour');
                inputStruts.value = val;
            }
        }
    </script>
</html>
