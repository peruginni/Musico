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

<h:form>
        <h:inputHidden id="id" value="#{musicianBack.musician.musicianID}" />
        <h:panelGrid columns="2">
                <h:outputText value="#{msg.firstName}" />
                <h:inputText id="firstName" value="#{musicianBack.musician.firstName}" />
                <h:outputText value="#{msg.secondName}" />
                <h:inputText id="secondName" value="#{musicianBack.musician.secondName}" />
                <h:outputText value="#{msg.artName}" />
                <h:inputText id="artName" value="#{musicianBack.musician.artName}" />
                <h:outputText value="#{msg.biography}" />
                <h:inputText id="biography" value="#{musicianBack.musician.biography}" />

                <h:panelGroup />
                <h:panelGroup>
                        <h:commandButton value="#{title.musicianEdit}" action="#{musicianBack.saveChanges}" />
                        <h:commandButton value="#{msg.cancel}" action="list" immediate="true" />
                </h:panelGroup>
        </h:panelGrid>
        <h:messages styleClass="error" />
</h:form>


<jsp:include page="/common/footer.jsp" />
</f:view>