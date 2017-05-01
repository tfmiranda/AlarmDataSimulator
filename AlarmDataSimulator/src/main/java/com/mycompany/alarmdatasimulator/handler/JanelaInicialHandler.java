/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alarmdatasimulator.handler;

import com.mycompany.alarmdatasimulator.dominio.Alarm;
import com.mycompany.alarmdatasimulator.view.JanelaInicial;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Tiago
 */
public class JanelaInicialHandler {

    private final JanelaInicial frame;

    public JanelaInicialHandler(JanelaInicial frame) {
        this.frame = frame;
    }

    public void initLista() {
        JList lista = frame.getLista();
        ListModel model = new DefaultListModel();
        lista.setModel(model);
    }

    public void initTabela() {
        JTable tabela = frame.getTabela();
        TableModel model = new DefaultTableModel();
        tabela.setModel(model);
    }
    
    public void initComboBox(){
        JComboBox comboBox = frame.getComboBox();
        ComboBoxModel model = new DefaultComboBoxModel();
        comboBox.setModel(model);
    }

    public void checkPopupListItensEnable() {
        JList lista = frame.getLista();
        int index = lista.getSelectedIndex();
        if (index == -1) {
            frame.enablePopoutItens(true, false, false);
        } else {
            frame.enablePopoutItens(true, true, true);
        }
    }

    public void openJanelaNewAlarm() {
        frame.openJanelaAlarm(new Alarm(), true);
    }

    public void openJanelaEditAlarm(int selectedIndex) {
        Object element = frame.getLista().getModel().getElementAt(selectedIndex);
        if(element instanceof Alarm){
            Alarm alarm = (Alarm) element;
            frame.openJanelaAlarm(alarm, false);
        }else{
            JOptionPane.showMessageDialog(frame, "Fail to load alarm fields");
        }
    }

    public void addAlarm(Alarm alarm) {
        DefaultListModel model = (DefaultListModel) frame.getLista().getModel();
        int index = model.indexOf(alarm);
        if(index == -1) model.addElement(alarm);
        else model.setElementAt(alarm, index);
        frame.getLista().setModel(model);
    }

    public void delSelectedAlarm() {
        int index = frame.getLista().getSelectedIndex();
        DefaultListModel model = (DefaultListModel) frame.getLista().getModel();
        model.removeElementAt(index);
        frame.getLista().setModel(model);
    }

}
