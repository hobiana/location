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
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-comments fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">26</div>
                                        <div>New Comments!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">12</div>
                                        <div>New Tasks!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-shopping-cart fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">124</div>
                                        <div>New Orders!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-support fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">13</div>
                                        <div>Support Tickets!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
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
                                <div class="row">
                                    <div class="col-lg-4">
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-hover table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>Date</th>
                                                        <th>Time</th>
                                                        <th>Amount</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>3326</td>
                                                        <td>10/21/2013</td>
                                                        <td>3:29 PM</td>
                                                        <td>$321.33</td>
                                                    </tr>
                                                    <tr>
                                                        <td>3325</td>
                                                        <td>10/21/2013</td>
                                                        <td>3:20 PM</td>
                                                        <td>$234.34</td>
                                                    </tr>
                                                    <tr>
                                                        <td>3324</td>
                                                        <td>10/21/2013</td>
                                                        <td>3:03 PM</td>
                                                        <td>$724.17</td>
                                                    </tr>
                                                    <tr>
                                                        <td>3323</td>
                                                        <td>10/21/2013</td>
                                                        <td>3:00 PM</td>
                                                        <td>$23.71</td>
                                                    </tr>
                                                    <tr>
                                                        <td>3322</td>
                                                        <td>10/21/2013</td>
                                                        <td>2:49 PM</td>
                                                        <td>$8345.23</td>
                                                    </tr>
                                                    <tr>
                                                        <td>3321</td>
                                                        <td>10/21/2013</td>
                                                        <td>2:23 PM</td>
                                                        <td>$245.12</td>
                                                    </tr>
                                                    <tr>
                                                        <td>3320</td>
                                                        <td>10/21/2013</td>
                                                        <td>2:15 PM</td>
                                                        <td>$5663.54</td>
                                                    </tr>
                                                    <tr>
                                                        <td>3319</td>
                                                        <td>10/21/2013</td>
                                                        <td>2:13 PM</td>
                                                        <td>$943.45</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.table-responsive -->
                                    </div>
                                    <!-- /.col-lg-4 (nested) -->
                                    <div class="col-lg-8">
                                        <div id="morris-bar-chart" style="position: relative; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg height="347.6000061035156" version="1.1" width="681.7999877929688" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style="overflow: hidden; position: relative; left: -0.4875px; top: -0.6px;"><desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.2.0</desc><defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs><text x="32.515625" y="314.60626220703125" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40313720703125">0</tspan></text><path fill="none" stroke="#aaaaaa" d="M45.015625,314.60626220703125H656.7999877929688" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="32.515625" y="242.20469665527344" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.4078216552734375">25</tspan></text><path fill="none" stroke="#aaaaaa" d="M45.015625,242.20469665527344H656.7999877929688" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="32.515625" y="169.80313110351562" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.412506103515625">50</tspan></text><path fill="none" stroke="#aaaaaa" d="M45.015625,169.80313110351562H656.7999877929688" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="32.515625" y="97.40156555175784" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.417190551757841">75</tspan></text><path fill="none" stroke="#aaaaaa" d="M45.015625,97.40156555175784H656.7999877929688" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="32.515625" y="25" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40625">100</tspan></text><path fill="none" stroke="#aaaaaa" d="M45.015625,25H656.7999877929688" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="613.1011047363281" y="327.10626220703125" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,6.7969)"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40313720703125">2012</tspan></text><text x="525.7033386230469" y="327.10626220703125" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,6.7969)"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40313720703125">2011</tspan></text><text x="438.3055725097656" y="327.10626220703125" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,6.7969)"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40313720703125">2010</tspan></text><text x="350.9078063964844" y="327.10626220703125" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,6.7969)"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40313720703125">2009</tspan></text><text x="263.5100402832031" y="327.10626220703125" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,6.7969)"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40313720703125">2008</tspan></text><text x="176.11227416992188" y="327.10626220703125" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,6.7969)"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40313720703125">2007</tspan></text><text x="88.71450805664062" y="327.10626220703125" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,6.7969)"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.40313720703125">2006</tspan></text><rect x="55.940345764160156" y="25" width="31.27416229248047" height="289.60626220703125" rx="0" ry="0" fill="#0b62a4" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="90.21450805664062" y="53.96062622070315" width="31.27416229248047" height="260.6456359863281" rx="0" ry="0" fill="#7a92a3" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="143.3381118774414" y="97.40156555175784" width="31.27416229248047" height="217.2046966552734" rx="0" ry="0" fill="#0b62a4" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="177.61227416992188" y="126.36219177246096" width="31.27416229248047" height="188.2440704345703" rx="0" ry="0" fill="#7a92a3" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="230.73587799072266" y="169.80313110351562" width="31.27416229248047" height="144.80313110351562" rx="0" ry="0" fill="#0b62a4" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="265.0100402832031" y="198.76375732421877" width="31.27416229248047" height="115.84250488281248" rx="0" ry="0" fill="#7a92a3" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="318.1336441040039" y="97.40156555175784" width="31.27416229248047" height="217.2046966552734" rx="0" ry="0" fill="#0b62a4" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="352.4078063964844" y="126.36219177246096" width="31.27416229248047" height="188.2440704345703" rx="0" ry="0" fill="#7a92a3" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="405.53141021728516" y="169.80313110351562" width="31.27416229248047" height="144.80313110351562" rx="0" ry="0" fill="#0b62a4" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="439.8055725097656" y="198.76375732421877" width="31.27416229248047" height="115.84250488281248" rx="0" ry="0" fill="#7a92a3" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="492.9291763305664" y="97.40156555175784" width="31.27416229248047" height="217.2046966552734" rx="0" ry="0" fill="#0b62a4" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="527.2033386230469" y="126.36219177246096" width="31.27416229248047" height="188.2440704345703" rx="0" ry="0" fill="#7a92a3" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="580.3269424438477" y="25" width="31.27416229248047" height="289.60626220703125" rx="0" ry="0" fill="#0b62a4" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="614.6011047363281" y="53.96062622070315" width="31.27416229248047" height="260.6456359863281" rx="0" ry="0" fill="#7a92a3" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect></svg><div class="morris-hover morris-default-style" style="display: none;"></div></div>
                                    </div>
                                    <!-- /.col-lg-8 (nested) -->
                                </div>
                                <!-- /.row -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-clock-o fa-fw"></i> Responsive Timeline
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <ul class="timeline">
                                    <li>
                                        <div class="timeline-badge"><i class="fa fa-check"></i>
                                        </div>
                                        <div class="timeline-panel">
                                            <div class="timeline-heading">
                                                <h4 class="timeline-title">Lorem ipsum dolor</h4>
                                                <p><small class="text-muted"><i class="fa fa-clock-o"></i> 11 hours ago via Twitter</small>
                                                </p>
                                            </div>
                                            <div class="timeline-body">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Libero laboriosam dolor perspiciatis omnis exercitationem. Beatae, officia pariatur? Est cum veniam excepturi. Maiores praesentium, porro voluptas suscipit facere rem dicta, debitis.</p>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="timeline-inverted">
                                        <div class="timeline-badge warning"><i class="fa fa-credit-card"></i>
                                        </div>
                                        <div class="timeline-panel">
                                            <div class="timeline-heading">
                                                <h4 class="timeline-title">Lorem ipsum dolor</h4>
                                            </div>
                                            <div class="timeline-body">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Autem dolorem quibusdam, tenetur commodi provident cumque magni voluptatem libero, quis rerum. Fugiat esse debitis optio, tempore. Animi officiis alias, officia repellendus.</p>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium maiores odit qui est tempora eos, nostrum provident explicabo dignissimos debitis vel! Adipisci eius voluptates, ad aut recusandae minus eaque facere.</p>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="timeline-badge danger"><i class="fa fa-bomb"></i>
                                        </div>
                                        <div class="timeline-panel">
                                            <div class="timeline-heading">
                                                <h4 class="timeline-title">Lorem ipsum dolor</h4>
                                            </div>
                                            <div class="timeline-body">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus numquam facilis enim eaque, tenetur nam id qui vel velit similique nihil iure molestias aliquam, voluptatem totam quaerat, magni commodi quisquam.</p>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="timeline-inverted">
                                        <div class="timeline-panel">
                                            <div class="timeline-heading">
                                                <h4 class="timeline-title">Lorem ipsum dolor</h4>
                                            </div>
                                            <div class="timeline-body">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptates est quaerat asperiores sapiente, eligendi, nihil. Itaque quos, alias sapiente rerum quas odit! Aperiam officiis quidem delectus libero, omnis ut debitis!</p>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="timeline-badge info"><i class="fa fa-save"></i>
                                        </div>
                                        <div class="timeline-panel">
                                            <div class="timeline-heading">
                                                <h4 class="timeline-title">Lorem ipsum dolor</h4>
                                            </div>
                                            <div class="timeline-body">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nobis minus modi quam ipsum alias at est molestiae excepturi delectus nesciunt, quibusdam debitis amet, beatae consequuntur impedit nulla qui! Laborum, atque.</p>
                                                <hr>
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown">
                                                        <i class="fa fa-gear"></i> <span class="caret"></span>
                                                    </button>
                                                    <ul class="dropdown-menu" role="menu">
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
                                    </li>
                                    <li>
                                        <div class="timeline-panel">
                                            <div class="timeline-heading">
                                                <h4 class="timeline-title">Lorem ipsum dolor</h4>
                                            </div>
                                            <div class="timeline-body">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi fuga odio quibusdam. Iure expedita, incidunt unde quis nam! Quod, quisquam. Officia quam qui adipisci quas consequuntur nostrum sequi. Consequuntur, commodi.</p>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="timeline-inverted">
                                        <div class="timeline-badge success"><i class="fa fa-graduation-cap"></i>
                                        </div>
                                        <div class="timeline-panel">
                                            <div class="timeline-heading">
                                                <h4 class="timeline-title">Lorem ipsum dolor</h4>
                                            </div>
                                            <div class="timeline-body">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deserunt obcaecati, quaerat tempore officia voluptas debitis consectetur culpa amet, accusamus dolorum fugiat, animi dicta aperiam, enim incidunt quisquam maxime neque eaque.</p>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-8 -->
                    <div class="col-lg-4">
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
                        <!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> Donut Chart Example
                            </div>
                            <div class="panel-body">
                                <div id="morris-donut-chart"><svg height="347.6000061035156" version="1.1" width="681.7999877929688" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style="overflow: hidden; position: relative; left: -0.4625px;"><desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.2.0</desc><defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs><path fill="none" stroke="#0b62a4" d="M340.8999938964844,287.6666768391927A111.06667073567708,111.06667073567708,0,0,0,445.76039347101954,213.20740903483727" stroke-width="2" opacity="0" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path><path fill="#0b62a4" stroke="#ffffff" d="M340.8999938964844,290.6666768391927A114.06667073567708,114.06667073567708,0,0,0,448.59275710125985,214.1962043959166L493.4699872078866,229.8631182320325A161.60000610351562,161.60000610351562,0,0,1,340.8999938964844,338.20001220703125Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><path fill="none" stroke="#3980b5" d="M445.76039347101954,213.20740903483727A111.06667073567708,111.06667073567708,0,0,0,241.26541178131458,127.52093322063826" stroke-width="2" opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 1;"></path><path fill="#3980b5" stroke="#ffffff" d="M448.59275710125985,214.1962043959166A114.06667073567708,114.06667073567708,0,0,0,238.574201678719,126.19526803527373L191.44812072372966,102.98139677919956A166.60000610351562,166.60000610351562,0,0,1,498.1905932582871,231.5111105004981Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><path fill="none" stroke="#679dc6" d="M241.26541178131458,127.52093322063826A111.06667073567708,111.06667073567708,0,0,0,340.8651012733741,287.66667135827225" stroke-width="2" opacity="0" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path><path fill="#679dc6" stroke="#ffffff" d="M238.574201678719,126.19526803527373A114.06667073567708,114.06667073567708,0,0,0,340.8641587955935,290.6666712102282L340.84922575811987,338.20000423239065A161.60000610351562,161.60000610351562,0,0,1,195.93347089472226,105.1908387548071Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="340.8999938964844" y="166.60000610351562" text-anchor="middle" font-family="&quot;Arial&quot;" font-size="15px" stroke="none" fill="#000000" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: Arial; font-size: 15px; font-weight: 800;" font-weight="800" transform="matrix(1.7283,0,0,1.7283,-248.437,-129.2002)" stroke-width="0.5785907901274234"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="6.006256103515625">In-Store Sales</tspan></text><text x="340.8999938964844" y="186.60000610351562" text-anchor="middle" font-family="&quot;Arial&quot;" font-size="14px" stroke="none" fill="#000000" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: Arial; font-size: 14px;" transform="matrix(2.3139,0,0,2.3139,-448.0361,-234.6524)" stroke-width="0.4321728533146833"><tspan style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" dy="4.803131103515625">30</tspan></text></svg></div>
                                <a href="#" class="btn btn-default btn-block">View Details</a>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                        <div class="chat-panel panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-comments fa-fw"></i> Chat
                                <div class="btn-group pull-right">
                                    <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                        <i class="fa fa-chevron-down"></i>
                                    </button>
                                    <ul class="dropdown-menu slidedown">
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-refresh fa-fw"></i> Refresh
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-check-circle fa-fw"></i> Available
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-times fa-fw"></i> Busy
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-clock-o fa-fw"></i> Away
                                            </a>
                                        </li>
                                        <li class="divider"></li>
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-sign-out fa-fw"></i> Sign Out
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <ul class="chat">
                                    <li class="left clearfix">
                                        <span class="chat-img pull-left">
                                            <img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body clearfix">
                                            <div class="header">
                                                <strong class="primary-font">Jack Sparrow</strong>
                                                <small class="pull-right text-muted">
                                                    <i class="fa fa-clock-o fa-fw"></i> 12 mins ago
                                                </small>
                                            </div>
                                            <p>
                                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                            </p>
                                        </div>
                                    </li>
                                    <li class="right clearfix">
                                        <span class="chat-img pull-right">
                                            <img src="http://placehold.it/50/FA6F57/fff" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body clearfix">
                                            <div class="header">
                                                <small class=" text-muted">
                                                    <i class="fa fa-clock-o fa-fw"></i> 13 mins ago</small>
                                                <strong class="pull-right primary-font">Bhaumik Patel</strong>
                                            </div>
                                            <p>
                                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                            </p>
                                        </div>
                                    </li>
                                    <li class="left clearfix">
                                        <span class="chat-img pull-left">
                                            <img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body clearfix">
                                            <div class="header">
                                                <strong class="primary-font">Jack Sparrow</strong>
                                                <small class="pull-right text-muted">
                                                    <i class="fa fa-clock-o fa-fw"></i> 14 mins ago</small>
                                            </div>
                                            <p>
                                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                            </p>
                                        </div>
                                    </li>
                                    <li class="right clearfix">
                                        <span class="chat-img pull-right">
                                            <img src="http://placehold.it/50/FA6F57/fff" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body clearfix">
                                            <div class="header">
                                                <small class=" text-muted">
                                                    <i class="fa fa-clock-o fa-fw"></i> 15 mins ago</small>
                                                <strong class="pull-right primary-font">Bhaumik Patel</strong>
                                            </div>
                                            <p>
                                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                            </p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <!-- /.panel-body -->
                            <div class="panel-footer">
                                <div class="input-group">
                                    <input id="btn-input" type="text" class="form-control input-sm" placeholder="Type your message here...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-warning btn-sm" id="btn-chat">
                                            Send
                                        </button>
                                    </span>
                                </div>
                            </div>
                            <!-- /.panel-footer -->
                        </div>
                        <!-- /.panel .chat-panel -->
                    </div>
                    <!-- /.col-lg-4 -->
                </div>
                <!-- /.row -->
            </div>
       </div>
    </body>
    <%@include file="/template/footer.jsp" %>
</html>
