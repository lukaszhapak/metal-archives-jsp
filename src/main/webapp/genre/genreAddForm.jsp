<jsp:include page="../topBar.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="../form.css">

<h2>Add New Genre:</h2>

<form:form method="post" modelAttribute="genre">
    <form:errors path="*" element="div" cssClass="errors"></form:errors>

    <form:label path="name">Name: </form:label>
    <form:input path="name" type="text" name="name"></form:input>
    <input type="submit" value="Add">
</form:form>