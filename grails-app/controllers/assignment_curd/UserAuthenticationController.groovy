package assignment_curd

import grails.plugin.springsecurity.annotation.Secured
import grails.plugins.mail.MailService

@Secured("permitAll")
class UserAuthenticationController  {

    private String myCurrentAppUrl = "http://localhost:8080/"

    static allowedMethods = [submit: 'POST', reset: 'GET', updatePassword: 'POST']

    UserAuthenticationService userAuthenticationService
    MailService mailService

    def submit() {
        String generatedToken = userAuthenticationService.saveToken(params)
        if (generatedToken) {
            mailService.sendMail {
                to params.email
                from "grailsappdemo@gmail.com"
                subject "Password Reset Email"
                text "Please enter this url to reset password: " + myCurrentAppUrl + "password-reset?email=" + params.email + "&token=" + generatedToken
            }
        }
        redirect(controller: "register", action: "forgotPassword")
    }

    def reset() {
        def checkUrlStatus = userAuthenticationService.checkPasswordResetEmail(params.email, params.token)
        if (checkUrlStatus) {
            [email: params.email]
        } else {
            throw new Exception("Invalid URL")
        }
    }

    def updatePassword() {
        def updateStatus = userAuthenticationService.updateUserPassword(params)
        println(updateStatus)
        redirect(controller: "login", action: "auth")
    }

}