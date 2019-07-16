<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Patrones</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="public/vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="public/vendors/base/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <link rel="stylesheet" href="public/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="public/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="public/images/favicon.png" />
</head>
<body>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
      <div class="navbar-brand-wrapper d-flex justify-content-center">
        <div class="navbar-brand-inner-wrapper d-flex justify-content-between align-items-center w-100">  
          <a class="navbar-brand brand-logo" href="index.html"><img src="public/images/logo.svg" alt="logo"/></a>
          <a class="navbar-brand brand-logo-mini" href="index.html"><img src="public/images/logo-mini.svg" alt="logo"/></a>
          <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
            <span class="mdi mdi-sort-variant"></span>
          </button>
        </div>  
      </div>
      <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
        <ul class="navbar-nav mr-lg-4 w-100">
          <li class="nav-item nav-search d-none d-lg-block w-100">
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text" id="search">
                  <i class="mdi mdi-magnify"></i>
                </span>
              </div>
              <input type="text" class="form-control" placeholder="Buscar" aria-label="search" aria-describedby="search">
            </div>
          </li>
        </ul>
        <ul class="navbar-nav navbar-nav-right">
          <li class="nav-item dropdown mr-1">
            <a class="nav-link count-indicator dropdown-toggle d-flex justify-content-center align-items-center" id="messageDropdown" href="#" data-toggle="dropdown">
              <i class="mdi mdi-message-text mx-0"></i>
              <span class="count"></span>
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="messageDropdown">
              <p class="mb-0 font-weight-normal float-left dropdown-header">Mensajes</p>
              <a class="dropdown-item">
                <div class="item-thumbnail">
                    <img src="public/images/faces/face4.jpg" alt="image" class="profile-pic">
                </div>
                <div class="item-content flex-grow">
                  <h6 class="ellipsis font-weight-normal">David Grey
                  </h6>
                  <p class="font-weight-light small-text text-muted mb-0">
                    The meeting is cancelled
                  </p>
                </div>
              </a>
              <a class="dropdown-item">
                <div class="item-thumbnail">
                    <img src="public/images/faces/face2.jpg" alt="image" class="profile-pic">
                </div>
                <div class="item-content flex-grow">
                  <h6 class="ellipsis font-weight-normal">Tim Cook
                  </h6>
                  <p class="font-weight-light small-text text-muted mb-0">
                    New product launch
                  </p>
                </div>
              </a>
              <a class="dropdown-item">
                <div class="item-thumbnail">
                    <img src="public/images/faces/face3.jpg" alt="image" class="profile-pic">
                </div>
                <div class="item-content flex-grow">
                  <h6 class="ellipsis font-weight-normal"> Johnson
                  </h6>
                  <p class="font-weight-light small-text text-muted mb-0">
                    Upcoming board meeting
                  </p>
                </div>
              </a>
            </div>
          </li>
          <li class="nav-item dropdown mr-4">
            <a class="nav-link count-indicator dropdown-toggle d-flex align-items-center justify-content-center notification-dropdown" id="notificationDropdown" href="#" data-toggle="dropdown">
              <i class="mdi mdi-bell mx-0"></i>
              <span class="count"></span>
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="notificationDropdown">
              <p class="mb-0 font-weight-normal float-left dropdown-header">Notificaciones</p>
              <a class="dropdown-item">
                <div class="item-thumbnail">
                  <div class="item-icon bg-success">
                    <i class="mdi mdi-information mx-0"></i>
                  </div>
                </div>
                <div class="item-content">
                  <h6 class="font-weight-normal">Application Error</h6>
                  <p class="font-weight-light small-text mb-0 text-muted">
                    Just now
                  </p>
                </div>
              </a>
              <a class="dropdown-item">
                <div class="item-thumbnail">
                  <div class="item-icon bg-warning">
                    <i class="mdi mdi-settings mx-0"></i>
                  </div>
                </div>
                <div class="item-content">
                  <h6 class="font-weight-normal">Settings</h6>
                  <p class="font-weight-light small-text mb-0 text-muted">
                    Private message
                  </p>
                </div>
              </a>
              <a class="dropdown-item">
                <div class="item-thumbnail">
                  <div class="item-icon bg-info">
                    <i class="mdi mdi-account-box mx-0"></i>
                  </div>
                </div>
                <div class="item-content">
                  <h6 class="font-weight-normal">New user registration</h6>
                  <p class="font-weight-light small-text mb-0 text-muted">
                    2 days ago
                  </p>
                </div>
              </a>
            </div>
          </li>
          <li class="nav-item nav-profile dropdown">
            <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
              <img src="public/images/faces/face5.jpg" alt="profile"/>
              <span class="nav-profile-name">${person.name}</span>
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
              <a class="dropdown-item">
                <i class="mdi mdi-settings text-primary"></i>
                Configuración
              </a>
              <a class="dropdown-item" href="LoginController?parametro=logout">
                <i class="mdi mdi-logout text-primary"></i>
                Cerrar Sesión
              </a>
            </div>
          </li>
        </ul>
        <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
          <span class="mdi mdi-menu"></span>
        </button>
      </div>
    </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_sidebar.html -->
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="administrador.jsp">
                    <i class="mdi mdi-home menu-icon"></i>
                    <span class="menu-title">Inicio</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="SedesControlador?pagina=verSedes">
                    <i class="mdi mdi-home menu-icon"></i>
                    <span class="menu-title">Sedes</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="UsersController?page=showUsers">
                    <i class="mdi mdi-home menu-icon"></i>
                    <span class="menu-title">Usuarios</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="CompetitionsController?page=showCompetitions">
                    <i class="mdi mdi-home menu-icon"></i>
                    <span class="menu-title">Competencias</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="StatisticController?parametro=CompetitionStatistic">
                    <i class="mdi mdi-home menu-icon"></i>
                    <span class="menu-title">Estadistica</span>
                </a>
            </li>
          
        </ul>
      </nav>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper" style="padding-top: 12px;">
          
          <div class="row">
            <div class="col-md-12">
              <div class="d-flex justify-content-between flex-wrap" >
                <div class="d-flex align-items-end flex-wrap">
                  <div class="mr-md-3 mr-xl-5">
                    <h2 style="padding-bottom: 0px; margin:0px;">Publicaciones de ${competition.title}</h2>
                  </div>
                </div>
              </div>
                <hr>
            </div>
          </div>
          <div class="row">
            <div class="col col-md-8">
                <div class="row" >
                    <div class="col col-md-12">
                        <div class="media">
                            <div class="media-body">
                              <div class="form-group">
                                <label for="txtArea">Crear publicación :</label>
                                <textarea class="form-control" id="txtArea" rows="3"></textarea>
                                <a id="botonPublicar" class="btn btn-info btn-lg btn-block" style="margin-top:10px;">Publicar</a>
                              </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row"id="divPublications">
                </div>
            </div>
            <div class="col col-md-4">
                <div class="row">
                    <c:forEach items="${competitors}" var="competitor">
                        <div class="col col-md-12">
                        <div class="card" style="width: 18rem;">
                            <div class="card-body">
                              <h5 class="card-title">${personsH.get(competitor.getPersonId())}</h5>
                              <div class="row">
                                  <div class="col col-md-6" style="text-align:center;">
                                      <button type="button" class="btn btn-sm btn-link likeCompetidor ${cReactionsH.get(competitor.getCompetitorId())!=null?cReactionsH.get(competitor.getCompetitorId())==1?'disabled':'':''}" id="likeComp${competitor.getCompetitorId()}" data-competitorid="${competitor.getCompetitorId()}">
                                            <i class="mdi mdi-thumb-up-outline" style="font-size: 18px;">Like</i>
                                        </button> 
                                  </div>
                                  <div class="col col-md-6" style="text-align:center;">
                                      <button type="button" class="btn btn-sm btn-link dislikeCompetidor ${cReactionsH.get(competitor.getCompetitorId())!=null?cReactionsH.get(competitor.getCompetitorId())==0?'disabled':'':''}" id="dislikeComp${competitor.getCompetitorId()}" data-competitorid="${competitor.getCompetitorId()}">
                                            <i class="mdi mdi-thumb-down-outline" style="font-size: 18px;">Dislike</i>
                                        </button> 
                                  </div>          
                              
                                
                              </div>
                            </div>
                          </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2018 <a href="https://www.urbanui.com/" target="_blank">Urbanui</a>. All rights reserved.</span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="mdi mdi-heart text-danger"></i></span>
          </div>
        </footer>
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->

  <!-- plugins:js -->
  <script src="public/vendors/base/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <script src="public/vendors/chart.js/Chart.min.js"></script>
  <script src="public/vendors/datatables.net/jquery.dataTables.js"></script>
  <script src="public/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="public/js/off-canvas.js"></script>
  <script src="public/js/hoverable-collapse.js"></script>
  <script src="public/js/template.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="public/js/dashboard.js"></script>
  <script src="public/js/data-table.js"></script>
  <script src="public/js/jquery.dataTables.js"></script>
  <script src="public/js/dataTables.bootstrap4.js"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <!-- End custom js for this page-->
  
  <script>
    /*  
    swal("Click OK to speak").then(() => {
          const ut = new SpeechSynthesisUtterance('Hola Mundo, vamos a jalara jajajaja equisde');
            speechSynthesis.speak(ut);
      });
    */     
   var likeOrDislike = function(value,publicationId){
       $.ajax({
            url : 'PublicationsController?parametro=setLikeOrDislike',
            scriptCharset: "utf-8" ,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            // la información a enviar
            // (también es posible utilizar una cadena de datos)
            data : { personId : ${person.personId},
                    publicationId: publicationId,
                    value: value
                    },

            // especifica si será una petición POST o GET
            type : 'GET',

            // el tipo de información que se espera de respuesta
            dataType : 'html',

            // código a ejecutar si la petición es satisfactoria;
            // la respuesta es pasada como argumento a la función
            success : function(html) {
                
            },

            // código a ejecutar sin importar si la petición falló o no
            complete : function(xhr, status) {
                //alert('Petición realizada');
            }
        });
   }
   
   var likeOrDislikeComp = function(value,competitorId){
       $.ajax({
            url : 'PublicationsController?parametro=setLikeOrDislikeComp',
            scriptCharset: "utf-8" ,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            // la información a enviar
            // (también es posible utilizar una cadena de datos)
            data : { personId : ${person.personId},
                    competitorId: competitorId,
                    value: value
                    },

            // especifica si será una petición POST o GET
            type : 'GET',

            // el tipo de información que se espera de respuesta
            dataType : 'html',

            // código a ejecutar si la petición es satisfactoria;
            // la respuesta es pasada como argumento a la función
            success : function(html) {
                
            },

            // código a ejecutar sin importar si la petición falló o no
            complete : function(xhr, status) {
                //alert('Petición realizada');
            }
        });
   }
   var reportPublication = function(publicationId){
       $.ajax({
            url : 'AdminPublicationsController?parametro=reportPublication',
            scriptCharset: "utf-8" ,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            // la información a enviar
            // (también es posible utilizar una cadena de datos)
            data : { personId : ${person.personId},
                    publicationId: publicationId
                    },

            // especifica si será una petición POST o GET
            type : 'GET',

            // el tipo de información que se espera de respuesta
            dataType : 'html',

            // código a ejecutar si la petición es satisfactoria;
            // la respuesta es pasada como argumento a la función
            success : function(html) {
                
            },

            // código a ejecutar sin importar si la petición falló o no
            complete : function(xhr, status) {
                //alert('Petición realizada');
            }
        });
   }
   
   var idDivComentario;
    var crearPublicacion = function(texto,parentId){
        if(texto!=null){
            var url = 'AdminPublicationsController?parametro=getPublications&competitionId=${competition.competitionId}';
        }else{
            if(parentId==0){
                var url = 'AdminPublicationsController?parametro=getPublicationsAlone&competitionId=${competition.competitionId}'
            }else{
                var url = 'PublicationsController?parametro=getPublicationsChildrenAlone&competitionId=${competition.competitionId}'
            }
        }
        
        
        $.ajax({
            url : url,
            scriptCharset: "utf-8" ,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            // la información a enviar
            // (también es posible utilizar una cadena de datos)
            data : { personId : ${person.personId},
                       competitionId: ${competition.competitionId},
                    txtPublication : texto,
                    parentId: parentId
                    },

            // especifica si será una petición POST o GET
            type : 'GET',

            // el tipo de información que se espera de respuesta
            dataType : 'html',

            // código a ejecutar si la petición es satisfactoria;
            // la respuesta es pasada como argumento a la función
            success : function(json) {
                //alert(json);
                if(parentId==0){
                   $("#divPublications").html(json);
                    $(".txtAreaComentario").keypress(function() {
                        var key = window.event.keyCode;
                        if (key === 13) {
                            if($(this).val()!=""){
                                idDivComentario = "divVC"+$(this).data("publicationid");
                                crearPublicacion($(this).val(),$(this).data("publicationid"));
                                $(this).val("");
                            }
                        }
                      });
                    $(".visualizarComentarios").on("click",function(){
                        idDivComentario = "divVC"+$(this).data("publicationid");
                        crearPublicacion(null,$(this).data("publicationid"));
                        
                    })
                    $(".dislikeComentarios").on("click",function(){
                        likeOrDislike(0,$(this).data("publicationid"))
                        $(this).addClass("disabled");
                        $("#like"+$(this).data("publicationid")).removeClass("disabled");
                    })
                    $(".likeComentarios").on("click",function(){
                        likeOrDislike(1,$(this).data("publicationid"))
                        $(this).addClass("disabled");
                        $("#dislike"+$(this).data("publicationid")).removeClass("disabled");
                    })
                    $(".soundComentarios").unbind("click");
                    $(".soundComentarios").on("click",function(){
                        const ut = new SpeechSynthesisUtterance($("#person"+$(this).data("publicationid")).html()+" comentó, "+$("#content"+$(this).data("publicationid")).html());
                        speechSynthesis.speak(ut);
                    })
                    
                    
                    $(".reportComentarios").unbind("click");
                    $(".reportComentarios").on("click",function(){
                        reportPublication($(this).data("publicationid"));
                        $("#todo"+$(this).data("publicationid")).remove();
                    })
                }else{
                    $("#"+idDivComentario).html(json);
                    $( ".likeComentarios2" ).unbind("click");
                    $( ".likeComentarios2" ).on("click",function(){
                        likeOrDislike(1,$(this).data("publicationid"))
                        $(this).addClass("disabled");
                        $("#dislikeC"+$(this).data("publicationid")).removeClass("disabled");
                    });
                    $( ".dislikeComentarios2" ).unbind("click");
                    $( ".dislikeComentarios2" ).on("click",function(){
                        likeOrDislike(0,$(this).data("publicationid"))
                        $(this).addClass("disabled");
                        $("#likeC"+$(this).data("publicationid")).removeClass("disabled");
                    });
                    $(".soundComentarios").unbind("click");
                    $(".soundComentarios").on("click",function(){
                        const ut = new SpeechSynthesisUtterance($("#person"+$(this).data("publicationid")).html()+" comentó, "+$("#content"+$(this).data("publicationid")).html());
                        speechSynthesis.speak(ut);
                    })
                }
                
                
            },

            // código a ejecutar sin importar si la petición falló o no
            complete : function(xhr, status) {
                //alert('Petición realizada');
            }
        });
    }
    $("#botonPublicar").on("click",function(){
        crearPublicacion($("#txtArea").val(),0);
    })
    crearPublicacion(null,0);
    $( ".likeCompetidor" ).on("click",function(){
        likeOrDislikeComp(1,$(this).data("competitorid"))
        $(this).addClass("disabled");
        $("#dislikeComp"+$(this).data("competitorid")).removeClass("disabled");
    });
    $( ".dislikeCompetidor" ).on("click",function(){
        likeOrDislikeComp(0,$(this).data("competitorid"))
        $(this).addClass("disabled");
        $("#likeComp"+$(this).data("competitorid")).removeClass("disabled");
    });
  </script>
</body>

</html>

