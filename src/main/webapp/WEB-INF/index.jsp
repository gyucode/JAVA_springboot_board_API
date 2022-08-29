<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <style>
        table{
            width: 60%;
            border-collapse: collapse;
        }
        th{
            border-bottom: 1px solid;
            border-bottom: 2px solid;
        }
        td{
            text-align: center;
            padding: 7px 0 11px;
            border-bottom: 1px solid;
        }
    </style>
</head>
<body>
    <h1> Board</h1>
    <br/>
    <div class="container">
        <table class="table table-hover table table-striped">
            <tr>
                <th>PostId</th>
                <th>NickName</th>
                <th>Title</th>
                <th>Content</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach items="${postList}" var="post">
                <tr>
                    <td>${post.getPostId()}</td>
                    <td>${post.getNickName()}</td>
                    <td>${post.getTitle()}</td>
                    <td>${post.getContent()}</td>
                    <td><a href="updateView/${post.getPostId()}">수정</a></td>
                    <td><a href="delete/${post.getPostId()}">삭제</a></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="createView">새 글 작성</a>
    </div>

</body>
</html>