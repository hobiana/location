<%@taglib  prefix="s" uri="/struts-tags"%>
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li>
                <a href="client"><i class="fa fa-users fa-fw"></i> Clients</a>
            </li>
            <li>
                <a href="indexUsers"><i class="fa fa-user fa-fw"></i> Gestion d'utilisateurs</a>
            </li>
            <li>
                <a><i class="fa fa-database fa-fw"></i> Stocks<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="stock"><i class="fa fa-database fa-fw"></i> Stocks</a>
                    </li>
                    <li>
                        <a href="listInStock"><i class="fa fa-sign-in fa-fw"></i>Listes des entr�es de stocks</a>
                    </li>
                    <li>
                        <a href="listOutStock"><i class="fa fa-sign-out fa-fw"></i>Listes des sorties de stocks</a>
                    </li>
                </ul>
            </li>
            <li>
                <a><i class="fa fa-shopping-cart fa-fw"></i> Commande<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="listcommande"><i class="fa fa-shopping-cart fa-fw"></i> Liste des commandes</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>