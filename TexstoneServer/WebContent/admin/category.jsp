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
	
	
	div.picure-contain { width: 250px; margin: 20px 0; }
	div.picure-contain table { border-collapse: collapse; width: 100%; }
	div.picure-contain table td{ border: 1px solid #eee; padding: .6em 10px; text-align: center; }
 	div.picure-contain table th{ border: 1px solid #eee; padding: .6em 10px; text-align: center; }
	
	
	div#category-input { width: 700px; margin: 20px 0; margin-top: 20px}
	div#category-input table { margin: 1em 0; border-collapse: collapse; width: 100%; }

</style>
</head>

<body>
	<jsp:include page="header.jsp"/>
	
	<br/>
	<br/>
	<br/>
	<br/>
	
	<div id="category-input" class="ui-widget">
		<s:actionerror/>
		<s:fielderror />
		<form action="<s:url action='saveOrUpdateCategory' namespace='/admin' includeParams='none'/>" enctype="multipart/form-data" method="post">
			<s:push value="category">
				<table>
					<tr>
						<td>
							<label>カテゴリー名:</label>
						</td>
						<td>
				        	<input type="hidden" name="id" value="<s:property value='categoryId'/>"/>
							<input type="text" name="categoryName" value="<s:property value='categoryName'/>"size="40"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<label>画像</label>
						</td>
						<td>
							<s:if test="imageFilePath != null">
								<img src="<s:property value='imageHttp'/>"/> <br/>
							</s:if>
							<input name="categoryImage" type="file" />
						</td>
					</tr>
					
					<tr>
						<td>
							<label>画像OVER</label>
						</td>
						<td>
							<s:if test="imageOverFilePath != null">
								<img src="<s:property value='imageOverHttp'/>"/> <br/>
							</s:if>
							<input name="categoryImageOver" type="file" />
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




	<s:if test="categoryList.size() > 0">
		<div id="users-contain" class="ui-widget">
			<table id="users" class="ui-widget ui-widget-content">
				<thead>
					<tr class="ui-widget-header ">
						<th>カテゴリー番号</th>
						<th>名称</th>
						<th>画像</th>
						<th>画像OVER</th>
						<th>編集</th>
						<th>削除</th>
					</tr>
				</thead>
				<tbody>	
					<s:iterator value="categoryList" status="categoryStatus" var="category">
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
							<td>
								<img src="<s:property value='imageOverHttp'/>"/>
							</td>
							<td>
								<s:if test="version == null">
									<s:url id="editURL" action="editCategory" namespace="/admin">
										<s:param name="id" value="%{categoryId}"></s:param>
									</s:url>
									<s:a href="%{editURL}">編集</s:a>
								</s:if>
								<s:else>
									&nbsp;
								</s:else>
							</td>
							<td>
								<s:if test="version == null">
									<s:url id="deleteURL" action="deleteCategory" namespace="/admin">
										<s:param name="id" value="%{categoryId}"></s:param>
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