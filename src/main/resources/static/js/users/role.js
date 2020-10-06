$(function () {

    var events = {};
    events['click #ck1'] = editRole;
    events['click #bj1'] = editRole;
    events['click #ty1'] = stopRole;
    events['click #sc1'] = delRole;

    $('#table_1').bootstrapTable({
        columns: [{
            field: 'role_id',
            title: '角色Id',
            align: 'center'
        }, {
            field: 'role_name',
            title: '角色名称',
            align: 'center'
        }, {
            field: 'stop_flag',
            title: '停用状态',
            align: 'center',
            formatter: stopFormatter
        }, {
            field: 'operate',
            title: '操作',
            align: 'center',
            valign: 'middle',
            events: events,
            formatter: operateFormatter
        }],
        url: '/role/list',
        dataType: 'json',
        pagination: true,
        search: true
    });
});

function operateFormatter(value, row, index) {
    var result = "";
    result += "<a id='ck1' class='btn btn-xs btn-info' title='查看'><i class='fa fa-search'></i></a>";
    result += "<a id='bj1' class='btn btn-xs btn-primary' title='编辑'><i class='fa fa-pencil-alt'></i></a>";
    result += "<a id='ty1' class='btn btn-xs btn-danger' title='停用'><i class='fa fa-ban'></i></a>";
    result += "<a id='sc1' class='btn btn-xs btn-danger' title='删除'><i class='fa fa-trash'></i></a>";

    return result;

}

function addRole() {
    $("#role_id").val("");
    $("#role_name").val("");
    $("[name='stop_flag'][value='0']").prop("checked", "checked");

    $('#roleModal').modal('show');
}

function saveRole() {
    var pUrl = "/role/update";

    var roleId = $("#role_id").val();
    var roleName = $("#role_name").val();

    var stopFlag = $("input[name='stop_flag']:checked").val();

    var editMode = $("#role_save").attr("editMode");

    var pData = {
        roleId: roleId,
        roleName: roleName,
        stopFlag: stopFlag,
        editMode: editMode
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
                $('#table_1').bootstrapTable('refresh');
                $('#roleModal').modal('hide');
            }
        },
        error :function(ee){
            alert("失败");
        }
    });

}

function editRole(e, value, row, index) {

    $("#role_id").val(row.role_id);
    $("#role_name").val(row.role_name);

    var stopFlag = row.stop_flag;
    stopFlag = Number(stopFlag);

    $("[name='stop_flag'][value='" + stopFlag + "']").prop("checked", "checked");

    $('#roleModal').modal('show');

}

function stopRole(e, value, row, index) {
    var pUrl = "/role/stop?roleId=" + row.role_id;
    $.ajax({
        url : pUrl,
        type : "post",
        async : true,
        contentType: "application/json;charset=utf-8",
        success: function(result) {
            $('#table_1').bootstrapTable('refresh');
            alert(result.retMsg);
        },
        error :function(ee){
            alert("停用异常");
        }
    });
}

function delRole(e, value, row, index) {

    var pUrl = "/role/delete?roleId=" + row.role_id;
    $.ajax({
        url : pUrl,
        type : "post",
        async : true,
        contentType: "application/json;charset=utf-8",
        success: function(result) {
            $('#table_1').bootstrapTable('refresh');
            alert(result.retMsg);
        },
        error :function(ee){
            alert("删除异常");
        }
    });

}

function stopFormatter(value) {
    if (value == 0) {
        return "正常";
    } else {
        return "停用";
    }
}