import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;


class TelaAgenda extends JFrame {
    
    public static final int LARGURA = 1024;
    public static final int ALTURA = 500;

    JPanel JPCentral;
    JPanel JPDados;
    JPanel JPDadosWestVertical;
    JPanel JPNome;
    JPanel JPTelefone;
    JPanel JPCodigo;
    JPanel JPEndereco;
    JPanel JPBotoes;
    JPanel JPAnotacoes;

    JLabel JLNome;
    JTextField JTFNome;

    JLabel JLTelefone;
    JTextField JTFTelefone;

    JLabel JLCodigo;
    JTextField JTFCodigo;

    JLabel JLEndereco;
    JTextField JTFEndereco;

    JLabel JLAnotacoes;
    JTextArea JTAAnotacoes;

    JButton JBConsultar;
    JButton JBInserir;
    JButton JBAlterar;
    JButton JBExcluir;
    JButton JBLimpar;

    JTable JTTabelaContatos;
    DefaultTableModel modeloTabelaContatos;


    
    public TelaAgenda(){

        setSize(TelaAgenda.LARGURA, TelaAgenda.ALTURA);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        montarLayout();

        setVisible(true);
        setFont(new Font("Arial", Font.BOLD, 25));
    }

    private void montarLayout(){
        JLabel JLbanner = new JLabel(new ImageIcon("./banner.png"));

        getContentPane().add("North", JLbanner);

        JPCentral = new JPanel();//Border 1
        JPCentral.setLayout(new BorderLayout());

        JPDados = new JPanel(); //Border 2
        JPDados.setLayout(new BorderLayout());
        JPDados.setBackground(Color.yellow);
        //JPDados.add("West", new JLabel("Teste"));
        JPCentral.add("West", JPDados);

        JPDadosWestVertical = new JPanel();
        JPDadosWestVertical.setLayout(new BoxLayout(JPDadosWestVertical,BoxLayout.Y_AXIS));
        JPDados.add("West", JPDadosWestVertical);

        JPCodigo = new JPanel();
        JLCodigo = new JLabel("Codigo");
        JTFCodigo = new JTextField(10);

        JPCodigo.setLayout(new FlowLayout());
        JPCodigo.add(JLCodigo);
        JPCodigo.add(JTFCodigo);
        JPDadosWestVertical.add(JPCodigo);

        JPNome = new JPanel();
        JLNome = new JLabel("Nome:");
        JTFNome = new JTextField(10);

        JPNome.setLayout(new FlowLayout());
        JPNome.add(JLNome);
        JPNome.add(JTFNome);
        JPDadosWestVertical.add(JPNome);

        JPEndereco = new JPanel();
        JLEndereco = new JLabel("Endereço");
        JTFEndereco = new JTextField(10);

        JPEndereco.setLayout(new FlowLayout());
        JPEndereco.add(JLEndereco);
        JPEndereco.add(JTFEndereco);
        JPDadosWestVertical.add(JPEndereco);

        JPTelefone = new JPanel();
        JPTelefone.setLayout(new FlowLayout());
        JLTelefone = new JLabel("Telefone");
        JTFTelefone = new JTextField(10);
        JPTelefone.add(JLTelefone);
        JPTelefone.add(JTFTelefone);
        JPDadosWestVertical.add(JPTelefone);

        JPDadosWestVertical.add(Box.createVerticalStrut(500));

        JPBotoes = new JPanel();
        JPBotoes.setLayout(new FlowLayout());
        JBConsultar = new JButton("Consultar");
        JBInserir = new JButton("Inserir");
        JBAlterar = new JButton("Alterar");
        JBLimpar = new JButton("Limpar");
        ActionListener acaoBotoes = new AcaoBotoes();
        JBInserir.addActionListener(acaoBotoes);
        JBExcluir = new JButton("Excluir");
        JPBotoes.add(JBInserir);
        JPBotoes.add(JBConsultar);
        JPBotoes.add(JBAlterar);
        JPBotoes.add(JBExcluir);
        JPBotoes.add(JBLimpar);

        JPDados.add("South", JPBotoes);

        JPAnotacoes = new JPanel();
        JPAnotacoes.setLayout(new BoxLayout(JPAnotacoes, BoxLayout.Y_AXIS));
        JLAnotacoes = new JLabel("Anotações");
        JTAAnotacoes = new JTextArea(100, 20);
        JPAnotacoes.add(JLAnotacoes);
        JPAnotacoes.add(JTAAnotacoes);

        JPDados.add("Center", JPAnotacoes);

        JPanel JPColunaDireita = new JPanel();
        JPColunaDireita.setLayout(new BoxLayout(JPColunaDireita, BoxLayout.X_AXIS));
        JPColunaDireita.add(Box.createHorizontalStrut(15));

        JPDados.add("East", JPColunaDireita);

       
        modeloTabelaContatos = new DefaultTableModel();
        modeloTabelaContatos.addColumn("Nome");
        modeloTabelaContatos.addColumn("Telefone");
        modeloTabelaContatos.addColumn("Anotações");
        Object[] linha = {"coluna1",9999888,"coluna3"};
        modeloTabelaContatos.addRow(linha);
        linha = new Object[] {"Joaquim",1111111,"Porteiro"};
        modeloTabelaContatos.addRow(linha);

        JTTabelaContatos = new JTable(modeloTabelaContatos);
       
        JScrollPane jspTabelaContatos = new JScrollPane(JTTabelaContatos);


        JPCentral.add("Center", jspTabelaContatos);

        getContentPane().add("Center", JPCentral);
        JPCentral.setBackground(Color.green);
    }

    private class AcaoBotoes implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "Oi!!");

        }

    }

}
