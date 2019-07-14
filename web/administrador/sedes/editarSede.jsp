<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
              <span class="nav-profile-name">Louis Barnett</span>
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
              <a class="dropdown-item">
                <i class="mdi mdi-settings text-primary"></i>
                Configuración
              </a>
              <a class="dropdown-item">
                <i class="mdi mdi-logout text-primary" href="index.jsp"></i>
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
          
        </ul>
      </nav>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          
            <div class="row">
                <div class="col-md-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h2 class="card-title" style="font-size: 25px;">Editar Sede</h2>
                            <p class="card-description">
                                Lugar que alberga cualquier actividad organizada por los Juegos Panamericanos
                            </p>
                            <form class="forms-sample" action="SedesControlador" method="POST">
                                <input type="hidden" name="_method" value="PUT" />
                                <input type="hidden" name="sedeId" value="${sede.sedeId}" />
                                <div class="form-group row">
                                    <label for="nombreSede" class="col-sm-2 col-form-label">Nombre :</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="nombreSede" name="nombreSede" placeholder="Nombre" value="${sede.nombre}">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="direccionSede" class="col-sm-2 col-form-label">Dirección :</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="direccionSede" name="direccionSede" placeholder="Dirección" value="${sede.direccion}">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="aforoSede" class="col-sm-2 col-form-label">Aforo :</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="aforoSede" name="aforoSede" placeholder="Aforo" value="${sede.aforo}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col col-md-10">
                                        <button type="submit" class="btn btn-primary mr-2">Editar Sede</button>
                                        <a class="btn btn-light" href="SedesControlador?pagina=verSedes">Cancelar</a>
                                    </div>
                                    </form>
                                    <form class="forms-sample" action="SedesControlador" method="POST">
                                    <input type="hidden" name="_method" value="DELETE" />
                                    <input type="hidden" name="sedeId" value="${sede.sedeId}" />
                                    <div class="col col-md-2">
                                        <button type="submit" class="btn btn-danger mr-2">Eliminar</button>
                                    </div>    
                                </div>
                            </form>
                        </div>
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
  <!-- End custom js for this page-->
</body>

</html>

