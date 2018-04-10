<%-- 
    Document   : usersListe
    Created on : 30 janv. 2018, 22:21:51
    Author     : Diary
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
                        <h1 class="page-header">Liste des utilisateurs</h1>
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
                                <form role="form">
                                    <div class="form-group">
                                        <label>Nom</label>
                                        <input class="form-control" placeholder="Nom">
                                    </div>
                                    <div class="form-group">
                                        <label>Pr&eacute;nom</label>
                                        <input class="form-control" placeholder="Prenom">
                                    </div>
                                    <div class="form-group">
                                        <label>CIN</label>
                                        <input class="form-control" placeholder="CIN" type="number">
                                    </div>
                                    <div class="form-group">
                                        <label>Adresse</label>
                                        <input class="form-control" placeholder="Adresse">
                                    </div>
                                    <button type="submit" class="btn btn-default">Rechercher</button>
                                </form>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Liste des utilisateurs</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <a 
                                        class="btn btn-default" 
                                        style="margin-bottom:15px"
                                        href="#ajoutClient" data-toggle="modal">
                                        Ajouter un utilisateur
                                    </a>
                                    <%@include file="/template/Success.jsp" %>
                                    <%@include file="/template/Erreur.jsp" %>
                                    <div class="modal fade" id="ajoutClient" role="dialog">
                                        <div class="modal-dialog modal-md">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <form method="POST" action="saveUser">
                                                    <div class="modal-header backg-brw">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title">Ajouter un utilisateur</h4>
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
                                                            <label>Num&eacute;ro de t&eacute;l&eacute;phone</label>
                                                            <input name="phone" class="form-control" placeholder="Numéro de téléphone" type="string">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Adresse</label>
                                                            <input name="adresse" class="form-control" placeholder="Adresse">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Pseudo</label>
                                                            <input name="pseudo" class="form-control" placeholder="Pseudo">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Mot de passe</label>
                                                            <input name="mdp" type="password" class="form-control" placeholder="Mot de passe">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Confirmer</label>
                                                            <input name="confirmation" type="password" class="form-control" placeholder="Confirmation mot de passe">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Accès aux liens</label>
                                                            <div class="checkbox">
                                                                <label>
                                                                    <input type="checkbox" value="">Caisse et quotient
                                                                </label>
                                                            </div>
                                                            <div class="checkbox">
                                                                <label>
                                                                    <input type="checkbox" value="">Clients
                                                                </label>
                                                            </div>
                                                            <div class="checkbox">
                                                                <label>
                                                                    <input type="checkbox" value="">Commande
                                                                </label>
                                                            </div>
                                                            <div class="checkbox">
                                                                <label>
                                                                    <input type="checkbox" value="">Stocks
                                                                </label>
                                                            </div>
                                                            <div class="checkbox">
                                                                <label>
                                                                    <input type="checkbox" value="">Utilisateurs
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Annuler</button>
                                                        <button class="btn btn-default pull-right">Ajouter</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <tr>
                                        <th>Pseudo</th>
                                        <th>Nom</th>
                                        <th>Prenom</th>
                                        <th>T&eacute;l&eacute;phone</th>
                                        <th>Adresse</th>
                                        <th>Hist.</th>
                                        <th>Modif.</th>
                                        <th>Suppr.</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="users">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="pseudo"  /> </td> 
                                                <td><s:property value="nom"  /></td> 
                                                <td><s:property value="prenom"  /></td>
                                                <td><s:property value="phone"  /></td>
                                                <td><s:property value="adresse"  /></td>
                                                <td><a type="button" class="btn btn-default btn-circle  center-block" href="historiqueuser?idUser=<s:property value="id"/>"><i class="fa fa-history"></i></a></td>
                                                <td><a type="button" class="btn btn-default btn-circle  center-block" href="modifierUser?idUsers=<s:property value="id"/>"><i class="fa fa-edit"></i></a></td>
                                                <td><a type="button" class="btn btn-danger btn-circle  center-block" href="deluser?idUser=<s:property value="id"  />"><i class="fa fa-times"></i></a></td>
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
    <script src="vendor/datatables/js/jquery.dataTables.js"></script>
    <script src="vendor/datatables/js/dataTables.bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
    </script>
</html>

