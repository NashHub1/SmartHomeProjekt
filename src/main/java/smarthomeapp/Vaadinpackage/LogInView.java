package smarthomeapp.Vaadinpackage;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterListener;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("Login | Smart Home")
public class LogInView extends Div implements BeforeEnterListener {

    LoginOverlay login = new LoginOverlay();

    public LogInView() {

        login.setTitle("SMART HOME \uD83C\uDFE0");
        login.setDescription("Built with \uD83D\uDC9C by  Bü and Michi");

        login.setAction("login");
        add(login);
        login.setOpened(true);
    }
    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // inform the user about an authentication error
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
}