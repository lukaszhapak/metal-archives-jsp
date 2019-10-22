<jsp:include page="../topBar.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="../../form.css">

<h3>add new song</h3>

<form:form method="post" modelAttribute="song">
    <form:errors path="*" element="div" cssClass="errors"></form:errors>

    <form:label path="name">Name: </form:label>
    <form:input type="text" path="name"></form:input>
    <form:label path="duration">Duration: </form:label>
    <form:input type="number" path="duration" step="0.01" placeholder="MM.SS"></form:input>
    <input type="submit" value="Add">
</form:form>
