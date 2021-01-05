
//SCROLL
var header = document.querySelector('header'),
    headerHeight = header.offsetHeight
window.addEventListener('scroll', function(){
  if(window.scrollY > 10) {
    header.classList.add('simplify')
  } else {
    header.classList.remove('simplify')
  }
})