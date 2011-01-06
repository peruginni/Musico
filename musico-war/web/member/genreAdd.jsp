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

<h2><h:outputText value="#{title.genreAdd}" /></h2>

<h:form title="#{title.genreAdd}">
        <h:panelGrid columns="2">
                <h:outputText value="#{msg.name}" />
                <h:panelGroup>
                        <h:inputText id="name" value="#{genreBack.genre.name}" required="true" requiredMessage="#{error.fillName}" />
                </h:panelGroup>
                <h:panelGroup />
                <h:panelGroup>
                        <h:commandButton value="#{title.genreAdd}" action="#{genreBack.add}" />
                        <h:commandButton value="#{msg.cancel}" action="list" immediate="true" />
                </h:panelGroup>
        </h:panelGrid>
        <h:messages styleClass="error" />
</h:form>

<jsp:include page="/common/footer.jsp" />
</f:view>