package assignment_curd

import com.bitmascot.security.Role

import com.bitmascot.security.User
import com.bitmascot.security.UserRole
import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class UserService {

    def save(GrailsParameterMap params) {
        User user = new User(params)
        def response = AppUtil.saveResponse(false, user)
        if(user.validate()){
            user.save(flush: true)
            def role = Role.findByAuthority('ROLE_USER')
            if(role) {
                UserRole.create(user, role)

                UserRole.withSession {
                    it.flush()
                    it.clear()
                }

                response.isSuccess = true
            } else {
                response.isSuccess = false
            }
            if(!user.hasErrors()) {
                response.isSuccess =true
            }
        }
        return response
    }

    def update(User user, GrailsParameterMap params){
        user.properties = params
        def response = AppUtil.saveResponse(false, user)
        if(user.validate()) {
            user.save(flush:true)
            if(!user.hasErrors()){
                response.isSuccess = true
            }
        }
        return  response
    }

    def getById(Serializable id) {
        return User.get(id)
    }

    def list(GrailsParameterMap params){
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<User> userList = User.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        return [list: userList, count: userList.size()]

    }

    def delete(User user){
        try {
            user.delete(flush: true)
        } catch(Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }

    def createUserRole(User user, Role adminRole){
        if( !user.authorities.contains(adminRole)) {
            UserRole.create(user, adminRole, true)
        }
    }
}
