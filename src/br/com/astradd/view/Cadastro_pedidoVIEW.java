package br.com.astradd.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import br.com.astradd.dto.PedidoDTO;
import br.com.astradd.dto.LoginDTO;
import br.com.astradd.dto.Tipo_do_exameDTO;
import br.com.astradd.ctr.Tipo_do_exameCTR;
import br.com.astradd.ctr.PacienteCTR;
import br.com.astradd.dto.PacienteDTO;
import br.com.astradd.dao.PedidoDAO;
import br.com.astradd.dao.ConexaoDAO;
import br.com.astradd.ctr.PedidoCTR;
import static br.com.astradd.dao.ConexaoDAO.con;
import java.sql.SQLException;
import javax.swing.JTextField;

public class Cadastro_pedidoVIEW extends javax.swing.JInternalFrame {

    PedidoDTO pedidoDTO = new PedidoDTO();
    Tipo_do_exameDTO tipo_do_exameDTO = new Tipo_do_exameDTO();
    Tipo_do_exameCTR tipo_do_exameCTR = new Tipo_do_exameCTR();
    PacienteDTO pacienteDTO = new PacienteDTO();
    PedidoDAO pedidoDAO = new PedidoDAO();
    PedidoCTR pedidoCTR = new PedidoCTR();
    PacienteCTR pacienteCTR = new PacienteCTR();
    LoginDTO loginDTO = new LoginDTO();
    ResultSet rs;
    DefaultTableModel modelo_tabExame;
    DefaultTableModel modelo_tab_pac;
    Statement stmt = null;

    public Cadastro_pedidoVIEW() {
        initComponents();
        ConexaoDAO.ConectDB();
        modelo_tabExame = (DefaultTableModel) tabExame.getModel();
        modelo_tab_pac = (DefaultTableModel) tab_pac.getModel();
        obs_ped.setWrapStyleWord(true);
        obs_ped.setLineWrap(true);

    }

    private void gravar() {
        pedidoDTO.setData_ped(data_ped.getText());
        pedidoDTO.setCod_pac(Integer.parseInt(cod_pac.getText()));
        tipo_do_exameDTO.setCod_tp_ex(Integer.parseInt(cod_tp_ex.getText()));
        pedidoDTO.setObs_ped(obs_ped.getText());

        JOptionPane.showMessageDialog(null,
                pedidoCTR.inserirPedido(pedidoDTO, tipo_do_exameDTO, pacienteDTO, loginDTO)
        );
    }

    private void preencheTabelaExame(String nome_ex) {
        try {
            modelo_tabExame.setNumRows(0);

            tipo_do_exameDTO.setNome_ex(nome_ex);
            rs = tipo_do_exameCTR.consultarTipo_do_exame(tipo_do_exameDTO);
            while (rs.next()) {
                modelo_tabExame.addRow(new Object[]{
                    rs.getString("cod_tp_ex"),
                    rs.getString("nome_ex"),});
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }
   private void preencheTabelaPaciente(String nome ) {
        try {
            modelo_tab_pac.setNumRows(0);

            pacienteDTO.setNome_p(nome);
            rs = pacienteCTR.consultarPaciente( pacienteDTO);
            while (rs.next()) {
                modelo_tab_pac.addRow(new Object[]{
                    rs.getString("cod_pac"),
                    rs.getString("nome_p"),});
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
}

    private void preencheCamposExame(int a) {
        try {
            tipo_do_exameDTO.setCod_tp_ex(a);
            rs = tipo_do_exameCTR.consultarTipo_do_exameCampos(tipo_do_exameDTO);
            if (rs.next()) {

                cod_tp_ex.setText(rs.getString("cod_tp_ex"));
                cod_tp_ex.setEditable(false);

            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }

   private void preencheCamposPaciente(int a) {
        try {
            pacienteDTO.setCod_pac(a);
           rs = pacienteCTR.consultarPacienteCampos( pacienteDTO);
           if (rs.next()) {

               cod_pac.setText(rs.getString("cod_pac"));
                cod_pac.setEditable(false);

            }
       } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
       }
   }
   
   private void limpaCampos() {
        data_ped.setText("");
        cod_pac.setText("");
        modelo_tab_pac.setNumRows(0);
        obs_ped.setText("");
        mostrar_paciente.setText("");
        mostrar_exame.setText("");
        modelo_tabExame.setNumRows(0);
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        data_ped = new javax.swing.JFormattedTextField();
        mostrar_paciente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_pac = new javax.swing.JTable();
        mostrar_exame = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabExame = new javax.swing.JTable();
        btn_pesq_pac = new javax.swing.JButton();
        btn_pesq = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cod_tp_ex = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cod_pac = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        obs_ped = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btn_salvar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Pedido");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(673, 282));

        jLabel2.setText("Data do pedido:");

        jLabel3.setText("Pesquisar tipo do exame:");

        jLabel4.setText("Pesquisar paciente:");

        try {
            data_ped.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tab_pac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_pac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_pacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_pac);

        tabExame.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome do exame"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabExame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabExameMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabExame);

        btn_pesq_pac.setText("Pesquisar");
        btn_pesq_pac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesq_pacActionPerformed(evt);
            }
        });

        btn_pesq.setText("Pesquisar");
        btn_pesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesqActionPerformed(evt);
            }
        });

        jLabel5.setText("Codigo Exame");

        jLabel6.setText("Codigo Paciente");

        jLabel7.setText("Observações");

        obs_ped.setColumns(20);
        obs_ped.setRows(5);
        jScrollPane3.setViewportView(obs_ped);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cod_pac, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(mostrar_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_pesq_pac))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(data_ped, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cod_tp_ex, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(mostrar_exame, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_pesq))
                    .addComponent(jLabel5))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(data_ped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(cod_tp_ex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cod_pac, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mostrar_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(mostrar_exame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_pesq)
                        .addComponent(btn_pesq_pac)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(258, 84));

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
                .addGap(33, 33, 33)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(711, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1037, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        gravar();
        limpaCampos();
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void tab_pacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_pacMouseClicked
        preencheCamposPaciente(Integer.parseInt(String.valueOf(tab_pac.getValueAt(tab_pac.getSelectedRow(), 0))));
    }//GEN-LAST:event_tab_pacMouseClicked

    private void btn_pesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesqActionPerformed
        preencheTabelaExame(mostrar_exame.getText());
    }//GEN-LAST:event_btn_pesqActionPerformed

    private void tabExameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabExameMouseClicked
        preencheCamposExame(Integer.parseInt(String.valueOf(tabExame.getValueAt(tabExame.getSelectedRow(), 0))));
    }//GEN-LAST:event_tabExameMouseClicked

    private void btn_pesq_pacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesq_pacActionPerformed
        preencheTabelaPaciente(mostrar_paciente.getText());
    }//GEN-LAST:event_btn_pesq_pacActionPerformed

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btn_limparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton btn_pesq;
    private javax.swing.JButton btn_pesq_pac;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JTextField cod_pac;
    private javax.swing.JTextField cod_tp_ex;
    private javax.swing.JFormattedTextField data_ped;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField mostrar_exame;
    private javax.swing.JTextField mostrar_paciente;
    private javax.swing.JTextArea obs_ped;
    private javax.swing.JTable tabExame;
    private javax.swing.JTable tab_pac;
    // End of variables declaration//GEN-END:variables
}
