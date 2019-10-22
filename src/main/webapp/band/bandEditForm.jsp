<jsp:include page="../topBar.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="../../form.css">

<h2>Edit Band:</h2>

<form:form method="POST" modelAttribute="band">
    <form:errors path="*" element="div" cssClass="errors"></form:errors>

    <form:label path="name">Name: </form:label>
    <form:input path="name"></form:input> <br/>
    <form:label path="country">Country: </form:label>
    <form:input path="country"></form:input> <br/>
    <form:label path="formedIn">Formed In: </form:label>
    <form:input type="number" path="formedIn" placeholder="YYYY"></form:input> <br/>
    <input type="submit" value="Confirm"/>
</form:form>

<h4>
    <a href="/band/${band.id}">cancel</a>
</h4>