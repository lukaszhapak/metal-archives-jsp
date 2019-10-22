<jsp:include page="../topBar.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="../../form.css">

<h3>edit lyric</h3>

<form:form method="post" modelAttribute="lyric">
    <form:errors path="*" element="div" cssClass="errors"></form:errors>

    <form:label path="text">lyric:</form:label>
    <form:textarea path="text" cols="30" rows="10"></form:textarea>
    <input type="submit" value="Add">
</form:form>