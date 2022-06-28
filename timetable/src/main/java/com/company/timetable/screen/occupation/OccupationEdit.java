package com.company.timetable.screen.occupation;

import io.jmix.ui.screen.*;
import com.company.timetable.entity.Occupation;

@UiController("Occupation.edit")
@UiDescriptor("occupation-edit.xml")
@EditedEntityContainer("occupationDc")
public class OccupationEdit extends StandardEditor<Occupation> {
}