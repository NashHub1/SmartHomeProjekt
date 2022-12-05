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

    Binder<Contact> binder = new BeanValidationBinder<>(Contact.class);
    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");
    EmailField email = new EmailField("Email");
    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");
    private Contact contact;

    public ContactInputForm(){
        addClassName("contact-form");
        binder.bindInstanceFields(this);

        add(firstName,lastName,email,createButtonsLayout());

    }


    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, contact)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));



        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);



        return new HorizontalLayout(save, delete, close);
        }

    private void validateAndSave() {
        try {
            binder.writeBean(contact);
            fireEvent(new SaveEvent(this, contact));

        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public void setContact(Contact contact) {
        this.contact = contact;
        binder.readBean(contact);
    }
    // Events für alle Button  -Save - Delete - Close
    public static abstract class ContactFormEvent extends ComponentEvent<ContactInputForm> {
        private Contact contact;// Speichern der Contacte - hier

        protected ContactFormEvent(ContactInputForm source, Contact contact) {
            super(source, false);
            this.contact = contact;
        }

        public Contact getContact() {
            return contact;
        }
    }

    public static class SaveEvent extends ContactFormEvent {
        SaveEvent(ContactInputForm source, Contact contact) {
            super(source, contact);
        }
    }

    public static class DeleteEvent extends ContactFormEvent {
        DeleteEvent(ContactInputForm source, Contact contact) {
            super(source, contact);
        }

    }

    public static class CloseEvent extends ContactFormEvent {
        CloseEvent(ContactInputForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
