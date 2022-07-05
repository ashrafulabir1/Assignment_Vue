%{--Include Main Layout--}%
<meta name="layout" content="auth"/>

<div id="global-wrapper">
    <div id="content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 mx-auto">
                    <h1 class="text-center login-title">Type your new Password</h1>
                    <g:if test='${flash.message}'>
                        <div class="alert alert-danger" role="alert">${flash.message}</div>
                    </g:if>
                    <div class="account-wall">
                        <g:img dir="images" file="moshkora.png" class="profile-img"/>
                        <g:form controller="userAuthentication" action="updatePassword" class="form-signin">
                            <g:textField name="email" class="form-control" placeholder="Email" required="required" value="${email}" readonly="readonly"/>
                            <g:passwordField name="password" class="form-control" placeholder="Password" required="required" />
                            <g:submitButton class="btn btn-lg btn-primary btn-block" name="submit" value="Submit"/>
                            <g:link controller="login" action="auth"
                                    class="btn btn-lg btn-primary btn-block">Login</g:link>
                        </g:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>