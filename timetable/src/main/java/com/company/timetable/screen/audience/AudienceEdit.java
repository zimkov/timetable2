package com.company.timetable.screen.audience;

import com.company.timetable.entity.TypeAudience;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.TextField;
import io.jmix.ui.screen.*;
import com.company.timetable.entity.Audience;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.Order;
import javax.swing.*;

@UiController("Audience.edit")
@UiDescriptor("audience-edit.xml")
@EditedEntityContainer("audienceDc")
public class AudienceEdit extends StandardEditor<Audience> {
    @Subscribe
    public void onInitEntity(InitEntityEvent<Order> event) {

    }
    @Autowired
    private TextField<String> capacityField;

    @Subscribe("typeField")
    public void onTypeFieldValueChange(HasValue.ValueChangeEvent<TypeAudience> event) {
        if(event.getValue() == TypeAudience.LECTURE) {
            capacityField.setVisible(true);
        } else {
            capacityField.setVisible(false);
        }

    }
}