<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <a type="button" class="btn btn-success" href="/cms/addsubcategory">ADD SUBCATEGORY</a>
        ${error}
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
                    <th>Category</th>
                    <th colspan="2">Action</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Slug</th>
                    <th>Sorting</th>
                    <th>Category</th>
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
                    <th>${subcategory.category.name}</th>
                    <td><a href="/cms/editsubcategory/${subcategory.id}"><i class="fa fa-pen"></i></a></td>
                    <td><a href="/cms/deletesubcategory/${subcategory.id}"><i class="fa fa-trash"></i></a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>