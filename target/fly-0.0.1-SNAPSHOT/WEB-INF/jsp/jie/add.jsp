<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fx" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>发表帖子</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
  <!-- fly基础样式 -->
  <%@include file="../common/link.jsp" %>
  <!-- ueditor主要依赖 -->
  <%@include file="../common/ueditor.jsp" %>
</head>
<body>

<%@include file="../common/header.jsp" %>
<div class="layui-container fly-marginTop">
  <div class="fly-panel" pad20 style="padding-top: 5px;">
    <!--<div class="fly-none">没有权限</div>-->
    <div class="layui-form layui-form-pane">
      <div class="layui-tab layui-tab-brief" lay-filter="user">
        <ul class="layui-tab-title">
          <li class="layui-this">发表新帖<!-- 编辑帖子 --></li>
        </ul>
        <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
          <div class="layui-tab-item layui-show">
            <form action="${pageContext.request.contextPath }/publishAnArticle" method="post">
              <div class="layui-row layui-col-space15 layui-form-item">
                <div class="layui-col-md3">
                  <label class="layui-form-label">所在专栏</label>
                  <div class="layui-input-block">
                    <select lay-verify="required" name="special_column" lay-filter="column" style="z-index:999">
                      <fx:forEach items="${special_column }" var="special_column">
                        <option></option>
                      	<option value="${special_column.id }">${special_column.special_column }</option>
                      </fx:forEach> 
                    </select>
                  </div>
                </div>
                <div class="layui-col-md9">
                  <label for="L_title" class="layui-form-label">标题</label>
                  <div class="layui-input-block">
                    <input type="text" id="L_title" name="title" required lay-verify="required" autocomplete="off" class="layui-input">
                    <!-- <input type="hidden" name="id" value="{{d.edit.id}}"> -->
                  </div>
                </div>
              </div>
              <div class="layui-row layui-col-space15 layui-form-item layui-hide" id="LAY_quiz">
                <div class="layui-col-md3">
                  <label class="layui-form-label">所属产品</label>
                  <div class="layui-input-block">
                    <select name="project">
                      <option></option>
                      <option value="layui">layui</option>
                      <option value="独立版layer">独立版layer</option>
                      <option value="独立版layDate">独立版layDate</option>
                      <option value="LayIM">LayIM</option>
                      <option value="Fly社区模板">Fly社区模板</option>
                    </select>
                  </div>
                </div>
                <div class="layui-col-md3">
                  <label class="layui-form-label" for="L_version">版本号</label>
                  <div class="layui-input-block">
                    <input type="text" id="L_version" value="" name="version" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-col-md6">
                  <label class="layui-form-label" for="L_browser">浏览器</label>
                  <div class="layui-input-block">
                    <input type="text" id="L_browser"  value="" name="browser" placeholder="浏览器名称及版本，如：IE 11" autocomplete="off" class="layui-input">
                  </div>
                </div>
              </div>
              <div class="layui-form-item layui-form-text">
                <div class="layui-input-block">
                  <!-- <textarea id="L_content" name="content" required lay-verify="required" placeholder="详细描述" class="layui-textarea fly-editor" style="height: 260px;"></textarea> -->
					<textarea id="editor" name="content" style="height: 260px;"></textarea>  
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">悬赏飞吻</label>
                  <div class="layui-input-inline" style="width: 190px;">
                    <select name="experience">
                      <fx:forEach items="${kiss }" var="kiss">
                      	<option value="${kiss.id }">${kiss.kiss_num }</option>
                      </fx:forEach> 
                    </select>
                  </div>
                  <div class="layui-form-mid layui-word-aux">发表后无法更改飞吻</div>
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
                <!-- <button class="layui-btn" lay-filter="*" lay-submit>立即发布</button> -->
                <input class="layui-btn" type="submit" value="立即发布">
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

<script src="${pageContext.request.contextPath}/res/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/res/js/jquery-3.4.1.min.js"></script>
<script>
layui.cache.page = 'jie';
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
<!-- 初始化UEditor -->
<script type="text/javascript">
	/* 解决文本编辑器z-index问题 */
	$(function(){ 
		$("#edui1").removeAttr("style","");
		$("#edui1_iframeholder").removeAttr("style","");
	}); 
		
	var ue = UE.getEditor('editor');
    
</script>
<!-- 获取文章分类 -->
<script>
	function required(){
		$.ajax({
			url:"${pageContext.request.contextPath}/special_column",
			type:"post",
			data:{
				
			},success:function(s){
				if(s == "get"){
					alert("!");
				}else if(s == "unget"){
					alert("?");
				}
			}
		})
	}

</script>
<!-- 验证码 Start -->
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
<!-- 验证码 End -->
</body>
</html>