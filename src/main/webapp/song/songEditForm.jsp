<jsp:include page="../topBar.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="../../form.css">

<h3>edit song</h3>

<form:form method="post" modelAttribute="song">
    <form:errors path="*" element="div" cssClass="errors"></form:errors>

    <form:label path="name">Name: </form:label>
    <form:input type="text" path="name"></form:input>
    <form:label path="duration">Duration: </form:label>
    <form:input type="number" path="duration" step="0.01" placeholder="MM.SS"></form:input>
    <input type="submit" value="Confirm">
</form:form>

<h4>
    <a href="/song/${song.id}">cancel</a>
</h4>