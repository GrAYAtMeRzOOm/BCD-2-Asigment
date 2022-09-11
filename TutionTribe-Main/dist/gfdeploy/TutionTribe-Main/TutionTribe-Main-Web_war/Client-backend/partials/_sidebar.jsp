<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
  <ul class="nav">
    <li class="nav-item nav-profile border-bottom">
      <a href="#" class="nav-link flex-column">
        <div class="nav-profile-text d-flex ms-0 mb-3 flex-column">
            <span class="font-weight-semibold mb-1 mt-2 text-center"></span>
          <!--<span class="text-secondary icon-sm text-center">$3499.00</span>-->
        </div>
      </a>
    </li>
    <li class="nav-item pt-3">
      <a class="nav-link d-block" href="index.jsp">
          <img class="sidebar-brand-logo" src="../Client-backend/User-login/img/logox100.png" alt="" />
        <!--<div class="small font-weight-light pt-1">Responsive Dashboard</div>-->
      </a>
    </li>
    <li class="pt-2 pb-1">
      <span class="nav-item-head">Pages</span>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="index.jsp">
        <i class="mdi mdi-compass-outline menu-icon"></i>
        <span class="menu-title">Dashboard</span>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="usermanager.jsp">
        <i class="mdi mdi-account-card-details menu-icon"></i>
        <span class="menu-title">User Management</span>
        <i class="menu-arrow"></i>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="institutemanager.jsp">
        <i class="mdi mdi-home-modern menu-icon"></i>
        <span class="menu-title">Institute Management</span>
        <i class="menu-arrow"></i>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="attendance.jsp">
        <i class="mdi mdi-calendar-check menu-icon"></i>
        <span class="menu-title">Attendance Management</span>
      </a>
    </li>
  </ul>
</nav>