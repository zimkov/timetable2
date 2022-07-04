package com.company.timetable.screen.occupation;

import com.company.timetable.entity.Audience;
import com.company.timetable.entity.Group;
import com.company.timetable.entity.Teacher;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.DateField;
import io.jmix.ui.component.EntityPicker;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.TimeField;
import io.jmix.ui.screen.*;
import com.company.timetable.entity.Occupation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@UiController("Occupation.edit")
@UiDescriptor("occupation-edit.xml")
@EditedEntityContainer("occupationDc")
public class OccupationEdit extends StandardEditor<Occupation> {
    @Autowired
    private EntityPicker<Audience> audienceField;
    @Autowired
    private EntityPicker<Teacher> teacherField;
    @Autowired
    private TimeField<Date> timeField;
    @Autowired
    private DateField<Date> dateField;
    @Autowired
    private Notifications notifications;



    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        for (Occupation x:getEditedEntity().getTeacher().getOccupation()) {
            if( x.getTime().equals(getEditedEntity().getTime()) && x.getDate().equals(getEditedEntity().getDate()) ) { notifications.create()
                    .withCaption("Данный преподаватель занят в это время")
                    .show();
                event.preventCommit();
            }
        }
        if(getEditedEntity().getGroup().size()>getEditedEntity().getAudience().getCapacity()) {
            notifications.create()
                .withCaption("Аудитория не вмещает столько групп")
                .show();
        event.preventCommit();
        }
        if(getEditedEntity().getAudience().getOccupation().getTime().equals(getEditedEntity().getTime()) && getEditedEntity().getAudience().getOccupation().getDate().equals(getEditedEntity().getDate()) ) {
            notifications.create()
                    .withCaption("Аудитория занята в это время")
                    .show();
            event.preventCommit();
        }
        for (Group x:getEditedEntity().getGroup()) {
            for (Occupation y: x.getOccupation())
                if(y.getTime().equals(getEditedEntity().getTime()) && y.getDate().equals(getEditedEntity().getDate()) ) {
                    notifications.create()
                    .withCaption("Данная группа занята в это время")
                    .show();
                event.preventCommit();
            }
        }
    }


}