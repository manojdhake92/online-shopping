<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${contextPath}/home">Online Shopping</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active"  id="home">
              <a class="nav-link" href="${contextPath}/home">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item" id="about">
              <a class="nav-link" href="${contextPath}/about">About</a>
            </li>
            
            <li class="nav-item"  id="contact">
              <a class="nav-link" href="${contextPath}/contact">Contact</a>
            </li>
            
            <li class="nav-item"  id="viewProducts">
              <a class="nav-link" href="${contextPath}/show/all/products">View Products</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
