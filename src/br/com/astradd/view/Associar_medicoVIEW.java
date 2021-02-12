package br.com.astradd.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import br.com.astradd.dto.MedicoDTO;
import br.com.astradd.dto.FuncionarioDTO;
import br.com.astradd.dto.Tipo_do_exameDTO;
import br.com.astradd.dto.PacienteDTO;
import br.com.astradd.dto.LoginDTO;
import br.com.astradd.dto.BiomedicoDTO;
import br.com.astradd.dto.PedidoDTO;
import br.com.astradd.dao.PedidoDAO;
import br.com.astradd.ctr.PedidoCTR;
import br.com.astradd.ctr.FuncionarioCTR;
import javax.swing.JTextField;

public class Associar_medicoVIEW extends javax.swing.JInternalFrame {

    PedidoDTO pedidoDTO = new PedidoDTO();
    MedicoDTO medicoDTO = new MedicoDTO();
    Tipo_do_exameDTO tipo_do_exameDTO = new Tipo_do_exameDTO();
    PacienteDTO pacienteDTO = new PacienteDTO();
    BiomedicoDTO biomedicoDTO = new BiomedicoDTO();
    PedidoDAO pedidoDAO = new PedidoDAO();
    LoginDTO loginDTO = new LoginDTO();
    PedidoCTR pedidoCTR = new PedidoCTR();
    FuncionarioCTR funcionarioCTR = new FuncionarioCTR();
    FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
    ResultSet rs;
    DefaultTableModel modelo_tab_med;
    DefaultTableModel modelo_tab_ped;

    public Associar_medicoVIEW() {
        initComponents();
        modelo_tab_med = (DefaultTableModel) tab_med.getModel();
        modelo_tab_ped = (DefaultTableModel) tab_ped.getModel();
    }

    private void gravar() {
        funcionarioDTO.setCod_fun(Integer.parseInt(cod_fun.getText()));
        pedidoDTO.setCod_ped(Integer.parseInt(cod_ped.getText()));

        JOptionPane.showMessageDialog(null,
                pedidoCTR.assocPedido(pedidoDTO, tipo_do_exameDTO, pacienteDTO, loginDTO, funcionarioDTO)
        );
    }

    private void preencheTabelaMedico(String campo_pesquisa_med) {
        try {
            modelo_tab_med.setNumRows(0);

            funcionarioDTO.setNome_f(campo_pesquisa_med);
            rs = funcionarioCTR.consultarFuncionarioMedicoTab(funcionarioDTO, medicoDTO, loginDTO);
            while (rs.next()) {
                modelo_tab_med.addRow(new Object[]{
                    rs.getString("cod_fun"),
                    rs.getString("nome_f"),});
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }

    private void preencheTabelaPedido(String campo_pesquisa_ped) {
        try {
            modelo_tab_ped.setNumRows(0);
            tipo_do_exameDTO.setNome_ex(campo_pesquisa_ped);

            rs = pedidoCTR.consultarPedidoAssoc(pedidoDTO, tipo_do_exameDTO, pacienteDTO, loginDTO);
            while (rs.next()) {
                modelo_tab_ped.addRow(new Object[]{
                    rs.getInt("cod_ped"),
                    rs.getString("nome_p")});
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }

    private void preencheCamposMedico(int cod) {
        try {
            funcionarioDTO.setCod_fun(cod);
            rs = funcionarioCTR.consultarFuncionarioCampoMedico(funcionarioDTO, medicoDTO,loginDTO);
            if (rs.next()) {
                cod_fun.setText(rs.getString("cod_fun"));
                cod_fun.setEditable(false);

            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }
    

    private void preencheCamposPedido(int cod) {
        try {
            pedidoDTO.setCod_ped(cod);
            rs = pedidoCTR.consultarPedido(pedidoDTO, tipo_do_exameDTO, pacienteDTO, loginDTO);
            if (rs.next()) {

                cod_ped.setText(rs.getString("cod_ped"));
                cod_ped.setEditable(false);

            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }
    private void limpaCampos() {
        cod_ped.setText("");
        cod_fun.setText("");
        modelo_tab_med.setNumRows(0);
        modelo_tab_med.setNumRows(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_med = new javax.swing.JTable();
        campo_pesquisa_med = new javax.swing.JTextField();
        btn_medico = new javax.swing.JButton();
        campo_pesquisa_ped = new javax.swing.JTextField();
        btn_ped = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_ped = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cod_fun = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cod_ped = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_salvar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(964, 547));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Associar Médico");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Pesquisar novo médico");

        jLabel3.setText("Pesquisar pedido a ser alterado");

        tab_med.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_med.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_medMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tab_medMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tab_med);

        btn_medico.setText("Pesquisar");
        btn_medico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_medicoActionPerformed(evt);
            }
        });

        btn_ped.setText("Pesquisar");
        btn_ped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedActionPerformed(evt);
            }
        });

        tab_ped.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Exame"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_ped.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_pedMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_ped);
        if (tab_ped.getColumnModel().getColumnCount() > 0) {
            tab_ped.getColumnModel().getColumn(0).setResizable(false);
            tab_ped.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jLabel4.setText("Codigo do medico");

        jLabel5.setText("Codigo do pedido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cod_fun, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campo_pesquisa_med, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_medico)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(campo_pesquisa_ped, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ped))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(46, 46, 46)
                        .addComponent(cod_ped, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cod_fun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cod_ped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campo_pesquisa_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_medico))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campo_pesquisa_ped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ped))
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(457, 84));

        btn_salvar.setText("Salvar");
        btn_salvar.setPreferredSize(new java.awt.Dimension(85, 44));
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.setPreferredSize(new java.awt.Dimension(85, 44));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_limpar.setText("Limpar");
        btn_limpar.setPreferredSize(new java.awt.Dimension(85, 44));
        btn_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_medicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_medicoActionPerformed
        preencheTabelaMedico(campo_pesquisa_med.getText());
    }//GEN-LAST:event_btn_medicoActionPerformed

    private void btn_pedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedActionPerformed
        preencheTabelaPedido(campo_pesquisa_ped.getText());
    }//GEN-LAST:event_btn_pedActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        gravar();
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void tab_medMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_medMouseClicked
        preencheCamposMedico((Integer.parseInt(String.valueOf(tab_med.getValueAt(tab_med.getSelectedRow(), 0)))));
    }//GEN-LAST:event_tab_medMouseClicked

    private void tab_pedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_pedMouseClicked
        preencheCamposPedido((Integer.parseInt(String.valueOf(tab_ped.getValueAt(tab_ped.getSelectedRow(), 0)))));

    }//GEN-LAST:event_tab_pedMouseClicked

    private void tab_medMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_medMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_medMouseEntered

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btn_limparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton btn_medico;
    private javax.swing.JButton btn_ped;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JTextField campo_pesquisa_med;
    private javax.swing.JTextField campo_pesquisa_ped;
    private javax.swing.JTextField cod_fun;
    private javax.swing.JTextField cod_ped;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tab_med;
    private javax.swing.JTable tab_ped;
    // End of variables declaration//GEN-END:variables
}
