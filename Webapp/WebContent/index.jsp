<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration Form</h1>
    <form action="UserControllerServlet" method="post">
        <table cellpadding="3pt">
            <tr>
                <td>Name :</td>
                <td><input type="text" name="name" size="30" /></td>
            </tr>
            <tr>
                <td>Address :</td>
                <td><input type="text" name="address" size="30" /></td>
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
                <td><input type="text" name="exp" size="30" /></td>
            </tr>
        </table>
        <p />
        <input type="submit" value="Register" />
    </form>
</body>
</html>