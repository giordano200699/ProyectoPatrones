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
                <a class="nav-link" href="UserProfileController?parametro=index">
                    <i class="mdi mdi-home menu-icon"></i>
                    <span class="menu-title">Inicio</span>
                </a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="UserProfileController?parametro=userProfile">
                    <i class="mdi mdi-home menu-icon"></i>
                    <span class="menu-title">Mi Perfil</span>
                </a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="PublicationsController?parametro=competitions">
                    <i class="mdi mdi-home menu-icon"></i>
                    <span class="menu-title">Competencias</span>
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
                    <h2 style="padding-bottom: 0px; margin:0px;">Mi Perfil</h2>
                  </div>
                </div>
              </div>
                <hr>
            </div>
          </div>
          <div class="row">
            <div class="col-md-7">
                <div class="row">
                    <div class="col-md-12"style="background-color:#2A4A92; text-align: center; margin-bottom: 25px;">
                        <span style="color:white; font-size: 37px;">${person.name}</span>
                    </div>
                    <div class="col-md-6">
                        <span>Apellidos :</span>
                    </div>
                    <div class="col-md-6">
                        <p>${person.lastName}</p>
                    </div>
                    <div class="col-md-6">
                        <span>Nombre :</span>
                    </div>
                    <div class="col-md-6">
                        <p>${person.name}</p>
                    </div>
                    <div class="col-md-6">
                        <span>Edad :</span>
                    </div>
                    <div class="col-md-6">
                        <p>${person.age} años</p>
                    </div>
                    <div class="col-md-6">
                        <span>Dirección :</span>
                    </div>
                    <div class="col-md-6">
                        <p>${person.address}</p>
                    </div>
                    <div class="col-md-6">
                        <span>Tipo de usuario :</span>
                    </div>
                    <div class="col-md-6">
                        <p>${person.type}</p>
                    </div>
                </div>
                
            </div> 
            <div class="col-md-5 grid-margin stretch-card">
              <div class="card">
                  <img src="public/img/milco.png" class="rounded" alt="Juegos panamericanos">
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
  </script>
</body>

</html>

