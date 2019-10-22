<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../topBar.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h3>select which genre you want to delete from this band</h3>

<form:form method="post" modelAttribute="genre">
    <form:label path="id">Genre
        <form:select path="id">
            <form:options items="${genres}" itemValue="id" itemLabel="name"></form:options>
        </form:select>
    </form:label>
    <input type="submit" value="Delete">
</form:form>

<a href="/band/${id}">cancel</a>

