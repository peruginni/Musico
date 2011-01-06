<%-- 
    Document   : index
    Created on : Jan 2, 2010, 5:37:03 PM
    Author     : Ondrej Macoszek <macosond@fel.cvut.cz>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view locale="#{localeBack.currentLocale}">
<jsp:include page="header.jsp" />

<h2><h:outputText value="#{title.memberArea}" /></h2>

<jsp:include page="/common/footer.jsp" />
</f:view>