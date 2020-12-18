window.addEventListener('scroll', function(){
    const logoImage = document.querySelector
    ('.logo img');
    const mainNav = document.getElementById
    ("mainNav");

    if(window.pageYOffset > 0){
        
        mainNav.classList.add('bg-grey');
        mainNav.classList.add('txt-white');
    }
    else{
        
        mainNav.classList.remove('bg-grey');
        mainNav.classList.remove('txt-white');
    }
});
$(function(){
	$('#categoryTap').mouseenter(function(){
		$(".one2").show();
	});
	$(".one2").mouseleave(function(){
		$(".one2").hide();
	});
});
$(document).ready(function(){
	$(".left").click(function(){
		window.history.back();
	});
});