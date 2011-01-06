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

<h2><h:outputText value="#{title.eventAdd}" /></h2>

<h:form>
        <h:panelGrid columns="2">
                <h:outputText value="#{msg.title}" />
                <h:panelGroup>
                        <h:inputText id="name" value="#{eventBack.event.name}" required="true" requiredMessage="#{error.fillName}" />
                </h:panelGroup>

                <h:panelGroup>
                        <h:outputText value="#{msg.dateStart}" />
                        <p class="hint"><h:outputText value="#{msg.dateTimeExample}"/></p>
                </h:panelGroup>
                <h:inputText id="dateStart" value="#{eventBack.event.dateStart}" required="true" requiredMessage="#{error.fillDateStart}">
                        <f:convertDateTime pattern="dd.MM.yyyy HH:mm" />
                </h:inputText>

                <h:panelGroup>
                        <h:outputText value="#{msg.dateEnd}" />
                        <p class="hint"><h:outputText value="#{msg.dateTimeExample}"/></p>
                </h:panelGroup>
                <h:inputText id="dateEnd" value="#{eventBack.event.dateEnd}" required="true" requiredMessage="#{error.fillDateEnd}">
                        <f:convertDateTime pattern="dd.MM.yyyy HH:mm" />
                </h:inputText>

                <h:outputText value="#{msg.place}" />
                <h:panelGroup>
                        <h:inputText id="place" value="#{eventBack.event.place}" />
                </h:panelGroup>

                <h:outputText value="#{msg.band}" />
                <h:selectOneMenu id="band" value="#{eventBack.event.band}" converter="bandConverter">
                        <f:selectItems value="#{bandBack.bandListSelectItemModel}" />
                </h:selectOneMenu>

                <h:panelGroup />
                <h:panelGroup>
                        <h:commandButton value="#{title.eventAdd}" action="#{eventBack.add}" />
                        <h:commandButton value="#{msg.cancel}" action="list" immediate="true" />
                </h:panelGroup>
        </h:panelGrid>
        <h:messages styleClass="error" />
</h:form>

<jsp:include page="/common/footer.jsp" />
</f:view>