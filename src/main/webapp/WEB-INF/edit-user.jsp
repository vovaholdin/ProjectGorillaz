<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<form class="form-horizontal" action="edit-user" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Edit User</legend>

        <input type="hidden" name="id" value="${requestScope.user.id}">

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Login</label>
            <div class="col-md-4">
                <input id="login" value="${requestScope.user.login}" name="login" type="text" placeholder=""
                       class="form-control input-md" required="">
                <span class="help-block">login</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Password</label>
            <div class="col-md-4">
                <input id="password" value="${requestScope.user.password}" name="password" type="password"
                       placeholder="2..20 symbols" class="form-control input-md" required="">
                <span class="help-block">enter Password</span>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Role</label>
            <div class="col-md-4">
                <select id="role" name="role" class="form-control">
                    <option value="USER">USER</option>
                    <option value="ADMIN">ADMIN</option>
                    <option value="GUEST">GUEST</option>
                </select>
            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="update">Operation</label>
            <div class="col-md-8">
                <button type="submit" id="update" name="update" class="btn btn-success">Update</button>
                <button type="submit" id="create" name="create" class="btn btn-danger">Create</button>
            </div>
        </div>

    </fieldset>
</form>


</body>
</html>
