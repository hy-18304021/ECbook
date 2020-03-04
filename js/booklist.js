var i = 0, $col3;
// var $col3 = $(".col3");
$(document).ready(function(){
 	$col3 = $(".col3");
	if($col3.length>8){
		$col3.parent().parent()
				.append($("<input>")
					.attr({type:"button",onclick:"previous()",value:"<<"})
					.addClass("previous-button"))
				.append($("<input>")
					.attr({type:"button",onclick:"next()",value:">>"})
					.addClass("next-button"));
	}
	display(i);
});

function next() {
  if (i <= $col3.length/8-1) {
    i++;
    display(i);
  }
}

function previous() {
  if (i > 0) {
    i--;
    display(i);
  }
}

function display(i){
	for(var a=0;a<$col3.length;a++){
		var $bookdiv = $col3[a];
		$bookdiv.style.display = 'none';
	}
	for(var y=i*8;y<((i+1)*8);y++){
		var $bookdiv = $col3[y];
		if(typeof $bookdiv !=='undefined'){
			$bookdiv.style.display = 'block';
		}
	}
}