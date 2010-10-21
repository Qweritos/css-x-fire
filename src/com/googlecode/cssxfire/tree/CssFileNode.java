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

package com.googlecode.cssxfire.tree;

import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: Ronnie
 */
public class CssFileNode extends CssTreeNode
{
    private final PsiFile psiFile;

    public CssFileNode(PsiFile psiFile)
    {
        this.psiFile = psiFile;
    }

    public String getFilename()
    {
        return psiFile.getName();
    }

    @Override
    public Icon getIcon()
    {
        ItemPresentation presentation = psiFile.getPresentation();
        return presentation != null ? presentation.getIcon(true) : psiFile.getIcon(1);
    }

    @Override
    public String getText()
    {
        VirtualFile virtualFile = psiFile.getVirtualFile();
        String path = virtualFile != null ? virtualFile.getPresentableUrl() : psiFile.getName();
        return path + " (" + TreeUtils.countLeafs(this) + ")";
    }

    @Override
    public ActionGroup getActionGroup()
    {
        return (ActionGroup) ActionManager.getInstance().getAction("IncomingChanges.DeclarationNodePopup.File");
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        CssFileNode fileNode = (CssFileNode) o;

        if (psiFile != null ? !psiFile.equals(fileNode.psiFile) : fileNode.psiFile != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return psiFile != null ? psiFile.hashCode() : 0;
    }
}
