package com.company.timetable.screen.occupation;

import io.jmix.ui.component.Component;
import io.jmix.ui.component.Table;
import io.jmix.ui.screen.*;
import com.company.timetable.entity.Occupation;

@UiController("Occupation.browse")
@UiDescriptor("occupation-browse.xml")
@LookupComponent("occupationsTable")
public class OccupationBrowse extends StandardLookup<Occupation> {
    @Install(to = "occupationsTable.group", subject = "columnGenerator")
    private Component occupationsTableGroupColumnGenerator(Occupation occupation) {
        return new Table.PlainTextCell(occupation.toString());
    }
}