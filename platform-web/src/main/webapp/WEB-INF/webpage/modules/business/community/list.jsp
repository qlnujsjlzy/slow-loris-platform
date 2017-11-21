<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <title>社区信息列表</title>
    <meta name="decorator" content="list"/>
</head>
<body title="社区信息">
<grid:grid id="communityGridId" url="${adminPath}/business/community/ajaxList">
    <grid:column label="sys.common.key" hidden="true" name="id" width="100"/>
    <grid:column label="sys.common.opt" name="opt" formatter="button" width="100"/>
    <grid:button groupname="opt" function="delete"/>
    <grid:column label="社区编码" name="communityCode" query="true" queryMode="input" condition="eq"/>
    <grid:column label="社区名称" name="communityName" query="true" queryMode="input" condition="eq"/>
    <grid:column label="社区地址" name="communityAddress"/>
    <grid:column label="社区坐标" name="communityCoordinate"/>
    <grid:column label="配送范围（米）" name="sendRange"/>
    <grid:toolbar function="create"/>
    <grid:toolbar function="update"/>
    <grid:toolbar function="delete"/>

    <grid:toolbar function="search"/>
    <grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>