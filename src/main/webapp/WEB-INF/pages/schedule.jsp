<%--
  Created by IntelliJ IDEA.
  User: lisao
  Date: 2016/5/31
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>签到</title>
    <style>
        .q_code {
            width: 200px;
            height: 200px;
            margin: 200px auto 0;
            display: block;
        }

        .center {
            width: 100%;
            margin: auto 0;
            display: block;
            text-align: center;
        }
    </style>
</head>
<body>
<img class="q_code" src="/api/schedule/getQ?id=${id}"/>
<div class="center">
    <p>课程名称：${name}</p>
    <p>上课地点：${address}</p>
    <p>结束签到时间：${endAttendTime}</p>
</div>
</body>
</html>
