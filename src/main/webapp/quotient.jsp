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
                        <h1 class="page-header">Quotient</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Solde
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <h3 class="text-center"><strong>Solde : 10 000 000 Ar</strong></h3>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Entr�e
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <form role="form">
                                    <div class="form-group">
                                        <label>Solde</label>
                                        <input class="form-control" type="number" min="0" placeholder="Solde">
                                    </div>
                                    <div class="form-group">
                                        <label>D&eacute;scription</label>
                                        <input class="form-control" placeholder="Description">
                                    </div>
                                    <button type="submit" class="btn btn-default">Valider</button>
                                </form>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Sortie
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <form role="form">
                                    <div class="form-group">
                                        <label>Solde</label>
                                        <input class="form-control" type="number" min="0" placeholder="Solde">
                                    </div>
                                    <div class="form-group">
                                        <label>D&eacute;scription</label>
                                        <input class="form-control" placeholder="Description">
                                    </div>
                                    <button type="submit" class="btn btn-default">Valider</button>
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
