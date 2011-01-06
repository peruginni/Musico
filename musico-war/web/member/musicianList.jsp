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

<h:form title="#{title.musicianAdd}">
        <h:commandLink value="#{title.musicianAdd}" action="add" />

        <h2><h:outputText value="#{title.musicianList}" /></h2>

        <c:choose>
        <c:when test="${musicianBack.musicianListModel.rowCount > 0}" >
        <h:dataTable value="#{musicianBack.musicianListModel}" var="musician">
                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.firstName}" />
                        </f:facet>
                        <h:outputText value="#{musician.firstName}" />
                </h:column>

                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.secondName}" />
                        </f:facet>
                        <h:outputText value="#{musician.secondName}" />
                </h:column>
                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.artName}" />
                        </f:facet>
                        <h:outputText value="#{musician.artName}" />
                </h:column>

                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.biography}" />
                        </f:facet>
                        <h:outputText value="#{musician.biography}" />
                </h:column>

                <h:column>
                        <h:commandButton action="#{musicianBack.edit}" value="#{msg.edit}" />
                        <h:commandButton action="#{musicianBack.delete}" value="#{msg.delete}" />
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