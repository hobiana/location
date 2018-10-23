
<%-- 
    Document   : profile
    Created on : 17 oct. 2018, 21:25:54
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
                <div class="right_col" role="main">
                    <div class="">
                      <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                          <div class="x_panel">
                            <div class="x_content">
                              <div class="col-md-3 col-sm-3 col-xs-12 profile_left">
                               
                                  <h3><s:property value="client.prenom"/> <s:property value="client.nom"/></h3>

                                <ul class="list-unstyled user_data">
                                    <li><i class="fa fa-map-marker user-profile-icon"></i> <s:property value="client.adresse"/>
                                    </li>

                                    <li>
                                        <i class="fa fa-mobile-phone"></i> <s:property value="client.telephone"/>
                                    </li>
                                    <li>
                                        <i class=" fa fa-user"></i> CIN : <s:property value="client.CIN"/>
                                    </li>

                                  
                                </ul>
                                <a class="btn btn-success" href="modifclient?idClient=<s:property value="idClient"  />"><i class="fa fa-edit m-right-xs"></i>Modifier les information</a>
                                <br />

                              

                              </div>
                              <div class="col-md-9 col-sm-9 col-xs-12">

                                <div class="profile_title">
                                  <div class="col-md-12">
                                    <h2>Client Statistiques</h2>
                                  </div>
                                    <div class="col-md-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <i class="fa fa-bar-chart-o fa-fw"></i> Nombre de commande
                                            <div class="pull-right">
                                                <input id="debut-commande" type='month' value='<s:property value="years"/>-01' onchange="getCommandeClient()">
                                                <input id="fin-commande" type='month' value='<s:property value="years"/>-12' onchange="getCommandeClient()">
                                            </div>
                                        </div>
                                        <!-- /.panel-heading -->
                                        <div id="panel-commande-client" class="panel-body">
                                           <canvas id="commande-client" width="800" height="450"></canvas>   
                                        </div>
                                        <!-- /.panel-body -->
                                    </div>
                                  </div>
                                  <div class="col-md-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <i class="fa fa-bar-chart-o fa-fw"></i> Preference d'arcticle
                                            <div class="pull-right">
                                                <input id="debut-preference" type='month' value='<s:property value="years"/>-01' onchange="getPreferenceClient()">
                                                <input id="fin-preference" type='month' value='<s:property value="years"/>-12' onchange="getPreferenceClient()">
                                            </div>
                                        </div>
                                        <!-- /.panel-heading -->
                                        <div id="panel-preference-client" class="panel-body">
                                           <canvas id="preference-client" width="800" height="450"></canvas>   
                                        </div>
                                        <!-- /.panel-body -->
                                    </div>
                                  </div>
                                  <div class="col-md-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <i class="fa fa-bar-chart-o fa-fw"></i> Argent dépensé
                                            <div class="pull-right">
                                                <input id="debut-benifice" type='month' value='<s:property value="years"/>-01' onchange="getBenificeClient()">
                                                <input id="fin-benifice" type='month' value='<s:property value="years"/>-12' onchange="getBenificeClient()">
                                            </div>
                                        </div>
                                        <!-- /.panel-heading -->
                                        <div id="panel-benifice-client" class="panel-body">
                                           <canvas id="benifice-client" width="800" height="450"></canvas>   
                                        </div>
                                        <!-- /.panel-body -->
                                    </div>
                                  </div>
                                  
                                </div>
                                <!-- start of user-activity-graph -->
                                <div id="graph_bar" style="width:100%; height:280px;"></div>
                              </div>
                            </div>
                          </div>
                        </div>
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
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
    </script>
    
    <script src="vendor/chart/Chart.js" ></script>
    <script src="vendor/stat/js/client/client-preference.js"></script>
    <script src="vendor/stat/js/client/benifice-client.js"></script>
    <script src="vendor/stat/js/client/commande-client.js"></script>
</html>