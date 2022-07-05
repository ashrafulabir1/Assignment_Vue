<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
    <g:layoutTitle default="Car Retailer"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>

<header>
    <nav class="navbar navbar-expand-lg navbar-success fixed-top bg-info rounded">
        <a class="navbar-brand" href="#">Student Database</a>
        <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <g:form controller="logout">
            <g:submitButton class="btn btn-danger" name="Submit" value="Logout" />
        </g:form>
    </nav>
</header>




<main role="main" >
    <g:layoutBody/>
</main>

<asset:javascript src="application.js"/>

</body>
</html>
