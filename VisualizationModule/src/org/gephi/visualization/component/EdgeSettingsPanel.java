/*
Copyright 2008 WebAtlas
Authors : Mathieu Bastian, Mathieu Jacomy, Julian Bilcke
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.visualization.component;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.gephi.ui.components.JColorButton;
import org.gephi.visualization.VizController;
import org.gephi.visualization.VizModel;

/**
 *
 * @author Mathieu Bastian
 */
public class EdgeSettingsPanel extends javax.swing.JPanel {

    /** Creates new form EdgeSettingsPanel */
    public EdgeSettingsPanel() {
        initComponents();
    }

    public void setup() {
        VizModel vizModel = VizController.getInstance().getVizModel();
        vizModel.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("edgeHasUniColor")) {
                    refreshSharedConfig();
                } else if (evt.getPropertyName().equals("showEdges")) {
                    refreshSharedConfig();
                } else if (evt.getPropertyName().equals("edgeUniColor")) {
                    refreshSharedConfig();
                }
            }
        });
        refreshSharedConfig();

        showEdgesCheckbox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                VizModel vizModel = VizController.getInstance().getVizModel();
                vizModel.setShowEdges(showEdgesCheckbox.isSelected());
            }
        });
        ((JColorButton) edgeColorButton).addPropertyChangeListener(JColorButton.EVENT_COLOR, new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                VizModel vizModel = VizController.getInstance().getVizModel();
                vizModel.setEdgeUniColor(((JColorButton) edgeColorButton).getColorArray());
            }
        });
        sourceNodeColorCheckbox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                VizModel vizModel = VizController.getInstance().getVizModel();
                vizModel.setEdgeHasUniColor(!sourceNodeColorCheckbox.isSelected());
            }
        });
    }

    private void refreshSharedConfig() {
        VizModel vizModel = VizController.getInstance().getVizModel();
        if (showEdgesCheckbox.isSelected() != vizModel.isShowEdges()) {
            showEdgesCheckbox.setSelected(vizModel.isShowEdges());
        }
        float[] edgeCol = vizModel.getEdgeUniColor();
        ((JColorButton) edgeColorButton).setColor(new Color(edgeCol[0], edgeCol[1], edgeCol[2], edgeCol[3]));

        if (sourceNodeColorCheckbox.isSelected() != !vizModel.isEdgeHasUniColor()) {
            sourceNodeColorCheckbox.setSelected(!vizModel.isEdgeHasUniColor());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showEdgesCheckbox = new javax.swing.JCheckBox();
        labelEdgeColor = new javax.swing.JLabel();
        edgeColorButton = new JColorButton(Color.BLACK);
        sourceNodeColorCheckbox = new javax.swing.JCheckBox();

        showEdgesCheckbox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        showEdgesCheckbox.setText(org.openide.util.NbBundle.getMessage(EdgeSettingsPanel.class, "EdgeSettingsPanel.showEdgesCheckbox.text")); // NOI18N

        labelEdgeColor.setText(org.openide.util.NbBundle.getMessage(EdgeSettingsPanel.class, "EdgeSettingsPanel.labelEdgeColor.text")); // NOI18N

        edgeColorButton.setText(org.openide.util.NbBundle.getMessage(EdgeSettingsPanel.class, "EdgeSettingsPanel.edgeColorButton.text")); // NOI18N

        sourceNodeColorCheckbox.setText(org.openide.util.NbBundle.getMessage(EdgeSettingsPanel.class, "EdgeSettingsPanel.sourceNodeColorCheckbox.text")); // NOI18N
        sourceNodeColorCheckbox.setBorder(null);
        sourceNodeColorCheckbox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sourceNodeColorCheckbox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        sourceNodeColorCheckbox.setMargin(new java.awt.Insets(2, 0, 2, 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(showEdgesCheckbox))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sourceNodeColorCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelEdgeColor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edgeColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(445, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(showEdgesCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelEdgeColor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(edgeColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sourceNodeColorCheckbox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton edgeColorButton;
    private javax.swing.JLabel labelEdgeColor;
    private javax.swing.JCheckBox showEdgesCheckbox;
    private javax.swing.JCheckBox sourceNodeColorCheckbox;
    // End of variables declaration//GEN-END:variables
}
