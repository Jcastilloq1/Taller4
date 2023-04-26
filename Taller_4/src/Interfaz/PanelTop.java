package Interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collection;

import javax.swing.DefaultListCellRenderer;
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
	private JDialog dialogTop;
	private Collection<RegistroTop10> nombres;
	private JList<String> rank10;
	private Top10 p10;
	
	public PanelTop(VentanaPrincipal principal, Top10 p10)
    {
		this.p10 = p10;
		p10.cargarRecords(new File("./data/top10.csv"));
		dialogTop = new JDialog(principal);  
        dialogTop.setLocationRelativeTo(principal);
        nombres = p10.darRegistros();
        String[] elementos = new String[10];

        int posicion = 1;
        for (RegistroTop10 registroTop10 : nombres) 
        {
            String panelito = (posicion + ".     " + registroTop10.darNombre() + "               " + registroTop10.darPuntos());
            elementos[posicion - 1] = panelito;
            posicion++;
        }
        
        DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
            private static final long serialVersionUID = 1L;

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Color verde para las primeras 3 posiciones
                if (index == 0 || index == 1 || index == 2) {
                    label.setForeground(Color.GREEN.darker());
                    label.setFont(label.getFont().deriveFont(Font.BOLD));
                }
                // Color rojo para las últimas 3 posiciones
                else if (index == list.getModel().getSize() - 3 || index == list.getModel().getSize() - 2 || index == list.getModel().getSize() - 1) {
                    label.setForeground(Color.RED);
                    label.setFont(label.getFont().deriveFont(Font.BOLD));
                }
                return label;
            }
        };

        JList<String> rank10 = new JList<>(elementos);
        rank10.setCellRenderer(renderer);
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
