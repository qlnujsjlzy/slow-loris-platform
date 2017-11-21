<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <title>社区信息</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput"/>
    <html:css name="simditor"/>
</head>

<body class="white-bg" formid="communityForm">
<form:form id="communityForm" modelAttribute="data" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>
            <td class="width-15 active text-right">
                <label><font color="red">*</font>社区编码:</label>
            </td>
            <td class="width-35">
                <form:input path="communityCode" htmlEscape="false" class="form-control" datatype="*"
                            nullmsg="请输入社区编码"/>
                <label class="Validform_checktip"></label>
            </td>
            <td class="width-15 active text-right">
                <label><font color="red">*</font>社区名称:</label>
            </td>
            <td class="width-35">
                <form:input path="communityName" htmlEscape="false" class="form-control" datatype="*"
                            nullmsg="请输入社区名称"/>
                <label class="Validform_checktip"></label>
            </td>

        </tr>
        <tr>
            <td class="width-15 active text-right">
                <label><font color="red">*</font>社区地址:</label>
            </td>
            <td class="width-35">
                <form:input path="communityAddress" htmlEscape="false" class="form-control" datatype="*"
                            nullmsg="请输入社区地址"/>
                <label class="Validform_checktip"></label>
            </td>
            <td class="width-15 active text-right">
                <label><font color="red">*</font>社区坐标:</label>
            </td>
            <td class="width-35">
                <form:input path="communityCoordinate" htmlEscape="false" class="form-control" datatype="*"
                            nullmsg="请输入社区坐标"/>
                <label class="Validform_checktip"></label>
            </td>
        </tr>
        <tr>

            <td class="width-15 active text-right">
                <label><font color="red">*</font>配送范围（米）:</label>
            </td>
            <td class="width-35">
                <form:input path="sendRange" htmlEscape="false" class="form-control" datatype="n" nullmsg="请输入配送范围"/>
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

        </tbody>
    </table>
</form:form>
<html:js name="bootstrap-fileinput"/>
<html:js name="simditor"/>
</body>
</html>