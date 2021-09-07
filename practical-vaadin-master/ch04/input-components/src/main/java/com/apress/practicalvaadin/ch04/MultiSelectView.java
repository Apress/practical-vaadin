package com.apress.practicalvaadin.ch04;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Set;

@Route("multi-select")
public class MultiSelectView extends Composite<Component> {

    private Service service = new Service();

    @Override
    protected Component initContent() {
        CheckboxGroup<Department> checkboxes = new CheckboxGroup<>();
        checkboxes.setItems(service.getDepartments());

        MultiSelectListBox<Department> listBox = new MultiSelectListBox<>();
        listBox.setItems(service.getDepartments());
        Set<Department> departments = listBox.getValue();

        return new VerticalLayout(checkboxes, listBox);
    }

}
