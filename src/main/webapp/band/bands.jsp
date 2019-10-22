<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../topBar.jsp"/>

<link rel="stylesheet" href="/table.css">
<h2>Bands List</h2>

<table>
    <tr>
        <th>Name:</th>
        <th>Country:</th>
        <th>FormedIn:</th>
    </tr>
    <c:forEach var="band" items="${bands}">
        <tr>
            <td><a href="/band/${band.id}">${band.name}</a></td>
            <td>${band.country}</td>
            <td>${band.formedIn}</td>
        </tr>
    </c:forEach>
</table>

<h2><a href="/band/add">add new band</a></h2>

