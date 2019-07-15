<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${publications}" var="publication">
<div class="media mt-3">
  <a class="mr-3" href="#">
  </a>
  <div class="media-body">
    <h5 class="mt-0">${personsH.get(publication.getPersonId())}</h5>
    <div>${publication.getContent()}</div>
    <i class="mdi mdi-thumb-up-outline">Me gusta</i>
    <i class="mdi mdi-thumb-down-outline">No me gusta</i>
  </div>
</div>
</c:forEach>
