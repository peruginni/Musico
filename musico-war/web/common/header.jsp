<%-- 
    Document   : header
    Created on : Jan 2, 2010, 4:27:57 PM
    Author     : Ondrej Macoszek <macosond@fel.cvut.cz>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="headerCore.jsp" />

	<div id="navigation">
                <h4><h:outputText value="#{title.navigation}" /> <span></span></h4>
		<ul>
                        <li>
                                <h:outputLink value="#{initParam.baseUri}bandList.jsf"><h:outputText value="#{title.bandList}"/></h:outputLink>
                        </li>
                        <li>
                                <h:outputLink value="#{initParam.baseUri}eventList.jsf"><h:outputText value="#{title.eventList}"/></h:outputLink>
                        </li>
                        <li>
                                <h:outputLink value="#{initParam.baseUri}member/index.jsf"><h:outputText value="#{title.memberArea}"/></h:outputLink>
                        </li>
		</ul>
	</div>


        <div id="body" class="clf">
