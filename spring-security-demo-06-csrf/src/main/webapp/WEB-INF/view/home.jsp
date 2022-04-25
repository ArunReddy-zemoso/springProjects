<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
    </head>
    <body>
        <h2>company Home Page</h2>
        <hr>
        <p> Welcome to the company home pages</p>

        <form:form method="post" action="${pageContext.request.contextPath}/logout">

            <input type="submit" value="Logout"/>

        </form:form>
        
    </body>
</html>