<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/screen.css"/>" />

<script src="http://code.jquery.com/jquery-1.11.0.js"></script>

<script>
	function populateAssociatedGroups() {

		var uid = ($(":radio:checked").map(function() {
			if (this.name == "uid") {
				return this.value;
			}
		}).get());

		$("#uid").val(uid);
		$("#uidClicked").val(1);

		$('form#reg').submit();

	}

	function getUserData() {
		var uid = ($(":radio:checked").map(function() {
			if (this.name == "uid") {
				return this.value;
			}
		}).get());

		var gid = ($(":checkbox:checked").map(function() {
			if (this.name == "gid") {
				return this.value;
			}
		}).get().join());

		$("#uid").val(uid);
		$("#gid").val(gid);

		if ($('#uid').val() == '') {
			alert('Please select a User');
			return;
		}
		if ($('#gid').val() == '') {
			alert('Please select a group');
			returnl
		}

		$('form#reg').submit();
	}
</script>

</head>



<body>
	<div id="content">
		<h1>User Group Association</h1>


		<h2>Select User</h2>
		<c:choose>
			<c:when test="${members.size()==0}">
				<em>No registered Users.</em>
			</c:when>
			<c:otherwise>
				<table class="simpletablestyle">
					<thead>
						<tr>
							<th>Select</th>
							<th>Name</th>
							<th>Email</th>
							<th>Password</th>
							<th>Phone #</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${members}" var="member">
							<tr>
								<td><input type="radio" ${member.checked} name="uid"
									value="${member.id}"
									onClick="javascript:populateAssociatedGroups()" /></td>
								<td>${member.name}</td>
								<td>${member.email}</td>
								<td>${member.password}</td>
								<td>${member.phoneNumber}</td>
						</c:forEach>
					</tbody>
				</table>

				<h2>Select Group(s)</h2>

				<table class="simpletablestyle">
					<thead>
						<tr>
							<th>Group Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${groupList}" var="group">
							<tr>
								<td><input type="checkbox" ${group.checked} name="gid"
									value="${group.key}" />${group.value}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<form:form commandName="userGroup" id="reg">
					<table>
						<tr>
							<td><input type="button" onclick="javascript:getUserData();"
								value="Register/Update" class="register" /></td>
						</tr>
					</table>

					<form:hidden path="gid" />
					<form:hidden path="uid" />
					<form:hidden path="uidClicked" value="0" />
				</form:form>


			</c:otherwise>

		</c:choose>


	</div>
</body>
</html>
