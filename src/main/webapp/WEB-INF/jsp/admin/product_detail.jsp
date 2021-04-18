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
            <div class="pagination_rounded">
                <ul>
                    <li> <a href="#" class="prev"> <i class="fa fa-angle-left" aria-hidden="true"></i> Prev </a> </li>
                    <c:forEach begin="1" end="${pageSize}" varStatus="index">
                                <li><a href="/cms/1 ?page=${index.index}">${index.index}</a></li>
                    </c:forEach>
                    <li class="hidden-xs"><a href="#">...</a> </li>
                    <li><a href="#">6</a></li>
                    <li><a href="#" class="next"> Next <i class="fa fa-angle-right" aria-hidden="true"></i></a> </li>
                </ul>
            </div>
        </div>
    </div>
</div>