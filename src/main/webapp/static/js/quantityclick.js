$(function () {
  $(".btn-decrease").click(function(){
    var currentVal = parseInt($(this).next().val());
    if(currentVal > 1){
        currentVal -= 1;
        $(this).next().val(currentVal);
    }
  });
  $(".btn-increase").click(function(){
    var currentVal = parseInt($(this).prev().val());
    if(currentVal < 50){
        currentVal += 1;
        $(this).prev().val(currentVal);
    }
  });
});