<div class="container">
		
		<div class="row">
		
				<!-- To display sidebar -->
	            <div  class="col-lg-3">
	            		<%@include file="sidebar.jsp" %>
	            </div>	
		  
		        <!-- To display actual products -->
				<div  class="col-lg-9">
	            
	            	<!-- Added breadcrumb -->
	            	  <div class="row">
	            	  			<div class="col-lg-12">
	            	  			
	            	  			
	            	  			        <c:if test ="${ClickedAllProductsBtn ==true }">
			            	  					<ol  class="breadcrumb">
			            	  							<li><a href="${contextPath }/home">Home</a></li>
			            	  							<li class="active">All Products</li>
			            	  					</ol>
	            	  					</c:if>
	            	  					
	            	  					  <c:if test ="${ClickedCategoryProductsBtn ==true }">
			            	  					<ol  class="breadcrumb">
			            	  							<li><a href="${contextPath }/home">Home</a></li>
			            	  							<li class="active">Category</li>
			            	  							<li class="active">${category.name}</li>
			            	  					</ol>
	            	  					</c:if>
	            	  					
	            	  					 
	            	  			</div>
	            	  		
	            	  </div>
	            </div>
		</div>

</div>