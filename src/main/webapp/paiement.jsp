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
    </head>
    <body>
        <div id="wrapper">
            <%@include file="/template/header.jsp" %>

            <div id="page-wrapper" style="min-height: 708px;">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Paiement</h1>
                    </div>
                </div>
                <%@include file="/template/Erreur.jsp" %>
                <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-2">
                                        <i class="fa fa-money fa-5x"></i>
                                    </div>
                                    <div class="col-xs-10 text-center">
                                        <div class="huge"><s:property value="totalToPaye"/></div>
                                        <div>Total à payer</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4"></div>
                </div>
                <div class="row">
                    <div class="col-lg-2 col-md-2"></div>
                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-2">
                                        <i class="fa fa-money fa-5x"></i>
                                    </div>
                                    <div class="col-xs-10 text-center">
                                        <div class="huge"><s:property value="reste"/></div>
                                        <div>Reste à payer</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-2">
                                        <i class="fa fa-money fa-5x"></i>
                                    </div>
                                    <div class="col-xs-10 text-center">
                                        <div class="huge"><s:property value="totalPaye"/></div>
                                        <div>Payé</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-6"></div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Liste des Paiements effectués
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="listepaiement">
                                    <thead>
                                        <tr>
                                            <th>Date de paiement</th>
                                            <th>Valeur</th>
                                            <th>Facture</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="listePaiement">
                                            <tr class="odd gradeX">
                                                <td> <s:property value="date"  /> </td> 
                                                <td><span class="pull-right"><s:property value="valeur"  /></span></td>
                                                <td> <a class="btn btn-circle btn-default center-block" href="downloadPaiement?idCommande=<s:property value="idCommande"  />&idFactureFille=<s:property value="id"/>"><i class="fa fa-download"></i></a> </td>
                                                
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Effectuer un paiement
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <form action="payer">
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <label>Dates de paiement</label>
                                        </div>
                                        <div class="col-md-12">
                                            <input name="datepaiement" class="form-control" type="date" value="<s:property value="datepaiement"/>" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <label>Valeur</label>
                                        </div>
                                        <div class="col-md-12">
                                            <input name="valeur" class="form-control" type="number" />
                                        </div>
                                    </div>
                                    <input name="idCommande" type="hidden" value="<s:property value="idCommande"/>" />
                                    <button style="margin-top: 10px;margin-right: 15px" type="submit" class="btn btn-primary pull-right">Payer</button>
                                </form>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <%@include file="/template/footer.jsp" %>
    <script src="vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/js/dataTables.bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#listepaiement').DataTable({
                responsive: true,
                paging: false
            });
        });
    </script>
</html>
