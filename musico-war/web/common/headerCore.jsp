<%--
    Document   : header
    Created on : Jan 2, 2010, 4:27:57 PM
    Author     : Ondrej Macoszek <macosond@fel.cvut.cz>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
        <% if( request.getParameter("title") == null || request.getParameter("title").isEmpty() ) { %>
        <title>Musico</title>
	<% } else { %>
        <title><%= request.getParameter("title") %> | Musico</title>
	<% } %>

	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<meta http-equiv="content-language" content="cs">

        <link rel="stylesheet" type="text/css" href="${initParam.baseUri}clientside/css/screen.css" media="screen">
	<link rel="stylesheet" type="text/css" href="${initParam.baseUri}clientside/css/print.css" media="print">

	<!--[if lt IE 8]>
		<link rel="stylesheet" href="${initParam.baseUri}clientside/css/hacks.ie.css" type="text/css" media="all" />
	<![endif]-->
</head>
<body>
<div id="page" class="theme">

	<div id="header">
		<h1><a href="${initParam.baseUri}">Musico<span></span></a></h1>
                <p>
                        <h:form>
                                <c:choose>
                                        <c:when test="${localeBack.czech}">
                                                <h:commandLink value="switch to english" actionListener="#{localeBack.switchToEnglish}" action="home" immediate="true" />
                                        </c:when>
                                        <c:otherwise>
                                                <h:commandLink value="přepnout do češtiny" actionListener="#{localeBack.switchToCzech}" action="home" immediate="true" />
                                        </c:otherwise>
                                </c:choose>
                        </h:form>
                </p>

                <p>
                        <h:form>
                                <c:choose>
                                        <c:when test="${userAccountBack.userAccountBean.currentUser != null}">
                                                <h:commandLink value="#{title.userAccountLogout}" actionListener="#{userAccountBack.logout}" />
                                        </c:when>
                                </c:choose>
                        </h:form>
                </p>
	</div>



