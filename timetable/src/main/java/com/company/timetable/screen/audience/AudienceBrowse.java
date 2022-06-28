package com.company.timetable.screen.audience;

import io.jmix.ui.screen.*;
import com.company.timetable.entity.Audience;

@UiController("Audience.browse")
@UiDescriptor("audience-browse.xml")
@LookupComponent("audiencesTable")
public class AudienceBrowse extends StandardLookup<Audience> {
}