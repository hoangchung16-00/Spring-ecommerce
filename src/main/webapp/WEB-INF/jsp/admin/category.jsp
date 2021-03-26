<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-1">
        <a type="button" class="btn btn-success" href="/cms/addcategory">ADD CATEGORY</a>
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
                <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>${category.slug}</td>
                    <td>${category.sorting}</td>
                    <td><a href="/cms/editcategory/${category.id}"><i class="fa fa-pen"></i></a></td>
                    <td><a href="/cms/deleteCategory/${category.id}"><i class="fa fa-trash"></i></a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="pagnition-container">
                <ul class="pagination">
                    <li><a href="#">Previous</a></li>
                    <c:forEach begin="1" end="${pageSize}" varStatus="index">
                    <li><a href="/cms/category?page=${index.index}">${index.index}</a></li>
                    </c:forEach>
                    <li><a href="#">Next</a></li>
                </ul>
            </div>
        </div>

    </div>

</div>
