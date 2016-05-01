var path;
var grid_selector = "#grid-table";
var pager_selector = "#grid-pager";

function reloadOnce(){
url=location.href;
var times=url.split('?');
if(times[1]!=1){
	url+='?1';
	self.location.replace(url); 
}
}

$(document).ready(function(){
	reloadOnce();
	$(window).resize(function(){
		$(grid_selector).setGridWidth($('#main-container').width());
		});
	$('#startDate').datepicker({autoclose:true});
	$('#endDate').datepicker({autoclose:true});
	path= getContextPath();
	var startDate='';
	var endDate=beforeDay(1);
	$('#startDate').val(startDate);
	$('#endDate').val(endDate);
	var phone=$("#phone").val();
	var roleId=$("#roleId").val();

	$(grid_selector).jqGrid({
		url: path+"/report/sysUser.do",
		postData:{"startDate":startDate,"endDate":endDate,"phone":phone,"roleId":roleId},
		datatype: "json",
		 height: 280,
		 shrinkToFit: true,
		 autowidth:true,
		colAlign:'center',
		colNames:['用户ID','用户名','号码','最后登录时间'],
		colModel:[
			{name:'USER_ID',index:'USER_ID',sortable:true, sorttype:"int", editable: false,align:'center'},
			{name:'NAME',index:'NAME',sortable:true, editable:false,align:'center'},
			{name:'PHONE',index:'PHONE',sortable:true, editable:false,align:'center'},
			{name:'LAST_LOGIN',index:'LAST_LOGIN',sortable:true, editable:false,align:'center'}
			
			
			
		], 
	    prmNames:{page:'page',rows:'rows',totalrows:'totalrows',sort:"sidx", order: "sord"},//设置默认传到后台的参数名称
		viewrecords : true,
		rowNum:10,
		rowList:[10,20,30],
		pager : pager_selector,
		//altRows: false,
		//toppager: true,
		multiselect: false,
		//multikey: "ctrlKey",
        multiboxonly: false,
		sortname: 'LAST_LOGIN',
		sortorder: "desc",
		sortable:true, 
		hidegrid:true, 
		loadComplete : function() {
			
			var table = this;
			setTimeout(function(){
			//	styleCheckbox(table);
			//	updateActionIcons(table);
				updatePagerIcons(table);
				//enableTooltips(table);
			}, 0);
//			var rowNum=parseInt($(this).getGridParam("records"),10);
//			if(rowNum>0){
//			
//			 var CNT_SET=$(this).getCol("CNT_SET",false,"sum");
//			 var CNT_ADUIT_SUCC=$(this).getCol("CNT_ADUIT_SUCC",false,"sum");
//			 var CNT_ADUIT_BAK=$(this).getCol("CNT_ADUIT_BAK",false,"sum");
//			 var CNT_NOT_ADUIT=$(this).getCol("CNT_NOT_ADUIT",false,"sum");                              
//			 $(grid_selector).jqGrid("addRowData",rowNum+1,{"DAILY_ID":"<strong>合计</strong>","CNT_SET":"<strong>"+CNT_SET+"</strong>","CNT_ADUIT_SUCC":"<strong>"+CNT_ADUIT_SUCC+"</strong>","CNT_ADUIT_BAK":"<strong>"+CNT_ADUIT_BAK+"</strong>","CNT_NOT_ADUIT":"<strong>"+CNT_NOT_ADUIT+"<strong>"},"last");
//			}
			//$(grid_selector).closest(".ui-jqgrid-bdiv").css({ "overflow-y" : "hidden" });
			//doResize(grid_selector);
		},
		 onSortCol: function (index,iCol,sortorder)
         {
             $(grid_selector).jqGrid('setGridParam',{postData:{"sortorder":sortorder}});
             $(grid_selector).jqGrid();
             
         },
         gridComplete : function() {


			}
	});
	
	$(grid_selector).jqGrid('navGrid',pager_selector,{add:false,del:false,edit:false,position:'right'});	
	
	
	
	 //$(window).triggerHandler('resize.jqGrid');
	//resize to fit page size
	
	//resize on sidebar collapse/expand
	var parent_column = $(grid_selector).closest('[class*="col-"]');
	$(document).on('settings.ace.jqGrid' , function(ev, event_name, collapsed) {
		if( event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed' ) {
			$(grid_selector).jqGrid( 'setGridWidth', parent_column.width() );
		}
	});
	
	
});


function updatePagerIcons(table) {
	var replacement = 
	{
		'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
		'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
		'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
		'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
	};
	$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
		var icon = $(this);
		var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
		
		if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
	})
}

function enableTooltips(table) {
	$('.navtable .ui-pg-button').tooltip({container:'body'});
	$(table).find('.ui-pg-div').tooltip({container:'body'});
}
function reloadJqGrid(){


	var startDate=$('#startDate').val();
	var endDate=$('#endDate').val();
	var phone=$("#phone").val();
	var roleId=$("#roleId").val();
	   $(grid_selector).jqGrid('setGridParam',{postData:{"startDate":startDate,"endDate":endDate,"phone":phone,"roleId":roleId}}).trigger("reloadGrid")

}

