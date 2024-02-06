<html>
<head>
  <%@ include file ="./base.jsp" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
</head>


<body>

<div class="container mt-3">

      <div class="row">

           <div class="col-md-12 ">

                <h1 class="text-center mb-3">Welcome to Product App</h1>

   <table class="table table-striped table-dark">
       <thead>
			    <tr>
			      <th scope="col">S.No</th>
			      <th scope="col">Product</th>
			      <th scope="col">Description</th>
			      <th scope="col">Price</th>
			      <th scope="col">Action</th>
			     
			    </tr>
       </thead>
  
        <tbody>
        <c:forEach items="${product}" var="p">
			    <tr>
			      <th scope="row">Technolys ${p.id}</th>
			      <td>${p.name}</td>
			      <td>${p.description}</td>
			      <td>&#x20B9; ${p.price}</td>
			      <td> <a href="delete/${p.id}"> <i class="fa-solid fa-trash"></i></a> 
			           <a href="update/${p.id}"> <i class="fa-solid fa-pen-to-square"></i></a> 
			      </td>
			    </tr>
			    </c:forEach>
			    
       </tbody>
 </table>
 <div class="container">
 <a href="add-product" class="btn btn-outline-success">Add Product</a>
 </div>

        </div>
    </div>
</div>

</body>
</html>
