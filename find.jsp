<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form id="data-upload" name="myForm" action="MyServlet1" method="post" >
		<table>
			<tbody>
			<tr>
					<td>From:</td>					
					<td>
						<select name="from" >
							<option>Ahmedabad</option>
							<option>Surat</option>
							<option>Vadodara</option>
							<option>Kutch</option>
							<option>Rajkot</option>
						</select>
					</td>
			</tr>
			
			<tr>
					<td>To:</td>					
					<td>
						<select name="to" >
							<option>Ahmedabad</option>
							<option>Surat</option>
							<option>Vadodara</option>
							<option>Kutch</option>
							<option>Rajkot</option>
						</select>
					</td>
			</tr>
			
			</tbody>
		
		</table>
		
		<input type="submit" value="submit" name="submit"/>
</form>
</body>
</html>