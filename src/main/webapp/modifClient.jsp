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
                        <h1 class="page-header">Clients</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Modifier un client
                            </div>
                             <%@include file="/template/Erreur.jsp" %>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <form action="updateclient">
                                    <div class="form-group">
                                        <label>Nom</label>
                                        <input name="nom" class="form-control" placeholder="Nom" value="<s:property value="getNom()" />">
                                    </div>
                                    <div class="form-group">
                                        <label>Pr&eacute;nom</label>
                                        <input name="prenom" class="form-control" placeholder="Prenom" value="<s:property value="getPrenom()" />">
                                    </div>
                                    <div class="form-group">
                                        <label>CIN</label>
                                        <input name="cin" class="form-control" placeholder="CIN" type="string" value="<s:property value="getCin()" />">
                                    </div>
                                    <div class="form-group">
                                        <label>Adresse</label>
                                        <input name="adresse" class="form-control" placeholder="Adresse" value="<s:property value="getAdresse()" />">
                                    </div>
                                    <div class="form-group">
                                        <label class="checkbox-inline">
                                            <input name="blacklist" type="checkbox" value="true" <s:if test="getBlacklist().equals('true')">checked</s:if>> Blacklist
                                        </label>
                                        </div>
                                        <input name="idClient" type="hidden" value="<s:property value="client.id"/>"/>
                                    <button type="submit" class="btn btn-default">Modifier</button>
                                </form>
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
