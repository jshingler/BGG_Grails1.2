

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'todo.label', default: 'Todo')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${todoInstance}">
            <div class="errors">
                <g:renderErrors bean="${todoInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${todoInstance?.id}" />
                <g:hiddenField name="version" value="${todoInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="todo.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: todoInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${todoInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="createdDate"><g:message code="todo.createdDate.label" default="Created Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: todoInstance, field: 'createdDate', 'errors')}">
                                    <g:datePicker name="createdDate" precision="day" value="${todoInstance?.createdDate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="priority"><g:message code="todo.priority.label" default="Priority" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: todoInstance, field: 'priority', 'errors')}">
                                    <g:textField name="priority" value="${todoInstance?.priority}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="status"><g:message code="todo.status.label" default="Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: todoInstance, field: 'status', 'errors')}">
                                    <g:textField name="status" value="${todoInstance?.status}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="note"><g:message code="todo.note.label" default="Note" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: todoInstance, field: 'note', 'errors')}">
                                    <g:textArea name="note" cols="40" rows="5" value="${todoInstance?.note}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="completedDate"><g:message code="todo.completedDate.label" default="Completed Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: todoInstance, field: 'completedDate', 'errors')}">
                                    <g:datePicker name="completedDate" precision="day" value="${todoInstance?.completedDate}" noSelection="['': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dueDate"><g:message code="todo.dueDate.label" default="Due Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: todoInstance, field: 'dueDate', 'errors')}">
                                    <g:datePicker name="dueDate" precision="day" value="${todoInstance?.dueDate}" noSelection="['': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="owner"><g:message code="todo.owner.label" default="Owner" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: todoInstance, field: 'owner', 'errors')}">
                                    <g:select name="owner.id" from="${User.list()}" optionKey="id" value="${todoInstance?.owner?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="category"><g:message code="todo.category.label" default="Category" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: todoInstance, field: 'category', 'errors')}">
                                    <g:select name="category.id" from="${Cat.list()}" optionKey="id" value="${todoInstance?.category?.id}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
