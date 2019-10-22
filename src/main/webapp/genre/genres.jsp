<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../topBar.jsp"/>

<link rel="stylesheet" href="/table.css">
<h2>Genres List</h2>

<table>
    <tr>
        <th>Name:</th>
        <th>Delete:</th>
        <th>Edit:</th>
    </tr>
    <c:forEach var="genre" items="${genres}">
        <tr>
            <td>${genre.name}</td>
            <td>
                <a href="/genre/${genre.id}/delete">delete</a>
            </td>
            <td>
                <a href="/genre/${genre.id}/edit">edit</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2><a href="/genre/add">add new genre</a></h2>

