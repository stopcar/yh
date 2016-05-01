
function getContextPath(){
	var strFullPath=window.document.location.href;
	var strPath=window.document.location.pathname;
	var pos=strFullPath.indexOf(strPath);
	var prePath=strFullPath.substring(0,pos);
	var postPath=strPath.substring(0,strPath.substr(1).indexOf('/')+1);
	return(prePath+postPath);
	//return 'http://report.jiaoyucard.com';
}



function exportToExcel(methodName,params,excelNm) {
	
	var colNames = getColNames("grid-table");
	var colModel=getColModel("grid-table");
	var strPars=getParams("grid-table",params);
	
	location.href=getContextPath()+'/report/exportExcel.do?methodName='+methodName+'&colNames='+encodeURI(colNames)+'&colModel='+colModel+'&strPars='+strPars+'&excelNm='+excelNm;

};


			function beforeDay(n){
				var now = new Date();
			    var year = now.getFullYear();       
			    var month = now.getMonth() + 1;     
			    var day = now.getDate();          
			    if(day <=n){
			    	if(month>1){
			    		month=month-1
			    	}else{
			    		year=year-1;
			    		month=12;
			    	}
			    }
			    now.setDate(day-n);
			   year = now.getFullYear();       
			   month = now.getMonth() + 1;    
			   day = now.getDate();            
			   var s=year+(month<10?('0'+month):month)+(day<10?('0'+day):day)
			    return s;
				
			}
			
			function getColNames(id) {
				var b = jQuery("#" + id)[0];
				var params = b.p.colNames;
				var cols = params[0];
				for (var i = 1; i < params.length; i++) {
					cols += "," + params[i];
				}
				return cols
			}

			function getParams(id,params) {
				var b = jQuery("#" + id);
				var url=b.getGridParam("postData");	
				var param;
				var strPars='';
				$.each(params,function(){
					param=this;
					$.each(url,function(key,val){
						if(param==key){
								strPars+=key+':'+url[key]+',';	
								
						}	
				});
					
				});
				strPars=strPars.substring(0,strPars.length-1);
				return strPars;
			}

			function getColModel(id) {
				var b = jQuery("#" + id)[0];
				var params = b.p.colModel;
				var cols = params[0].name;
				for (var i = 1; i < params.length; i++) {
					cols += "," + params[i].name;
				}
				return cols
			}
