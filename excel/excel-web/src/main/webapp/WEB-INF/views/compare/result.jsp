<!DOCTYPE div PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<c:choose>
		<c:when test="${compareResult.errorFound}">
			Differences between reports shown below<br />
			<c:forEach var="missingSheet" items="${compareResult.missingSheet}">
				Latest Report is missing sheet : <strong>${missingSheet}</strong>
				<br />
			</c:forEach>
			<c:forEach var="extraSheet" items="${compareResult.extraSheet}">
				Latest Report has extra sheet : <strong>${extraSheet}</strong>
				<br />
			</c:forEach>
			<table style="border:1px solid;height:100px;width:700px;">
				<thead>
					<tr><th colspan="50" style="border:1px solid;text-align:left;">Latest Report missing rows are shown below<td></tr>
				</thead>
				<tbody>
					<c:forEach var="missingRow" items="${compareResult.missingRows}">
						<tr style="overflow:hidden;border:1px solid;">
							<c:forEach var="cell" items="${missingRow.cells}" varStatus="status">
								<c:choose>
									<c:when test="${status.getIndex() < 20}">
										<c:choose>
											<c:when test="${cell.length() > 100}">
												<td style="overflow:hidden;border:1px solid;">Too Large to Display, check report</td>
											</c:when>
											<c:otherwise>
												<td style="overflow:hidden;border:1px solid;">${cell}</td>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:when test="${status.getIndex() == 20}">
										<td>Check report for rest of row</td>
									</c:when>
								</c:choose>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>No differences detected between reports : ${compareResult.errorFound}</c:otherwise>
	</c:choose>
</div>

