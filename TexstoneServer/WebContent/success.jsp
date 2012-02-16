<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>マイページ</title>
    </head>
    <body>

        <s:url id="logoutURL" action="logout" namespace="/"/>        

        
        <table>
        	<tr>
        		<td>
					<s:a href="%{logoutURL}">ログアウト</s:a>
        		</td>
        	</tr>

        </table>
        
        
    </body>
</html>
