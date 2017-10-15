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
	            	  			        		<script>
	            	  			        				window.categoryId = '';
	            	  			        				window.contextPath = '${contextPath}'
	            	  			        		</script>
			            	  					<ol  class="breadcrumb">
			            	  							<li><a href="${contextPath }/home">Home</a></li>
			            	  							<li class="active">All Products</li>
			            	  					</ol>
	            	  					</c:if>
	            	  					
	            	  					  <c:if test ="${ClickedCategoryProductsBtn ==true }">
	            	  					  	<script>
	            	  			        				window.categoryId = '${category.id}';
	            	  			        				window.contextPath = '${contextPath}'
	            	  			        		</script>
			            	  					<ol  class="breadcrumb">
			            	  							<li><a href="${contextPath }/home">Home</a></li>
			            	  							<li class="active">Category</li>
			            	  							<li class="active">${category.name}</li>
			            	  					</ol>
	            	  					</c:if>
	            	  					
	            	  					 
	            	  			</div>
	            	  		
	            	  </div>
	            			
	            			<div class="row">
	            			
		            			 <table id="productDataTable" class="table table-striped table-borderd">
		            					
		            			        <thead>	
		            			        		<tr>	
		            			        		        <th>Image</th>
		            									<th>Name</th>
		            									<th>Brand</th>
		            									<th>Price</th>
		            									<th>Ava. Qty</th>
		            									<th></th>
		            							</tr>
		            					</thead>		
		            					<tfoot>
		            							<tr>
		            							       <th>Image</th>
		            								    <th>Name</th>
		            									<th>Brand</th>
		            									<th>Price</th>
		            									<th>Ava. Qty</th>
		            									<th></th>
		            							</tr>
		            						
		            					</tfoot>		
		            			</table>
		            			   </div>
	            </div>
		</div>

</div>

 <script src="${js}/jquery.min.js"></script>
 <script type="text/javascript" src="${js}/jquery.dataTables.js"></script>
  <script type="text/javascript" src="${js}/dataTables.bootstrap.js"></script>
 <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<script >

var $productTable = $ ('#productDataTable');
if($productTable.length){
	console.log ("Inside Table")
	var jsonURL ="";
	if (window.categoryId ==''){
	
		jsonURL = window.contextPath +"/json/data/all/products";
		console.log (jsonURL)	
	}else{

		jsonURL = window.contextPath +'/json/data/category/'+ window.categoryId + '/products';
		console.log (jsonURL)
	}
	  
	$productTable.DataTable({
		lengthMenu : [[2,3,-1],["2 records","3 records","All"]],
		pageLength : 3,
		ajax : {
					url : jsonURL,
					dataSrc : ''
				},	
					columns : [
					           		
						               {
										data : 'code'	,
										mRender : function(data,type,row){
											           return '<img src=" ' + window.contextPath + '/resources/images/' + data + '.jpg"/>'
										}
									}, 
					           		{
					           			data : 'name'	
					           		},
					           		{
					           			data : 'brand'	
					           		},
					           		{
					           			data : 'unitPrice',
					           			mRender : function (data,type,row) {
											return "&#8377; " + data
										}
					           		},
					           		{
					           			data : 'quantity'	
					           		},
					           		{
					           			data : 'id',
					           			bSortable : false,
					           			mRender : function(data,type,row){
					           				var str="";
					           				str+='<a href="' +window.contextPath +'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> ';
					           				str+='<a href="' +window.contextPath +'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
					           				return str;
					           			}
					           		}
					           ]
					
		
	});	
}
</script>
