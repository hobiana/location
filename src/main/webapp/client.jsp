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
                                Recherche avancée
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <form action="client">
                                    <div class="form-group">
                                        <label>Nom</label>
                                        <input name="nom" class="form-control" placeholder="Nom">
                                    </div>
                                    <div class="form-group">
                                        <label>Pr&eacute;nom</label>
                                        <input name="prenom" class="form-control" placeholder="Prenom">
                                    </div>
                                    <div class="form-group">
                                        <label>CIN</label>
                                        <input name="cin" class="form-control" placeholder="CIN" type="number">
                                    </div>
                                    <div class="form-group">
                                        <label>Adresse</label>
                                        <input name="adresse" class="form-control" placeholder="Adresse">
                                    </div>
                                    <button type="submit" class="btn btn-default">Rechercher</button>
                                </form>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Liste des clients</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <a 
                                        class="btn btn-default" 
                                        style="margin-bottom:15px"
                                        href="#ajoutClient" data-toggle="modal">
                                        Ajouter un client
                                    </a>
                                    <%@include file="/template/Success.jsp" %>
                                    <%@include file="/template/Erreur.jsp" %>
                                    <div class="modal fade" id="ajoutClient" role="dialog">
                                        <div class="modal-dialog modal-md">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <form method="POST" action="saveclient">
                                                    <div class="modal-header backg-brw">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title">Ajouter un client</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <label>Nom</label>
                                                            <input name="nom" class="form-control" placeholder="Nom">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Pr&eacute;nom</label>
                                                            <input name="prenom" class="form-control" placeholder="Prenom">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>CIN</label>
                                                            <input name="cin" class="form-control" placeholder="CIN" type="string">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Adresse</label>
                                                            <input name="adresse" class="form-control" placeholder="Adresse">
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Annuler</button>
                                                        <button class="btn base-background pull-right">Ajouter</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <tr>
                                        <th>Nom</th>
                                        <th>Prenom</th>
                                        <th>CIN</th>
                                        <th>adresse</th>
                                        <th>telephone</th>
                                        <th>Blacklist / Whitelist</th>
                                        <th>Commande</th>
                                        <th>Modifier</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listeClient" status="client">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="nom"  /> </td> 
                                                <td><s:property value="prenom"  /></td> 
                                                <td><s:property value="CIN"  /></td>
                                                <td><s:property value="adresse"  /></td>
                                                <td><s:property value="telephone"  /></td>
                                                <td class="center">
                                                    <s:if test="blackListe==true"><button type="button" class="btn btn-sm btn-danger btn-circle center-block"><i class="fa fa-times"></i> <span style="display: none">blacklist</span></button></s:if>
                                                    <s:else><button type="button" class="btn btn-sm btn-success btn-circle center-block"><i class="fa fa-check"></i> <span style="display: none">whitelist</span></button></s:else>
                                                </td>
                                                <td>
                                                    <s:if test="blackListe==false">
                                                        <a class="btn btn-circle btn-default center-block" href="commande?idClient=<s:property value="id"  />&action=save"><i class="fa fa-shopping-cart"></i></a>
                                                    </s:if>
                                                </td>
                                                <td><a type="button" class="btn btn-default center-block" href="modifclient?idClient=<s:property value="id"  />"><i class="fa fa-edit"></i></a></td>
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
    <script>
        $(document).ready(function () {
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
    </script>
</html>
