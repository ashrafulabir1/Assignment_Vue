package assignment_curd

import com.bitmascot.security.PasswordReset
import com.bitmascot.security.User
import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

import java.text.SimpleDateFormat

@Transactional
class UserAuthenticationService {

    UserService userService

    private String getToken() {
        Date date = new Date()
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs")
        String datetime = ft.format(date)
        return 'token'.md5() + datetime
    }

    def saveToken(GrailsParameterMap params) {
        User user = User.findByEmail(params.email)
        if (user) {
            String token = getToken()
            PasswordReset passwordReset = new PasswordReset(params)
            passwordReset.token = token
            passwordReset.save()
            return token
        } else {
            throw new Exception("User not found")
        }
    }

    def checkPasswordResetEmail(email, token) {
        PasswordReset passwordReset = PasswordReset.findByEmailAndToken(email, token)
        if (passwordReset) {
            return true
        } else {
            return false
        }
    }

    def updateUserPassword(GrailsParameterMap params) {
        User user = User.findByEmail(params.email)
        if (user) {
            PasswordReset.findByEmail(params.email).delete()
            def updateStatus = userService.update(user, params)
            return updateStatus
        }
        return false
    }
}
