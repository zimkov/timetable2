package com.company.firstproject.screen.project;

import io.jmix.ui.screen.*;
import com.company.firstproject.entity.Project;

@UiController("Project.edit")
@UiDescriptor("project-edit.xml")
@EditedEntityContainer("projectDc")
public class ProjectEdit extends StandardEditor<Project> {
}