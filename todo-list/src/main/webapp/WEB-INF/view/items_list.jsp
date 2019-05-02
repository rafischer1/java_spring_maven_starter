<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" />
    <title>MAVEN WAR TODO Items LIST - Todo List</title>
    <style>
        * {text-align: center;}

       body {
        background: lightblue;
        color: white;
       }

    </style>
</head>
<body>
<div style="background: darkgrey; margin-top: -.10em; padding: .5%; border-bottom: 1px solid gold;" class="ui secondary menu">
    <a class="active item">
       JSP File Bridge
    </a>
    <a class="item">
        10 Forward
    </a>
    <a class="item">
        Transport
    </a>
    <div class="right menu">
    <h4>${welcomeMessage} User: ${helloMessage} Age: ${age}</h4>
        <div class="item">
            <div class="ui icon input">
                <input type="text" placeholder="Computer...">
                <i class="search link icon"></i>
            </div>
        </div>
        <a class="ui item">
            Logout
        </a>
    </div>
</div>
    <div class="ui sizer vertical segment">
        <div class="ui huge header">Java Spring Maven To-Do List App</div>


    </div>

    <div class="ui horizontal list">
        <div class="item">
            <img class="ui mini circular image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-1jDDpAOCMTEu66K2wpanR4B2O01NxPyl4di3bgSA3g5zfYN7">
            <div class="content">
                <div class="ui sub header">Jordi</div>
                Engineering
            </div>
        </div>
        <div class="item">
            <img class="ui mini circular image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-1jDDpAOCMTEu66K2wpanR4B2O01NxPyl4di3bgSA3g5zfYN7">
            <div class="content">
                <div class="ui sub header">Data</div>
                Science
            </div>
        </div>
        <div class="item">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-1jDDpAOCMTEu66K2wpanR4B2O01NxPyl4di3bgSA3g5zfYN7" class="ui mini circular image">
            <div class="content">
                <div class="ui sub header">Riker</div>
                First Officer
            </div>
        </div>
    <div class="todoList">
        <table class="border="1" cellpadding="5">
            <caption><h2>ToDo Items</h2></caption>
            <tr>
                <th>Title</th>
                <th>Task</th>
                <th>Deadline</th>
            </tr>
            <c:forEach var="item" items="${todoData.items}">

                <tr>
                    <td><c:out value="${item.title}" /></td>
                    <td><c:out value="${item.details}" /></td>
                    <td><c:out value="${item.deadline}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    </div>
</body>

</html>