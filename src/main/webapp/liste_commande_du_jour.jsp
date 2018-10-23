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
                                    Recherche
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <form role="form" action="commandedujour">
                                        <div class="form-group">
                                            <label>Date début</label>
                                            <input name="dateMin" type="date" class="form-control" value="<s:property value="dateMin"/>">
                                        </div>
                                        <div class="form-group">
                                            <label>Date fin</label>
                                            <input name="dateMax" type="date" class="form-control" value="<s:property value="dateMax"/>">
                                        </div>
                                        <button style="margin-top: 15px;" type="submit" class="btn btn-default">Rechercher</button>
                                        </form>
                                </div>
                                <!-- /.panel-body -->
                            </div>
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
                                            <th>Acquisition</th>
                                            <th>Fin de commande</th>
                                            <th>Date d'enre. du com.</th>
                                            <th>Préparée</th>
                                            <th>Fiche</th>
                                        </tr>
                                    </thead>
                                    <s:iterator value="listeCommande">
                                        <tbody>
                                            <tr class="odd gradeX">
                                                <td> <s:property value="getRef()"/> </td>
                                                <td> <s:property value="getClient().getNom()" /></td> 
                                                <td><span class="pull-right"><s:property value="dateAcquisition()"/></span></td>
                                                <td><span class="pull-right"><s:property value="dateFin()"/></span></td>
                                                <td><span class="pull-right"><s:property value="dateCommande()"/></span></td>
                                                <td>
                                                    <s:if test="isPrepare()==false">
                                                        <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-times"></i></button>
                                                    </s:if>
                                                    <s:else>
                                                        <button type="button" class="btn btn-default btn-sm btn-circle"><i class="fa fa-check"></i></button>
                                                    </s:else>
                                                </td>
                                                <td><a type="button" class="btn btn-default center-block" href="fichecommandestock?idCommande=<s:property value="id"/>&action=preparation"><i class="fa fa-file-text-o"></i></a></td>
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
