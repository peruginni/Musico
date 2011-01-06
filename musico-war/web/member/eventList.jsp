<%-- 
    Document   : index
    Created on : Jan 2, 2010, 5:37:03 PM
    Author     : Ondrej Macoszek <macosond@fel.cvut.cz>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<f:view locale="#{localeBack.currentLocale}">
<jsp:include page="header.jsp" />

<h:form>
        <h:commandLink value="#{title.eventAdd}" action="add" />
        <h2><h:outputText value="#{title.eventList}" /></h2>
        
        <c:choose>
        <c:when test="${eventBack.eventListModel.rowCount > 0}" >
        <h:dataTable value="#{eventBack.eventListModel}" var="event">
                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.name}" />
                        </f:facet>
                        <h:outputText value="#{event.name}" />
                </h:column>
                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.dateStart}" />
                        </f:facet>
                        <h:outputText value="#{event.dateStart}">
                                <f:convertDateTime pattern="dd.MM.yyyy HH:mm" />
                        </h:outputText>
                </h:column>
                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.dateEnd}" />
                        </f:facet>
                        <h:outputText value="#{event.dateEnd}">
                                <f:convertDateTime pattern="dd.MM.yyyy HH:mm" />
                        </h:outputText>
                </h:column>
                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.place}" />
                        </f:facet>
                        <h:outputText value="#{event.place}" />
                </h:column>

                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.band}" />
                        </f:facet>
                        <h:outputText value="#{event.band.name}" />
                </h:column>

                <h:column>
                        <h:commandButton action="#{eventBack.edit}" value="#{msg.edit}" />
                        <h:commandButton action="#{eventBack.delete}" value="#{msg.delete}" />
                </h:column>
        </h:dataTable>
        </c:when>
        <c:otherwise>
                <p><h:outputText value="#{msg.noResults}" /></p>
        </c:otherwise>
        </c:choose>

</h:form>

<jsp:include page="/common/footer.jsp" />
</f:view>