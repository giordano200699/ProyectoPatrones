<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${publications}" var="publication">
<div class="col col-md-12" id="todo${publication.getPublicationId()}">
    <div class="media">
        <div class="media-body">
          <h5 class="mt-0" id="person${publication.getPublicationId()}">${personsH.get(publication.getPersonId())}</h5>
          <div id="content${publication.getPublicationId()}">${publication.getContent()}</div>
            <button type="button" class="btn btn-link likeComentarios ${pReactionsH.get(publication.getPublicationId())!=null?pReactionsH.get(publication.getPublicationId())==1?'disabled':'':''}" id="like${publication.getPublicationId()}" data-publicationid="${publication.getPublicationId()}">
                <i class="mdi mdi-thumb-up-outline">Me gusta</i>
            </button> 
            <button type="button" class="btn btn-link dislikeComentarios ${pReactionsH.get(publication.getPublicationId())!=null?pReactionsH.get(publication.getPublicationId())==0?'disabled':'':''}" id="dislike${publication.getPublicationId()}" data-publicationid="${publication.getPublicationId()}">
                <i class="mdi mdi-thumb-down-outline">No me gusta</i>
            </button>  
            <button type="button" class="btn btn-link soundComentarios" id="sound${publication.getPublicationId()}" data-publicationid="${publication.getPublicationId()}">
                 <i class="mdi mdi-voice">Escuchar</i>
            </button>  
            <button type="button" class="btn btn-link reportComentarios" id="report${publication.getPublicationId()}" data-publicationid="${publication.getPublicationId()}">
                 <i class="mdi mdi-voice">Reportar</i>
            </button>  
          <!--<div class="media mt-3">
            <a class="mr-3" href="#">
            </a>
            <div class="media-body">
              <h5 class="mt-0">Media heading</h5>
              Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
            </div>
          </div>-->
          <div id="divVC${publication.getPublicationId()}">
              <a class="visualizarComentarios" href="#" onclick="return false;" data-publicationid="${publication.getPublicationId()}"><i class="mdi mdi-message-text-outline">Visualizar Comentarios</i></a>
          </div>
          <div class="form-group">
              <i class="mdi mdi-message-text-outline">Comentar</i>
              <textarea class="form-control txtAreaComentario" id="txtArea" rows="3" data-publicationid="${publication.getPublicationId()}"></textarea>
          </div>
        </div>
      </div>
</div>
</c:forEach>
