(function($){
	var urls=[];
	$.each($(".urls"),function(index,item){
		urls.push($(item).attr("uri"));
	})
	$.post("/module/hide?urls="+urls+"",function(data){
		$.each(data,function(i,obj){
			$("[uri='"+obj+"']").remove();
		})
	},"json");
})(jQuery);