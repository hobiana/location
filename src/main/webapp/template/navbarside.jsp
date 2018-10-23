<%@taglib  prefix="s" uri="/struts-tags"%>
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            
            <s:if test="getAccesRoot().equals(true)">
                <li>
                    <a><i class="fa fa-money fa-fw"></i> Caisse et caution<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="caisse"><i class="fa fa-money fa-fw"></i> Caisse</a>
                        </li>
                        <li>
                            <a href="findcaisse"><i class="fa fa-money fa-fw"></i> Historique Caisse</a>
                        </li>
                        <li>
                            <a href="quotient"><i class="fa fa-money fa-fw"></i> Caution</a>
                        </li>
                        <li>
                            <a href="findquotient"><i class="fa fa-money fa-fw"></i> Historique Caution</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="client"><i class="fa fa-users fa-fw"></i> Clients</a>
                </li>
                <li>
                    <a><i class="fa fa-shopping-cart fa-fw"></i> Commande<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="listcommande"><i class="fa fa-shopping-cart fa-fw"></i> Liste des commandes</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="indexUsers"><i class="fa fa-user fa-fw"></i> Gestions utilisateurs</a>
                </li>
                <li>
                    <a><i class="fa fa-database fa-fw"></i> Stocks<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="stock"><i class="fa fa-database fa-fw"></i> Stocks</a>
                        </li>
                        <li>
                            <a href="listInStock"><i class="fa fa-sign-in fa-fw"></i>Listes des entrées de stocks</a>
                        </li>
                        <li>
                            <a href="listOutStock"><i class="fa fa-sign-out fa-fw"></i>Listes des sorties de stocks</a>
                        </li>   
                        <li>
                            <a href="commandedujour"><i class="fa fa-shopping-cart fa-fw"></i>Commande du jour</a>
                        </li>
                        <li>
                            <a href="listcommandestock"><i class="fa fa-shopping-cart fa-fw"></i>Commande</a>
                        </li>
                    </ul>
                </li>
            </s:if>
            <s:elseif test="getAccesRoot().equals(false)">
                <s:if test="getAccesCaisseQuotient().equals(true)">
                <li>
                    <a><i class="fa fa-money fa-fw"></i> Caisse et caution<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="caisse"><i class="fa fa-money fa-fw"></i> Caisse</a>
                        </li>
                        <li>
                            <a href="findcaisse"><i class="fa fa-money fa-fw"></i> Historique Caisse</a>
                        </li>
                        <li>
                            <a href="quotient"><i class="fa fa-money fa-fw"></i> caution</a>
                        </li>
                        <li>
                            <a href="findquotient"><i class="fa fa-money fa-fw"></i> Historique Caution</a>
                        </li>
                    </ul>
                </li>
                </s:if>
                <s:if test="getAccesClient().equals(true)">
                <li>
                    <a href="client"><i class="fa fa-users fa-fw"></i> Clients</a>
                </li>
                </s:if>
                <s:if test="getAccesCommande().equals(true)">
                <li>
                    <a><i class="fa fa-shopping-cart fa-fw"></i> Commande<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="listcommande"><i class="fa fa-shopping-cart fa-fw"></i> Liste des commandes</a>
                        </li>
                    </ul>
                </li>
                </s:if>
                <s:if test="getAccesUser().equals(true)">
                <li>
                    <a href="indexUsers"><i class="fa fa-user fa-fw"></i> Gestions utilisateurs</a>
                </li>
                </s:if>
                <s:if test="getAccesStock().equals(true)">
                <li>
                    <a><i class="fa fa-database fa-fw"></i> Stocks<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="stock"><i class="fa fa-database fa-fw"></i> Stocks</a>
                        </li>
                        <li>
                            <a href="listInStock"><i class="fa fa-sign-in fa-fw"></i>Listes des entrées de stocks</a>
                        </li>
                        <li>
                            <a href="listOutStock"><i class="fa fa-sign-out fa-fw"></i>Listes des sorties de stocks</a>
                        </li>
                        <li>
                            <a href="commandedujour"><i class="fa fa-shopping-cart fa-fw"></i>Commande du jour</a>
                        </li>
                        <li>
                            <a href="listcommandestock"><i class="fa fa-shopping-cart fa-fw"></i>Commande</a>
                        </li>
                    </ul>
                </li>
                </s:if>
            </s:elseif>
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>