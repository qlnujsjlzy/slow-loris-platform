<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <title>商户信息列表</title>
    <meta name="decorator" content="list"/>
</head>
<body title="商户信息">
<grid:grid id="faGridId" url="${adminPath}/business/fa/ajaxList">
    <grid:column label="sys.common.key" hidden="true" name="id" width="100"/>
    <grid:column label="sys.common.opt" name="opt" formatter="button" width="100"/>
    <grid:button groupname="opt" function="delete"/>
    <grid:column label="商户名称" name="faName" query="true" queryMode="input" condition="prefixLike"/>
    <grid:column label="社区编码" name="communityCode" query="true" queryMode="input" condition="eq"/>
    <grid:toolbar function="create"/>
    <grid:toolbar function="update"/>
    <grid:toolbar function="delete"/>

    <grid:toolbar function="search"/>
    <grid:toolbar function="reset"/>
</grid:grid>
</body>
<script>
    function test() {
        return "123";
    }
</script>
</html>