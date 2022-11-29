package smarthomeapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value = "", layout = MainLayout.class)
@PageTitle("Menu")
@CssImport("./themes/style.css")
//public class UserView extends Div {
//public class UserView extends VerticalLayout {
public class UserView extends Div {
    public UserView() {

        //Button 1
        Button button1 = new Button("AN");
        


        //Feld 1 - Licht 1
        var box1 = new HorizontalLayout(createH1("Licht 1"),button1);
        box1.setClassName("BoxLay");
        box1.setAlignItems(FlexComponent.Alignment.BASELINE);
        box1.setMargin(true);

        button1.addClickListener(buttonClickEvent -> Notification.show("Geht wohl"));

        // Feld 2 - Licht 2
        var box2 = new HorizontalLayout(createH1("Licht 2"),createButton("AUS"));
        box2.setClassName("BoxLay");
        box2.setAlignItems(FlexComponent.Alignment.BASELINE);
        box2.setMargin(true);

        // Feld 3 - Heizung
        var box3 = new HorizontalLayout(createH1("Heizung1"),createButton("heizen"));
        box3.setClassName("BoxLay");
        box3.setAlignItems(FlexComponent.Alignment.BASELINE);
        box3.setMargin(true);


        // Feld 4 - Raumtemperatur Wohnzimmer
        var box4 = new HorizontalLayout(createH1("Heizung2"),createButton("heizen"));
        box4.setClassName("BoxLay");
        box4.setAlignItems(FlexComponent.Alignment.BASELINE);
        box4.setMargin(true);


        FormLayout formLayout = new FormLayout();
        formLayout.add(box1,box2,box3,box4);
        formLayout.setClassName("BoxLay");



        add(formLayout);

    }

   public H1 createH1(String text) {
        var uerberschrit_1 = new H1(text);
        return uerberschrit_1;
    }

    public Button createButton(String test)
    {
        var button = new Button (test);
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return button;
    }
}




