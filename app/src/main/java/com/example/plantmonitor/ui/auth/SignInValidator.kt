package com.example.plantmonitor.ui.auth

import java.util.regex.Pattern

/**
 * An Email format validator for [android.widget.EditText].
 */
class SignInValidator {

    companion object {
        /**
         * Email validation pattern.
         */
        val EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        /**
         * Password Validation Pattern
         */
        val PASSWORD_PATTERN = Pattern.compile(
            "[a-zA-Z0-9*!@\$%^&(){}\\[\\]:;<>,.?/~_+\\-=|]"
        )

        /**
         * Validates if the given input is a valid email address.
         *
         * @param email        The email to validate.
         * @return `true` if the input is a valid email. `false` otherwise.
         */
        fun isValidEmail(email: CharSequence?): Boolean {
            return email != null && EMAIL_PATTERN.matcher(email).matches()
        }

        fun isValidPassword(password: CharSequence?): Boolean {
            
/*            var count : Int = 0;
            
            if ( password == null) {
                return false
            }
            else if(password.length in 8..32)
            {
                if( password.matches(".*\\d.*") )
                    count ++;
                if( password.matches(".*[a-z].*") )
                    count ++;
                if( password.matches(".*[A-Z].*") )
                    count ++;
                if( password.matches(".*[*.!@#$%^&(){}[]:;'<>,.?/~`_+-=|\\]\".*") )
                count ++;


            }
            if (count > 1) return true
            return false*/
            return password != null && password.length >= 6 && password.length <= 32
        }
    }
}


