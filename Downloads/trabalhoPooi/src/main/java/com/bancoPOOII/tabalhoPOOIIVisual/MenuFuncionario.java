
package com.bancoPOOII.tabalhoPOOIIVisual;
import com.bancoPOOII.trabalhoPooi.TrabalhoPooiApplication;
import com.bancoPOOII.trabalhoPooi.dto.ContasDTO;
import com.bancoPOOII.trabalhoPooi.entity.Contas;
import com.bancoPOOII.trabalhoPooi.service.ContasService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class MenuFuncionario extends javax.swing.JFrame implements ActionListener{
    
    public MenuFuncionario() {
        initComponents();
        ftTipo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                String tipoSelecionado = (String) ftTipo.getSelectedItem();
                ftLimite.setEnabled(false);
                    ftLimite.setValue(0);
                    ftRendimento.setEnabled(false);
                    ftRendimento.setValue(0);
                if (tipoSelecionado == ("Conta Especial")) {
                    ftLimite.setEnabled(true);
                } else if (tipoSelecionado == ("Conta Poupança")) {
                    ftRendimento.setEnabled(true);
                }
            }
        });
        readJTable();
    }
    
    public void readJTable() {
    DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
    modelo.setNumRows(0); // Limpa a tabela antes de preencher

        try {
            String response = HttpClientUtil.getRequest("/contas/buscar-contas");
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Contas>>() {}.getType();
            List<Contas> contasList = new Gson().fromJson(response, listType);

            for (Contas conta : contasList) {
                modelo.addRow(new Object[]{
                    conta.getId(),
                    conta.getNumero(),
                    conta.getNome(),
                    conta.getTipo(),
                    conta.getSaldo(),
                    conta.getLimite(),
                    conta.getRendimento()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ftNome = new javax.swing.JFormattedTextField();
        ftNumero = new javax.swing.JFormattedTextField();
        ftSaldo = new javax.swing.JFormattedTextField();
        ftLimite = new javax.swing.JFormattedTextField();
        ftRendimento = new javax.swing.JFormattedTextField();
        ftTipo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        ftPesquisa = new javax.swing.JFormattedTextField();
        bPesquisar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bInserir = new javax.swing.JButton();
        bAtualizar = new javax.swing.JButton();
        bDeletar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("CLIQUE AQUI PARA VOLTAR PARA O MENU INICIAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(130, 205, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nome do Cliente:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Número da Conta:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tipo da conta:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Saldo Inicial da Conta:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Valor do Limite:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Valor do Rendimento (%):");

        ftNumero.setText("número preenchido automaticamente");
        ftNumero.setEnabled(false);

        ftSaldo.setText("0");

        ftLimite.setText("0");

        ftRendimento.setText("0");

        ftTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Conta Corrente", "Conta Especial", "Conta Poupança" }));
        ftTipo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                String tipoSelecionado = (String) ftTipo.getSelectedItem();
                if (tipoSelecionado == ("Conta Corrente")) {
                    ftLimite.setEnabled(false);
                    ftLimite.setValue(0);
                    ftRendimento.setEnabled(false);
                    ftRendimento.setValue(0);
                } else if (tipoSelecionado == ("Conta Especial")) {
                    ftLimite.setEnabled(true);
                    ftRendimento.setEnabled(false);
                    ftRendimento.setValue(0);
                } else if (tipoSelecionado == ("Conta Poupança")) {
                    ftLimite.setEnabled(false);
                    ftLimite.setValue(0);
                    ftRendimento.setEnabled(true);
                }
            }
        });
        ftTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ftTipoMouseClicked(evt);
            }
        });
        ftTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ftTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ftNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ftNome, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ftRendimento)
                    .addComponent(ftLimite)
                    .addComponent(ftSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ftSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(ftLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ftRendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ftNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ftNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3))
                            .addComponent(ftTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(130, 205, 255));

        ftPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftPesquisaActionPerformed(evt);
            }
        });

        bPesquisar.setText("PESQUISAR");
        bPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(ftPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(bPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(ftPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(130, 205, 255));

        bInserir.setText("INSERIR");
        bInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInserirActionPerformed(evt);
            }
        });

        bAtualizar.setText("ATUALIZAR");
        bAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtualizarActionPerformed(evt);
            }
        });

        bDeletar.setText("DELETAR");
        bDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(bInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(bDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable2.setBackground(new java.awt.Color(165, 219, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Numero", "Nome", "Tipo", "Saldo", "Llimite", "Rendimento"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setHeaderValue("Id");
            jTable2.getColumnModel().getColumn(1).setHeaderValue("Numero");
            jTable2.getColumnModel().getColumn(2).setHeaderValue("Nome");
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Tipo");
            jTable2.getColumnModel().getColumn(4).setHeaderValue("Saldo");
            jTable2.getColumnModel().getColumn(5).setHeaderValue("Llimite");
            jTable2.getColumnModel().getColumn(6).setHeaderValue("Rendimento");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MenuInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ftPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftPesquisaActionPerformed

    private void ftTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftTipoActionPerformed

    private void bInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInserirActionPerformed

            try {
                
                String tipoSelecionado = ftTipo.getSelectedItem().toString();
                double limite = 0.0;
                double rendimento = 0.0;

                if ("Conta Especial".equals(tipoSelecionado)) {
                    limite = Double.parseDouble(ftLimite.getText());
                } else if ("Conta Poupança".equals(tipoSelecionado)) {
                    rendimento = Double.parseDouble(ftRendimento.getText());
                }

                ContasDTO contaDto = new ContasDTO();
                contaDto.setNome(ftNome.getText());
                contaDto.setNumero(0);
                contaDto.setTipo(tipoSelecionado);
                contaDto.setLimite(limite);
                contaDto.setRendimento(rendimento);

                // Criar JSON para a requisição
                String jsonInputString = "{" +

                        "\"nome\":\"" + ftNome.getText() + "\"," +
                        "\"saldo\":" + Double.parseDouble(ftSaldo.getText()) + "," +
                        "\"limite\":" + limite + "," +
                        "\"rendimento\":" + rendimento + "," +
                        "\"tipo\":\"" + tipoSelecionado + "\"" +
                        "}";

                // Fazer requisição POST para criar conta
                HttpClientUtil.postRequest("/contas", jsonInputString);
                JOptionPane.showMessageDialog(null, "Conta criada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao criar conta: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Verifique os valores numéricos.", "Erro de Formato", JOptionPane.WARNING_MESSAGE);
            }

            // Limpar campos e atualizar tabela
            ftNome.setText("");
            ftSaldo.setText("0");
            ftLimite.setText("0");
            ftRendimento.setText("0");
            readJTable();
    }//GEN-LAST:event_bInserirActionPerformed

    private void bAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtualizarActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (jTable2.getSelectedRow() != -1) {
            try {
                // Determinar valores de limite e rendimento com base no tipo selecionado
                String tipoSelecionado = ftTipo.getSelectedItem().toString();
                double limite = 0.0;
                double rendimento = 0.0;

                if ("Conta Especial".equals(tipoSelecionado)) {
                    limite = Double.parseDouble(ftLimite.getText());
                } else if ("Conta Poupança".equals(tipoSelecionado)) {
                    rendimento = Double.parseDouble(ftRendimento.getText());
                }

                // Recuperar o ID da conta selecionada
                int idConta = (int) jTable2.getValueAt(jTable2.getSelectedRow(), 0); // Aqui assume-se que a primeira coluna contém o ID da conta

                // Criar o objeto ContasDTO com os dados atualizados
                ContasDTO contaDto = new ContasDTO();
                contaDto.setId(idConta);
                contaDto.setNome(ftNome.getText());
                contaDto.setTipo(tipoSelecionado);
                contaDto.setLimite(limite);
                contaDto.setRendimento(rendimento);
                contaDto.setSaldo(Double.parseDouble(ftSaldo.getText()));

                // Criar JSON para a requisição PUT
                String jsonInputString = "{" +
                        "\"id\":" + idConta + "," +
                        "\"nome\":\"" + ftNome.getText() + "\"," +
                        "\"numero\":" + jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString() + "," +
                        "\"saldo\":" + Double.parseDouble(ftSaldo.getText()) + "," +
                        "\"limite\":" + limite + "," +
                        "\"rendimento\":" + rendimento + "," +
                        "\"tipo\":\"" + tipoSelecionado + "\"" +
                        "}";
                // Fazer requisição PUT para atualizar conta
                HttpClientUtil.putRequest("/contas/" + idConta, jsonInputString);
                JOptionPane.showMessageDialog(null, "Conta atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar conta: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Verifique os valores numéricos.", "Erro de Formato", JOptionPane.WARNING_MESSAGE);
            }

            // Limpar campos e atualizar tabela
            ftNome.setText("");
            ftSaldo.setText("0");
            ftLimite.setText("0");
            ftRendimento.setText("0");
            readJTable();
        }
    }//GEN-LAST:event_bAtualizarActionPerformed

    private void bDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletarActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (jTable2.getSelectedRow() != -1) {
        try {
        int idConta = (int) jTable2.getValueAt(jTable2.getSelectedRow(), 0); // Aqui assume-se que a primeira coluna contém o ID da conta
        HttpClientUtil.deleteRequest("/contas/" + idConta);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir conta: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        readJTable();
    }
    }//GEN-LAST:event_bDeletarActionPerformed
    public void jTable2KeyReleased(java.awt.event.KeyEvent evt){
        // Recuperar os dados da linha selecionada
        String numero = jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString();
        String nome = jTable2.getValueAt(jTable2.getSelectedRow(),2).toString();
        String tipo = jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString();
        String saldo = jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString();
        String limite = jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString();
        String rendimento = jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString();

        // Preencher os campos de texto com os dados da linha selecionada
        ftNome.setText(nome);
        ftNumero.setText(numero);
        ftTipo.setSelectedItem(tipo);
        ftSaldo.setText(saldo);
        ftLimite.setText(limite);
        ftRendimento.setText(rendimento);
    
    }
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        
        String numero = jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString();
        String nome = jTable2.getValueAt(jTable2.getSelectedRow(),2).toString();
        String tipo = jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString();
        String saldo = jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString();
        String limite = jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString();
        String rendimento = jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString();

        // Preencher os campos de texto com os dados da linha selecionada
        ftNome.setText(nome);
        ftNumero.setText(numero);
        
        // Se você tiver um campo de ComboBox para o tipo de conta
        ftTipo.setSelectedItem(tipo);
        
        // Preencher os campos de texto com valores numéricos
        ftSaldo.setText(saldo);
        ftLimite.setText(limite);
        ftRendimento.setText(rendimento);
    }//GEN-LAST:event_jTable2MouseClicked

    private void ftTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ftTipoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ftTipoMouseClicked

    private void bPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisarActionPerformed
        DefaultTableModel ob = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        jTable1.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(ftPesquisa.getText()));
        readJTable();
    }//GEN-LAST:event_bPesquisarActionPerformed

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtualizar;
    private javax.swing.JButton bDeletar;
    private javax.swing.JButton bInserir;
    private javax.swing.JButton bPesquisar;
    private javax.swing.JFormattedTextField ftLimite;
    private javax.swing.JFormattedTextField ftNome;
    private javax.swing.JFormattedTextField ftNumero;
    private javax.swing.JFormattedTextField ftPesquisa;
    private javax.swing.JFormattedTextField ftRendimento;
    private javax.swing.JFormattedTextField ftSaldo;
    private javax.swing.JComboBox<String> ftTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
