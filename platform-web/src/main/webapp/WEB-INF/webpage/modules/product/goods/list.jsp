<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <title>产品---商品的模板列表</title>
    <meta name="decorator" content="list"/>
</head>
<body title="产品---商品的模板">
<grid:grid id="goodsGridId" url="${adminPath}/product/goods/ajaxList">
    <grid:column label="sys.common.key" hidden="true" name="id" width="100"/>
    <grid:column label="sys.common.opt" name="opt" formatter="button" width="100"/>
    <grid:button groupname="opt" function="delete"/>
    <grid:column label="产品名称" name="goodsName" query="true" queryMode="input" condition="prefixLike"/>
    <grid:column label="物料编码" name="materialsCode" query="true" queryMode="input" condition="eq"/>
    <grid:column label="产品类型" name="goodsType" query="true" queryMode="select" condition="eq" dict="goodstype"/>
    <grid:column label="产品单位" name="goodsUnit"/>
    <grid:column label="参考价（元）" name="referPrice.amount"/>
    <grid:column label="创建时间" name="createDate"/>
    <grid:toolbar function="create"/>
    <grid:toolbar function="update"/>
    <grid:toolbar function="delete"/>

    <grid:toolbar function="search"/>
    <grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>