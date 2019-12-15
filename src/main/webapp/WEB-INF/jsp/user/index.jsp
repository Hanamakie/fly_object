<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fx" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>用户中心</title>
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
    <li class="layui-nav-item layui-this">
      <a href="${pageContext.request.contextPath }/index">
        <i class="layui-icon">&#xe612;</i>
        用户中心
      </a>
    </li>
    <li class="layui-nav-item">
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
    <!--
    <div class="fly-msg" style="margin-top: 15px;">
      您的邮箱尚未验证，这比较影响您的帐号安全，<a href="activate.html">立即去激活？</a>
    </div>
    -->
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title" id="LAY_mine">
        <li data-type="mine-jie" lay-id="index" class="layui-this">我发的帖（<span>${count }</span>）</li>
        <li data-type="collection" data-url="/collection/find/" lay-id="collection">我收藏的帖（<span>16</span>）</li>
      </ul>
      <div class="layui-tab-content" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <ul class="mine-view jie-row">		
          	<fx:if test="${release != null}">
          	    <fx:forEach items="${release}" var="release">
	          		<li>
		              <a class="jie-title" href="${pageContext.request.contextPath }/detail/${release.id}" target="_blank" title="${release.title}">${release.title}</a>
		              <i>${create_time }</i>
		              <a class="mine-edit" href="${pageContext.request.contextPath }/edit/${release.id}" target="_blank" title="点击编辑">编辑</a>
		              <em>${release.view_count }</em>
		            </li>
	          	</fx:forEach>
          	</fx:if>
			<fx:if test="${count == 0}">
				<div class="layui-tab-content" id="LAY_ucm" style="padding: 5px 0;">
				    <div class="layui-tab-item layui-show">
				        <table class="layui-hide" id="LAY_mySendCard">
				        </table>
				        <div class="layui-form layui-border-box layui-table-view" lay-filter="LAY-table-1"
				        lay-id="LAY_mySendCard" style=" ">
				            <div class="layui-table-box">
				                <div class="layui-table-header">
				                    <table cellspacing="0" cellpadding="0" border="0" class="layui-table"
				                    lay-skin="line">
				                        <thead>
				                            <tr>
				                                <th data-field="title" data-key="1-0-0" data-minwidth="300" class="">
				                                    <div class="layui-table-cell laytable-cell-1-0-0">
				                                        <span>
				                                            帖子标题
				                                        </span>
				                                    </div>
				                                </th>
				                                <th data-field="status" data-key="1-0-1" class="">
				                                    <div class="layui-table-cell laytable-cell-1-0-1" align="center">
				                                        <span>
				                                            状态
				                                        </span>
				                                    </div>
				                                </th>
				                                <th data-field="status" data-key="1-0-2" class="">
				                                    <div class="layui-table-cell laytable-cell-1-0-2" align="center">
				                                        <span>
				                                            结贴
				                                        </span>
				                                    </div>
				                                </th>
				                                <th data-field="time" data-key="1-0-3" class="">
				                                    <div class="layui-table-cell laytable-cell-1-0-3" align="center">
				                                        <span>
				                                            发表时间
				                                        </span>
				                                    </div>
				                                </th>
				                                <th data-field="4" data-key="1-0-4" class=" layui-table-col-special">
				                                    <div class="layui-table-cell laytable-cell-1-0-4">
				                                        <span>
				                                            数据
				                                        </span>
				                                    </div>
				                                </th>
				                                <th data-field="5" data-key="1-0-5" class=" layui-table-col-special">
				                                    <div class="layui-table-cell laytable-cell-1-0-5">
				                                        <span>
				                                            操作
				                                        </span>
				                                    </div>
				                                </th>
				                            </tr>
				                        </thead>
				                    </table>
				                </div>
				                <div class="layui-table-body layui-table-main">
				                    <table cellspacing="0" cellpadding="0" border="0" class="layui-table"
				                    lay-skin="line">
				                        <tbody>
				                        </tbody>
				                    </table>
				                    <div class="layui-none">
				                        无数据
				                    </div>
				                </div>
				            </div>
				            <div class="layui-table-page layui-hide">
				                <div id="layui-table-page1">
				                </div>
				            </div>
				            <style>
				                .laytable-cell-1-0-0{ }.laytable-cell-1-0-1{ width: 100px; }.laytable-cell-1-0-2{
				                width: 100px; }.laytable-cell-1-0-3{ width: 120px; }.laytable-cell-1-0-4{
				                width: 150px; }.laytable-cell-1-0-5{ width: 100px; }
				            </style>
				        </div>
				    </div>
				    <div class="layui-tab-item" style="">
				        <table class="layui-hide" id="LAY_myCollectioncard">
				        </table>
				        <div class="layui-form layui-border-box layui-table-view" lay-filter="LAY-table-4"
				        lay-id="LAY_myCollectioncard" style=" ">
				            <div class="layui-table-box">
				                <div class="layui-table-header">
				                    <table cellspacing="0" cellpadding="0" border="0" class="layui-table"
				                    lay-skin="line">
				                        <thead>
				                            <tr>
				                                <th data-field="title" data-key="4-0-0" data-minwidth="300" class="">
				                                    <div class="layui-table-cell laytable-cell-4-0-0">
				                                        <span>
				                                            帖子标题
				                                        </span>
				                                    </div>
				                                </th>
				                                <th data-field="collection_timestamp" data-key="4-0-1" class="">
				                                    <div class="layui-table-cell laytable-cell-4-0-1" align="center">
				                                        <span>
				                                            收藏时间
				                                        </span>
				                                    </div>
				                                </th>
				                            </tr>
				                        </thead>
				                    </table>
				                </div>
				                <div class="layui-table-body layui-table-main">
				                    <table cellspacing="0" cellpadding="0" border="0" class="layui-table"
				                    lay-skin="line">
				                        <tbody>
				                        </tbody>
				                    </table>
				                    <div class="layui-none">
				                        无数据
				                    </div>
				                </div>
				            </div>
				            <div class="layui-table-page layui-hide">
				                <div id="layui-table-page4">
				                </div>
				            </div>
				            <style>
				                .laytable-cell-4-0-0{ }.laytable-cell-4-0-1{ width: 120px; }
				            </style>
				        </div>
				    </div>
				</div>
			</fx:if>
          	<!-- 分页Start -->
          	<div>
				<div id="test1"></div>
			</div>
          	<!-- 分页End -->
          </ul>
          <div id="LAY_page"></div>
        </div>
        <div class="layui-tab-item">
          <ul class="mine-view jie-row">
            <li>
              <a class="jie-title" href="../jie/detail.html" target="_blank">基于 layui 的极简社区页面模版</a>
              <i>收藏于23小时前</i>  </li>
          </ul>
          <div id="LAY_page1"></div>
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
<%-- <script src="${pageContext.request.contextPath }/res/js/layer.js" charset="utf-8"></script> --%>
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
<!-- 分页模板End -->
<script>
function getpostlist(str,index,size){
	$(".selectcondition").removeClass("layui-this");
	$("#"+str).attr("class","selectcondition layui-this");
	$.ajax({
		url:"${pageContext.request.contextPath}/postServlet?action=getpostlist&selectcondition="+str+"&index="+index+"&size="+size,
		type:"get",
		data:{
			
		},
		success:function(result){
			var list = JSON.parse(result);
			/* {
				list2:[]
			} */
			var inner = template("temp",list);
			//alert(inner);
			
			$("#list").html(inner);
			
		}
	});
}

	$(function(){
		//getpostlist("newpost");
		layui.use('laypage', function(){
			  var laypage = layui.laypage;
			  
			  //执行一个laypage实例
			  laypage.render({
			    elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
			    ,count: 8 //数据总数，从服务端得到
			    ,limit:2
			    ,jump:function(object){
			    	getpostlist("newpost",object.curr,object.limit);
			    }
			  });
		}); 
		
	});
</script>
</body>
</html>