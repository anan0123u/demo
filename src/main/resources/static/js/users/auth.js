var $table = $("#table_auth");

$(function () {

    var events = {};
    events['click #ck1'] = addAuth;
    events['click #ty1'] = stopAuth;
    events['click #sc1'] = delAuth;

    $table.bootstrapTable({
        url: "/auth/list",
        dataType: "json",
        columns: [{
            field: "auth_name",
            title: "name"
        }, {
            field: "stop_flag",
            title: "flag"
        }, {
            field: "auth_value",
            title: "value"
        }, {
            field: 'operate',
            title: '操作',
            align: 'center',
            valign: 'middle',
            events: events,
            formatter: operateFormatter
        }],
        idField: "auth_id",
        treeShowField: "auth_name",
        parentIdField: "p_id",
        onResetView: function (data) {
            $table.treegrid({
                initialState: "collapsed",
                treeColumn: 0
            });
        }
    });
});

function operateFormatter(value, row, index) {
    var result = "";
    result += "<a id='ck1' class='btn btn-xs btn-info' title='新增'><i class='fa fa-search'></i></a>";
    result += "<a id='ty1' class='btn btn-xs btn-danger' title='停用'><i class='fa fa-ban'></i></a>";
    result += "<a id='sc1' class='btn btn-xs btn-danger' title='删除'><i class='fa fa-trash'></i></a>";

    return result;

}

function addAuth() {
    $('#authModal').modal('show');
}

function saveAuth() {
    var pUrl = "/auth/add";

    // var roleId = $("#auth_id").val();
    var authName = $("#auth_name").val();
    var authValue = $("#auth_value").val();

    var pData = {
        authName: authName,
        authValue: authValue
    }

    $.ajax({
        url : pUrl,
        data : JSON.stringify(pData),
        type : "post",
        async : true,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function(result) {
            if (result && result.retCode == 0) {
                $table.bootstrapTable('refresh');
                $('#authModal').modal('hide');
            }
        },
        error :function(ee){
            alert("失败");
        }
    });
}

function stopAuth(e, value, row, index) {

    var pUrl = "/auth/stop?authId=" + row.auth_id;
    $.ajax({
        url : pUrl,
        // data : JSON.stringify(pData),
        type : "post",
        async : true,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function(result) {
            if (result && result.retCode == 0) {
                $table.bootstrapTable('refresh');
            }
        },
        error :function(ee){
            alert("失败");
        }
    });
}

function delAuth() {

}