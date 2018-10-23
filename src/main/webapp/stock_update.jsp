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
        <link href="css/lightbox.css" rel="stylesheet">
    </head>
    <body>
        <div id="wrapper">
            <%@include file="/template/header.jsp" %>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><a href="listcommande" ><i class="fa fa-arrow-left"></i></a> Modification du stock <s:property value="stock.reference" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Modification du stock > <s:property value="stock.designation" />
                            </div>
                            <%@include file="/template/Erreur.jsp" %>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <form method="POST" action="modifStock">
                                    <a id="img" href="<s:property value="stock.image"/>" data-lightbox="image-1" data-title="<s:property value="stock.designation" />"><img id="printImg" src="<s:property value="stock.image"/>"  width="300px"> </a>
                                    
                                    <div class="form-group">
                                        <label>Image</label>
                                        <input id="file" type="file" class="form-control" accept="image/x-png,image/gif,image/jpeg" onchange="changeFile()" >
                                        <input id="base64" type="hidden" name="image" value="<s:property value="stock.image" />">
                                    </div>
                                    <div class="form-group">
                                        <label>Référence</label>
                                        <input name="reference" class="form-control" placeholder="Référence" value="<s:property value="stock.reference" />">
                                    </div>
                                    <div class="form-group">
                                        <label>Désignation</label>
                                        <input name="designation" class="form-control" placeholder="Désignation" value="<s:property value="stock.designation" />">
                                    </div>
                                    <div class="form-group">
                                        <label>Prix de Location unitaire (Ariary)</label>
                                        <input name="prixLocation" type="number" class="form-control" placeholder="Prix de Location" value="<s:property value="stock.prixLocation" />">
                                    </div>
                                    <div class="form-group">
                                        <label>Prix de casse unitaire (Ariary)</label>
                                        <input name="prixCasse" class="form-control" placeholder="Prix de Casse" type="number" value="<s:property value="stock.prixCasse" />">
                                    </div>
                                    <input name="idStock" type="hidden" value="<s:property value="stock.id" />"/>
                                    <button type="submit" class="btn btn-default">Modifier</button>
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
    <script src="js/lightbox.js" ></script>
    <script>
        function getBase64(file, callback) {
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function () {
              callback(false,reader.result);
            };
            reader.onerror = function (error) {
                callback(true,error);
            };
         }
         function changeFile(){
              var file = document.getElementById('file').files[0];
              getBase64(file, function(err, data) {
                if(!err) {
                    document.getElementById("base64").value = data;
                    document.getElementById("img").href = data;
                    document.getElementById("printImg").src = data;
                } else {
                    alert('une erreur s\'est parvenue lors du chargement de l\'image cause : '+data);
                }
             });
         }
         
    </script>
</html>
