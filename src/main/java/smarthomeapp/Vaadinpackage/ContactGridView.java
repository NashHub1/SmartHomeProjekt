package smarthomeapp.Vaadinpackage;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import smarthomeapp.backend.entity.Contact;
import smarthomeapp.backend.entity.CrmService;

import javax.annotation.security.PermitAll;


//@Route(value="", layout = MainLayout.class)
@Route(value = "", layout = MainLayout.class)
@PageTitle("ContactGridView")
@PermitAll
public class ContactGridView extends VerticalLayout {

    Grid<Contact> grid = new Grid<>(Contact.class);
    TextField filterText = new TextField();
    ContactInputForm form;
    CrmService service;

    public ContactGridView(CrmService service) {
        this.service = service;
        addClassName("list-view");
        setSizeFull();

        configureGrid();
        configureForm();

        FlexLayout content = new FlexLayout(grid, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, form);
        content.setFlexShrink(0, form);//Vielleicht löschen
        content.addClassNames("content");
        content.setSizeFull();

        add(getToolbar(),content);
        updateList();
        closeEditor();
        grid.asSingleSelect().addValueChangeListener(event ->
                editContact(event.getValue()));
    }

    private void closeEditor() {
        form.setContact(null);
        form.setVisible(false);
        removeClassName("editing");
    }


    private void configureForm() {
        form = new ContactInputForm();
        form.setWidth("25em");

        form.addListener(ContactInputForm.SaveEvent.class, this::saveContact);
        form.addListener(ContactInputForm.DeleteEvent.class, this::deleteContact);
        form.addListener(ContactInputForm.CloseEvent.class, e -> closeEditor());
    }

    private void configureGrid(){
            grid.addClassNames("contact-grid");
            grid.setSizeFull();
            grid.setColumns("firstName", "lastName", "email");
            grid.getColumns().forEach(col -> col.setAutoWidth(true));



    }
    private HorizontalLayout getToolbar() {
            filterText.setPlaceholder("Filter by name...");
            filterText.setClearButtonVisible(true);
            //Die Datenbank soll nicht nach jeden Buchstaben den man angibt suchen
            filterText.setValueChangeMode(ValueChangeMode.LAZY);
            filterText.addValueChangeListener(e -> updateList());


            Button addContactButton = new Button("Kontakt hinzufügen");
            addContactButton.addClickListener(click -> addContact());

            HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
            toolbar.addClassName("toolbar");
            return toolbar;
    }
    private void updateList() {

        grid.setItems(service.findAllContacts(filterText.getValue()));
    }
    public void editContact(Contact contact) {
        if (contact == null) {
            closeEditor();
        } else {
            form.setContact(contact);
            form.setVisible(true);
            addClassName("editing");
        }
    }
    void addContact() {
        grid.asSingleSelect().clear();
        editContact(new Contact());
    }
    private void saveContact(ContactInputForm.SaveEvent event) {
        service.saveContact(event.getContact());
        updateList();
        closeEditor();
    }

    private void deleteContact(ContactInputForm.DeleteEvent event) {
        service.deleteContact(event.getContact());
        updateList();
        closeEditor();
    }

}













//        Contact michael = new Contact();
//        michael.setFirstName("Michael");
//        michael.setLastName("Stephens");
//        michael.setEmail("stephens@gmx.de");
//        Contact anneke = new Contact();
//        michael.setFirstName("Annke");
//        michael.setLastName("Goblish");
//        michael.setEmail("annke@gmx.de");
//        grid.setItems(anneke,michael);