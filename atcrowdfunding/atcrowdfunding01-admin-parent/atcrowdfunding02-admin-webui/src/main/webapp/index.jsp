<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
<meta charset="UTF-8">
<title>测试页面</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript">
      $(function (){
      $("#btn04").click(function (){
        layer.msg("layer的弹框");
      });
      $("#btn03").click(function (){
          // 准备要发送的数据
          var student = {
          stuId: 5,
          stuName: "tom",
          address: {
              province: "江苏",
              city: "南京",
              street: "秣陵街道"
          },
          subjectList: [
              {
              subName: "java",
              subScore: 100
              },
              {
              subName: "c++",
              subScore: 98
              }
          ],
          map:{
              key1: "value1",
              key2: "value2"
          }
          };
          // 将JSON对象转换为JSON字符串
          var requestBody = JSON.stringify(student);

          // 发送Ajax请求
          $.ajax({
          url: "send/compose/object.json",
          type: "post",
          data: requestBody,
          contentType: "application/json;character=UTF-8",
          dataType: "json",
          success: function (response){
              console.log(response);
          },
          error: function (response) {
              console.log(response);
          }
          });
      });

        $("#btn02").click(function (){
          // 准备好要发送到服务端的数组
          var array = [5,8,12];

          // 将JSON数组转换为JSON字符串
          var requestBody = JSON.stringify(array);
          $.ajax({
            "url": "send/array2.html",
            "type": "post",
            "data": requestBody,
            contentType: "application/json;character=UTF-8",
            "dataType": "text",
            "success": function (response){
              alert(response);
            },
            "error": function (response){
              alert(response);
            }
          });
        });
      })
    </script>
</head>
<body>
    <a href="test/ssm.html">测试ssm整合环境</a>

    </br>
    </br>

    <button id="btn01">Send text</button>

    </br>
    </br>

    <button id="btn02">Send text2</button>


    </br>
    </br>

    <!-- body中添加按钮 -->
    <button id="btn03">Send Object</button>


    </br>
    </br>
    <button id="btn04">layer</button>
</body>
</html>