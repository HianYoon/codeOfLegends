const imgLabelsContainer = $(".img-labels-container");
imgLabelsContainer.click(e=>{
  // 이곳이 true인 까닭은 click이벤트가 먼저 일어난 뒤에, 체크가 일어나기 때문이다.
  // 클릭이 일어나는 시점에서는 check가 반대로 되어있기 때문.
  if($("#"+$(e.target).parents("label").prop("for")).prop("checked") == true){
    $(e.target).parents("label").children()
      .css({
        "background-color":"ivory",
        "transition-duration": "0.5s"
      });
  } else {
    $(e.target).parents("label").children()
      .css({
        "background-color":"#ffca28",
        "transition-duration": "0.5s"
      });
  }
}); 