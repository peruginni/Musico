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

<h2><h:outputText value="#{title.bandEdit}" /></h2>

<h:form>
        <h:inputHidden id="id" value="#{bandBack.band.bandID}" />
        <h:panelGrid columns="2">

                <h:outputText value="#{msg.name}" />
                <h:panelGroup>
                        <h:inputText id="name" value="#{bandBack.band.name}" required="true" requiredMessage="#{error.fillName}" />
                </h:panelGroup>
                <h:outputText value="#{msg.website}" />
                <h:inputText value="#{bandBack.band.website}" />

                <h:outputText value="#{msg.country}" />
                <h:inputText value="#{bandBack.band.country}" />

                <h:panelGroup>
                        <h:outputText value="#{msg.dateFoundation}" />
                        <p class="hint"><h:outputText value="#{msg.dateExample}"/></p>
                </h:panelGroup>
                <h:inputText id="dateFoundation" value="#{bandBack.band.dateFoundation}">
                        <f:convertDateTime pattern="dd.MM.yyyy" />
                </h:inputText>

                <h:outputText value="#{msg.preferredGenre}" />
                <h:selectOneMenu id="preferredGenre" value="#{bandBack.band.preferredGenre}" converter="genreConverter">
                        <f:selectItems value="#{genreBack.genreListSelectItemModel}" />
                </h:selectOneMenu>

                <h:outputText value="#{msg.musicians}" />
                <h:selectManyMenu id="musicians" value="#{bandBack.band.musicians}" converter="musicianConverter" styleClass="dropdown">
                        <f:selectItems value="#{musicianBack.musicianListSelectItemModel}" />
                </h:selectManyMenu>

                <h:panelGroup />
                <h:panelGroup>
                        <h:commandButton value="#{title.bandEdit}" action="#{bandBack.saveChanges}" />
                        <h:commandButton value="#{msg.cancel}" action="list" immediate="true" />
                </h:panelGroup>
        </h:panelGrid>
        <h:messages styleClass="error" />
</h:form>

<jsp:include page="/common/footer.jsp" />
</f:view>