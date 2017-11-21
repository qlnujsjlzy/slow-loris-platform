<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <title>产品物料管理列表</title>
    <meta name="decorator" content="list"/>
</head>
<body title="产品物料管理">
<grid:grid id="materialsGridId" url="${adminPath}/product/materials/ajaxList">
    <grid:column label="sys.common.key" hidden="true" name="id" width="100"/>
    <grid:column label="sys.common.opt" name="opt" formatter="button" width="100"/>
    <grid:button groupname="opt" function="delete"/>
    <grid:column label="物料编号" name="materialsCode" query="true" queryMode="input" condition="eq"/>
    <grid:column label="真实物料" name="realMaterials" query="true" queryMode="input" condition="eq"/>
    <grid:column label="备注信息" name="remarks"/>
    <grid:toolbar function="create"/>
    <grid:toolbar function="update"/>
    <grid:toolbar function="delete"/>

    <grid:toolbar function="search"/>
    <grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>