<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fx" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>登入</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
  <%@include file="../common/link.jsp" %>
</head>
<body>

<%@include file="../common/header.jsp" %>

<div class="layui-container fly-marginTop">
  <div class="fly-panel fly-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title">
        <li class="layui-this">登入</li>
        <li><a href="${pageContext.request.contextPath }/reg">注册</a></li>
      </ul>
      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <div class="layui-form layui-form-pane">
            <form method="post" action="${pageContext.request.contextPath }/loginin" onsubmit="return login()">
              <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">邮箱</label>
                <div class="layui-input-inline">
                  <input type="text" id="email" name="email" required lay-verify="required" autocomplete="off" class="layui-input" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="password" name="password" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_vercode" class="layui-form-label">人类验证</label>
                <div class="layui-input-inline">
                  <input type="text" id="vercode" name="vercode" required lay-verify="required" autocomplete="off" class="layui-input" onblur="checkCode()">
                </div>
                <div class="layui- form-mid">
                  <!-- <span style="color: #c00;">{{d.vercode}}</span> -->
                  <span style="color: #c00;">
                  	<img id="code" src="${pageContext.request.contextPath }/code" style="height: 38px" onclick="changecode()" />
                  	<span id="inputcode"></span>
                  </span>
                </div>
              </div>
              <div class="layui-form-item">
                <!-- <button class="layui-btn" lay-filter="*" lay-submit>立即登录</button> -->
               <!-- 	<button type="button" class="layui-btn">立即登录</button> -->
               	 <input type="submit" value="立即登录" class="layui-btn">
                <span style="padding-left:20px;">
                  <a href="forget.html">忘记密码？</a>
                </span>
              </div>
              <div class="layui-form-item fly-form-app">
                <span>或者使用社交账号登入</span>
                <a href="" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-qq" title="QQ登入"></a>
                <a href="" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-weibo" title="微博登入"></a>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="fly-footer">
  <p><a href="http://fly.layui.com/" target="_blank">Fly社区</a> 2017 &copy; <a href="http://www.layui.com/" target="_blank">layui.com 出品</a></p>
  <p>
    <a href="http://fly.layui.com/jie/3147/" target="_blank">付费计划</a>
    <a href="http://www.layui.com/template/fly/" target="_blank">获取Fly社区模版</a>
    <a href="http://fly.layui.com/jie/2461/" target="_blank">微信公众号</a>
  </p>
</div>

<script src="${pageContext.request.contextPath }/res/layui/layui.js"></script>
<script>
layui.cache.page = 'user';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '${pageContext.request.contextPath }/res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '${pageContext.request.contextPath }/res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>
<script src="${pageContext.request.contextPath }/res/js/jquery-3.4.1.min.js"></script>
<script>
	function changecode(){
		var code = document.getElementById("code");
		code.src = "${pageContext.request.contextPath }/code?"+Math.random(); 
	}
	function checkCode(){
		var vercode = $("#vercode").val();
		var inputcode = $("#inputcode");
		var msg = "";
		if(vercode != ""){
			$.ajax({
				url:"${pageContext.request.contextPath }/checkCode/"+vercode,
				type:"post",
				data:{
				},success:function(s){
					if(s == "check"){
						msg = "√".fontcolor("green");
					}else{
						msg = "×".fontcolor("red");
					}
					inputcode.html(msg);
				}
			});
		}else{
			inputcode.html("验证码不允许为空！");
		}

	}
	function login(){
		var vercode = $("#vercode").val();
		var inputcode = $("#inputcode");
		if(inputcode.text() != "√"){
			return false;
		}
	}
</script>
</body>
</html>