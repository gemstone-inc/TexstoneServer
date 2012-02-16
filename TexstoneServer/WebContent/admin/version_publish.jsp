<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="../jquery/jquery-1.5.1.js"></script>
<script src="../jquery/external/jquery.bgiframe-2.1.2.js"></script>
<script src="../jquery/ui/jquery.ui.core.js"></script>
<script src="../jquery/ui/jquery.ui.widget.js"></script>
<script src="../jquery/ui/jquery.ui.mouse.js"></script>
<script src="../jquery/ui/jquery.ui.button.js"></script>
<script src="../jquery/ui/jquery.ui.draggable.js"></script>
<script src="../jquery/ui/jquery.ui.position.js"></script>
<script src="../jquery/ui/jquery.ui.selectable.js"></script>
<script src="../jquery/ui/jquery.ui.resizable.js"></script>
<script src="../jquery/ui/jquery.ui.dialog.js"></script>
<script src="../jquery/ui/jquery.effects.core.js"></script>


<link rel="stylesheet" href="../jquery/themes/ui-lightness/jquery.ui.all.css">
<link rel="stylesheet" href="../style/demos.css">
<link href="../style/dropdown/themes/vimeo.com/helper.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../style/dropdown/dropdown.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../style/dropdown/themes/vimeo.com/default.advanced.css" media="screen" rel="stylesheet" type="text/css" />


<title>カテゴリーページ</title>
<s:head />




<style type="text/css">
	body { font-size: 80%; }
	/* label, input { display:block; }
	input.text { margin-bottom:5px; width:95%; padding: .4em; } */
	
	fieldset { padding:0; border:0; margin-top:25px; }
	h1 { font-size: 1.2em; margin: .6em 0; }
	div#users-contain1 { width: 1000px; margin: 20px 0; }
	div#users-contain1 table { margin: 1em 0; border-collapse: collapse; width: 100%; }
	div#users-contain1 table td, div#users-contain1 table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
	
	div#users-contain2 { width: 1000px; margin: 20px 0; }
	div#users-contain2 table { margin: 1em 0; border-collapse: collapse; width: 100%; }
	div#users-contain2 table td, div#users-contain2 table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }


	
	
	div#article-input1 { width: 700px; margin: 20px 0; margin-top: 20px}
	div#article-input1 table { margin: 1em 0; border-collapse: collapse; width: 100%; }
	
	div#article-input2 { width: 700px; margin: 20px 0; margin-top: 20px}
	div#article-input2 table { margin: 1em 0; border-collapse: collapse; width: 100%; }

	div#article-input3 { width: 700px; margin: 20px 0; margin-top: 20px}
	div#article-input3 table { margin: 1em 0; border-collapse: collapse; width: 100%; }


</style>
</head>

<body>
	<jsp:include page="header.jsp"/>
	
	<br/>
	<br/>
	<br/>
	<br/>
	
	<div id="version-input" class="ui-widget">
	
	    <s:if test="currentVersion != null">
			<s:push value="currentVersion">
		    	<label>現在のバージョンNOは<s:property value="versionId"/></label><br/>
		    	<label>現在のバージョンの公開日は<s:date name='releaseDate' format='yyyy年M月d日' /></label><br/>
			</s:push>
	    </s:if>
	    
	    <s:if test="publishNeed">
			<form action="<s:url action='publishVersion' namespace='/admin' includeParams='none'/>" method="post">
				<table>
					<tr>
						<td>
				        	<input type="submit" value="バージョンをアプする"  style="width: 150px; font-size: 2em">			
						</td>
					</tr>
				</table>
			</form>
	    </s:if>
	    <s:else>
	    	<label>現在のバージョンは最新です。</label>
	    </s:else>
	</div>
	


	<s:if test="newCategoryList.size() > 0">
		<div id="users-contain1" class="ui-widget">
			<table id="users" class="ui-widget ui-widget-content">
				<thead>
					<tr class="ui-widget-header ">
						<th>カテゴリー番号</th>
						<th>名称</th>
						<th>画像</th>
					</tr>
				</thead>
				<tbody>	
					<s:iterator value="newCategoryList" status="categoryStatus" var="category">
						<tr
							class="<s:if test="#categoryStatus.odd == true ">odd</s:if><s:else>even</s:else>">
							<td>
								<s:property value="categoryId"/>
							</td>
							<td>
								<s:property value="categoryName"/>
							</td>
							<td>
								<img src="<s:property value='imageHttp'/>"/>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</s:if>
	


	<s:if test="newArticleList.size() > 0">
		<div id="users-contain2" class="ui-widget">
			<table id="users" class="ui-widget ui-widget-content">
				<thead>
					<tr class="ui-widget-header ">
						<th>タグ</th>
						<th>カテゴリー番号</th>
						<th>タイトル</th>
						<th>編集</th>
						<th>削除</th>
					</tr>
				</thead>
				<tbody>	
					<s:iterator value="newArticleList" status="articleStatus" var="article">
						<tr
							class="<s:if test="#articleStatus.odd == true ">odd</s:if><s:else>even</s:else>">
							<td>
								<s:property value="tag"/>
							</td>
							<td>
								<s:property value="categoryId"/>
							</td>
							<td>
								<s:property value="title"/>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</s:if>

</body>
</html>