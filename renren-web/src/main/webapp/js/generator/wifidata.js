$(function () {
    $("#jqGrid").jqGrid({
        url: '../wifidata/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '', name: 'tem', index: 'tem', width: 80 }, 			
			{ label: '', name: 'humi', index: 'humi', width: 80 }, 			
			{ label: '', name: 'mq', index: 'mq', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		wifidata: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.wifidata = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.wifidata.id == null ? "../wifidata/save" : "../wifidata/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.wifidata),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../wifidata/delete",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get("../wifidata/info/"+id, function(r){
                vm.wifidata = r.wifidata;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});