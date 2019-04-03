window.projectName = getProjectName();
//查询项目项目  /Police-admin
function getProjectName() {
    // 获取URI，即主机名+端口之后的字符串,
    // 如 http://127.0.0.1:8080/uimcardprj/share/menu.jsp，获取的是 /uimcardprj/share/menu.jsp
    var pathName = window.document.location.pathname;
    return pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
}
//form表单数据转为json数据
function getFormDataToJson($form) {
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function (n, i) {
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}