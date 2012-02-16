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
	div#users-contain { width: 1000px; margin: 20px 0; }
	div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
	div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
	
	div#article-input { width: 700px; margin: 20px 0; margin-top: 20px}
	div#article-input table { margin: 1em 0; border-collapse: collapse; width: 100%; }

</style>
</head>

<body>
	<jsp:include page="header.jsp"/>
	
	<br/>
	<br/>
	<br/>
	<br/>
	
	<s:if test="articleList.size() > 0">
		<div id="users-contain" class="ui-widget">
		  <form action="saveBatchArticleList" method="post">
				<table>
					<tr>
						<td>
							<label>タグ:</label>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="tagInput" size="20"/>
						</td>
						<td>
							<input type="submit" value="送信"  style="width: 100px; font-size: 2em">
						</td>
					</tr>
				</table>
				
		  
				<table id="users" class="ui-widget ui-widget-content">
					<thead class="ui-widget-header">
						<tr>
							<th rowspan="2">カテゴリー番号</th>
							<th><center>タイトル</center></th>
							<th><center>タイトルよみ</center></th>
						</tr>
						<tr>
							<th colspan="2"><center>本文</center></th>
						</tr>
					</thead>
					<tbody>	
						<s:iterator value="articleList" status="articleStatus" var="article">
							<tr
								class="<s:if test="#articleStatus.odd == true ">odd</s:if><s:else>even</s:else>">
								<td rowspan="2">
									<input type="text" name="articleList[${articleStatus.index}].categoryId" value="<s:property value="categoryId"/>" size="10"/>
								</td>
								<td>
									<input type="text" name="articleList[${articleStatus.index}].title" value="<s:property value="title"/>" size="70"/>
								</td>
								<td>
									<input type="text" name="articleList[${articleStatus.index}].titleFurigana" value="<s:property value="titleFurigana"/>" size="70"/>
								</td>
							</tr>
							<tr
								class="<s:if test="#articleStatus.odd == true ">odd</s:if><s:else>even</s:else>">
								<td colspan="2">
									<textarea cols="140" rows="6" name="articleList[${articleStatus.index}].body"><s:property value='body'/></textarea>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</form>
		</div>
	</s:if>

</body>
</html>