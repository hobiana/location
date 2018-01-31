<%-- 
    Document   : modifierUser
    Created on : 31 janv. 2018, 01:46:04
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
                        <h1 class="page-header">Utilisateur</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Modifier un utilisateur
                            </div>
                            <%@include file="/template/Erreur.jsp" %>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <form action="updateUsers">
                                    <div class="form-group">
                                        <label>Nom</label>
                                        <input name="nom" value="<s:property value="getNom()" />"class="form-control" placeholder="Nom">
                                    </div>
                                    <div class="form-group">
                                        <label>Pr&eacute;nom</label>
                                        <input name="prenom" value="<s:property value="getPrenom()" />" class="form-control" placeholder="Prenom">
                                    </div>
                                    <div class="form-group">
                                        <label>Num&eacute;ro de t&eacute;l&eacute;phone</label>
                                        <input name="phone" value="<s:property value="getPhone()" />" class="form-control" placeholder="Num�ro de t�l�phone" type="string">
                                    </div>
                                    <div class="form-group">
                                        <label>Adresse</label>
                                        <input name="adresse" value="<s:property value="getAdresse()" />" class="form-control" placeholder="Adresse">
                                    </div>
                                    <div class="form-group">
                                        <label>Pseudo</label>
                                        <input name="pseudo" value="<s:property value="getPseudo()" />" class="form-control" placeholder="Pseudo">
                                    </div>
                                    <div class="form-group">
                                        <label>Mot de passe</label>
                                        <input name="mdp" type="password" class="form-control" placeholder="Mot de passe">
                                    </div>
                                    <div class="form-group">
                                        <label>Confirmer</label>
                                        <input name="confirmation" type="password" class="form-control" placeholder="Confirmation mot de passe">
                                    </div>
                                    <input name="idUsers" type="hidden" value="<s:property value="utilisateur.id"/>"/>
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