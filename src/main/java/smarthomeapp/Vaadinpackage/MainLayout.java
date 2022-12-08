package smarthomeapp.Vaadinpackage;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;


@CssImport("./themes/style.css")
public class MainLayout extends AppLayout {

    public MainLayout() {

        createHeader();
        createDrawer();
    }

    private void createDrawer() {
        RouterLink homesystem = new RouterLink("Home Systems", HomeSystemView.class);
        RouterLink kontakte = new RouterLink("ContactGridView", ContactGridView.class);

        homesystem.setHighlightCondition(HighlightConditions.sameLocation());
        kontakte.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(kontakte,homesystem));

    }


    private void createHeader() {
       H1 logoname = new H1("SMART HOME");
       logoname.setClassName("logo");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logoname);
        header.addClassName("header");
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);


    }

}