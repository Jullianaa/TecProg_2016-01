package com.mathheals.euvou;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;
import com.mathheals.euvou.controller.home_page.HomePage;
import com.mathheals.euvou.controller.utility.LoginUtility;

import org.junit.Before;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by izabela on 03/11/15.
 */
public class UserRegistrationControlTest extends ActivityInstrumentationTestCase2<HomePage> {

    LoginUtility isLoged;

    public UserRegistrationControlTest() {
        super(HomePage.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
        isLoged = new LoginUtility(getActivity());
    }

    public void testRegisterOptionInActionBarMenu() {
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.saveButton)).check(matches(isDisplayed()));
        onView(withId(R.id.saveButton)).check(matches(withText("Cadastrar")));
    }
    
    public void testIfNameLabelIsCorrect() {
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.userNameLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.userNameLabel)).check(matches(withText("Nome")));
    }

    public void testNameField(){
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.nameField)).check(matches(isDisplayed()));
        onView(withId(R.id.nameField)).perform(typeText("Ju Almeida"));
        onView(withId(R.id.dateField)).perform(click());
        onView(withId(R.id.nameField)).check(matches(withText("Ju Almeida")));
    }

    public void testIfDateLabelIsCorrect() {
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.birthDateLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.birthDateLabel)).check(matches(withText("Data de Nascimento")));
    }

    public void testDateField(){
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.dateField)).check(matches(isDisplayed()));
        onView(withId(R.id.dateField)).perform(typeText("22/12/2000"));
        onView(withId(R.id.mailField)).perform(click());
        onView(withId(R.id.dateField)).check(matches(withText("22/12/2000")));
    }

    public void testIfMailLabelIsCorrect() {
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.userMailLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.userMailLabel)).check(matches(withText("E-mail")));
    }

    public void testMailField(){
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.mailField)).check(matches(isDisplayed()));
        onView(withId(R.id.mailField)).perform(typeText("oi-xau@voltei.com"));
        onView(withId(R.id.confirmMailField)).perform(click());
        onView(withId(R.id.mailField)).check(matches(withText("oi-xau@voltei.com")));
    }

    public void testIfMailConfirmationLabelIsCorrect() {
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.confirmUserMailLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.confirmUserMailLabel)).check(matches(withText("Confirme o e-mail")));
    }

    public void testMailConfirmationField(){
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.confirmMailField)).check(matches(isDisplayed()));
        onView(withId(R.id.confirmMailField)).perform(typeText("oi-xau@voltei.com"));
        onView(withId(R.id.loginField)).perform(click());
        onView(withId(R.id.confirmMailField)).check(matches(withText("oi-xau@voltei.com")));
    }

    public void testIfLoginLabelIsCorrect() {
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.userLoginLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.userLoginLabel)).check(matches(withText("Login")));
    }

    public void testLoginField(){
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.loginField)).check(matches(isDisplayed()));
        onView(withId(R.id.loginField)).perform(typeText("oioioi123"));
        onView(withId(R.id.passwordField)).perform(click());
        onView(withId(R.id.loginField)).check(matches(withText("oioioi123")));
    }

    public void testIfPasswordLabelIsCorrect() {
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.userPasswordLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.userPasswordLabel)).check(matches(withText("Senha")));
    }

    public void testPasswordField(){
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.passwordField)).check(matches(isDisplayed()));
        onView(withId(R.id.passwordField)).perform(typeText("1234567"));
        onView(withId(R.id.confirmPasswordField)).perform(click());
        onView(withId(R.id.passwordField)).check(matches(withText("1234567")));
    }

    public void testIfConfirmPasswordLabelIsCorrect() {
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.userConfirmPasswordLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.userConfirmPasswordLabel)).check(matches(withText("Confirme a senha")));
    }

    public void testConfirmPasswordField(){
        if(isLoged.hasUserLoggedIn()){
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
            onView(withText("Sair")).perform(click());
        }
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Cadastrar")).perform(click());
        onView(withId(R.id.confirmPasswordField)).check(matches(isDisplayed()));
        onView(withId(R.id.confirmPasswordField)).perform(typeText("1234567"));
        onView(withId(R.id.passwordField)).perform(click());
        onView(withId(R.id.confirmPasswordField)).check(matches(withText("1234567")));
    }

}
