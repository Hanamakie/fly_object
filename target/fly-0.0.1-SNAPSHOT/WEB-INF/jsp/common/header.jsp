<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="n" %>


<div class="fly-header layui-bg-black">
  <div class="layui-container">
    <a class="fly-logo" href="${pageContext.request.contextPath }/">
      <img src="${pageContext.request.contextPath }/res/images/logo.png" alt="layui">
    </a>
    <ul class="layui-nav fly-nav layui-hide-xs">
<%--       <li class="layui-nav-item layui-this">
        <a href="${pageContext.request.contextPath }/"><i class="iconfont icon-jiaoliu"></i>交流</a>
      </li>
      <li class="layui-nav-item">
        <a href="case/case.html"><i class="iconfont icon-iconmingxinganli"></i>案例</a>
      </li>
      <li class="layui-nav-item">
        <a href="http://www.layui.com/" target="_blank"><i class="iconfont icon-ui"></i>框架</a>
      </li> --%>
    </ul>
    
    <ul class="layui-nav fly-nav-user">
      
      <!-- 未登入的状态 -->
		<n:if test="${customer2 == null }">
	      <li class="layui-nav-item">
	        <a class="iconfont icon-touxiang layui-hide-xs" href="${pageContext.request.contextPath }/login"></a>
	      </li>
	      <li class="layui-nav-item">
	        <a href="${pageContext.request.contextPath }/login">登入</a>
	      </li>
	      <li class="layui-nav-item">
	        <a href="${pageContext.request.contextPath }/reg">注册</a>
	      </li>
	      <li class="layui-nav-item layui-hide-xs">
	        <a href="" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" title="QQ登入" class="iconfont icon-qq"></a>
	      </li>
	      <li class="layui-nav-item layui-hide-xs">
	        <a href="" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" title="微博登入" class="iconfont icon-weibo"></a>
	      </li>
	   </n:if>
      <!-- 登入后的状态 -->
	   <n:if test="${customer2 != null }">
	      <li class="layui-nav-item">
	        <a class="fly-nav-avatar" href="javascript:;">
	          <cite class="layui-hide-xs">${customer2.nick_name}</cite>
	          <i class="iconfont icon-renzheng layui-hide-xs" title="认证信息：layui 作者"></i>
	          <i class="layui-badge fly-badge-vip layui-hide-xs">${user.level.level_name}</i>
	             <!-- 头像 Start -->   
	                <fx:if test="${imgpath == ''|| imgpath == null}">
	                	<img src="${pageContext.request.contextPath}/res/avatar/${customer2.avatar}">
	                </fx:if>
	                <fx:if test="${imgpath == customer2.avatar}">
	                	<img src="${pageContext.request.contextPath}/res/avatar/${imgpath}">
	                </fx:if>
	              <!-- 头像 End -->   
	        </a>
	        <dl class="layui-nav-child">
	          <dd><a href="${pageContext.request.contextPath }/set"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
	          <dd><a href="${pageContext.request.contextPath }/message"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
	          <dd><a href="${pageContext.request.contextPath }/home"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
	          <hr style="margin: 5px 0;">
	          <dd><a href="${pageContext.request.contextPath }/logout" style="text-align: center;">退出</a></dd>
	        </dl>
	      </li>
	    </n:if>
      
    </ul>
  </div>
</div>