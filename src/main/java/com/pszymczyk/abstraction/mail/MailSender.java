package com.pszymczyk.abstraction.mail;

/**
 * @author pawel szymczyk
 */
interface MailSender {

    void sendEmail(Content content, Author author);
}
