
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<h1>Registration Form</h1>
    <form action="register" method="get">
        <table cellpadding="3pt">
            <tr>
                <td>Name :</td>
                <td><input type="text" name="Name" size="30" /></td>
            </tr>
            <tr>
                <td>Address :</td>
                <td><input type="Address" name="address" size="30" /></td>
            </tr>
            <tr>
                <td>Phone :</td>
                <td><input type="text" name="phone" size="30" /></td>
            </tr>
            <tr>
                <td>email :</td>
                <td><input type="text" name="email" size="30" /></td>
            </tr>
            <tr>
                <td>Experience :</td>
                <td><input type="text" name="Experience" size="30" /></td>
            </tr>
        </table>
        <p />
        <input type="submit" value="Register" />
    </form>
</body>
</html>