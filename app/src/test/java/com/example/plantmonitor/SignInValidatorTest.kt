package com.example.plantmonitor

import com.example.plantmonitor.ui.auth.SignInValidator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SignInValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(SignInValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(SignInValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(SignInValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(SignInValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(SignInValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(SignInValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(SignInValidator.isValidEmail(null))
    }

    @Test
    fun passwordValidator_Length6_ReturnsTrue() {
        assertTrue(SignInValidator.isValidPassword("123456"))
    }

    @Test
    fun passwordValidator_Length32_ReturnsTrue() {
        assertTrue(SignInValidator.isValidPassword("123456abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun passwordValidator_Length33_ReturnsFalse() {
        assertFalse(SignInValidator.isValidPassword("1234567abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun passwordValidator_Length5_ReturnsFalse() {
        assertFalse(SignInValidator.isValidPassword("12345"))
    }
}