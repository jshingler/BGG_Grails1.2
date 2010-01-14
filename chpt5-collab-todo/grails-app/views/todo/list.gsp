

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'todo.label', default: 'Todo')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'todo.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'todo.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="createdDate" title="${message(code: 'todo.createdDate.label', default: 'Created Date')}" />
                        
                            <g:sortableColumn property="priority" title="${message(code: 'todo.priority.label', default: 'Priority')}" />
                        
                            <g:sortableColumn property="status" title="${message(code: 'todo.status.label', default: 'Status')}" />
                        
                            <g:sortableColumn property="note" title="${message(code: 'todo.note.label', default: 'Note')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${todoInstanceList}" status="i" var="todoInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${todoInstance.id}">${fieldValue(bean: todoInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: todoInstance, field: "name")}</td>
                        
                            <td><g:formatDate date="${todoInstance.createdDate}" /></td>
                        
                            <td>${fieldValue(bean: todoInstance, field: "priority")}</td>
                        
                            <td>${fieldValue(bean: todoInstance, field: "status")}</td>
                        
                            <td>${fieldValue(bean: todoInstance, field: "note")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${todoInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
