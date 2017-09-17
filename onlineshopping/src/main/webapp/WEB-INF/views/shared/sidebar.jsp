<p class="lead">Shop Name</p>

<div class="list-group">
	<c:forEach items="${ catList }" var="category">
          			<a href="${ contextPath }/show/category/${category.id}/products" class="list-group-item" id="act_${category.name }">${category.name}</a>
     </c:forEach>
</div>