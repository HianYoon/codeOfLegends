<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" "/>
</jsp:include>
<section id="context">

</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
		<title>Document</title>
		<link
			rel="stylesheet"
			href="../../../../../../src\main\webapp\resources\css\sharedStyle.css"
		/>
		<link
			rel="stylesheet"
			href="../../../../../../src\main\webapp\resources\css\signUp\businessInfo.css"
		/>
		<link
			rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
		/>
	</head>

	<body>
		<section>
			<div class="form-logo-cont">
				<img
					src="../../../../../../src\main\webapp\resources\images\logo\signature.png"
					alt=""
				/>
			</div>
			<form action="">
				<div class="form-wrapper">
					<table>
						<tr>
							<td>ì¬ìì ë±ë¡ë²í¸</td>
							<td>
								<input
									type="number"
									class="input--text"
									placeholder="-ë¥¼ ì ì¸í ë²í¸ë§"
								/>
							</td>
							<td>
								<img
									src="../../../resources/images/signUp/checked.png"
									class="opacity0"
									id="businessNoCheck"
									alt=""
								/>
							</td>
						</tr>
						<tr>
							<td>ì£¼ì</td>
							<td>
								<input
									type="text"
									class="input--text"
									id="narrow-field"
									readonly
								/>
								<button class="input--text">ì°í¸ë²í¸ ì°¾ê¸°</button>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="text" class="input--text" readonly /></td>
							<td>
								<img
									src="../../../resources/images/signUp/checked.png"
									class="opacity0"
									id="addressCheck"
									alt=""
								/>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input
									type="text"
									class="input--text"
									placeholder="ëë¨¸ì§ ì£¼ì"
								/>
							</td>
						</tr>
						<tr>
							<td>ì¹´íê³ ë¦¬</td>
							<td class="categories">
								<label for="beef">
									<div class="img-labels-container animate__animated">
										<h5>ì ì¡</h5>
										<img
											src="../../../../webapp/resources/images/signUp/beef.png"
											alt=""
										/>
									</div>
								</label>
								<label for="seafood">
									<div class="img-labels-container animate__animated">
										<h5>ìì°</h5>
										<img
											src="../../../../webapp/resources/images/signUp/fish.png"
											alt=""
										/>
									</div>
								</label>
								<label for="vegetable">
									<div class="img-labels-container animate__animated">
										<h5>ì¼ì±</h5>
										<img
											src="../../../../webapp/resources/images/signUp/vegetables.png"
											alt=""
										/>
									</div>
								</label>
								<label for="steel">
									<div class="img-labels-container animate__animated">
										<h5>ì² ë¬¼</h5>
										<img
											src="../../../../webapp/resources/images/signUp/beam.png"
											alt=""
										/>
									</div>
								</label>
							</td>
						</tr>
						<tr>
							<td></td>
							<td class="categories">
								<label for="pet">
									<div class="img-labels-container animate__animated">
										<h5>ì ê²¬</h5>
										<img
											src="../../../../webapp/resources/images/signUp/bone.png"
											alt=""
										/>
									</div>
								</label>
								<label for="bakery">
									<div class="img-labels-container animate__animated">
										<h5>ë² ì´ì»¤ë¦¬</h5>
										<img
											src="../../../../webapp/resources/images/signUp/bread.png"
											alt=""
										/>
									</div>
								</label>
								<label for="electronics">
									<div class="img-labels-container animate__animated">
										<h5>ì ìê¸°ê¸°</h5>
										<img
											src="../../../../webapp/resources/images/signUp/free-icon-lightning-616494.png"
											alt=""
										/>
									</div>
								</label>
								<label for="etc">
									<div class="img-labels-container animate__animated">
										<h5>ê¸°í</h5>
										<img
											src="../../../../webapp/resources/images/signUp/free-icon-question-mark-in-dark-circle-71768.png"
											alt=""
										/>
									</div>
								</label>
							</td>
						</tr>
						<div class="input-fields">
							<input type="checkbox" name="beef" id="beef" />
							<input type="checkbox" name="seafood" id="seafood" />
							<input type="checkbox" name="vegetable" id="vegetable" />
							<input type="checkbox" name="steel" id="steel" />
							<input type="checkbox" name="pet" id="pet" />
							<input type="checkbox" name="bakery" id="bakery" />
							<input type="checkbox" name="electronics" id="electronics" />
							<input type="checkbox" name="etc" id="etc" />
						</div>
					</table>
					<div class="btn-cont">
						<button class="btn btn--primary">ê°ì</button>
						<button class="btn btn--primary2">ì·¨ì</button>
					</div>
				</div>
			</form>
		</section>
	</body>

	<script src="../../../resources/js/signUp/businessInfo.js"></script>
</html>
