<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<h1>TEXSTONEアンドロイドアプリ管理</h1>
<ul id="nav" class="dropdown dropdown-horizontal">

	<s:url var="URLtag" action='home' namespace='/admin' includeParams='none'/>
	<li class="first"><a href="<s:property value='#URLtag' />">ホーム</a></li>
	
	<li>
		<s:url var="URLtag" action='listCategory' namespace='/admin' includeParams='none'/>
		<a href="<s:property value='#URLtag' />">カテゴリー</a>
	</li>
	
	<li>
		<s:url var="URLtag" action='listArticle' namespace='/admin' includeParams='none'/>
		<a href="<s:property value='#URLtag' />">記事</a>
	</li>
	
	<li>
		<s:url var="URLtag" action='checkVersion' namespace='/admin' includeParams='none'/>
		<a href="<s:property value='#URLtag' />">バージョン</a>
	</li>
	
	<li>
		<s:url var="URLtag" action='logout' namespace='/' includeParams='none'/>
		<a href="<s:property value='#URLtag' />">ログアウト</a>
	</li>
</ul>