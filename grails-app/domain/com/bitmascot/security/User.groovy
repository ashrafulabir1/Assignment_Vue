package com.bitmascot.security

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    String firstname
    String email
    Integer age
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    Boolean isActive = true

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        email(email: true, nullable: false, unique: true, blank: false)
        age nullable: false, blank: false, unique: false
        firstname nullable: false, blank: false, unique: false
    }

    static mapping = {
	    password column: '`password`'
    }
}
