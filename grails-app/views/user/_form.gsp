<h1 class="text-center login-title">User Registration</h1>
<g:img dir="images" file="moshkora.png" class="profile-img"/>
<div class="form-group">
    <label>Username *</label>
    <g:textField name="username" class="form-control" value="${user?.username}" placeholder="Please Enter Username"/>
</div>

<div class="form-group">
    <label>Name</label>
    <g:textField name="firstname" class="form-control" value="${user?.firstname}" placeholder="Please Enter your Name"/>
</div>

<div class="form-group">
    <label>Age</label>
    <g:textField name="age" class="form-control" value="${user?.age}" placeholder="Please Enter your Age"/>
</div>

<div class="form-group">
    <label>Email *</label>
    <g:field type="email" name="email" class="form-control" value="${user?.email}" placeholder="Please Enter Email"/>
</div>

<g:if test="${!edit}">
    <div class="form-group">
        <label>Password *</label>
        <g:passwordField name="password" class="form-control" value="${user?.password}" placeholder="Please Enter Password"/>
    </div>
</g:if>