package com.company.timetable.screen.occupation;

import com.company.timetable.entity.Group;
import io.jmix.core.Messages;
import io.jmix.core.annotation.MessageSourceBasenames;
import io.jmix.ui.Notifications;
import io.jmix.ui.screen.*;
import com.company.timetable.entity.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@UiController("Occupation.edit")
@UiDescriptor("occupation-edit.xml")
@EditedEntityContainer("occupationDc")

public class OccupationEdit extends StandardEditor<Occupation> {

    @Autowired
    private Notifications notifications;

    @Autowired
    private MessageBundle messageBundle;
    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        if(getEditedEntity().getGroup() == null || getEditedEntity().getGroup().size() == 0){
            notifications.create()
                    .withCaption(messageBundle.getMessage("group.empty"))
                    .show();
            event.preventCommit();
        }else {
            for (Occupation x : getEditedEntity().getTeacher().getOccupations()) {
                if (x.getTime().equals(getEditedEntity().getTime()) && x.getDate().equals(getEditedEntity().getDate())) {
                    notifications.create()
                            .withCaption(messageBundle.getMessage("teacher.busy"))
                            .show();
                    event.preventCommit();
                }
            }
            if (getEditedEntity().getGroup().size() > getEditedEntity().getAudience().getCapacity()) {
                notifications.create()
                        .withCaption(messageBundle.getMessage("audience.more"))
                        .show();
                event.preventCommit();
            }
            if (getEditedEntity().getAudience().getOccupation() != null) {
                if (getEditedEntity().getAudience().getOccupation().getTime().equals(getEditedEntity().getTime()) && getEditedEntity().getAudience().getOccupation().getDate().equals(getEditedEntity().getDate())) {
                    notifications.create()
                            .withCaption(messageBundle.getMessage("audience.busy"))
                            .show();
                    event.preventCommit();
                }
            }


            for (Group x : getEditedEntity().getGroup()) {
                for (Occupation y : x.getOccupations())
                    if (y.getTime().equals(getEditedEntity().getTime()) && y.getDate().equals(getEditedEntity().getDate())) {
                        notifications.create()
                                .withCaption(messageBundle.getMessage("group.busy"))
                                .show();
                        event.preventCommit();
                    }
            }
        }
    }


}