hide();
function hide(){
	var urls=[];
	$.each(".urls",function(index,item){
		console.log(item);
		urls.push($(item).attr("uri"));
	})
	$.post("/module/hide?urls="+urls+"",function(data){
		$.each(data,function(i,obj){
			$("[url='"+obj+"']").remove();
		})
	},"json");
}