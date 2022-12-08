package smarthomeapp.Vaadinpackage;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;


@Route(value = "Haussteuerung", layout = MainLayout.class)
@PageTitle("Menu")
@CssImport("./themes/style.css")
@PermitAll
//public class HomeSystemView extends Div {
//public class HomeSystemView extends VerticalLayout {
public class HomeSystemView extends Div{


    public HomeSystemView() {

        // API für Lichtstatus
        API message = new API();


        //Box 1 Komponenten
        var ueberschrift1 = new H1("Licht 1");
        ueberschrift1.setClassName("ueberschrift_licht1");
        Button Schalter1An = new Button("An");
        Button Schalter1Aus = new Button("Aus");
        Schalter1An.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_SUCCESS);
        Schalter1Aus.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_ERROR);

        //Box 2 Komponenten
        var ueberschrift2 = new H1("Licht 2");
        ueberschrift2.setClassName("ueberschrift_licht1");
        Button Schalter2An = new Button("An");
        Button Schalter2Aus = new Button("Aus");
        Schalter2An.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_SUCCESS);
        Schalter2Aus.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_ERROR);


        //Box 1 Layout
        var schalterBox1 = new HorizontalLayout(Schalter1An,Schalter1Aus);
        var box1 = new VerticalLayout(ueberschrift1,schalterBox1);
        box1.setClassName("BoxLay");
        box1.setMargin(true);
        box1.setAlignItems(FlexComponent.Alignment.CENTER); //Alles in der mitte
        //Actions-Events der Schalter
        Schalter1An.addClickListener(buttonClickEvent -> message.api1(true)); //Licht-Wert wird an die API geschickt
        Schalter1An.addClickListener(buttonClickEvent -> Notification.show("Antrag bestätigt - Licht 1 anschalten"));
        Schalter1Aus.addClickListener(buttonClickEvent -> message.api1(false));
        Schalter1Aus.addClickListener(buttonClickEvent -> Notification.show("Antrag bestätigt - Licht 1 ausschalten"));



        //Box 2 Layout
        var schalterBox2 = new HorizontalLayout(Schalter2An,Schalter2Aus);
        var box2 = new VerticalLayout(ueberschrift2,schalterBox2);
        box2.setClassName("BoxLay");
        box2.setMargin(true);
        box2.setAlignItems(FlexComponent.Alignment.CENTER);
        //Actions-Events der Schalter
        Schalter2An.addClickListener(buttonClickEvent -> message.api2(true)); //Licht-Wert wird an die API geschickt
        Schalter2An.addClickListener(buttonClickEvent -> Notification.show("Antrag bestätigt - Licht 2 anschalten"));
        Schalter2Aus.addClickListener(buttonClickEvent -> message.api2(false));
        Schalter2Aus.addClickListener(buttonClickEvent -> Notification.show("Antrag bestätigt - Licht 2 ausschalten"));


        FormLayout formLayout = new FormLayout();
        formLayout.add(box1,box2);
        formLayout.setClassName("außenBox");



        add(formLayout);

    }
}




