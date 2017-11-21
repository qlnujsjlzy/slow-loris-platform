<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput"/>
    <html:css name="simditor"/>
</head>

<body class="white-bg" formid="productForm">
<form:form id="productForm" modelAttribute="data" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
        <tbody>
        <tr>

            <td class="width-15 active text-right">
                <label><font color="red">*</font>商品名称:</label>
            </td>
            <td class="width-35" colspan="3">
                <form:input path="productName" htmlEscape="false" class="form-control" datatype="*"/>
                <label class="Validform_checktip"></label>
            </td>
        </tr>
        <tr>

            <td class="width-15 active text-right">
                <label><font color="red">*</font>产品编码:</label>
            </td>
            <td class="width-35">
                <form:select path="goodsCode" htmlEscape="false" class="form-control" items="${goods}"
                             itemLabel="goodsName" itemValue="id"/>
                <label class="Validform_checktip"></label>
            </td>
            <td class="width-15 active text-right">
                <label><font color="red">*</font>商户编码:</label>
            </td>
            <td class="width-35">
                <form:select path="faId" htmlEscape="false" class="form-control" datatype="*" items="${fa}"
                             itemLabel="faName" itemValue="id"/>
                <label class="Validform_checktip"></label>
            </td>
        </tr>

        <tr>
            <td class="width-15 active text-right">
                <label><font color="red">*</font>销售价(元):</label>
            </td>
            <td class="width-35">
                <form:input path="price" htmlEscape="false" class="form-control" datatype="*"/>
                <label class="Validform_checktip"></label>
            </td>
            <td class="width-15 active text-right">
                <label><font color="red">*</font>市场价(元):</label>
            </td>
            <td class="width-35">
                <form:input path="marketPrice" htmlEscape="false" class="form-control" datatype="*"/>
                <label class="Validform_checktip"></label>
            </td>

        </tr>
        <tr>
            <td class="width-15 active text-right">
                <label><font color="red">*</font>库存数:</label>
            </td>
            <td class="width-35">
                <form:input path="stockNum" htmlEscape="false" class="form-control" datatype="*"/>
                <label class="Validform_checktip"></label>
            </td>


            <td class="width-15 active text-right">
                <label>销售类型:</label>
            </td>
            <td class="width-35">
                <form:select path="salesType" htmlEscape="false" class="form-control" dict="salestype"/>
                <label class="Validform_checktip"></label>
            </td>
        <tr>
            <td class="width-15 active text-right">
                <label>备注信息:</label>
            </td>
            <td class="width-35" colspan="3">
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