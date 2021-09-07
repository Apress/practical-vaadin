package com.apress.practicalvaadin.ch04;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("select")
public class SelectView extends Composite<Component> {

    private Service service = new Service();

    @Override
    protected Component initContent() {
        List<Department> list = service.getDepartments();
        ComboBox<Department> comboBox = new ComboBox<>("Department");
        comboBox.setItems(list);
        comboBox.setItemLabelGenerator(department -> {
            String text = department.getName() + " department";
            return text;
        });

        RadioButtonGroup<Department> radio = new RadioButtonGroup<>();
        radio.setItems(list);

        ListBox<Department> listBox = new ListBox<>();
        listBox.setItems(list);

        return new VerticalLayout(comboBox, radio, listBox);
    }

}
