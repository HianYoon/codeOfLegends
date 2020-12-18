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
      $(e.target).parents("label").children().removeClass("animate__shakeY").addClass("animate__shakeX");
  } else {
    $(e.target).parents("label").children()
      .css({
        "background-color":"#ffca28",
        "transition-duration": "0.5s"
      });
      $(e.target).parents("label").children().removeClass("animate__shakeX").addClass("animate__shakeY");
  }
}); 

let checker = [false, false, false];

const regexes = [
  /^\d{10}$/,
  /^\d{2,3}-\d{3,4}-\d{4}$/
];

const businessNo = $("#businessNo");
const businessTel = $("#businessTel");
const businessAddress1 = $("#businessAddress1");
const businessNoCheck = $("#businessNoCheck");


businessNo.keyup((e) => {
  
  if(regexes[0].test(businessNo.val())){
    $.ajax({
      method: "POST",
      url: path+"/business/signup/business/no",
      data: {data: businessNo.val()},
      async: false,
      success: result => {
        console.log(result);
      }
    });
    businessNoCheck.removeClass("opacity0");
  } else {
    businessNoCheck.addClass("opacity0");
    checker[0] = false;
  }
});