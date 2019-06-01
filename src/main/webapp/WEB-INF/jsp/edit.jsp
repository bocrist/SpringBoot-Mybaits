<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>


    <title>编辑页面</title>
</head>

<body>

<div class="editDIV">

    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">编辑</h3>
        </div>
        <div class="panel-body">

            <form method="post" action="update" role="form">
                <table class="editTable">
                    <tr>
                        <td>编号：</td>
                        <td><input type="text" name="bootid" id="bootid" value="${boot.bootid}"
                                   placeholder="请在这里输入编号"></td>
                    </tr>
                    <tr>
                        <td>姓名：</td>
                        <td><input type="text" name="bootname" id="bootname" value="${boot.bootname}" placeholder="请在这里输入名字">
                        </td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td><input type="text" name="bootage" id="bootage" value="${boot.bootage}" placeholder="请在这里输入年龄"></td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td><input type="radio" <c:if test="${boot.bootsex=='男'}">checked</c:if> class="radio radio-inline" name="bootsex" value="男"> 男
                            <input type="radio" <c:if test="${boot.bootsex=='女'}">checked</c:if> class="radio radio-inline" name="bootsex" value="女"> 女
                        </td>
                    </tr>
                    <tr>
                        <td>出生日期：</td>
                        <td><input type="date" name="bootbirthday" id="bootbirthday" value="${boot.bootbirthday}"
                                   placeholder="请在这里输入出生日期"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${boot.id}">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>

                    </tr>

                </table>
            </form>
        </div>
    </div>

</div>

</body>
</html>