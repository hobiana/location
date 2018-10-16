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
                                        <div>Soldes Quotient</div>
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
                                <i class="fa fa-bar-chart-o fa-fw"></i> Bar Chart Example
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
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> Mouvenement Caisse
                            </div>
                            <div class="panel-body">
                                <canvas id="caisse" width="100" height="50"></canvas>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> Mouvenement Quotient
                            </div>
                            <div class="panel-body">
                                <canvas id="quotient" width="100" height="50"></canvas>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->                        
                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bell fa-fw"></i> Notifications Panel
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="list-group">
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-comment fa-fw"></i> New Comment
                                        <span class="pull-right text-muted small"><em>4 minutes ago</em>
                                        </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                        <span class="pull-right text-muted small"><em>12 minutes ago</em>
                                        </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-envelope fa-fw"></i> Message Sent
                                        <span class="pull-right text-muted small"><em>27 minutes ago</em>
                                        </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-tasks fa-fw"></i> New Task
                                        <span class="pull-right text-muted small"><em>43 minutes ago</em>
                                        </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                        <span class="pull-right text-muted small"><em>11:32 AM</em>
                                        </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-bolt fa-fw"></i> Server Crashed!
                                        <span class="pull-right text-muted small"><em>11:13 AM</em>
                                        </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-warning fa-fw"></i> Server Not Responding
                                        <span class="pull-right text-muted small"><em>10:57 AM</em>
                                        </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-shopping-cart fa-fw"></i> New Order Placed
                                        <span class="pull-right text-muted small"><em>9:49 AM</em>
                                        </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-money fa-fw"></i> Payment Received
                                        <span class="pull-right text-muted small"><em>Yesterday</em>
                                        </span>
                                    </a>
                                </div>
                                <!-- /.list-group -->
                                <a href="#" class="btn btn-default btn-block">View All Alerts</a>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                    </div>
                        <!-- /.panel -->
                    <!-- /.col-lg-4 -->
                </div>
                <!-- /.row -->
            </div>
       </div>
    </body>
    <%@include file="/template/footer.jsp" %>
    <script src="vendor/chart/Chart.js" ></script>
    <script src="vendor/jquery/jquery.min.js" ></script>
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
                    label: '# of Votes',
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
        
        var labelDate = [];
        var preference = document.getElementById("bar-chart-grouped").getContext('2d');
        var preference = null;
        function initChart(label, data){
            preference = new Chart(document.getElementById("bar-chart-grouped"), {
                type: 'bar',
                data: {
                  labels: label,
                  datasets: data
                },
                options: {
                  title: {
                    display: true,
                    text: 'Les articles les plus loués ( nombre de fois loué)'
                  }
                }
            });
        }
        function getPreference() {
            debut = document.getElementById("debut-preference").value;
            fin = document.getElementById("fin-preference").value;
            labelDate = [];
            $.ajax({
                url: "evenementiel/webservice/articlePreferer",
                type: "get", //send it through get method
                data: { 
                  debut: debut, 
                  fin: fin
                },
                success: function(data) {
                    if(data.success) {
                        for(var i=0;i<data.message.length;i++){
                            var tempDate = new Date(data.message[i][0].date),
                            locale = "fr-fr",
                            month = tempDate.toLocaleString(locale, { month: "long" });
                            labelDate.push(month + " "+ tempDate.getFullYear());
                        }
                        var firstDSize = data.message.length;
                        var listArticle = [];
                        for(var i =0;i<firstDSize;i++){
                            var secondDSize = data.message[i].length;
                            for(var j = 0; j<secondDSize; j++) {
                                var otherTemp = data.message[i][j].other;
                                if(otherTemp!==null){
                                    if(!containsObject(otherTemp.designation,listArticle)) {
                                        listArticle.push(otherTemp.designation);
                                    }
                                }
                            }
                        }
                        var listData = [];
                        var articleSize = listArticle.length;
                        for(var i=0;i<articleSize;i++){
                            listData.push({label:listArticle[i],backgroundColor:'#'+(Math.random()*0xFFFFFF<<0).toString(16), data:[]});
                        }
                        for(var i =0;i<firstDSize;i++){
                            var secondDSize = data.message[i].length;
                            var listArticleTemp = data.message[i];
                            var listDataSize = listData.length;
                            for(var j=0;j<listDataSize;j++){
                                var article = listData[j].label;
                                var otherTemp = data.message[i][0].other; 
                                if(otherTemp===null){
                                    listData[j].data.push(0);
                                } else {
                                    var index = listArticleTemp.findIndex(x => x.other.designation==article);
                                    if(index<0) {
                                        listData[j].data.push(0);
                                    } else {
                                        listData[j].data.push(data.message[i][index].value);
                                    }
                                }
                            }
                            
                        }
                        clear();
                        initChart(labelDate, listData);
                    }
                },
                error: function(xhr) {
                    console.log(xhr);
                }
              });
           }
        getPreference();
        function containsObject(obj, list) {
            var x;
            for (x in list) {
                if (list.hasOwnProperty(x) && list[x] === obj) {
                    return true;
                }
            }

            return false;
        }
        function clear(){
            $('#bar-chart-grouped').remove(); // this is my <canvas> element
            $('#panel-char-grouped').append('<canvas id="bar-chart-grouped" width="800" height="450"></canvas>');
        }
        
    </script>
</html>
