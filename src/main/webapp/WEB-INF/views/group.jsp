<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/screen.css"/>" />
</head>

<body>
	<div id="content">
		<h1>Group</h1>

		<form:form commandName="newGroup" id="reg">
			<h2>Group Registration</h2>
			<table>
				<tbody>
					<tr>
						<td><form:label path="name">Name:</form:label></td>
						<td><form:input path="name" /></td>
						<td><form:errors class="invalid" path="name" /></td>
					</tr>
					<tr>
						<td><form:label path="desc">Description:</form:label></td>
						<td><form:input path="desc" /></td>
						<td><form:errors class="invalid" path="desc" /></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td><input type="submit" value="Register" class="register" />
					</td>
				</tr>
			</table>
		</form:form>

		<h2>Registered Groups</h2>
		<c:choose>
			<c:when test="${groups.size()==0}">
				<em>No registered groups.</em>
			</c:when>
			<c:otherwise>
				<table class="simpletablestyle">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${groups}" var="groups">
							<tr>
								<td>${groups.id}</td>
								<td>${groups.name}</td>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>
