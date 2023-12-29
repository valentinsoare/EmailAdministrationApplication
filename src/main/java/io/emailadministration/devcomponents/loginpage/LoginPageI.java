package io.emailadministration.devcomponents.loginpage;

import io.emailadministration.devcomponents.header.Header;

public interface LoginPageI {
    LoginPageI generateLoginOrSignUpPage();
    Header extractHeader();
}
