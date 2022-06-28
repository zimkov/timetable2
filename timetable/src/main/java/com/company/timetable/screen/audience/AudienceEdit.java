package com.company.timetable.screen.audience;

import io.jmix.ui.screen.*;
import com.company.timetable.entity.Audience;

@UiController("Audience.edit")
@UiDescriptor("audience-edit.xml")
@EditedEntityContainer("audienceDc")
public class AudienceEdit extends StandardEditor<Audience> {
}