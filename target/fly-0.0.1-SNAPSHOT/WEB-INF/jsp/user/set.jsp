<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fx" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>帐号设置</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
  <%@include file="../common/link.jsp" %>
</head>
<body>

<%@include file="../common/header.jsp" %>

<div class="layui-container fly-marginTop fly-user-main">
  <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
    <li class="layui-nav-item">
      <a href="${pageContext.request.contextPath }/home">
        <i class="layui-icon">&#xe609;</i>
        我的主页
      </a>
    </li>
    <li class="layui-nav-item">
      <a href="${pageContext.request.contextPath }/index">
        <i class="layui-icon">&#xe612;</i>
        用户中心
      </a>
    </li>
    <li class="layui-nav-item layui-this">
      <a href="${pageContext.request.contextPath }/set">
        <i class="layui-icon">&#xe620;</i>
        基本设置
      </a>
    </li>
    <li class="layui-nav-item">
      <a href="${pageContext.request.contextPath }/message">
        <i class="layui-icon">&#xe611;</i>
        我的消息
      </a>
    </li>
  </ul>

  <div class="site-tree-mobile layui-hide">
    <i class="layui-icon">&#xe602;</i>
  </div>
  <div class="site-mobile-shade"></div>
  
  <div class="site-tree-mobile layui-hide">
    <i class="layui-icon">&#xe602;</i>
  </div>
  <div class="site-mobile-shade"></div>
  
  
  <div class="fly-panel fly-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title" id="LAY_mine">
        <li class="layui-this" lay-id="info">我的资料</li>
        <li lay-id="avatar">头像</li>
        <li lay-id="pass">密码</li>
        <li lay-id="bind">帐号绑定</li>
      </ul>
      <div class="layui-tab-content" style="padding: 20px 0;">
        <div class="layui-form layui-form-pane layui-tab-item layui-show">
          <form method="post">
            <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">邮箱</label>
              <div class="layui-input-inline">
                <input type="text" id="L_email" name="email" required lay-verify="email" autocomplete="off" value="" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">如果您在邮箱已激活的情况下，变更了邮箱，需<a href="activate.html" style="font-size: 12px; color: #4f99cf;">重新验证邮箱</a>。</div>
            </div>
            <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">昵称 </label>
              <div class="layui-input-inline">
                <input type="text" id="L_username" name="username" required lay-verify="required" autocomplete="off" value="" class="layui-input">
              </div>
              <div class="layui-inline">
                <div class="layui-input-inline">
                  <input type="radio" name="sex" value="0" checked title="男">
                  <input type="radio" name="sex" value="1" title="女">
                </div>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="L_city" class="layui-form-label">城市</label>
              <div class="layui-input-inline">
                <input type="text" id="L_city" name="city" autocomplete="off" value="" class="layui-input">
              </div>
            </div>
            <div class="layui-form-item layui-form-text">
              <label for="L_sign" class="layui-form-label">签名</label>
              <div class="layui-input-block">
                <textarea placeholder="随便写些什么刷下存在感" id="L_sign"  name="sign" autocomplete="off" class="layui-textarea" style="height: 80px;"></textarea>
              </div>
            </div>
            <div class="layui-form-item">
              <button class="layui-btn" key="set-mine" lay-filter="*" lay-submit>确认修改</button>
            </div>
            </form>
          </div>
          
          <div class="layui-form layui-form-pane layui-tab-item">
          <form action="${pageContext.request.contextPath}/set/avatar" method="post" enctype="multipart/form-data">
	            <div class="layui-form-item">
	              <div class="avatar-add">
	                <p>建议尺寸168*168，支持jpg、png、gif，最大不能超过50KB</p>
	                <input type="file" name="avatar" id="avatar" class="avatar">
	                <fx:if test="${imgpath == ''|| imgpath == null}">
	                	<img src="${pageContext.request.contextPath}/res/avatar/${customer2.avatar}">
	                </fx:if>
	                <fx:if test="${imgpath == customer2.avatar}">
	                	<img src="${pageContext.request.contextPath}/res/avatar/${imgpath}">
	                </fx:if>
	                <span class="loading"></span>
	                <input type="submit">
	              </div>
	            </div>
            </form>
          </div>
          
          <div class="layui-form layui-form-pane layui-tab-item">
            <form action="${pageContext.request.contextPath }/changepass" method="post" onsubmit="return changepassword()">
              <div class="layui-form-item">
                <label for="L_nowpass" class="layui-form-label">当前密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_nowpass" name="nowpass" required lay-verify="required" autocomplete="off" class="layui-input" onblur="checkNowpass()">
                </div>
                <div class="layui-form-mid layui-word-aux" id="messageNowpass"></div>
              </div>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">新密码 </label>
                <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="pass" required lay-verify="required" autocomplete="off" class="layui-input" onblur="checkPass()">
                </div>
                <div class="layui-form-mid layui-word-aux" id="messagePass">包含一个大写，一个小写字母，8~16位</div>
              </div>
              <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">确认密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repass" required lay-verify="required" autocomplete="off" class="layui-input" onblur="checkRepass()">
                </div>
                <div class="layui-form-mid layui-word-aux" id="messageRepass"></div>
              </div>
              <div class="layui-form-item">
                <!-- <button class="layui-btn" key="set-mine" lay-filter="*" lay-submit>确认修改</button> -->
                <input class="layui-btn" type="submit" value="确认修改" />
              </div>
            </form>
          </div>
          
          <div class="layui-form layui-form-pane layui-tab-item">
            <ul class="app-bind">
              <li class="fly-msg app-havebind">
                <i class="iconfont icon-qq"></i>
                <span>已成功绑定，您可以使用QQ帐号直接登录Fly社区，当然，您也可以</span>
                <a href="javascript:;" class="acc-unbind" type="qq_id">解除绑定</a>
                
                <!-- <a href="" onclick="layer.msg('正在绑定微博QQ', {icon:16, shade: 0.1, time:0})" class="acc-bind" type="qq_id">立即绑定</a>
                <span>，即可使用QQ帐号登录Fly社区</span> -->
              </li>
              <li class="fly-msg">
                <i class="iconfont icon-weibo"></i>
                <!-- <span>已成功绑定，您可以使用微博直接登录Fly社区，当然，您也可以</span>
                <a href="javascript:;" class="acc-unbind" type="weibo_id">解除绑定</a> -->
                
                <a href="" class="acc-weibo" type="weibo_id"  onclick="layer.msg('正在绑定微博', {icon:16, shade: 0.1, time:0})" >立即绑定</a>
                <span>，即可使用微博帐号登录Fly社区</span>
              </li>
            </ul>
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
  version: "2.0.0"
  ,base: '${pageContext.request.contextPath}/res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>
<script src="${pageContext.request.contextPath}/res/js/jquery-3.4.1.min.js"></script>
<!-- 个人信息修改密码  Start -->
<script>
	/* 当前密码校验 */
	function checkNowpass(){
		var nowpass = $("#L_nowpass").val();
		var message = "";
		$.ajax({
			url:"${pageContext.request.contextPath}/checkpassword/"+nowpass,
			type:"post",
			data:{
				nowpass:nowpass,
			},success:function(s){
				if(s=="check"){
					message = "√".fontcolor("green");
				}if(s=="uncheck"){
					message = "× 密码错误！".fontcolor("red");
				}
				$("#messageNowpass").html(message);
			}
		})
	}
	/* 新密码校验 */
	function checkPass(){
		var pass = $("#L_pass").val();
		var pattern = /^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9~!@&%#_]{8,16}$/;
		var message = "";
		if(pass == null || pass == ""){
			message = "× 新密码不允许为空！".fontcolor("red");
		}else if(!pattern.test(pass)){
			layer.open({
				  title: '格式错误'
				  ,content: '新密码格式不正确，请重新填写！'
				}); 
			message = "× 新密码格式不正确！".fontcolor("red");
		}else{
			message = "√".fontcolor("green");
		}
		$("#messagePass").html(message);
	}
	/* 确认密码校验 */
	function checkRepass(){
		/* 获取确认密码 */
		var repass = $("#L_repass").val();
		/* 获取新密码 */
		var pass = $("#L_pass").val();
		var pattern = /^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9~!@&%#_]{8,16}$/;
		var message = "";
		if(repass == null || repass == ""){
			message = "× 确认密码不允许为空！".fontcolor("red");
		}else if(repass != pass){
			message = "× 两次密码输入不一致！".fontcolor("red");
		}else{
			message = "√".fontcolor("green");
		}
		$("#messageRepass").html(message);
	}
	/* 表单验证 */
	function changepassword(){
		var messageNowpass = $("#messageNowpass");
		var messagePass = $("#messagePass");
		var messageRepass = $("#messageRepass");
		if(messageNowpass.text() != "√"){
			return false;
		}
		if(messagePass.text() != "√"){
			return false;
		}
		if(messageRepass.text() != "√"){
			return false;
		}
	}
</script>
<!-- 个人信息修改密码  End -->
</body>

</html>