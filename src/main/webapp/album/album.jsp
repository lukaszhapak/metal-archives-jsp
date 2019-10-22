<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../topBar.jsp"/>

<h2>
    <a href="/band/${album.band.id}">${album.band.name}</a>
</h2>
<h4>${album.name}</h4>
<h4>${album.releaseYear}</h4>

<h4>Songs:</h4>
<c:forEach var="song" items="${album.songs}" varStatus="loop">
    <a href="/song/${song.id}">
            ${song.name}${loop.last ? '' : ','}
    </a>
</c:forEach>

<h4>
    <a href="/album/${album.id}/addSong">add song</a>
</h4>

<h4>
    <a href="/album/${album.id}/delete">delete album</a> |
    <a href="/album/${album.id}/edit">edit album</a>
</h4>
