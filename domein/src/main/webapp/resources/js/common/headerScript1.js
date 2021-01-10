 
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

var tabArea = document.querySelector('header .list-depth-1'),
    tabList = tabArea.querySelectorAll('.depth-1'),
    tabButton = tabArea.querySelectorAll('.depth-1 > a')
tabList[0].classList.add('active')
for(let i = 0; i < tabButton.length; i++) {
  tabButton[i].addEventListener('mouseover', function(){
    let activeList = tabArea.querySelector('.depth-1.active')
    activeList && activeList.classList.remove('active')
    tabList[i].classList.add('active')
  })
}

var topButton = document.querySelector('.btn-top')
topButton.addEventListener('click', function() {
  window.scrollTo({
    top: 0,
    left: 0,
    behavior: 'smooth'
  })
})