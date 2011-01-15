
/*
Copyright 2008-2010 Gephi
Authors : Eduardo Ramos <eduramiba@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.visualization.spi;

import javax.swing.Icon;
import org.gephi.graph.api.HierarchicalGraph;
import org.gephi.graph.api.Node;

/**
 * <p>Interface from providing graph context menu items as services.</p>
 * <p>All context menu items are able to:</p>
 * <ul>
 *  <li>Execute an action</li>
 *  <li>Provide a name, type and order of appearance (position in group of its type)</li>
 * <li>Indicate wether they have to be available (appear in the context menu) or not</li>
 *  <li>Indicate wether they have to be executable (enabled in the context menu) or not</li>
 *  <li>Provide and icon or not</li>
 * </ul>
 * <p>Used for different manipulators such as NodesManipulator, EdgesManipulator and GeneralActionsManipulator.</p>
 * <p>The only methods that are called before setting up an item with the data are getType and getPosition.
 * This way, the other methods behaviour can depend on the data that has been setup before</p>
 *
 * To provide a context menu item, a class has to implement this interface and have a <code>@ServiceProvider</code> annotation
 * @author Eduardo Ramos <eduramiba@gmail.com>
 */
public interface GraphContextMenuItem {

    /**
     * Prepare nodes for this item.
     * @param graph Hierarchical graph
     * @param nodes All selected nodes
     */
    void setup(HierarchicalGraph graph, Node[] nodes);

    /**
     * Execute this item.
     * It will operate with data like nodes and edges previously setup for the type of manipulator.
     */
    void execute();

    /**
     * This is optional. Return sub items for this menu item if desired.
     * If this item should contain more items, return a new instance of each sub item.
     * If not return null and implement execute for this item.
     * @return
     */
    GraphContextMenuItem[] getSubItems();

    /**
     * <p>Return name to show for this item in the context menu.</p>
     * <p>Implementations can provide different names depending on the data this
     * item has (for example depending on the number of nodes).</p>
     * @return Name to show at current time and conditions
     */
    String getName();

    /**
     * Indicates if this item has to appear in the context menu at all
     * @return True to show, false otherwise
     */
    boolean isAvailable();

    /**
     * Indicates if this item can be executed when it is available.
     * Implementations should evaluate the current data and conditions.
     * @return True if it has to be executable, false otherwise
     */
    boolean canExecute();

    /**
     * Type of item. This is used for separating the items
     * in groups when shown, using popup separators. First types to show will be the lesser.
     * @return Type of this manipulator
     */
    int getType();

    /**
     * Returns a position value that indicates the position
     * of this Manipulator in its type group. Less means upper.
     * @return This Manipulator position
     */
    int getPosition();

    /**
     * Returns an icon for this item if necessary.
     * @return Icon or null
     */
    Icon getIcon();
}
