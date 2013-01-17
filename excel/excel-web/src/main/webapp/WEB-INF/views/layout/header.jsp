<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<h1 id="heading">
	<font face="Bradley Hand ITC" style="padding-top: 25px;">Automation
		Remediation Tool</font>
	<security:authorize ifAnyGranted="ROLE_USER">
		<!-- Lets use the default login until i create a page to do it. -->
		<a href="j_spring_security_logout" style="font-size: 15px;">Logout:
			<security:authentication property="principal.username" /> </a>
	</security:authorize>
	<security:authorize ifNotGranted="ROLE_USER">
		<a href="login" style="font-size: 20px; margin-left: 10px;">Login
		</a>
	</security:authorize>
</h1>
