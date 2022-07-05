<!--DOCTYPE html-->


<meta name="layout" content="auth">
<title>Change Password</title>
<div class="shell">
    <section>
        <article class="common-view no-background center-form">
            <h1 align="center">Change Password</h1>
            <g:form controller="changePassword" action="changePassword" parsley-validate="true" class="reset-pwd-form custom-form">
                <g:textField name="username" id="username" placeholder="Enter your username"></g:textField>
                <g:passwordField name="password" id="password" placeholder="Enter your password"></g:passwordField>
                <g:passwordField name="password2" id="password2" placeholder="Enter your password again"></g:passwordField>
                <button type="submit" id="forgot-pwd-btn">Submit</button>
                <g:link controller="dashBoard" action="reports" class="cancel-btn">Cancel</g:link>
            </g:form>
        </article>
    </section>
</div>
<script type="text/javascript">
    jQuery('#reset-btn').live('click',function(){
        var isValid = $('.reset-pwd-form').parsley('validate');
        if(isValid){
            jQuery('#reset-pwd-btn').click();
        }
    });
    jQuery("input").bind("keydown", function(event) {
        var keycode = (event.keyCode ? event.keyCode : (event.which ? event.which : event.charCode));
        if (keycode == 13) {
            jQuery('#reset-pwd-btn').click();
            return false;
        } else  {
            return true;
        }
    });
</script>