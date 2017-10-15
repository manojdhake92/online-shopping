<div class="container">
		
		<div class="row">
							<div class="col-xs-12">
									<ol  class="breadcrumb">
											<li><a href="${contextPath}/home">Home</a></li>
											<li><a href="${contextPath}//show/all/products">Products</a></li>
											<li class="active">${product.name}</li>
									</ol>
							</div>
		</div>
		
		
		<div class="row">
					<!-- Displaying Image -->
					<div class="col-sm-4">
							<div class="thumpnail">
									<img src="${images}/${product.code}.jpg" class="img img-responsive">
							</div>	
					</div>
					
					<!-- Display Product Information -->
					<div class="col-sm-8">
							<h4>${product.name}</h4>
							<hr/>
							<p>${product.description}</p>
							<hr/>
							<h4>Price : ${product.unitPrice} /-</h4>
							<hr/>
							<h4> Avail. Qty : ${product.quantity}</h4>
							<hr/>
							<a href="${ contextPath }/cart/add/ ${product.id} /product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a>
							<a href="${ contextPath}/show/all/products" class="btn btn-primary">Back</a>  
					</div>
		
		</div>

</div>