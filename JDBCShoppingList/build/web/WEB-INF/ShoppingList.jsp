<%-- 
    Document   : ShoppingList
    Created on : Nov. 4, 2021, 12:44:14 p.m.
    Author     : Administrator
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingListController" method="GET">
            
        
        <h2>Add Item</h2>
        Enter item: <input type="text" name="enterItem"><input type="submit" value="Add"><br>
        ${requestScope.message}
        
        <h2>To Get</h2>
        <table border="1">
            <tr>
                <th>Item</th>
                <th>In Cart</th>
                <th>Delete</th>
            </tr>
            <c:forTokens var="item" delims="," items="${requestScope.itemsList}">
                <tr>
                    <td>${fn:substring(item,(fn:indexOf(item,"+"))+1,100)}</td>
                    <td><a href="ShoppingListController?addToCart=${fn:substring(item,0,(fn:indexOf(item,"+")))}">Add to Cart</a></td>
                    <td><a href="ShoppingListController?delete=${fn:substring(item,0,(fn:indexOf(item,"+")))}">Delete</a></td>
                </tr>
            </c:forTokens>
        </table>
        
        <h2>In Cart</h2>
        <table border="1">
            <tr>
                <th>Item</th>
                <th>Remove from Cart</th>
                <th>Delete</th>
            </tr>
            <c:forTokens var="item" delims="," items="${requestScope.cartList}">
                <tr>
                    <td>${fn:substring(item,(fn:indexOf(item,"+"))+1,100)}</td>
                    <td><a href="ShoppingListController?removeFromCart=${fn:substring(item,0,(fn:indexOf(item,"+")))}">Remove from Cart</a></td>
                    <td><a href="ShoppingListController?deleteFromCart=${fn:substring(item,0,(fn:indexOf(item,"+")))}">Delete</a></td>
                </tr>
            </c:forTokens>
        </table>
        </form>
    </body>
</html>
