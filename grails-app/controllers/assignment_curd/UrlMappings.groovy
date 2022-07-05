package assignment_curd

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'home', action: 'index')
        "/password-reset"(controller: "userAuthentication", action: "reset")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
