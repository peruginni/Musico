<%-- 
    Document   : footer
    Created on : Jan 2, 2010, 4:47:51 PM
    Author     : Ondrej Macoszek <macosond@fel.cvut.cz>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
        </div>
	<div id="footer" class="clf">
		<div class="credits">
                        &copy; 2009 Ondřej Macoszek |
                        <a href="${initParam.baseUri}" class="home"><h:outputText value="#{title.homepage}" /></a> |
			<a href="#header" class="up"><h:outputText value="#{msg.upLink}" /></a>
		</div>
		<div class="backend">
                        <h:outputText value="#{msg.backend}" />
		</div>
	</div>
</div>
</body>
</html>