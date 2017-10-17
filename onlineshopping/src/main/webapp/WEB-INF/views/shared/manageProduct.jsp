<%@taglib prefix="sf"  uri="http://www.springframework.org/tags/form" %>

<div class="container">
	
	    <div class="row">
	    			<c:if test="${ not empty message}">
	    			<div class="col-md-offset-1 col-md-11">
	    				<div class="alert alert-success">
  							<strong >Success!</strong>${message} 
						</div>	
	    			</div>
	    			</c:if>
	    	
			
			<div class="col-md-offset-1 col-md-11">
			
				<div class = "panel panel-primary">
						
				  <div class="panel-heading">
				  		<h4>Product Management</h4>
				    <div class="panel-body">
				    
				    	<!-- FROM ELEMENT  -->
				   		<sf:form class="form-horizontal" modelAttribute="product" 
				   		method="POST" action="${contextPath}/manage/products" >
				   		
				   		<div class="form-group">
						    <label for="name" class="control-label col-md-3">Product Name</label>
						    <sf:input type="text" class="form-control col-md-9" id="name"  path="name" placeholder="Enter Product Name"/>
							<sf:errors cssClass="help-block col-md-offset-3" element="em" path="name" style="color: red"></sf:errors>
						</div>
						
						<div class="form-group">
						    <label for="brand" class="control-label col-md-3">Brand Name</label>
						    <sf:input type="text" class="form-control col-md-9" id="brand" path="brand" placeholder="Enter Brand Name"/>
							<sf:errors cssClass="help-block col-md-offset-3" element="em" path="brand" style="color: red"></sf:errors>
						</div>
						
						<div class="form-group">
						    <label for="description" class="control-label col-md-3">Product Description</label>
						    <sf:textarea class="form-control col-md-9" id="description" rows="4" path="description" placeholder="Enter Product description"/>
						    <sf:errors cssClass="help-block col-md-offset-3" element="em" path="description" style="color: red"></sf:errors>
					
						</div>
						
						<div class="form-group">
						    <label for="unitPrice" class="control-label col-md-3">Product Price</label>
						    <sf:input type="number" class="form-control col-md-9" id="unitPrice" path="unitPrice" placeholder="Enter Price In Rupees"/>
							<sf:errors cssClass="help-block col-md-offset-3" element="em" path="unitPrice" style="color: red"></sf:errors>
						</div>
						
						
						
						<div class="form-group">
						    <label for="quantity" class="control-label col-md-3">Quantity Available</label>
						    <sf:input type="number" class="form-control col-md-9" id="quantity" path="quantity" placeholder="Enter Quantity Available"/>
					
						</div>
						
						
						<div class="form-group">
						    <label for="categoryId" class="control-label col-md-3">Select Category:</label>
						    <sf:select path="categoryId" name="categoryId" class="from-control col-md-9"
								items="${categories}"						    
								itemLabel="name"
								itemValue="id">
						    </sf:select>
					
						</div>
						<sf:hidden path="id"/>
						<sf:hidden path="code"/>
						<sf:hidden path="active"/>
						<sf:hidden path="supplierId"/>
						<sf:hidden path="purchases"/>
						<sf:hidden path="views"/>
							  
						<button type="submit" id="submit" class="btn btn-primary" style="background-color:green">Submit</button>
				   		
				   		
				   		</sf:form>
				    </div>
				  </div>
				
				</div>
			
			</div>	    
	          
	    </div>

</div>



<script type="text/javascript">
var $alertClass = $('.alert');
alert("helloo")
	if($alertClass.length){
		alert("Inside oif")
		setTimeout(function(){
			$alertClass.fadeOut('slow');
		}, 3000)
	}	

</script>