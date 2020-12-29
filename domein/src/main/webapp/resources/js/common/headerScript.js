window.addEventListener("scroll", function () {
	const logoImage = document.querySelector(".logo img");
	const mainNav = document.getElementById("mainNav");

	if (window.pageYOffset > 0) {
		mainNav.classList.add("bg-grey");
		mainNav.classList.add("txt-white");
	} else {
		mainNav.classList.remove("bg-grey");
		mainNav.classList.remove("txt-white");
	}
});
$(function () {
	$("#categoryTap").mouseenter(function () {
		$(".one2").show();
	});
	$(".one2").mouseleave(function () {
		$(".one2").hide();
	});
});
$(document).ready(function () {
	$(".left").click(function () {
		window.history.back();
	});
});

let width = $(window).width();
$(".one2").hide();
$("#categoryTap").mouseenter(function () {
	let width = $(window).width();
	if (width > 768) $(".one2").show();
});
$(".one2").mouseleave(function () {
	if (width > 768) $(".one2").hide();
});

$("#logout *").click((e) => {
	signOut();
	location.href = path + "/member/logout.do";
});

function signOut() {
	const auth2 = gapi.auth2.getAuthInstance();
	auth2.signOut();
}
