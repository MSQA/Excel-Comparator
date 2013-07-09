<!DOCTYPE div PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<div>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".slidingDiv").hide();
			$(".show_hide").show();
			
		    $('.show_hide').click(function(){
		    	$(this).parent().find(".slidingDiv").slideToggle();
		    });
		});
		
		function startReport(button,url){
			$(button).hide();
			$(button).next().show();
			$.getJSON(url,function(data) { 
				$(button).show();
				$(button).next().hide();
				if(data.resultStatus){
					$(button).next().next().replaceWith("<img class='status' style='margin-left:10px;' alt='Reports match ajax' src='<c:url value="/resources/green.gif"/>'>");
				}
				else {
					$(button).next().next().replaceWith("<img style='margin-left:10px;' alt='Reports match ajax' src='<c:url value="/resources/red.gif"/>'>");
				}
				$(button).next().after("<a style='margin-left:10px;' href='results/" + data + "'>View Result</a>");
			});
		}
		
	</script>
	<security:authorize ifAnyGranted="ROLE_ADMIN">
		<div class="addReport">
			<form method="post" enctype="multipart/form-data">
				<h3>Add report to monitor</h3>
				<table style="width:400px;border:1;cellspacing:0;padding-top:20px;padding-left:10px;">
					<tr>
						<td><strong>Grab File</strong></td>
						<td><input type="file" name="grabFile" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" name="submit" value="Add and Run" /></td>
					</tr>
				</table>
			</form>
		</div>
	</security:authorize>
	<div class="displayReports" style="padding-top:20px;">
		<h3>Existing reports to monitor</h3>
		<c:forEach items="${reports}" var="report">
			<div style="padding-top:10px;padding-left:10px;">
				<a href="#" class="show_hide">${report.zipName}</a>
				<input type="button" value="Run Report" style="margin-left:10px;" onclick="startReport(this,'reports/${report.id}')"/>
				<img style="margin-left:10px;display:none;" alt="running report" src='<c:url value="/resources/ajax-loader.gif"/>'>
				<c:choose>
					<c:when test="${report.statusLastRun}">
						<img class="status" style="margin-left:10px;" alt="Reports match" src='<c:url value="/resources/green.gif"/>'>
					</c:when>
					<c:otherwise>
						<img class="status" style="margin-left:10px;" alt="Differences in reports" src='<c:url value="/resources/red.gif"/>'>
					</c:otherwise>
				</c:choose>
				<div class="slidingDiv" style=";padding-left:20px;">
					Grab ID : ${report.id} <br />
					Grab Name : ${report.zipName} <br />
					Date Added : ${report.dateAdded}<br />
					Status of last report : ${report.statusLastRun}
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="displayReports" style="padding-top:20px;">
		<h3>Run Nightly Reports</h3>
		<form method="post" enctype="multipart/form-data">
			<input style="display:none;" type="text" name="zipName" value="allReports"/>
			<input type="submit" name="submit" value="Run all reports" />
		</form>
	</div>
</div>
