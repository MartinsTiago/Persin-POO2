/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import control.DisciplinaControl;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Aula;
import model.DisciplinaAluno;
import model.Professor;

/**
 *
 * @author araujot
 */
public class CadastroDisciplinaAluno extends CadastroDisciplina{
    JTextField nomeProfessor ;
    JTextField emailProfessor;
    JTextField salaProfessor;


    @Override
    public void initComponents() {
        super.initComponents();

        JLabel JLabel7 = new JLabel();
        JLabel7.setText("Email:");
        JLabel7.setBounds(330,27,92,28);
        add(JLabel7);

        emailProfessor = new JTextField();
        emailProfessor.setBounds(390,27,190,28);
        add(emailProfessor);

        JLabel JLabel6 = new JLabel();
        JLabel6.setText("Professor:");
        JLabel6.setBounds(330,60,92,28);
        add(JLabel6);

       nomeProfessor = new JTextField();
       nomeProfessor.setBounds(390,60,80,28);
       add(nomeProfessor);

       JLabel JLabel8 = new JLabel();
        JLabel8.setText("Sala:");
        JLabel8.setBounds(470,60,92,28);
        add(JLabel8);

       salaProfessor = new JTextField();
       salaProfessor.setBounds(500,60,80,28);
       add(salaProfessor);


    }

    @Override
    public void gravarDisciplina() {
        sala = getSalaAula().getText().toString();
        professor = nomeProfessor.getText().toString();
        professorEmail = emailProfessor.getText().toString();
        salaProf = salaProfessor.getText().toString();
        disciplina = getNomeDisciplina().getText().toString();
        disciplinaID = getIdDisciplina().getText().toString();


        Professor pf = new Professor(professor, professorEmail, salaProf);
        linhasTabela = getTabelaDiaAula().getRowCount();
        DisciplinaAluno ds = new DisciplinaAluno(disciplinaID, disciplina, pf, sala);
        while(linhasTabela>0)
        {
            diaSemanaAula = getTabelaDiaAula().getValueAt(linhasTabela-1, 1).toString();
            horaAula = getTabelaDiaAula().getValueAt(linhasTabela-1, 2).toString();

            ds.getAulas().add(new Aula(diaSemanaAula, horaAula));
            linhasTabela--;
        }
        linhasTabela = getTabBibliografia().getRowCount();
        while(linhasTabela>0)
        {
            livros = getTabBibliografia().getValueAt(linhasTabela-1, 0).toString();
            ds.getBibliografia().add(livros);
            linhasTabela--;
        }

        DisciplinaControl.save(ds);
        DisciplinaControl.getDisciplinas().add(ds);
    }

}


