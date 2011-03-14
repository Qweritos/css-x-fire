/*
 * Copyright 2010 Ronnie Kolehmainen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecode.cssxfire.action;

import com.googlecode.cssxfire.CssXFireConnector;
import com.googlecode.cssxfire.ProjectSettings;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: Ronnie
 */
public class MediaReduceOption extends BooleanOption
{
    @NotNull
    @Override
    protected String getOptionName()
    {
        return "Reduce for @media query";
    }

    @Override
    protected boolean getOptionValue(AnActionEvent event)
    {
        ProjectSettings projectSettings = getProjectSettings(event);
        return projectSettings != null && projectSettings.isMediaReduce();
    }

    @Override
    protected void setOptionValue(AnActionEvent event, boolean value)
    {
        ProjectSettings projectSettings = getProjectSettings(event);
        if (projectSettings != null)
        {
            projectSettings.setMediaReduce(value);
        }

        // Store value as default for new projects
        CssXFireConnector.getInstance().getState().setMediaReduce(value);
    }
}
