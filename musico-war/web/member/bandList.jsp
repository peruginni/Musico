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

<h:form title="#{title.bandAdd}">
        <h:commandLink value="#{title.bandAdd}" action="add" />

        <h2><h:outputText value="#{title.bandList}" /></h2>

        <c:choose>
        <c:when test="${bandBack.bandListModel.rowCount > 0}" >
                <h:dataTable value="#{bandBack.bandListModel}" var="band">
                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.name}" />
                        </f:facet>
                        <h:outputText value="#{band.name}" />
                </h:column>
                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.website}" />
                        </f:facet>
                        <h:outputText value="#{band.website}" />
                </h:column>

                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.country}" />
                        </f:facet>
                        <h:outputText value="#{band.country}" />
                </h:column>

                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.dateFoundation}" />
                        </f:facet>
                        <h:outputText value="#{band.dateFoundation}">
                                <f:convertDateTime pattern="dd.MM.yyyy HH:mm" />
                        </h:outputText>
                </h:column>

                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.preferredGenre}" />
                        </f:facet>
                        <h:outputText value="#{band.preferredGenre.name}" />
                </h:column>


                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.musicians}" />
                        </f:facet>

                        <h:dataTable value="#{band.musicians}" var="mus">
                                <h:outputText value="#{mus}" converter="musicianConverter" />
                        </h:dataTable>
                        
                </h:column>

                <h:column>
                        <h:commandButton action="#{bandBack.edit}" value="#{msg.edit}" />
                        <h:commandButton action="#{bandBack.delete}" value="#{msg.delete}" />
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