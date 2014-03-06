/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DisciplinaControl;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Aula;
import model.Professor;
import javax.swing.table.DefaultTableModel;


public class CadastroDisciplina extends javax.swing.JInternalFrame {

   public String dia, horaAula, livros, horas, minutos, professor, professorEmail, sala, salaProf, disciplina, disciplinaID, horarioAula,diaSemanaAula ;
    int contaLinhas = 0, contaLinhas2 = 0, linhaTabela, linhasTabela;



    //public GroupLayout getLayout() {
    //    return layout;
    //}
    /**
     * Creates new form Teste
     */
    public CadastroDisciplina() {
        initComponents();
        this.setTitle("Cadastro de Disciplinas");
        this.setLocation(410, 0);
        this.setClosable(true);
        listaDiaSemana();
    }

     public void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabBibliografia = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        nomeDisciplina = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        livro = new javax.swing.JTextField();
        addLivro = new javax.swing.JButton();
        remveLivro = new javax.swing.JButton();
        salaAula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addDiaHora = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDiaAula = new javax.swing.JTable();
        remvDiaHora = new javax.swing.JButton();
        horaSpinner = new javax.swing.JSpinner();
        minSpinner = new javax.swing.JSpinner();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        idDisciplina = new javax.swing.JTextField();
        diaSemana = new javax.swing.JComboBox();

        setResizable(true);

        jLabel2.setText("Nome Disciplina:");

        tabBibliografia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {                
            },
            new String [] {
                "Bibliografia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabBibliografia);
        if (tabBibliografia.getColumnModel().getColumnCount() > 0) {
            tabBibliografia.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel3.setText("Sala:");

        nomeDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeDisciplinaActionPerformed(evt);
            }
        });

        jLabel10.setText("Livro:");

        addLivro.setText("Adicionar Livro");
        addLivro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLivroActionPerformed(evt);
            }
        });

        remveLivro.setText("Remover Livro");
        remveLivro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        remveLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remveLivroActionPerformed(evt);
            }
        });

        salaAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaAulaActionPerformed(evt);
            }
        });

        jLabel4.setText("Dia:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Bibliografia");

        jLabel5.setText("Horário:");

        addDiaHora.setText("Adicionar Dia/HoraAula");
        addDiaHora.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addDiaHora.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDiaHoraActionPerformed(evt);
            }
        });

        tabelaDiaAula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Disciplina", "Dia", "Hora/Aula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaDiaAula);
        if (tabelaDiaAula.getColumnModel().getColumnCount() > 0) {
            tabelaDiaAula.getColumnModel().getColumn(0).setResizable(false);
            tabelaDiaAula.getColumnModel().getColumn(1).setResizable(false);
            tabelaDiaAula.getColumnModel().getColumn(2).setResizable(false);
        }

        remvDiaHora.setText("Remover Dia/HoraAula");
        remvDiaHora.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        remvDiaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remvDiaHoraActionPerformed(evt);
            }
        });

        horaSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));
        horaSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        minSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLabel11.setText("Sigla Disciplina:");

        diaSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaSemanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addDiaHora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remvDiaHora))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(horaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(idDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(salaAula))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(livro, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(addLivro)
                        .addGap(24, 24, 24)
                        .addComponent(remveLivro)))
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(btSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(salaAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(idDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(horaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(minSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(diaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(remvDiaHora))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addDiaHora)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(livro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addLivro)
                            .addComponent(remveLivro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btSalvar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>



    private void nomeDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addLivroActionPerformed(java.awt.event.ActionEvent evt) {
        livros = livro.getText().toString();
        preencheBibliografia(livros);
        limpaBibliografia();
    }

    private void remveLivroActionPerformed(java.awt.event.ActionEvent evt) {
        linhaTabela = tabBibliografia.getSelectedRow();
        removeBibliografia(linhaTabela);
    }

    private void salaAulaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addDiaHoraActionPerformed(java.awt.event.ActionEvent evt) {
        gravarDiaHorario();
    }

    private void remvDiaHoraActionPerformed(java.awt.event.ActionEvent evt) {
        removerDiaHorario();
    }

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        gravarDisciplina();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();
    }

    private void diaSemanaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void limpaBibliografia()
    {
        livro.setText("");
    }

    public void listaDiaSemana() {
        diaSemana.addItem("Segunda");
        diaSemana.addItem("Terça");
        diaSemana.addItem("Quarta");
        diaSemana.addItem("Quinta");
        diaSemana.addItem("Sexta");
        diaSemana.addItem("Sabado");
    }

    public void preencher_tabela(String idDisc, String dia, String horaAula) {
        //Conexao.conectar();
        DefaultTableModel modelo = (DefaultTableModel) tabelaDiaAula.getModel();
        modelo.setNumRows(contaLinhas);
        modelo.addRow(new Object[]{idDisc,dia,horaAula});
        contaLinhas++;
    }

    public void removerDaTabela(int linha){
        DefaultTableModel modelo = (DefaultTableModel) tabelaDiaAula.getModel();
        System.out.println(modelo);
        modelo.removeRow(linha);
        contaLinhas--;
    }

    public void preencheBibliografia(String livro)
    {
        DefaultTableModel bibliografia = (DefaultTableModel) tabBibliografia.getModel();
        bibliografia.setNumRows(contaLinhas2);
        bibliografia.addRow(new Object[]{livro});
        contaLinhas2++;
    }

    public void removeBibliografia(int linha)
    {
        DefaultTableModel bibliografia = (DefaultTableModel) tabBibliografia.getModel();
        bibliografia.removeRow(linha);
        contaLinhas2--;
    }

    public void gravarDiaHorario()
    {
        Aula aula = new Aula();
        dia = diaSemana.getSelectedItem().toString();
        horas = horaSpinner.getValue().toString();
        minutos = minSpinner.getValue().toString();
        horaAula = horas+":"+minutos;
        disciplinaID = idDisciplina.getText().toString();
        preencher_tabela(disciplinaID,dia,horaAula);
    }

    public void removerDiaHorario()
    {
        linhaTabela = tabelaDiaAula.getSelectedRow();
        removerDaTabela(linhaTabela);
        disciplinaID = tabelaDiaAula.getValueAt(linhaTabela, 0).toString();

    }


    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraAula() {
        return horaAula;
    }

    public void setHoraAula(String horaAula) {
        this.horaAula = horaAula;
    }

    public String getLivros() {
        return livros;
    }

    public void setLivros(String livros) {
        this.livros = livros;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getProfessorEmail() {
        return professorEmail;
    }

    public void setProfessorEmail(String professorEmail) {
        this.professorEmail = professorEmail;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getSalaProf() {
        return salaProf;
    }

    public void setSalaProf(String salaProf) {
        this.salaProf = salaProf;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDisciplinaID() {
        return disciplinaID;
    }

    public void setDisciplinaID(String disciplinaID) {
        this.disciplinaID = disciplinaID;
    }

    public String getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(String horarioAula) {
        this.horarioAula = horarioAula;
    }

    public String getDiaSemanaAula() {
        return diaSemanaAula;
    }

    public void setDiaSemanaAula(String diaSemanaAula) {
        this.diaSemanaAula = diaSemanaAula;
    }

    public int getContaLinhas() {
        return contaLinhas;
    }

    public void setContaLinhas(int contaLinhas) {
        this.contaLinhas = contaLinhas;
    }

    public int getContaLinhas2() {
        return contaLinhas2;
    }

    public void setContaLinhas2(int contaLinhas2) {
        this.contaLinhas2 = contaLinhas2;
    }

    public int getLinhaTabela() {
        return linhaTabela;
    }

    public void setLinhaTabela(int linhaTabela) {
        this.linhaTabela = linhaTabela;
    }

    public int getLinhasTabela() {
        return linhasTabela;
    }

    public void setLinhasTabela(int linhasTabela) {
        this.linhasTabela = linhasTabela;
    }

    public JButton getAddDiaHora() {
        return addDiaHora;
    }

    public void setAddDiaHora(JButton addDiaHora) {
        this.addDiaHora = addDiaHora;
    }

    public JButton getAddLivro() {
        return addLivro;
    }

    public void setAddLivro(JButton addLivro) {
        this.addLivro = addLivro;
    }

    public JButton getBtCancelar() {
        return btCancelar;
    }

    public void setBtCancelar(JButton btCancelar) {
        this.btCancelar = btCancelar;
    }

    public JButton getBtSalvar() {
        return btSalvar;
    }

    public void setBtSalvar(JButton btSalvar) {
        this.btSalvar = btSalvar;
    }

    public JComboBox getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(JComboBox diaSemana) {
        this.diaSemana = diaSemana;
    }

    public JSpinner getHoraSpinner() {
        return horaSpinner;
    }

    public void setHoraSpinner(JSpinner horaSpinner) {
        this.horaSpinner = horaSpinner;
    }

    public JTextField getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(JTextField idDisciplina) {
        this.idDisciplina = idDisciplina;
    }


    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }


    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTextField getLivro() {
        return livro;
    }

    public void setLivro(JTextField livro) {
        this.livro = livro;
    }

    public JSpinner getMinSpinner() {
        return minSpinner;
    }

    public void setMinSpinner(JSpinner minSpinner) {
        this.minSpinner = minSpinner;
    }

    public JTextField getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(JTextField nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }


    public JButton getRemvDiaHora() {
        return remvDiaHora;
    }

    public void setRemvDiaHora(JButton remvDiaHora) {
        this.remvDiaHora = remvDiaHora;
    }

    public JButton getRemveLivro() {
        return remveLivro;
    }

    public void setRemveLivro(JButton remveLivro) {
        this.remveLivro = remveLivro;
    }

    public JTextField getSalaAula() {
        return salaAula;
    }

    public void setSalaAula(JTextField salaAula) {
        this.salaAula = salaAula;
    }

    public JTable getTabBibliografia() {
        return tabBibliografia;
    }

    public void setTabBibliografia(JTable tabBibliografia) {
        this.tabBibliografia = tabBibliografia;
    }

    public JTable getTabelaDiaAula() {
        return tabelaDiaAula;
    }

    public void setTabelaDiaAula(JTable tabelaDiaAula) {
        this.tabelaDiaAula = tabelaDiaAula;
    }





    public void gravarDisciplina(){};

    // Variables declaration - do not modify
    private javax.swing.JButton addDiaHora;
    private javax.swing.JButton addLivro;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox diaSemana;
    private javax.swing.JSpinner horaSpinner;
    private javax.swing.JTextField idDisciplina;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField livro;
    private javax.swing.JSpinner minSpinner;
    private javax.swing.JTextField nomeDisciplina;
    private javax.swing.JButton remvDiaHora;
    private javax.swing.JButton remveLivro;
    private javax.swing.JTextField salaAula;
    private javax.swing.JTable tabBibliografia;
    private javax.swing.JTable tabelaDiaAula;
    // End of variables declaration
}
