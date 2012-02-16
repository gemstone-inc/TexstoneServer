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
	
	<div id="article-input1" class="ui-widget">
		<s:actionerror/>
		<s:fielderror />
		<form action="<s:url action='saveOrUpdateArticle' namespace='/admin' includeParams='none'/>" method="post">
			<s:push value="article">
				<table>
					<tr>
						<td>
							<label>カテゴリーID:</label>
						</td>
						<td>
				        	<input type="hidden" name="id" value="<s:property value='articleId'/>"/>
							<input type="text" name="categoryId" value="<s:property value='categoryId'/>"size="10"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<label>タイトル:</label>
						</td>
						<td>
							<input type="text" name="title" value="<s:property value='title'/>"size="40"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<label>よみ:</label>
						</td>
						<td>
							<input type="text" name="titleFurigana" value="<s:property value='titleFurigana'/>"size="40"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<label>本文:</label>
						</td>
						<td>
							<textarea cols="100" rows="6" name="body"><s:property value='body'/></textarea>
						</td>
					</tr>
					
					
					
					<tr>
						<td colspan="2">
				        	<input type="submit" value="送信"  style="width: 100px; font-size: 2em">			
						</td>
					</tr>
				</table>
			</s:push>	
		</form>
	</div>
	
	
	<div id="article-input2" class="ui-widget">
		<form action="<s:url action='uploadArticleExcel' namespace='/admin' includeParams='none'/>" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<td>
						<label>EXCEL</label>
					</td>
					<td>
						<input name="userExcel" type="file" /> <input type="submit" value="送信"  style="width: 100px; font-size: 2em">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="article-input3" class="ui-widget">
		<form action="<s:url action='listArticle' namespace='/admin' includeParams='none'/>" method="post">
			<table>
				<tr>
					<td>
						<label for="tagToSearch">タグ</label><br/>
						<input type="text" name="tagToSearch" size="10" value="<s:property value='tagToSearch'/>"/>
					</td>
					<td>
						<label for="versionToSearch">バージョン</label><br/>
						<select name="versionToSearch">
					        	   <option value=""></option>
					        	   <option value="null" <s:if test="%{ versionToSearch == 'null' }"> selected </s:if>  >未公開</option>
					        	 <s:iterator value="versionList">
								   <option value="<s:property value="versionId"/>"  <s:if test="%{ versionToSearch == versionId }"> selected </s:if>  >
								   		<s:date name='releaseDate' format='yyyy年M月d日' />-<s:property value="versionId"/>
									</option>
								 </s:iterator>
						</select>
					</td>
					<td>
						<label for="categoryToSearch">カテゴリー</label><br/>
						<select name="categoryToSearch">
								 <option value=""></option>
					        	 <s:iterator value="categoryList">
								   <option value="<s:property value="categoryId"/>"  <s:if test="%{ categoryToSearch == categoryId }"> selected </s:if>  >
								   		<s:property value="categoryId"/>
									</option>
								 </s:iterator>
						</select>
					</td>
					<td>
						<input type="submit" value="検索"  style="width: 100px; font-size: 2em">
					</td>
				</tr>
			</table>
		</form>
	</div>
	


	<s:if test="articleList.size() > 0">
		<div id="users-contain" class="ui-widget">
			<table id="users" class="ui-widget ui-widget-content">
				<thead>
					<tr class="ui-widget-header ">
						<th>バージョン</th>
						<th>タグ</th>
						<th>カテゴリー番号</th>
						<th>タイトル</th>
						<th>編集</th>
						<th>削除</th>
					</tr>
				</thead>
				<tbody>	
					<s:iterator value="articleList" status="articleStatus" var="article">
						<tr
							class="<s:if test="#articleStatus.odd == true ">odd</s:if><s:else>even</s:else>">
							<td>
								<s:if test="version != null">
									<s:date name='version.releaseDate' format='yyyy年M月d日' />-
									<s:property value="version.versionId"/>
								</s:if>
								<s:else>
									新規
								</s:else>
							</td>
							<td>
								<s:property value="tag"/>
							</td>
							<td>
								<s:property value="categoryId"/>
							</td>
							<td>
								<s:property value="title"/>
							</td>
							<td>
								<s:if test="version == null">
									<s:url id="editURL" action="editArticle" namespace="/admin">
										<s:param name="id" value="%{articleId}"></s:param>
									</s:url>
									<s:a href="%{editURL}">編集</s:a>
									</s:if>
								<s:else>
									&nbsp;
								</s:else>
							</td>
							<td>
								<s:if test="version == null">
									<s:url id="deleteURL" action="deleteArticle" namespace="/admin">
										<s:param name="id" value="%{articleId}"></s:param>
									</s:url>
									<s:a href="%{deleteURL}" onclick="javascript:return confirm('本当に削除しますか?');">削除</s:a>
								</s:if>
								<s:else>
									&nbsp;
								</s:else>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</s:if>

</body>
</html>