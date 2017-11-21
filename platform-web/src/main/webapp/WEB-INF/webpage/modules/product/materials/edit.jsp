<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <title>产品物料管理</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput"/>
    <html:css name="simditor"/>
</head>

<body class="white-bg" formid="materialsForm">
<form:form id="materialsForm" modelAttribute="data" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>
            <td class="width-15 active text-right">
                <label><font color="red">*</font>物料编号:</label>
            </td>
            <td class="width-35">
                <form:input path="materialsCode" htmlEscape="false" class="form-control" datatype="*"
                            nullmsg="请输入物料编号"/>
                <label class="Validform_checktip"></label>
            </td>
            <td class="width-15 active text-right">
                <label>真实物料:</label>
            </td>
            <td class="width-35">
                <form:input path="realMaterials" htmlEscape="false" class="form-control"/>
                <label class="Validform_checktip"></label>
            </td>
        </tr>
        <tr>
            <td class="width-15 active text-right">
                <label>备注信息:</label>
            </td>
            <td class="width-35">
                <form:input path="remarks" htmlEscape="false" class="form-control"/>
                <label class="Validform_checktip"></label>
            </td>

            <td class="width-15 active text-right"></td>
            <td class="width-35"></td>
        </tr>

        </tbody>
    </table>
</form:form>
<html:js name="bootstrap-fileinput"/>
<html:js name="simditor"/>
</body>
</html>