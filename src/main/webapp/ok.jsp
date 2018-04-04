<%@page contentType="text/html;charset=UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%
    out.print("It works");
%>
<script type="text/javascript">
    if(confirm("确定吗？")){
        alert(123);
    }else{
        alert(321);
    }
</script>