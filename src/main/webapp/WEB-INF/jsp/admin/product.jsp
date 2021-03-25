<!-- DataTales Example -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <a type="button" class="btn btn-success" href="/cms/addproduct">ADD PRODUCT</a>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Category</th>
                    <th colspan="2">Action</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Category</th>
                    <th colspan="2">Action</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach items="${products}" var="product">
                <tr>
                    <th>${product.id}</th>
                    <th>${product.name}</th>
                    <th>${product.description}</th>
                    <th>${product.quantity}</th>
                    <th>${product.price}</th>
                    <th>${product.image}</th>
                    <th>${product.subcategory.name}</th>
                    <td><a href="/cms/editproduct/${product.id}"><i class="fa fa-pen"></i></a></td>
                    <td><a href="/cms/deleteproduct/${product.id}"><i class="fa fa-trash"></i></a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>