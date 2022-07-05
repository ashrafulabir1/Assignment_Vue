<meta name="layout" content="auth"/>

<div id="global-wrapper">
    <div id="content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 mx-auto">
                    <h1 class="text-center login-title">User Login</h1>
                    <g:if test='${flash.message}'>
                        <div class="alert alert-danger" role="alert">${flash.message}</div>
                    </g:if>
                    <div class="account-wall">
                        <g:img dir="images" file="moshkora.png" class="profile-img"/>
                        <g:form controller="login" action="authenticate" class="form-signin">
                            <g:textField name="username" class="form-control" placeholder="Username" required="required" />
                            <g:passwordField name="password" class="form-control" placeholder="Password" required="required" />
                            <g:submitButton class="btn btn-lg btn-primary btn-block" name="login" value="Login"/>
                            <g:link controller="register" action="index" class="btn btn-lg btn-primary btn-block">User Registration</g:link>
                            <g:link controller="register" action="forgotPassword" class="btn btn-lg btn-primary btn-block">Forgot Password?</g:link>
                        </g:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>