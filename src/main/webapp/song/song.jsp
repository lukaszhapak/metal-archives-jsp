<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../topBar.jsp"/>

<h2>
    <a href="/band/${song.album.band.id}">${song.album.band.name}</a>
</h2>

<h3>
    <a href="/album/${song.album.id}">${song.album.name}</a>
</h3>

<h4>${song.name}</h4>
<h4>${song.duration}</h4>

<h4>lyric:</h4>
${song.lyric.text}
<h4>
    <c:choose>
        <c:when test="${song.lyric.text==null}">
            <a href="/song/${song.id}/addLyric">add lyric</a>
        </c:when>
        <c:otherwise>
            <a href="/lyric/${song.lyric.id}/delete">delete lyric</a> |
            <a href="/lyric/${song.lyric.id}/edit">edit lyric</a>
        </c:otherwise>
    </c:choose>
</h4>

<h4>
    <a href="/song/${song.id}/delete">delete song</a> |
    <a href="/song/${song.id}/edit">edit song</a>
</h4>
