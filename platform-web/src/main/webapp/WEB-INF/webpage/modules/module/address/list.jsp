<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>address列表</title>
    <meta name="decorator" content="list"/>
</head>
<body title="address">
<grid:grid id="addressGridId"
           url="${adminPath}/module/address/ajaxList">
    <grid:column label="sys.common.key" hidden="true" name="id" width="100"/>
    <grid:column label="sys.common.opt" name="opt" formatter="button" width="100"/>
    <grid:button groupname="opt" function="delete"/>
        <grid:column label="收货人"
                     name="name" 
                     query="true" 
                     queryMode="input" 
                     condition="eq" />
        <grid:column label="手机号"
                     name="phone" 
                     query="true" 
                     queryMode="input" 
                     condition="eq" />
        <grid:column label="省"
                     name="province" />
        <grid:column label="市"
                     name="city" />
        <grid:column label="区"
                     name="region" />
        <grid:column label="社区编码"
                     name="communityId" />
        <grid:column label="社区名称"
                     name="communityName" />
        <grid:column label="街道门牌号"
                     name="street" />
        <grid:column label="默认地址"
                     name="isDefault" />
    <grid:toolbar function="create"/>
    <grid:toolbar function="update"/>
    <grid:toolbar function="delete"/>

    <grid:toolbar function="search"/>
    <grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>