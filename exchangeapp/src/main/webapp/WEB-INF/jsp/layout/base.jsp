<html>
<head>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/sbadmin.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/bootstrap/bootstrap.css">


    <%
        String contenido = (String) request.getAttribute("contenido");
    %>


</head>
<body>
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav sidebar sidebar-dark accordion" id="accordionSidebar" style="background-color: #017e38;">
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" style="background-color: #FFFFFF">
                <img src="~/image/logo_elpino.png"  />
            </a>
            <hr class="sidebar-divider my-0">
            <div id="MenuLateral" style="background-color: #017e38;">
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/Estado">
                        <i class="bi bi-check-square"></i>
                        <span>Estado</span>
                    </a>
                </li>
            </div>

            <hr class="sidebar-divider">
            <div class="text-center d-none d-md-inline">
               <div id="MenuLateral" style="background-color: #017e38;">
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/Registro">
                        <i class="bi bi-check-square"></i>
                        <span>Registro</span>
                    </a>
                </li>
            </div>
            </div>
                        <div id="MenuLateral" style="background-color: #017e38;">
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/Perfil">
                        <i class="bi bi-check-square"></i>
                        <span>Perfil</span>
                    </a>
                </li>
            </div>
                        <div id="MenuLateral" style="background-color: #017e38;">
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/Mensaje">
                        <i class="bi bi-check-square"></i>
                        <span>Mensaje</span>
                    </a>
                </li>
            </div>
                        <div id="MenuLateral" style="background-color: #017e38;">
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/login">
                        <i class="bi bi-check-square"></i>
                        <span>login</span>
                    </a>
                </li>
            </div>
                        <div id="MenuLateral" style="background-color: #017e38;">
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/Valoraciones">
                        <i class="bi bi-check-square"></i>
                        <span>Valoraciones</span>
                    </a>
                </li>
            </div>
        </ul>
        <!-- End of Sidebar -->
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <div id="MenuPerfil">
        <header class="header bg-primary text-white text-center p-4">
        <h1>TruequePlace</h1>
        <p class="lead">Intercambia productos y servicios sin dinero</p>
    </header>
<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
    <!-- Topbar Navbar -->
    <!--<center>
        <header class="header bg-primary text-white text-center p-4">
        <h1>TruequePlace</h1>
    <a href="header.jsp"></a>
        <p class="lead">Intercambia productos y servicios sin dinero</p>
    </header>
    </center>-->
    
   <!-- Nav Item - Search Dropdown (Visible Only XS) -->
        <li class="nav-item dropdown no-arrow d-sm-none">
            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
               data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
            </a>
            <!-- Dropdown - Messages -->
            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                 aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small"
                               placeholder="Search for..." aria-label="Search"
                               aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </li>

        <div class="topbar-divider d-none d-sm-block"></div>
        <!-- Nav Item - Alerts -->
        <li class="nav-item dropdown no-arrow mx-1">
            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
               data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fa-solid fa-blender-phone fa-2x"></i>
            </a>
            <div class="dropdown-list dropdown-menu dropdown-menu-end shadow animated--grow-in"
                 aria-labelledby="alertsDropdown">
                <h6 class="dropdown-header">
                    Central Telefónica
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                    <div class="mr-3">
                        <div class="icon-circle">
                            <i class="fa-solid fa-phone-volume"></i>
                        </div>
                    </div>
                    <div>
                        <div class="small text-gray-500">Call Center Ventas</div>
                        <span class="font-weight-bold">(+51) 748-4000</span>
                    </div>

                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                    <div class="mr-3">
                        <div class="icon-circle">
                            <i class="fa-solid fa-arrows-to-dot"></i>
                        </div>
                    </div>
                    <div>
                        <div class="small text-gray-500">Central Telefónica</div>
                        <span class="font-weight-bold">(+51) 748-4000</span>
                    </div>

                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                    <div class="mr-3">
                        <div class="icon-circle">
                            <i class="fa-solid fa-user-tie"></i>
                        </div>
                    </div>
                    <div>
                        <div class="small text-gray-500">Servicio al cliente</div>
                        <span class="font-weight-bold">(+51) 204 6900 opción 5</span>
                    </div>

                </a>
            </div>
        </li>

                </div>


                <!-- End of Topbar -->
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <jsp:include page="<%= contenido %>" />
                </div>
            </div>
            <!-- End of Main Content -->
            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>
                            &copy;arlos NO HAY DARIO 2025
                        </span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <script src="<%= request.getContextPath() %>/javascript/bootstrap/bootstrap.js"></script>
    <script src="<%= request.getContextPath() %>/javascript/fontawesome/fontawesome.js"></script>
</body>
</html>
