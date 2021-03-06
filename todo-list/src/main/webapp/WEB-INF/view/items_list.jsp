<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learnprogramming.util.Mappings" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">


    <title>MAVEN WAR TODO Items LIST - Todo List</title>
    <style>
        * {text-align: center;}

       body {
        background: lightblue;
        color: white;
       }

       table {
        border: 2px outset white;
        font-family: Montserrat, sans-serif;
        border-radius: 5px;
       }

       .tableHeading {
        background-color: darkgrey;
        color: white;
        border-bottom: 2px solid white;
       }

       td {
        background-color: #E8914C;
        border-bottom: 1px dashed darkgrey;
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
        <c:url var="addUrl" value="${Mappings.ADD_ITEM}" />
                <h3><a href="${addUrl}">Add Task <i class="fas fa-plus-circle"></i></a></h3>
    <div class="todoList">



        <table class="border="1" cellpadding="5">
            <caption>Enterprise D To Do List</caption>
            <br />
            <tr>
                <th class="tableHeading">Title</th>
                <th class="tableHeading">Task</th>
                <th class="tableHeading">Deadline</th>
                <th class="tableHeading">View</th>
                <th class="tableHeading">Edit</th>
                <th class="tableHeading">Delete</th>
            </tr>
            <c:forEach var="item" items="${todoData.items}">

             <c:url var="viewUrl" value="${Mappings.VIEW_ITEM}">
                <c:param name="id" value="${item.id}" />
             </c:url>

             <c:url var="editUrl" value="${Mappings.ADD_ITEM}">
                <c:param name="id" value="${item.id}" />
              </c:url>

                <c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}">
                    <c:param name="id" value="${item.id}" />
                </c:url>

                <tr>
                    <td><c:out value="${item.title}" /></td>
                    <td><c:out value="${item.details}" /></td>
                    <td><c:out value="${item.deadline}" /></td>
                    <td><a href="${viewUrl}"><i class="fas fa-binoculars"></i></a></td>
                    <td><a href="${editUrl}"><i class="fas fa-user-edit"></i></a></td>
                    <td><a href="${deleteUrl}"><i class="fas fa-trash"></i></a></td>

                </tr>
            </c:forEach>
        </table>
    </div>

    </div>
</body>

</html>