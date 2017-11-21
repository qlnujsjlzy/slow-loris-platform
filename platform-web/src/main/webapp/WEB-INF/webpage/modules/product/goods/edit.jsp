<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <title>产品管理</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput"/>
    <html:css name="simditor"/>
    <html:css name="summernote,syntaxhighlighter"/>
</head>

<body class="white-bg" formid="goodsForm">
<form:form id="goodsForm" modelAttribute="data" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>

            <td class="width-15 active text-right">
                <label>产品名称:</label>
            </td>
            <td class="width-35">
                <form:input path="goodsName" htmlEscape="false" class="form-control" datatype="*"/>
                <label class="Validform_checktip"></label>
            </td>
            <td class="width-15 active text-right">
                <label>产品单位:</label>
            </td>
            <td class="width-35">
                <form:input path="goodsUnit" htmlEscape="false" class="form-control" datatype="*"/>
                <label class="Validform_checktip"></label>
            </td>
        </tr>
        <tr>
            <td class="width-15 active text-right">
                <label>产品类型:</label>
            </td>
            <td class="width-35">
                <form:select path="goodsType" htmlEscape="false" class="form-control" dict="goodstype"/>
                <label class="Validform_checktip"></label>
            </td>
            <td class="width-15 active text-right">
                <label>参考价（元）:</label>
            </td>
            <td class="width-35">
                <form:input path="referPrice" htmlEscape="false" class="form-control" datatype="*"/>
                <label class="Validform_checktip"></label>
            </td>
        </tr>
        <tr>
            <td class="width-15 active text-right">
                <label>物料编码:</label>
            </td>
            <td class="width-35">
                <form:select path="materialsCode" htmlEscape="false" class="form-control" items="${materials}"
                             itemLabel="materialsCode" itemValue="materialsCode"/>
                <label class="Validform_checktip"></label>
            </td>
            <td class="width-15 active text-right">
                <label>备注信息:</label>
            </td>
            <td class="width-35">
                <form:input path="remarks" htmlEscape="false" class="form-control"/>
                <label class="Validform_checktip"></label>
            </td>
        </tr>


        <tr>
            <td class="width-15 active text-right">
                <label>橱窗图（,分隔）:</label>
            </td>
            <td class="width-35" colspan="3">
                <form:input path="goodsImgs" htmlEscape="false" class="form-control" datatype="*"/>
                <label class="Validform_checktip"></label>
            </td>
        </tr>

        <tr>
            <td class="width-15 active text-right">
                <label>产品介绍:</label>
            </td>
            <td class="width-35" colspan="3">
                <form:editor editorType="summernote"
                             editorAfterSetting="editorAfterSetting" path="goodsDesc"
                             defaultValue="${data.goodsDesc}" nested="false"/>
                <label class="Validform_checktip"></label>
            </td>
        </tr>

        </tbody>
    </table>

</form:form>
<div id="goods-desc" class="center-block">

</div>
<html:js name="bootstrap-fileinput"/>
<html:js name="simditor"/>
<!-- 全局js -->
<html:js name="summernote"/>
<!-- 自定义js -->
<script src="${staticPath}/common/js/content.js?v=1.0.0"></script>
<script>
    $(function () {
        $("#goods-desc").append($('${data.goodsDesc}'));
    })
</script>
</body>
</html>