<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${publications}" var="publication">
<div class="media mt-3">
  <a class="mr-3" href="#">
  </a>
  <div class="media-body">
    <h5 class="mt-0" id="person${publication.getPublicationId()}">${personsH.get(publication.getPersonId())}</h5>
    <div id="content${publication.getPublicationId()}">${publication.getContent()}</div>
    <button type="button" class="btn btn-link likeComentarios2 ${pReactionsH.get(publication.getPublicationId())!=null?pReactionsH.get(publication.getPublicationId())==1?'disabled':'':''}" id="likeC${publication.getPublicationId()}" data-publicationid="${publication.getPublicationId()}">
        <i class="mdi mdi-thumb-up-outline">Me gusta</i>
    </button> 
    <button type="button" class="btn btn-link dislikeComentarios2 ${pReactionsH.get(publication.getPublicationId())!=null?pReactionsH.get(publication.getPublicationId())==0?'disabled':'':''}" id="dislikeC${publication.getPublicationId()}" data-publicationid="${publication.getPublicationId()}">
        <i class="mdi mdi-thumb-down-outline">No me gusta</i>
    </button>
    <button type="button" class="btn btn-link soundComentarios" id="sound${publication.getPublicationId()}" data-publicationid="${publication.getPublicationId()}">
        <i class="mdi mdi-voice">Escuchar</i>
   </button>  
  </div>
</div>
</c:forEach>
