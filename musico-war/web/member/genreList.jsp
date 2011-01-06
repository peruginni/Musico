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
        <h:commandLink value="#{title.genreAdd}" action="add" />
        
        <h2><h:outputText value="#{title.genreList}" /></h2>

        <c:choose>
        <c:when test="${genreBack.genreListModel.rowCount > 0}" >
        <h:dataTable value="#{genreBack.genreListModel}" var="genre">
                <h:column>
                        <f:facet name="header">
                                <h:outputText value="#{msg.name}" />
                        </f:facet>
                        <h:outputText value="#{genre.name}" />
                </h:column>

                <h:column>
                        <h:commandButton action="#{genreBack.edit}" value="#{msg.edit}" />
                        <h:commandButton action="#{genreBack.delete}" value="#{msg.delete}" />
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