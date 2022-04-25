<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
    </head>
    <body>
        <h2>company Home Page</h2>
        <hr>
        <p> Welcome to the company home pages</p>
        
        <p> YouUser: <security:authentication property="principal.username" />
        <br><br>
        Role(s): <security:authentication property="principal.authorities" />
        </p>
        <hr>
        
        <security:authorize access="hasRole('MANAGER')">
            <p>
                <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
                (only for Manager peeps)
            </p>
            <hr>
        </security:authorize>

        <security:authorize access="hasRole('ADMIN')">
            <p>
                <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
                (only for Admin peeps)
            </p>
            <hr>
        </security:authorize>


        <form:form method="post" action="${pageContext.request.contextPath}/logout">

            <input type="submit" value="Logout"/>

        </form:form>
        
    </body>
</html>