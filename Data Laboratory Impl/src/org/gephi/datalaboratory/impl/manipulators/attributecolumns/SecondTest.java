/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gephi.datalaboratory.impl.manipulators.attributecolumns;

import java.awt.Image;
import javax.swing.JOptionPane;
import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeTable;
import org.gephi.datalaboratory.spi.attributecolumns.AttributeColumnsManipulator;
import org.gephi.datalaboratory.spi.attributecolumns.AttributeColumnsManipulatorUI;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Eduardo Ramos <eduramiba@gmail.com>
 */
@ServiceProvider(service=AttributeColumnsManipulator.class)
public class SecondTest implements AttributeColumnsManipulator {

    public void execute(AttributeTable table, AttributeColumn column) {
        JOptionPane.showMessageDialog(null, table.getName()+" - "+column.getTitle());
    }

    public String getName() {
        return "Second Test";
    }

    public String getDescription() {
        return "";
    }

    public boolean canManipulateColumn(AttributeColumn column) {
        return true;
    }

    public AttributeColumnsManipulatorUI getUI() {
        return null;
    }

    public int getPosition() {
        return 100;
    }

    public Image getIcon() {
        return ImageUtilities.loadImage("org/gephi/datalaboratory/impl/manipulators/resources/cross.png");
    }

}
