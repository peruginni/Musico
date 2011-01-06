<%-- 
    Document   : login
    Created on : Jan 3, 2010, 12:11:17 PM
    Author     : Ondrej Macoszek <macosond@fel.cvut.cz>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view locale="#{localeBack.currentLocale}">
<jsp:include page="/common/header.jsp" />

<h2><h:outputText value="#{title.userAccountLogin}" /></h2>
<jsp:include page="form.jsp" />

<jsp:include page="/common/footer.jsp" />
</f:view>