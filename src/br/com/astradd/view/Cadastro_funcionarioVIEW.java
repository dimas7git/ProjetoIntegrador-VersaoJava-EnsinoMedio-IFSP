package br.com.astradd.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import br.com.astradd.dto.BiomedicoDTO;
import br.com.astradd.dto.MedicoDTO;
import br.com.astradd.dto.FuncionarioDTO;
import br.com.astradd.dto.LoginDTO;
import br.com.astradd.dao.FuncionarioDAO;
import br.com.astradd.ctr.FuncionarioCTR;
import javax.swing.JTextField;


public class Cadastro_funcionarioVIEW extends javax.swing.JInternalFrame {

    BiomedicoDTO biomedicoDTO = new BiomedicoDTO();
    MedicoDTO medicoDTO = new MedicoDTO();
    FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
    LoginDTO loginDTO = new LoginDTO();
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    FuncionarioCTR funcionarioCTR = new FuncionarioCTR();
    ResultSet rs;
    DefaultTableModel modelo_tfun_f;

    public Cadastro_funcionarioVIEW() {
        initComponents();
        modelo_tfun_f = (DefaultTableModel) tfun_f.getModel();
        btn_excluir.setEnabled(false);
        btn_editar.setEnabled(false);
    }

    private void limpaCampos() {
        
        nome_f.setText("");
        tel_f.setText("");
        cargo_bio.setText("");
        especializacao_med.setText("");
        endereco.setText("");
        rg.setText("");
        cpf.setText("");
        cep.setText("");
        data_nasc.setText("");
        crm.setText("");
        nome_login.setText("");
        senha.setText("");
        btn_salvar.setEnabled(true);
        btn_editar.setEnabled(false);
        btn_excluir.setEnabled(false);
        med.setSelected(false);
        bio.setSelected(false);
        adm.setSelected(false);
    }

    private void gravar() {
        funcionarioDTO.setNome_f(nome_f.getText());
        funcionarioDTO.setTel_f(tel_f.getText());

        funcionarioDTO.setEndereco(endereco.getText());
        funcionarioDTO.setRg(rg.getText());
        funcionarioDTO.setCpf(cpf.getText());
        funcionarioDTO.setCep(cep.getText());
        loginDTO.setNome_login(nome_login.getText());
        loginDTO.setSenha(senha.getText());
        funcionarioDTO.setCrm(crm.getText());
        funcionarioDTO.setData_nasc(data_nasc.getText());

        if (med.isSelected()) {
            medicoDTO.setEspecializacao_med(especializacao_med.getText());
            loginDTO.setTp_usuario("med");
        } else if (bio.isSelected()) {
            biomedicoDTO.setCargo_bio(cargo_bio.getText());
            loginDTO.setTp_usuario("fun");
        } else if (adm.isSelected()) {
            biomedicoDTO.setCargo_bio(cargo_bio.getText());
            loginDTO.setTp_usuario("adm");
        }
        JOptionPane.showMessageDialog(null,
                funcionarioCTR.inserirFuncionario(medicoDTO, biomedicoDTO, funcionarioDTO, loginDTO)
        );

    }

    private void alterar() {
        funcionarioDTO.setNome_f(nome_f.getText());
        funcionarioDTO.setTel_f(tel_f.getText());
        biomedicoDTO.setCargo_bio(cargo_bio.getText());
        medicoDTO.setEspecializacao_med(especializacao_med.getText());
        funcionarioDTO.setEndereco(endereco.getText());
        funcionarioDTO.setRg(rg.getText());
        funcionarioDTO.setCpf(cpf.getText());
        funcionarioDTO.setCep(cep.getText());
        funcionarioDTO.setData_nasc(data_nasc.getText());
        loginDTO.setNome_login(nome_login.getText());
        loginDTO.setSenha(senha.getText());
        funcionarioDTO.setCrm(crm.getText());
        if (med.isSelected()) {
            medicoDTO.setEspecializacao_med(especializacao_med.getText());
            loginDTO.setTp_usuario("med");
        } else if (bio.isSelected()) {
            biomedicoDTO.setCargo_bio(cargo_bio.getText());
            loginDTO.setTp_usuario("fun");
        } else if (adm.isSelected()) {
            biomedicoDTO.setCargo_bio(cargo_bio.getText());
            loginDTO.setTp_usuario("adm");
        }
        JOptionPane.showMessageDialog(null,
                funcionarioCTR.alterarFuncionario(funcionarioDTO, medicoDTO, biomedicoDTO, loginDTO)
        );
    }

    private void preencheTabela(String mostrar) {
        try {
            modelo_tfun_f.setNumRows(0);
            funcionarioDTO.setNome_f(mostrar);
            rs = funcionarioCTR.consultarFuncionarioTab(funcionarioDTO, medicoDTO, biomedicoDTO, loginDTO);
           
            //System.out.println(rs.getInt("cod_fun"));
            while (rs.next()) {
                
                modelo_tfun_f.addRow(new Object[]{
                    rs.getInt("cod_fun"),
                    rs.getString("nome_f"),
                    rs.getString("tel_f"),
                    rs.getString("tp_usuario"),
                });
                    
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }

    private void preencheCampos(int cod_fun) {
        try {
            funcionarioDTO.setCod_fun(cod_fun);
            rs = funcionarioCTR.consultarFuncionario(funcionarioDTO, medicoDTO, biomedicoDTO, loginDTO);
            btn_salvar.setEnabled(false);
            btn_excluir.setEnabled(true);
            btn_editar.setEnabled(true);
            if (rs.next()) {

                
                
                nome_f.setText(rs.getString("nome_f"));
                tel_f.setText(rs.getString("tel_f"));
                endereco.setText(rs.getString("endereco"));
                rg.setText(rs.getString("rg"));
                crm.setText(rs.getString("crm"));
                cpf.setText(rs.getString("cpf"));
                cep.setText(rs.getString("cep"));
                nome_login.setText(rs.getString("nome_login"));
                senha.setText(rs.getString("senha"));
                data_nasc.setValue(rs.getString("data_nasc"));
                
         
                      
                
         if (rs.getString("tp_usuario").equalsIgnoreCase("med")) {
            especializacao_med.setText(rs.getString("especializacao_med"));
            med.setSelected(true);
            cargo_bio.setEditable(false);
            especializacao_med.setEditable(true);
        } else if (rs.getString("tp_usuario").equalsIgnoreCase("fun")) {
           cargo_bio.setText(rs.getString("cargo_bio"));
           bio.setSelected(true);
           especializacao_med.setEditable(false);
           cargo_bio.setEditable(true);
        } else if (rs.getString("tp_usuario").equalsIgnoreCase("adm")) {
            cargo_bio.setText(rs.getString("cargo_bio"));
            adm.setSelected(true);
            especializacao_med.setEditable(false);
            cargo_bio.setEditable(true);
        }
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }
    
    private void excluir(){
        funcionarioCTR.excluirFuncionario(funcionarioDTO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nome_f = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        endereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bio = new javax.swing.JRadioButton();
        med = new javax.swing.JRadioButton();
        tel_f = new javax.swing.JFormattedTextField();
        cpf = new javax.swing.JFormattedTextField();
        rg = new javax.swing.JFormattedTextField();
        adm = new javax.swing.JRadioButton();
        cep = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        nome_login = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        senha = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        especializacao_med = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cargo_bio = new javax.swing.JTextField();
        data_nasc = new javax.swing.JFormattedTextField();
        crm = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_cancelar = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        bnt_mostrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfun_f = new javax.swing.JTable();
        mostrar = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1117, 580));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Funcionário");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("CPF:");

        jLabel8.setText("CEP:");

        jLabel9.setText("RG:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("CRM:");

        jLabel5.setText("Data de nascimento:");

        jLabel6.setText("Endereço:");

        buttonGroup1.add(bio);
        bio.setText("Biomédico");
        bio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bioActionPerformed(evt);
            }
        });

        buttonGroup1.add(med);
        med.setText("Médico");
        med.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medActionPerformed(evt);
            }
        });

        try {
            tel_f.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            rg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        buttonGroup1.add(adm);
        adm.setText("Administrador");
        adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admActionPerformed(evt);
            }
        });

        try {
            cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Usuário:");

        jLabel12.setText("Senha:");

        jLabel13.setText("Especialização");

        jLabel14.setText("Cargo");

        try {
            data_nasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            crm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(nome_f, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(rg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(tel_f, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(senha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(data_nasc, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(bio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(med)
                                .addGap(18, 18, 18)
                                .addComponent(adm))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(especializacao_med, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(cargo_bio, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nome_login, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(crm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(220, 220, 220))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nome_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tel_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(data_nasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(nome_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bio)
                    .addComponent(med)
                    .addComponent(adm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(especializacao_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(cargo_bio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_salvar.setText("Salvar");
        btn_salvar.setPreferredSize(new java.awt.Dimension(85, 44));
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
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
                .addGap(45, 45, 45)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_limpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(357, 85));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Funcionários atuais");

        bnt_mostrar.setText("Mostrar");
        bnt_mostrar.setPreferredSize(new java.awt.Dimension(83, 25));
        bnt_mostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bnt_mostrarMouseClicked(evt);
            }
        });
        bnt_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_mostrarActionPerformed(evt);
            }
        });

        tfun_f.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Nome", "Telefone", "Tipo de usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tfun_f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfun_fMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tfun_f);
        if (tfun_f.getColumnModel().getColumnCount() > 0) {
            tfun_f.getColumnModel().getColumn(0).setResizable(false);
            tfun_f.getColumnModel().getColumn(0).setPreferredWidth(20);
            tfun_f.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(mostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bnt_mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnt_mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        alterar();
        limpaCampos();
        preencheTabela("");
        btn_editar.setEnabled(false);
        btn_excluir.setEnabled(false);
    }//GEN-LAST:event_btn_editarActionPerformed

    private void bnt_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_mostrarActionPerformed
        preencheTabela(mostrar.getText());
    }//GEN-LAST:event_bnt_mostrarActionPerformed

    private void tfun_fMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfun_fMouseClicked
        limpaCampos();
        preencheCampos(Integer.parseInt(String.valueOf(tfun_f.getValueAt(tfun_f.getSelectedRow(), 0))));
    }//GEN-LAST:event_tfun_fMouseClicked

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        limpaCampos();
        preencheTabela("");
    }//GEN-LAST:event_btn_limparActionPerformed

    private void bnt_mostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bnt_mostrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bnt_mostrarMouseClicked

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        excluir();
        preencheTabela("");
        limpaCampos();              
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admActionPerformed
        especializacao_med.setEditable(false);
        cargo_bio.setEditable(true);
    }//GEN-LAST:event_admActionPerformed

    private void bioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bioActionPerformed
        especializacao_med.setEditable(false);
        cargo_bio.setEditable(true);
    }//GEN-LAST:event_bioActionPerformed

    private void medActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medActionPerformed
        cargo_bio.setEditable(false);
        especializacao_med.setEditable(true);
    }//GEN-LAST:event_medActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton adm;
    private javax.swing.JRadioButton bio;
    private javax.swing.JButton bnt_mostrar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton btn_salvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cargo_bio;
    private javax.swing.JFormattedTextField cep;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JFormattedTextField crm;
    private javax.swing.JFormattedTextField data_nasc;
    private javax.swing.JTextField endereco;
    private javax.swing.JTextField especializacao_med;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton med;
    private javax.swing.JTextField mostrar;
    private javax.swing.JTextField nome_f;
    private javax.swing.JTextField nome_login;
    private javax.swing.JFormattedTextField rg;
    private javax.swing.JTextField senha;
    private javax.swing.JFormattedTextField tel_f;
    private javax.swing.JTable tfun_f;
    // End of variables declaration//GEN-END:variables
}
