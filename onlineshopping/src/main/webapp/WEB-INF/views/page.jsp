<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<spring:url var ="css"   value="/resources/css"></spring:url>
<spring:url var ="js"   value="/resources/js"></spring:url>
<spring:url var ="images"   value="/resources/images"></spring:url>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title} </title>
    <script >
    		window.menu='${title}';
    </script>
    
    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
		
    <!-- Bootstrap Readable Css -->
    <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">
  </head>

  <body>
    
    <!-- Navigation -->
    <%@include file="./shared/navbar.jsp" %>
    <!-- Page Content -->
   
    <!-- Home Page  Content-->
    <c:if test="${ ClickedHomeBtn == true}">
		<%@include  file="./shared/home.jsp" %>
	</c:if>
	
	<!-- Load only when user clicks -->
	<c:if test="${ ClickedAboutBtn == true}">
		<%@include  file="./shared/about.jsp" %>
	</c:if>
	
	<c:if test="${ ClickedContactBtn == true}">
		<%@include  file="./shared/contact.jsp" %>
	</c:if>
	
	<c:if test="${ ClickedAllProductsBtn == true  or  ClickedCategoryProductsBtn == true}">
		<%@include  file="./shared/listProducts.jsp" %>
	</c:if>
	
	<c:if test="${ ClickedShowProductBtn == true }">
		<%@include  file="./shared/singleProduct.jsp" %>
	</c:if>
	
    <!-- Footer  Page-->
    <%@include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/popper.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
  
   <!-- DataTable Plugin -->
   <%-- <script src="${js}/jquery.dataTables.js"></script> --%>
  
   
	<!-- Self Coded Javascript -->
	<script src="${js}/myapp.js"></script>
  </body>

</html>
  
