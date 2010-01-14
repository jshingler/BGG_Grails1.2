

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cat.label', default: 'Cat')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'cat.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'cat.name.label', default: 'Name')}" />
                        
                            <th><g:message code="cat.user.label" default="User" /></th>
                   	    
                            <g:sortableColumn property="description" title="${message(code: 'cat.description.label', default: 'Description')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${catInstanceList}" status="i" var="catInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${catInstance.id}">${fieldValue(bean: catInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: catInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: catInstance, field: "user")}</td>
                        
                            <td>${fieldValue(bean: catInstance, field: "description")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${catInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
