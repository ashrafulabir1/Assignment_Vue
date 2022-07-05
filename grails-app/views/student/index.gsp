<%--
  Created by IntelliJ IDEA.
  User: LOCAL ADMIN
  Date: 6/19/2022
  Time: 2:38 PM
--%>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'student.label', default: 'student')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-student" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>


    %{--Search Panel --}%
    <div class="btn-group">
        <g:form controller="student" action="index" method="GET">
            <div class="input-group" id="search-area">
                <g:select name="colName" class="form-control" from="[name: 'Name', address: 'Address']" value="${params?.colName}" optionKey="key" optionValue="value"/>
                <g:textField name="colValue" class="form-control" value="${params?.colValue}"/>
                <span class="input-group-btn">
                    <button class="btn btn-default" type="submit">Search</button>
                </span>
            </div>
        </g:form>
    </div>

%{--Create and Reload Panel--}%
<div class="btn-group">
    <g:link controller="student" action="index" class="btn btn-primary"><g:message code="reload"/></g:link>
</div>


    %{--Pagination Area--}%
    <div class="paginate">
        <g:paginate total="${total ?: 0}" />
    </div>


<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="list-student" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:table collection="${studentList}" />

    <div class="pagination">
        <g:paginate total="${studentCount ?: 0}" />
    </div>
</div>
</body>
</html>