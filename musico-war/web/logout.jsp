<%--
    Document   : logout
    Created on : Jan 2, 2010, 5:37:03 PM
    Author     : Ondrej Macoszek <macosond@fel.cvut.cz>
--%>
<% 
session.invalidate();
response.sendRedirect("index.jsf");
%>