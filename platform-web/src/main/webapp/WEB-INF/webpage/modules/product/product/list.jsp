<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品列表</title>
    <meta name="decorator" content="list"/>
</head>
<body title="商品">
<grid:grid id="productGridId" url="${adminPath}/product/product/ajaxList">
    <grid:column label="sys.common.key" hidden="true" name="id" width="100"/>
    <grid:column label="sys.common.opt" name="opt" formatter="button" width="200"/>
    <grid:button title="上架" exp="row.status==0||row.status==2" tipMsg="你确定要上架该商品吗?" groupname="opt"
                 function="rowConfirm" outclass="btn-primary" innerclass="fa-hourglass-start"
                 url="${adminPath}/product/product/changeUpStatus?cmd=up"/>
    <grid:button title="下架" exp="row.status==1" tipMsg="你确定要下架该商品吗?" groupname="opt" function="rowConfirm"
                 outclass="btn-danger" innerclass="fa-square-o"
                 url="${adminPath}/product/product/changeUpStatus?cmd=down"/>
    <grid:button groupname="opt" function="delete"/>

    <grid:column label="商品编码" name="id" query="true" queryMode="input" condition="eq"/>
    <grid:column label="商品名称" name="productName" width="200"/>
    <grid:column label="物料编号" name="materialsCode" hidden="true" query="true" queryMode="input" condition="eq"/>
    <grid:column label="商户编码" name="faId" hidden="true" query="true" queryMode="input" condition="eq"/>
    <grid:column label="商户名称" name="faName"/>
    <grid:column label="市场价(元)" name="marketPrice.amount"/>
    <grid:column label="销售价(元)" name="price.amount"/>
    <grid:column label="库存数" name="stockNum"/>
    <grid:column label="销售量" name="salesNum"/>
    <grid:column label="创建时间" name="createDate" hidden="true"/>
    <grid:column label="上架状态" name="status" query="true" queryMode="select" condition="eq" dict="upstatus"/>
    <grid:column label="上架时间" name="upTime"/>
    <grid:column label="下架时间" name="downTime"/>
    <grid:toolbar function="create"/>
    <grid:toolbar function="update"/>
    <grid:toolbar function="delete"/>

    <grid:toolbar function="search"/>
    <grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>