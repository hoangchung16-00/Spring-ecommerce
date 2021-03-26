<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Au Register Forms by Colorlib</title>

    <!-- Icons font CSS-->
    <link href="/admin/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="/admin/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="/admin/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="/admin/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="/admin/css/main.css" rel="stylesheet" media="all">
</head>

<body>
<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
    <div class="wrapper wrapper--w790">
        <div class="card card-5">
            <div class="card-heading">
                <h2 class="title">EDIT CATEGORY</h2>
            </div>
            <div class="card-body">
                <form:form method="POST" action="/cms/editcategory" modelAttribute="editCategoryForm">
                    <form:hidden path="id"/>
                    <div class="form-row">
                        <div class="name">Name</div>
                        <div class="value">
                            <div class="input-group">
                                <form:input class="input--style-5" type="text" path="name"/>
                                <form:errors path="name"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="name">Sorting</div>
                        <div class="value">
                            <div class="input-group">
                                <form:input class="input--style-5" type="text" path="sorting"/>
                                <form:errors path="sorting"/>
                            </div>
                        </div>
                    </div>
                    <div>
                        <button class="btn btn--radius-2 btn--red" type="submit">SUBMIT</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<!-- Jquery JS-->
<script src="/admin/vendor/jquery2/jquery.min.js"></script>
<!-- Vendor JS-->
<script src="/admin/vendor/select2/select2.min.js"></script>
<script src="/admin/vendor/datepicker/moment.min.js"></script>
<script src="/admin/vendor/datepicker/daterangepicker.js"></script>

<!-- Main JS-->
<script src="/admin/js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->