<!DOCTYPE div PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<div>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".slidingDiv").hide();
			$(".show_hide").show();
			$(".show_hide_ajax").show();
			$(".stagingdiv").show();
			
		    $('.show_hide_ajax').click(function(){
		    	var contentDiv = $(this).parent().find(".slidingDiv");
		    	$(contentDiv).slideToggle();
		    	if ($(contentDiv).html().indexOf("Loading ajax ....") == -1) {
					$(contentDiv).html("Loading ajax ....");
		    	}
		    	else {
		    		var url = 'results/' + $(this).attr("id");
			    	$.getJSON(url,function(data) { 
			    		var table = createResultsDiv(data);
			    		$(contentDiv).html(table);
					});
		    	}
		    });
		    
		    $('.show_hide').click(function(){
		    	var contentDiv = $(this).siblings(".slidingDiv");
		    	$(contentDiv).slideToggle();
		    });
		});
		
		function createResultsDiv(data){
			var resultsDiv = '';
			for(var i=0;i<data.length;i++){
				var result = data[i];
				console.log(data[i]);
				if(result.runType != "COMPARE"){
					resultsDiv += '<div class="resultsDiv">';
					resultsDiv += 'Zip Name : ' + result.name;
					if(result.resultStatus){
						resultsDiv += '<img class="status" style="margin-left:10px;" alt="Reports match" src="resources/green.gif">';
					}
					else {
						resultsDiv += '<img class="status" style="margin-left:10px;" alt="Reports match" src="resources/red.gif">';
					}
	    			resultsDiv += '</div>';
				}
				else {
					resultsDiv = displayComparisonReport(result,resultsDiv);
				}
    		}
			
			return resultsDiv;
		}
		
		function displayComparisonReport(result,resultsDiv){
			resultsDiv += '<div class="resultsDiv">';
			resultsDiv += 'Origional Sheet Name  : ' + result.compareResult.firstFileName + '<br />';
			resultsDiv += 'New Sheet Name : ' + result.compareResult.secondFileName + '<br />';
			if(!result.resultStatus){
				resultsDiv = displayComparisonDifferences(result.compareResult,resultsDiv);
			}
			resultsDiv += '</div>';
			return resultsDiv;
		}
		
		function displayComparisonDifferences(compareResult,resultsDiv){
			resultsDiv += '<div class="comparisonDisplayDiv">';
			for(var i=0;i<compareResult.missingSheet.length;i++){
				resultsDiv += 'Missing sheet(\'s) : <strong>' + compareResult.missingSheet[i] + '</strong><br />';
			}
			for(var i=0;i<compareResult.extraSheet.length;i++){
				resultsDiv += 'Extra sheet(\'s) : <strong>' + compareResult.extraSheet[i] + '</strong><br />';
			}
			resultsDiv += '<table style="border:1px solid;height:100px;width:700px;">';
			resultsDiv += '</table>';
			resultsDiv += '</div>';
			return resultsDiv;
		}
	</script>
	<c:if test="${not empty showUUID}">
		<script type="text/javascript">
			$(document).ready(function(){
				console.log("${showUUID}");
				$("#${showUUID}").click();
			});
		</script>
	</c:if>
	<div style="padding-top:20px;">
		<a href="#" class="show_hide title">Staging Results : 10.64.46.64</a>
		<div class="slidingDiv stagingdiv" style=";padding-left:10px;">
			<div style="padding-top:20px;">
				<h3>Nightly Reports</h3>
				<c:forEach items="${nightly}" var="result">
					<div style="padding-top:10px;padding-left:20px;">
						<a href="#" class="show_hide_ajax" id="${result.label}">${result.formattedDate}</a>
						<c:choose>
							<c:when test="${result.result}">
								<img class="status" style="margin-left:10px;" alt="Reports match" src='<c:url value="/resources/green.gif"/>'>
							</c:when>
							<c:otherwise>
								<img class="status" style="margin-left:10px;" alt="Differences in reports" src='<c:url value="/resources/red.gif"/>'>
							</c:otherwise>
						</c:choose>
						<div class="slidingDiv" style=";padding-left:20px;">
							Loading ajax ....
						</div>
					</div>
				</c:forEach>
			</div>
			<div style="padding-top:20px;">
				<h3>On Demand Reports</h3>
				<c:forEach items="${onDemand}" var="result">
					<div style="padding-top:10px;padding-left:10px;">
							<a href="#" class="show_hide_ajax" id="${result.label}">${result.formattedDate}</a>
							<c:choose>
								<c:when test="${result.result}">
									<img class="status" style="margin-left:10px;" alt="Reports match" src='<c:url value="/resources/green.gif"/>'>
								</c:when>
								<c:otherwise>
									<img class="status" style="margin-left:10px;" alt="Differences in reports" src='<c:url value="/resources/red.gif"/>'>
								</c:otherwise>
							</c:choose>
							<div class="slidingDiv" style=";padding-left:20px;">
								Loading ajax ....
							</div>
						</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div style="padding-top:30px;">
		<h3>Excel Comparing Reports</h3>
		<c:forEach items="${onCompare}" var="result">
			<div style="padding-top:10px;padding-left:10px;">
					<a href="#" class="show_hide_ajax" id="${result.label}">${result.formattedDate}</a>
					<c:choose>
						<c:when test="${result.result}">
							<img class="status" style="margin-left:10px;" alt="Reports match" src='<c:url value="/resources/green.gif"/>'>
						</c:when>
						<c:otherwise>
							<img class="status" style="margin-left:10px;" alt="Differences in reports" src='<c:url value="/resources/red.gif"/>'>
						</c:otherwise>
					</c:choose>
					<div class="slidingDiv" style=";padding-left:20px;">
						Loading ajax ....
					</div>
				</div>
		</c:forEach>
	</div>
</div>
