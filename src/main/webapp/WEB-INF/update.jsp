<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Employee</h1>
<form:form method="POST" action="/update">
    <table >
        <tr>
            <td>PostId : </td>
            <td>${command.getPostId()}</td>
            <td><form:hidden  path="postId" /></td>
        </tr>
        <tr>
            <td>NickName : </td>
            <td><form:input path="nickName"  /></td>
        </tr>
        <tr>
            <td>Title :</td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td>Content :</td>
            <td><form:input path="content" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Edit Save" /></td>
        </tr>
    </table>
</form:form>