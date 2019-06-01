<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


    <title>管理页面</title>
    <script>
        $(function () {
            $("ul.pagination li.disabled a").click(function () {
                return false;
            });
        });
    </script>
    
</head>

<style type="text/css">
<!--

li { list-style:none; float:left;   float:left; margin-right:10px; padding:5px;}
-->
</style>

<body>

 <form action="add">
        <table>
            <tr>
                <td><input type="submit" value="增加"></td>
            </tr>
        </table>
    </form>
    <form action="list" method="post">姓名
<input type="text" name="search" placeholder="根据姓名查询" style="    border: 1px solid #E6E6E6;;height:18px;width:120px;">
<button class="layui-btn layui-btn-sm">搜索</button>
</form>
 

<div class="listDIV">
    <table class="table table-striped table-bordered table-hover table-condensed">

        <caption>列表</caption>
        <thead>
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>编辑</th>
            <th>删除</th>
           
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${pageInfo.list}" var="pageInfo" varStatus="status">
            <tr>
            
             <td>${pageInfo.bootid}</td>
                <td>${pageInfo.bootname}</td>
                <td>${pageInfo.bootage}</td>
                <td>${pageInfo.bootsex}</td>
                <td>${pageInfo.bootbirthday}</td>
            <td><a href="edit?id=${pageInfo.id}">edit </a></td>
                <td><a href="del?id=${pageInfo.id}">del </a></td>
               
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<nav class="pageDIV">
    <ul class="pagination">

<p>当前 ${pageInfo.pageNum}页,总${pageInfo.pages} 页,总 ${pageInfo.total} 条记录</div></p>
        <a href="list?pageNum=1">首页</a>
        <c:if test="${pageInfo.hasPreviousPage }">
            <a href="list?pageNum=${pageInfo.pageNum-1}">上一页</a>
        </c:if>
      
        <c:if test="${pageInfo.hasNextPage}">
            <a href="list?pageNum=${pageInfo.pageNum+1}">下一页</a>
        </c:if>
        
        <a href="list?pageNum=${pageInfo.pages}">末页</a>

</ul>
</nav>




</body>
</html>