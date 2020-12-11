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