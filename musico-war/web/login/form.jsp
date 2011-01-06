<%-- 
    Document   : form
    Created on : Jan 3, 2010, 12:11:27 PM
    Author     : Ondrej Macoszek <macosond@fel.cvut.cz>
--%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
        
<form name="musicoLoginRealm" action="j_security_check" method="POST" class="clf">
        <label>${msg.username} <input type="text" name="j_username" value="" /></label>
        <label>${msg.password} <input type="password" name="j_password" value="" /></label>
        <input type="submit" value="${msg.login}" style="clear:both"/>
</form>