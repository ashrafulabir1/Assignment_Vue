package com.bitmascot.security

class PasswordReset {

    String email
    String token

    def beforeInsert() {
        token
    }
}
