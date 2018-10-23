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
                        <h1 class="page-header">Historiques entrées et sorties cautions</h1>
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
                                <form role="form" action="findquotient">
                                    <div class="form-group">
                                        <label>Description</label>
                                        <input name="designation" class="form-control" placeholder="Description" value="">
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <label>Solde Min / Max</label>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <input name="soldeMin" class="form-control" placeholder="Solde Min" type="number" min="0" value="">
                                            </div>
                                            <div class="col-md-6">
                                                <input name="soldeMax" class="form-control" placeholder="Solde Max" type="number" min="0" value="">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12" style="margin-top: 15px;">
                                            <label>Date  Min / Max</label>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <input name="dateMin" class="form-control" placeholder="Date Min" type="date" value="<s:property value="dateMin"/>">
                                            </div>
                                            <div class="col-md-6">
                                                <input name="dateMax" class="form-control" placeholder="Date Max" type="date" value="<s:property value="dateMax"/>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12" style="margin-top: 15px;">
                                            <label>Type</label>
                                        </div>
                                        <div class="col-md-12" >
                                            <select name="type" class="form-control">
                                                <option value=""></option>
                                                <option value="entree">Entree</option>
                                                <option value="sortie">Sortie</option>
                                            </select>
                                        </div>
                                    </div>
                                    <button style="margin-top: 15px;" type="submit" class="btn btn-default">Rechercher</button>
                                </form>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Historiques</span>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Date</th>
                                            <th>Description</th>
                                            <th>Type</th>
                                            <th>Solde</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listeQuotient">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="date"/> </td> 
                                                <td><s:property value="designation"/></td> 
                                                <td><s:property value="type"/></td>
                                                <td><s:property value="volaM"/></td>
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
