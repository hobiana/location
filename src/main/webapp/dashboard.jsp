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
                        <h1 class="page-header">Dashboard</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <s:if test="getAccesRoot().equals(true)">
                    <div class="row">
                    <div class="col-lg-2 col-md-2"></div>
                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-2">
                                        <i class="fa fa-money fa-5x"></i>
                                    </div>
                                    <div class="col-xs-10 text-center">
                                        <div class="huge"><s:property value="caisseMoney"/></div>
                                        <div>Soldes Caisse</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-2">
                                        <i class="fa fa-money fa-5x"></i>
                                    </div>
                                    <div class="col-xs-10 text-center">
                                        <div class="huge"><s:property value="quotientMoney"/></div>
                                        <div>Soldes Caution</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-6"></div>
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-database fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><s:property value="stockCount"/></div>
                                        <div>Produits en stocks</div>
                                    </div>
                                </div>
                            </div>
                            <a href="stock">
                                <div class="panel-footer">
                                    <span class="pull-left">Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-user fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><s:property value="clientCount"/></div>
                                        <div>Clients</div>
                                    </div>
                                </div>
                            </div>
                            <a href="client">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-shopping-cart fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><s:property value="commandeCount"/></div>
                                        <div>Commandes</div>
                                    </div>
                                </div>
                            </div>
                            <a href="listcommande">
                                <div class="panel-footer">
                                    <span class="pull-left">Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> Preference d'arcticle
                                <div class="pull-right">
                                    <input id="debut-preference" type='month' value='<s:property value="years"/>-01' onchange="getPreference()">
                                    <input id="fin-preference" type='month' value='<s:property value="years"/>-12' onchange="getPreference()">
                                </div>
                            </div>
                            <!-- /.panel-heading -->
                            <div id="panel-char-grouped" class="panel-body">
                               <canvas id="bar-chart-grouped" width="800" height="450"></canvas>   
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> Articles les plus cassés
                                <div class="pull-right">
                                    <input id="debut-casse" type='month' value='<s:property value="years"/>-01' onchange="getCasse()">
                                    <input id="fin-casse" type='month' value='<s:property value="years"/>-12' onchange="getCasse()">
                                </div>
                            </div>
                            <!-- /.panel-heading -->
                            <div id="casse-chart-panel" class="panel-body">
                               <canvas id="casse-chart" width="800" height="450"></canvas>   
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> Nombre de commande cette semaine
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="row">
                                    <!-- /.col-lg-8 (nested) -->
                                    <div class="col-lg-12">
                                        <canvas id="myChart" width="100" height="50"></canvas>
                                    </div>
                                </div>
                                <!-- /.row -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-8 -->
                    <div class="col-lg-4">
                        <!-- /.panel -->                        
                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-area-chart"></i> TOP 10 Clients
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="list-group">
                                    <s:iterator value="meilleurClient" >
                                        <a href="ficheclient?idClient=<s:property value="other.id"/>" class="list-group-item">
                                            <i class="fa fa-user"></i>  <s:property value="other.prenom"/> <s:property value="other.nom"/>
                                            <span class="pull-right text-muted small"><em><s:property value="toMoney()"/> Ariary</em>
                                            </span>
                                        </a>
                                        
                                    </s:iterator>
                                    
                                    
                                </div>
                                <!-- /.list-group -->
                                
                            </div>
                            <!-- /.panel-body -->
                        </div>
                    </div>
                        <!-- /.panel -->
                    <!-- /.col-lg-4 -->
                </div>
                <!-- /.row -->
                </s:if>
                
            </div>
       </div>
    </body>
    <%@include file="/template/footer.jsp" %>
    <script src="vendor/chart/Chart.js" ></script>
    <script>
        var ctx = $("#myChart");
        var bar = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: [
            <s:iterator value="label" var="Output" status="incr">
                  "<s:property value="#Output"/>",
            </s:iterator>
                ],
                datasets: [{
                    label: 'Nombre de commande',
                    data: [
                        <s:iterator value="data" var="Output" status="incr">
                                "<s:property value="#Output"/>",
                         </s:iterator>
                    ],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    xAxes: [{
                        stacked: true
                    }],
                    yAxes: [{
                        stacked: true
                    }]
                }
            }
        });
        
        var caisse = $("#caisse");
        var c = new Chart(caisse,{
            type: 'pie',
            data: {
                datasets: [{
                    data: [10, 20, 30],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                }],

                // These labels appear in the legend and in the tooltips when hovering different arcs
                labels: [
                    'Red',
                    'Yellow',
                    'Blue'
                ]
            }
        });
        
        var quotient = $("#quotient");
        var q = new Chart(quotient,{
            type: 'pie',
            data: {
                datasets: [{
                    data: [10, 20, 30],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                }],

                // These labels appear in the legend and in the tooltips when hovering different arcs
                labels: [
                    'Red',
                    'Yellow',
                    'Blue'
                ]
            }
        });
        
        
    </script>
    <script src="vendor/stat/js/preference/preference.min.js" ></script>
    <script src="vendor/stat/js/casse/casse.js" ></script>
</html>
