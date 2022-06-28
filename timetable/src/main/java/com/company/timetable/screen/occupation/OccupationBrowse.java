package com.company.timetable.screen.occupation;

import io.jmix.ui.screen.*;
import com.company.timetable.entity.Occupation;

@UiController("Occupation.browse")
@UiDescriptor("occupation-browse.xml")
@LookupComponent("occupationsTable")
public class OccupationBrowse extends StandardLookup<Occupation> {
}