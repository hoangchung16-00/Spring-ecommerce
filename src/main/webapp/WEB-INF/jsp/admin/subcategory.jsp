<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
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
                    <th>Action</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Slug</th>
                    <th>Sorting</th>
                    <th>Action</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach items="${subcategories}" var="subcategory">
                <tr>
                    <td>${subcategory.id}</td>
                    <td>${subcategory.name}</td>
                    <td>${subcategory.slug}</td>
                    <td>${subcategory.sorting}</td>
                    <td><a href="#"><i class="fa fa-trash"></i></a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>