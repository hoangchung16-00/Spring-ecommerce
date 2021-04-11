<!-- DataTales Example -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <a type="button" class="btn btn-success" href="/cms/addskudetail?productId=${productId}">Add SkuDetail</a>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>SkuCode</th>
                    <th>Size</th>
                    <th>Color</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th colspan="2">Action</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>SkuCode</th>
                    <th>Size</th>
                    <th>Color</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th colspan="2">Action</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach items="${productDetails}" var="productDetail">
                <tr>
                    <th>${productDetail.skuCode}</th>
                    <th>${productDetail.size}</th>
                    <th>${productDetail.color}</th>
                    <th>${productDetail.quantity}</th>
                    <th>${productDetail.price}</th>
                    <th>${productDetail.image}</th>
                    <td><a href="/cms/editproduct/${product.id}"><i class="fa fa-pen"></i></a></td>
                    <td><a href="/cms/deleteproduct/${product.id}"><i class="fa fa-trash"></i></a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="pagnition-container">
                <ul class="pagination">
                    <li><a href="#">Previous</a></li>
                    <c:forEach begin="1" end="${pageSize}" varStatus="index">
                        <li><a href="/cms/product?page=${index.index}">${index.index}</a></li>
                    </c:forEach>
                    <li><a href="#">Next</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>