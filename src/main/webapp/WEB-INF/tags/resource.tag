<%@tag pageEncoding="utf-8" isELIgnored="false" description="公用头部" body-content="empty"%>
<%@include file="/WEB-INF/jsp/taglib/taglibs.jsp" %>
<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/bootstrap/css/bootstrap-responsive.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/style.css"/>" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/js/jquery/jquery-1.8.0.min.js"/>"></script>

<link href="<c:url value="/resources/messager/messenger.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/messager/messenger-theme-future.css"/>" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/messager/messenger.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/messager/messagerUtil.js"/>"></script>

<link href="<c:url value="/resources/sco/scojs.css"/>" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/sco/sco.modal.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/sco/sco.confirm.js"/>"></script>
<script type="text/javascript" >
    window.contextPath = '<c:url value="/___"/>'.split('___')[0];
//var $j = $.noConflict();
</script>