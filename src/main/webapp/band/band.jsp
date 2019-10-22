<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../topBar.jsp"/>

<h2>${band.name}</h2>
<h4>${band.country}</h4>
<h4>${band.formedIn}</h4>

<h4>Albums:</h4>
<c:forEach var="album" items="${band.albums}" varStatus="loop">
    <a href="/album/${album.id}">
            ${album.name}${loop.last ? '' : ','}
    </a>
</c:forEach>

<h4>
    <a href="/band/${band.id}/addAlbum">add album</a>
</h4>

<h4>Genres:</h4>
<c:forEach var="genre" items="${band.genres}" varStatus="loop">
    ${genre.name}${loop.last ? '' : ','}
</c:forEach>

<h4>
    <a href="/band/${band.id}/addGenre">add genre</a> |
    <a href="/band/${band.id}/deleteGenre">delete genre</a>
</h4>

<h4>
    <a href="/band/${band.id}/delete">delete band</a> |
    <a href="/band/${band.id}/edit">edit band</a>
</h4>
