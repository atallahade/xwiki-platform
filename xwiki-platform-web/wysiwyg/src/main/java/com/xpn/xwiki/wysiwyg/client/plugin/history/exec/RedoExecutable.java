/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.xpn.xwiki.wysiwyg.client.plugin.history.exec;

import com.xpn.xwiki.wysiwyg.client.plugin.history.History;
import com.xpn.xwiki.wysiwyg.client.widget.rta.RichTextArea;

/**
 * Loads the next entry in the history of a rich text area.
 * 
 * @version $Id$
 */
public class RedoExecutable extends AbstractHistoryExecutable
{
    /**
     * Creates a new redo executable that uses the given history.
     * 
     * @param history the history to use
     */
    public RedoExecutable(History history)
    {
        super(history);
    }

    /**
     * {@inheritDoc}
     * 
     * @see AbstractHistoryExecutable#execute(RichTextArea, String)
     */
    public boolean execute(RichTextArea rta, String param)
    {
        if (getHistory().canRedo()) {
            getHistory().redo();
            return true;
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see AbstractHistoryExecutable#getParameter(RichTextArea)
     */
    public String getParameter(RichTextArea rta)
    {
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see AbstractHistoryExecutable#isEnabled(RichTextArea)
     */
    public boolean isEnabled(RichTextArea rta)
    {
        return getHistory().canRedo();
    }

    /**
     * {@inheritDoc}
     * 
     * @see AbstractHistoryExecutable#isExecuted(RichTextArea)
     */
    public boolean isExecuted(RichTextArea rta)
    {
        // Right now there's no way to test if the redo command has been executed.
        return true;
    }

    /**
     * {@inheritDoc}
     * 
     * @see AbstractHistoryExecutable#isSupported(RichTextArea)
     */
    public boolean isSupported(RichTextArea rta)
    {
        return true;
    }
}
