package smarthomeapp.Vaadinpackage;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import smarthomeapp.backend.entity.Contact;

public class ContactInputForm extends FormLayout {


    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");
    EmailField email = new EmailField("Email");
    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    public ContactInputForm(){
        addClassName("contact-form");

        add(firstName,lastName,email,createButtonsLayout());

    }
        private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);



        return new HorizontalLayout(save, delete, close);
        }


}
