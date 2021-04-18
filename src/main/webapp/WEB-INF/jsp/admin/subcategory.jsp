<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <a type="button" class="btn btn-success" href="/cms/addsubcategory">ADD SUBCATEGORY</a>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Slug</th>
                    <th>Sorting</th>
                    <th colspan="2">Action</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Slug</th>
                    <th>Sorting</th>
                    <th colspan="2">Action</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach items="${subcategories}" var="subcategory">
                <tr>
                    <td>${subcategory.id}</td>
                    <td>${subcategory.name}</td>
                    <td>${subcategory.slug}</td>
                    <td>${subcategory.sorting}</td>
                    <td><a href="/cms/deletesubcategory/${subcategory.id}"><i class="fa fa-trash"></i></a></td>
                    <td><a href="/cms/editsubcategory/${subcategory.id}"><i class="fa fa-pen"></i></a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="pagination_rounded">
                <ul>
                    <li> <a href="#" class="prev"> <i class="fa fa-angle-left" aria-hidden="true"></i> Prev </a> </li>
                    <c:forEach begin="1" end="${pageSize}" varStatus="index">
                        <li><a href="/cms/subcategory?page=${index.index}">${index.index}</a></li>
                    </c:forEach>
                    <li class="hidden-xs"><a href="#">...</a> </li>
                    <li><a href="#">6</a></li>
                    <li><a href="#" class="next"> Next <i class="fa fa-angle-right" aria-hidden="true"></i></a> </li>
                </ul>
            </div>
        </div>
    </div>
</div>