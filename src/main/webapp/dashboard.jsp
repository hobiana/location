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
                                        <div class="huge">13</div>
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
                                        <div class="huge">13</div>
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
                                        <div class="huge">26</div>
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
                                        <div class="huge">12</div>
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
                                        <div class="huge">124</div>
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
                                <i class="fa fa-bar-chart-o fa-fw"></i> Area Chart Example
                                <div class="pull-right">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                            Actions
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu pull-right" role="menu">
                                            <li><a href="#">Action</a>
                                            </li>
                                            <li><a href="#">Another action</a>
                                            </li>
                                            <li><a href="#">Something else here</a>
                                            </li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div id="morris-area-chart" style="position: relative; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg height="347.6000061035156" version="1.1" width="681.7999877929688" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style="overflow: hidden; position: relative;"><desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.2.0</desc><defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs><text x="49.203125" y="314.60626220703125" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40313720703125">0</tspan></text><path fill="none" stroke="#aaaaaa" d="M61.703125,314.60626220703125H656.7999877929688" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="49.203125" y="242.20469665527344" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.4078216552734375">7,500</tspan></text><path fill="none" stroke="#aaaaaa" d="M61.703125,242.20469665527344H656.7999877929688" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="49.203125" y="169.80313110351562" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.412506103515625">15,000</tspan></text><path fill="none" stroke="#aaaaaa" d="M61.703125,169.80313110351562H656.7999877929688" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="49.203125" y="97.40156555175781" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.4171905517578125">22,500</tspan></text><path fill="none" stroke="#aaaaaa" d="M61.703125,97.40156555175781H656.7999877929688" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="49.203125" y="25" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40625">30,000</tspan></text><path fill="none" stroke="#aaaaaa" d="M61.703125,25H656.7999877929688" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="546.8914542030159" y="327.10626220703125" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,6.7969)"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40313720703125">2012</tspan></text><text x="282.9663570955631" y="327.10626220703125" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,6.7969)"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40313720703125">2011</tspan></text><path fill="#7cb57c" stroke="none" d="M61.703125,263.31699317016603C78.33402153005866,258.0075450297038,111.59581459017599,246.98923344548544,128.22671112023465,242.07920060831705C144.85760765029332,237.16916777114866,178.11940071041067,230.7583388390157,194.75029724046934,224.036730472819C211.20042315607085,217.38818306712443,244.10067498727386,190.58242041773505,260.5508009028754,188.59857752075195C276.8201562040197,186.63653509516425,309.3588668063084,206.81032941189721,325.62822210745276,208.2531891825358C342.2591186375114,209.72811250363304,375.5209116976288,199.2874619817098,392.1518082276874,200.2697098876953C408.78270475774605,201.25195779368082,442.04449781786343,233.54731572114426,458.67539434792207,216.1111724304199C475.1255202635236,198.86455243633387,508.0257720947266,69.95171866556804,524.4758980103281,61.538656748453775C540.9260239259296,53.12559483133953,573.8262757571326,136.47086142868017,590.2764016727341,148.80667709350587C606.9072982027927,161.27805117223076,640.1690912629101,157.77723106536865,656.7999877929688,160.76741572265624L656.7999877929688,314.60626220703125L61.703125,314.60626220703125Z" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></path><path fill="none" stroke="#4da74d" d="M61.703125,263.31699317016603C78.33402153005866,258.0075450297038,111.59581459017599,246.98923344548544,128.22671112023465,242.07920060831705C144.85760765029332,237.16916777114866,178.11940071041067,230.7583388390157,194.75029724046934,224.036730472819C211.20042315607085,217.38818306712443,244.10067498727386,190.58242041773505,260.5508009028754,188.59857752075195C276.8201562040197,186.63653509516425,309.3588668063084,206.81032941189721,325.62822210745276,208.2531891825358C342.2591186375114,209.72811250363304,375.5209116976288,199.2874619817098,392.1518082276874,200.2697098876953C408.78270475774605,201.25195779368082,442.04449781786343,233.54731572114426,458.67539434792207,216.1111724304199C475.1255202635236,198.86455243633387,508.0257720947266,69.95171866556804,524.4758980103281,61.538656748453775C540.9260239259296,53.12559483133953,573.8262757571326,136.47086142868017,590.2764016727341,148.80667709350587C606.9072982027927,161.27805117223076,640.1690912629101,157.77723106536865,656.7999877929688,160.76741572265624" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><circle cx="61.703125" cy="263.31699317016603" r="2" fill="#4da74d" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="128.22671112023465" cy="242.07920060831705" r="2" fill="#4da74d" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="194.75029724046934" cy="224.036730472819" r="2" fill="#4da74d" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="260.5508009028754" cy="188.59857752075195" r="2" fill="#4da74d" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="325.62822210745276" cy="208.2531891825358" r="2" fill="#4da74d" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="392.1518082276874" cy="200.2697098876953" r="2" fill="#4da74d" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="458.67539434792207" cy="216.1111724304199" r="2" fill="#4da74d" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="524.4758980103281" cy="61.538656748453775" r="2" fill="#4da74d" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="590.2764016727341" cy="148.80667709350587" r="2" fill="#4da74d" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="656.7999877929688" cy="160.76741572265624" r="2" fill="#4da74d" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><path fill="#a8b4bd" stroke="none" d="M61.703125,288.86991903889975C78.33402153005866,283.0633134816488,111.59581459017599,270.72970678990686,128.22671112023465,265.64349680989585C144.85760765029332,260.55728682988484,178.11940071041067,250.9610923351517,194.75029724046934,248.18023919881185C211.20042315607085,245.42961272699742,244.10067498727386,245.75380006482598,260.5508009028754,243.51757837727865C276.8201562040197,241.30593055442966,309.3588668063084,233.49049196275982,325.62822210745276,230.38876115722655C342.2591186375114,227.2181030004592,375.5209116976288,218.2964930173238,392.1518082276874,218.42802252807616C408.78270475774605,218.5595520388285,442.04449781786343,244.88057411551273,458.67539434792207,231.44099724324542C475.1255202635236,218.14750272828536,508.0257720947266,119.37785408223469,524.4758980103281,111.49573697916665C540.9260239259296,103.61361987609862,573.8262757571326,160.10937912587374,590.2764016727341,168.38406041870118C606.9072982027927,176.74967227518607,640.1690912629101,175.6386972869873,656.7999877929688,178.05690957641602L656.7999877929688,314.60626220703125L61.703125,314.60626220703125Z" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></path><path fill="none" stroke="#7a92a3" d="M61.703125,288.86991903889975C78.33402153005866,283.0633134816488,111.59581459017599,270.72970678990686,128.22671112023465,265.64349680989585C144.85760765029332,260.55728682988484,178.11940071041067,250.9610923351517,194.75029724046934,248.18023919881185C211.20042315607085,245.42961272699742,244.10067498727386,245.75380006482598,260.5508009028754,243.51757837727865C276.8201562040197,241.30593055442966,309.3588668063084,233.49049196275982,325.62822210745276,230.38876115722655C342.2591186375114,227.2181030004592,375.5209116976288,218.2964930173238,392.1518082276874,218.42802252807616C408.78270475774605,218.5595520388285,442.04449781786343,244.88057411551273,458.67539434792207,231.44099724324542C475.1255202635236,218.14750272828536,508.0257720947266,119.37785408223469,524.4758980103281,111.49573697916665C540.9260239259296,103.61361987609862,573.8262757571326,160.10937912587374,590.2764016727341,168.38406041870118C606.9072982027927,176.74967227518607,640.1690912629101,175.6386972869873,656.7999877929688,178.05690957641602" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><circle cx="61.703125" cy="288.86991903889975" r="2" fill="#7a92a3" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="128.22671112023465" cy="265.64349680989585" r="2" fill="#7a92a3" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="194.75029724046934" cy="248.18023919881185" r="2" fill="#7a92a3" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="260.5508009028754" cy="243.51757837727865" r="2" fill="#7a92a3" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="325.62822210745276" cy="230.38876115722655" r="2" fill="#7a92a3" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="392.1518082276874" cy="218.42802252807616" r="2" fill="#7a92a3" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="458.67539434792207" cy="231.44099724324542" r="2" fill="#7a92a3" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="524.4758980103281" cy="111.49573697916665" r="2" fill="#7a92a3" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="590.2764016727341" cy="168.38406041870118" r="2" fill="#7a92a3" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="656.7999877929688" cy="178.05690957641602" r="2" fill="#7a92a3" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><path fill="#2677b5" stroke="none" d="M61.703125,288.86991903889975C78.33402153005866,288.5996198608399,111.59581459017599,290.49895426381426,128.22671112023465,287.78872232666015C144.85760765029332,285.078490389506,178.11940071041067,268.38800409657074,194.75029724046934,267.1880635416667C211.20042315607085,266.00116581888113,244.10067498727386,280.5443256798001,260.5508009028754,278.24136921590167C276.8201562040197,275.9637199658922,309.3588668063084,251.13674254172187,325.62822210745276,248.86564068603514C342.2591186375114,246.54406990022204,375.5209116976288,257.46936005910237,392.1518082276874,259.87067864990235C408.78270475774605,262.2719972407023,442.04449781786343,279.48472433433875,458.67539434792207,268.07618941243487C475.1255202635236,256.7916603048995,508.0257720947266,176.1780889503479,524.4758980103281,169.09842253214518C540.9260239259296,162.01875611394246,573.8262757571326,203.46900187164752,590.2764016727341,211.43885806681317C606.9072982027927,219.49629509928832,640.1690912629101,227.76541109873455,656.7999877929688,233.20759544270834L656.7999877929688,314.60626220703125L61.703125,314.60626220703125Z" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></path><path fill="none" stroke="#0b62a4" d="M61.703125,288.86991903889975C78.33402153005866,288.5996198608399,111.59581459017599,290.49895426381426,128.22671112023465,287.78872232666015C144.85760765029332,285.078490389506,178.11940071041067,268.38800409657074,194.75029724046934,267.1880635416667C211.20042315607085,266.00116581888113,244.10067498727386,280.5443256798001,260.5508009028754,278.24136921590167C276.8201562040197,275.9637199658922,309.3588668063084,251.13674254172187,325.62822210745276,248.86564068603514C342.2591186375114,246.54406990022204,375.5209116976288,257.46936005910237,392.1518082276874,259.87067864990235C408.78270475774605,262.2719972407023,442.04449781786343,279.48472433433875,458.67539434792207,268.07618941243487C475.1255202635236,256.7916603048995,508.0257720947266,176.1780889503479,524.4758980103281,169.09842253214518C540.9260239259296,162.01875611394246,573.8262757571326,203.46900187164752,590.2764016727341,211.43885806681317C606.9072982027927,219.49629509928832,640.1690912629101,227.76541109873455,656.7999877929688,233.20759544270834" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><circle cx="61.703125" cy="288.86991903889975" r="2" fill="#0b62a4" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="128.22671112023465" cy="287.78872232666015" r="2" fill="#0b62a4" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="194.75029724046934" cy="267.1880635416667" r="2" fill="#0b62a4" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="260.5508009028754" cy="278.24136921590167" r="2" fill="#0b62a4" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="325.62822210745276" cy="248.86564068603514" r="2" fill="#0b62a4" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="392.1518082276874" cy="259.87067864990235" r="2" fill="#0b62a4" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="458.67539434792207" cy="268.07618941243487" r="2" fill="#0b62a4" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="524.4758980103281" cy="169.09842253214518" r="2" fill="#0b62a4" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="590.2764016727341" cy="211.43885806681317" r="2" fill="#0b62a4" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle><circle cx="656.7999877929688" cy="233.20759544270834" r="2" fill="#0b62a4" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle></svg><div class="morris-hover morris-default-style" style="left: 569.725px; top: 130px; display: none;"><div class="morris-hover-row-label">2012 Q2</div><div class="morris-hover-point" style="color: #0b62a4">
                                            iPhone:
                                            8,432
                                        </div><div class="morris-hover-point" style="color: #7A92A3">
                                            iPad:
                                            5,713
                                        </div><div class="morris-hover-point" style="color: #4da74d">
                                            iPod Touch:
                                            1,791
                                        </div></div></div>
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
    <script>
        var ctx = $("#myChart");
        var bar = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
                datasets: [{
                    label: '# of Votes',
                    data: [12, 19, 3, 5, 2, 3],
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
</html>
