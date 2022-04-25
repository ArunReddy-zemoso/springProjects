<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Student Registration Form</title>
    </head>
    <body>
        <form:form action="processForm" modelAttribute="student">
            First Name: <form:input path="firstName" />
            <br></br>
            Last Name: <form:input path="lastName" />
           <br></br>
           Country:
           <form:select path="country">
                <form:options items="${student.countryOptions}" />
           </form:select>

           <br></br>

           Favorite Language:
           Java <form:radiobutton path="favoriteLanguage" value="Java" />
           C# <form:radiobutton path="favoriteLanguage" value="C#" />
           Python <form:radiobutton path="favoriteLanguage" value="Python" />
           CPP <form:radiobutton path="favoriteLanguage" value="CPP" />

           <br></br>
           Operating Systems:
           Linux <form:checkbox path="operatingSystems" value="Linux" />
           Mac OS X <form:checkbox path="operatingSystems" value="macOS" />
           Windows <form:checkbox path="operatingSystems" value="windows" />
           <br></br>
           <input type="submit" value="Submit" />
        </form:form>
    </body>

</html>