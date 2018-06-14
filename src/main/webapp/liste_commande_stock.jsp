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
                        <h1 class="page-header">Commandes du jour</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                            <!-- /.panel -->

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span>Commandes du jour</span>
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
                                                <td><a type="button" class="btn btn-default center-block" href="fichecommandestock?idCommande=<s:property value="id"/>"><i class="fa fa-file-text-o"></i></a></td>
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
        
        setInterval(function() {
                  window.location.reload();
                }, 5*60*1000); 

    </script>
</html>
