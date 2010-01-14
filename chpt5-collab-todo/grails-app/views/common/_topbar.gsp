  <div id="menu">
    <nobr>
      <g:if test="${session.user}">
        <b>${session.user?.firstName} ${session.user?.lastName}</b> | 
         <g:link controller="user" action="logout"><g:message code="topbar.logout" /></g:link>
      </g:if> 
      <g:else>
        <g:link controller="user" action="login">
           <g:message code="topbar.login" /></g:link> 
      </g:else>
    </nobr>
  </div>
