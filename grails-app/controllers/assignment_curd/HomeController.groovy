package assignment_curd

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class HomeController {

    def index() {
    }
}

