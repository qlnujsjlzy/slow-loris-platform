<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>bill列表</title>
    <meta name="decorator" content="list"/>
</head>
<body title="bill">
<grid:grid id="billGridId"
           url="${adminPath}/bill/bill/ajaxList">
    <grid:column label="sys.common.key" hidden="true" name="id" width="100"/>
    <grid:column label="sys.common.opt" name="opt" formatter="button" width="100"/>
    <grid:button groupname="opt" function="delete"/>
        <grid:column label="商铺编码"
                     name="shopId" />
        <grid:column label="商铺名称"
                     name="shopName" />
        <grid:column label="账单类型（1：自营 2：代理 3：全部）"
                     name="billType" />
        <grid:column label="订单总数"
                     name="orderNum" />
        <grid:column label="账单日期（2017-11-11）"
                     name="billDate" />
        <grid:column label="总收入"
                     name="totalIncome" />
        <grid:column label="创建人"
                     name="createBy" />
        <grid:column label="创建时间"
                     name="createTime" />
    <grid:toolbar function="create"/>
    <grid:toolbar function="update"/>
    <grid:toolbar function="delete"/>

    <grid:toolbar function="search"/>
    <grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>