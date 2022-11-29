package smarthomeapp;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;

@Route("login")
public class LogInView extends Div {
    public LogInView() {
        LoginOverlay logInFeld = new LoginOverlay();
        logInFeld.setTitle("SMART HOME \uD83C\uDFE0");
        logInFeld.setDescription("Built with \uD83D\uDC9C by  Bü and Michi");
        add(logInFeld);
        logInFeld.setOpened(true);
    }
}