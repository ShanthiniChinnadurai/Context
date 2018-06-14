<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        
<head>
<title>Product details</title>
</head>
<body>
        <div class="container">

<div align="center">
    <c:if test="${productid != null}">
        <form action="update" method="post">
    </c:if>
    
        <table   class="table table-striped table-bordered table-hover table-condensed" border="1" cellpadding="5">
       
            <c:if test="${productid != null}">
                <input type="text" name="id" value="<c:out value='${productid}' />" />
            </c:if>           
        <tr>
            <th>Name: </th>
            <td>
                <input type="text" name="name" size="45"
                        value="<c:out value='${prd.name}' />"
                    />
            </td>
        </tr>
        <tr>
            <th>Description: </th>
            <td>
                <input type="text" name="description" size="45"
                        value="<c:out value='${prd.description}' />"
                />
            </td>
        </tr>
        <tr>
            <th>Quantity: </th>
            <td>
                <input type="text" name="price" size="5"
                        value="<c:out value='${prd.price}' />"
                />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save" />               
            </td>
        </tr>
    </table>
    </form>
</div>   
</div>
</body>
</html>