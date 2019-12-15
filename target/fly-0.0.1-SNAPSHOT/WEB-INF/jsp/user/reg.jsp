<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fx" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>注册</title>
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
        <li><a href="${pageContext.request.contextPath }/login">登入</a></li>
        <li class="layui-this">注册</li>
      </ul>
      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <div class="layui-form layui-form-pane">
            <form method="post" action="${pageContext.request.contextPath}/reg" onsubmit="return regist()">
              <div class="layui-form-item">
                <label for="L_username" class="layui-form-label">账号</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_username" name="username" required  autocomplete="off" class="layui-input" onblur="testusername()">
                </div>
                <div class="layui-form-mid layui-word-aux" id="usernameresultdiv">将会成为您的登入名</div>
              </div>
              <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">邮箱</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_email" name="email"  required lay-verify="email" autocomplete="off" class="layui-input" onblur="testemail()">
                </div>
                <!-- 添加邮箱验证 -->
                <div class="layui-form-mid layui-word-aux" id="resultdiv">例：daniu@163.com</div>
              </div>
              <div class="layui-form-item">
                <label for="L_username" class="layui-form-label">昵称</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_nick_name" name="nick_name" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="pass"  lay-verify="required" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
              </div>
              <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">确认密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repass" required lay-verify="required" autocomplete="off" class="layui-input" onblur="testpassword()">
                </div>
                <div class="layui-form-mid layui-word-aux" id="passwordresultdiv">密码状态</div>
              </div>
              <div class="layui-form-item">
                <label for="L_vercode" class="layui-form-label">人类验证</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_vercode" name="vercode" required lay-verify="required" placeholder="请回答后面的问题" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid">
         
                   <span style="color: #c00;">验证码</span>
                </div>
              </div>
              <div class="layui-form-item">
              <button type="submit" class="layui-btn" onclick="addcustomer()">立即注册</button>
                <!-- <input type="button" class="layui-btn" lay-filter="*"  onclick="addcustomer()" value="立即注册" /> -->
              </div>
              <div class="layui-form-item fly-form-app">
                <span>或者直接使用社交账号快捷注册</span>
                <a href="" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-qq" title="QQ登入"></a>
                <a href="" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-weibo" title="微博登入"></a>
              </div>
              <input type="hidden" name="action" value="regist">
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

<script src="${pageContext.request.contextPath}/res/layui/layui.js"></script>
<script>
layui.cache.page = 'user';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '${pageContext.request.contextPath}/res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '${pageContext.request.contextPath}/res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>

</body>
</html>
<script src="${pageContext.request.contextPath}/res/js/jquery-3.4.1.min.js"></script>
<script>
	

	/* 验证用户名 */
	function testusername(){
		var username = $("#L_username").val();
		$.ajax({
			url:"${pageContext.request.contextPath}/testusername",
			type:"post",
			data:{
				username:username
			},success:function(result){
				if(result == "OK"){
					msg = "OK".fontcolor("green").fontsize("1px");
				}else if(result == "NO"){
					msg = "用户名已被占用".fontcolor("red").fontsize("1px");
				}
				$("#usernameresultdiv").html(msg);
			}
			
		});
	}
	
	/* 验证邮箱格式 */
	function testemail(){
		var email = $("#L_email").val();
		$.ajax({
			url:"${pageContext.request.contextPath}/testemail",
			type:"post",
			data:{
				email:email
				},success:function(result){
					if(result == "NO"){
						msg = "邮箱不可用，已被注册".fontcolor("red").fontsize("1px");
					}else if(result == "NO@"){
						msg = "邮箱格式不正确".fontcolor("red").fontsize("1px");
					}else if(result == "more@"){
						msg = "邮箱格式不正确".fontcolor("red").fontsize("1px");
					}else if(result == "typeerror"){
						msg = "邮箱格式不正确".fontcolor("red").fontsize("1px");
					}else if(result == "error"){
						msg = "邮箱地址包含敏感字符".fontcolor("red").fontsize("1px");
					}else {
						msg = "OK".fontcolor("green").fontsize("1px");
					}
					$("#resultdiv").html(msg);
				}
		});
	}
	
	/* 验证两次密码是否一致 */
	function testpassword(){
		var password = $("#L_pass").val(); 
		var password2 = $("#L_repass").val();
		if(password != "" && password2 != "" && password == password2){
			msg = "OK".fontcolor("green").fontsize("1px");
		}else{
			msg = "两次密码不一致".fontcolor("red").fontsize("1px"); 
		}
		$("#passwordresultdiv").html(msg);
	}
	
	function addcustomer(){
		var username = $("#L_username").val();
		var nick_name = $("#L_nick_name").val();
		
		var email = $("#L_email").val();
		/* var password = $("pass").val(); */
		var password = $("#L_repass").val();
		$.ajax({
			url:"${pageContext.request.contextPath}/reg2",
			type:"post",
			data:{
				username:username,
				email:email,
				password:password,
				nick_name:nick_name
			}
		});
	}
	/* 验证重复性 */
	function regist(){
		var resultdiv = $("#resultdiv");
		var usernameresultdiv = $("#usernameresultdiv");
		if(usernameresultdiv.test() != "OK"){
			return false;
		}else if(passwordresultdiv.ext() != "OK"){
			return false;
		}else if(resultdiv.text() != "OK"){
			return false;
		}	
	}
</script>