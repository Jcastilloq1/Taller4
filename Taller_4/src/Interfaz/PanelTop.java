package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collection;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import modelo.RegistroTop10;
import modelo.Top10;

public class PanelTop extends JDialog implements ActionListener
{
	
	private RegistroTop10 registroTop10;
	private Top10 top10;
	private JDialog dialogTop;
	private Collection<RegistroTop10> nombres;
	private JList<String> rank10;
	
	public PanelTop(VentanaPrincipal principal)
    {
		top10 = new Top10();
		top10.cargarRecords(new File("./data/top10.csv"));
		dialogTop = new JDialog(principal);  
        dialogTop.setLocationRelativeTo(principal);
        nombres = top10.darRegistros();
        String[] elementos = new String[10];

        int posicion = 1;
        for (RegistroTop10 i : nombres) 
        {
            String panelito = (posicion + ".     " + i.darNombre() + "               " + i.darPuntos());
            elementos[posicion - 1] = panelito;
            posicion++;
        }

        JList<String> rank10 = new JList<>(elementos);
        JScrollPane scrollableTextArea = new JScrollPane(rank10);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        dialogTop.getContentPane().add(scrollableTextArea);
        rank10.setBorder(new TitledBorder("Rank"));
        dialogTop.setSize(350,250);
        dialogTop.setResizable(false);
        dialogTop.setVisible(true);
        
    }

   

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
