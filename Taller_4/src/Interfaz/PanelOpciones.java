package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.TitledBorder;

import modelo.RegistroTop10;
import modelo.Tablero;
import modelo.Top10;

public class PanelOpciones extends JPanel implements ActionListener
{
	
	
	private JButton btnNuevo;    
    private JButton btnReiniciar;
    private JButton btnTop10;
    private JButton btnCambiarJ;
    private JDialog dialogIngNombre;
    private JDialog dialogTop;
    private VentanaPrincipal principal; 
    private JList rank10;     
    private JList listadoNombres;
    private JLabel espacio;
    private Top10 top10;
    private String nombre;
    private JScrollPane scrollableTextArea;
    private Collection<RegistroTop10> nombres;
    
    public PanelOpciones(VentanaPrincipal principal)
    {

    	top10 = new Top10();
    	top10.cargarRecords(new File("./data/top10.csv"));
    	this.principal=principal;
        
        setLayout( new GridLayout( 9,1 ) );
        
        espacio = new JLabel();
        add(espacio);
        
        btnNuevo= new JButton("Nuevo");
        btnNuevo.addActionListener( this );
        btnNuevo.setBackground(new Color(126, 205, 250));
        add(btnNuevo);
        
        espacio = new JLabel();
        add(espacio);
        
        btnReiniciar=new JButton( "Reiniciar");
        btnReiniciar.addActionListener( this );
        add(btnReiniciar);
        
        espacio = new JLabel();
        add(espacio);
        
        btnTop10=new JButton( "Top-10");
        add(btnTop10);
        btnTop10.addActionListener( this );
        
        espacio = new JLabel();
        add(espacio); 
        
        btnCambiarJ = new JButton("Cambiar Jugador");
        add(btnCambiarJ);
        btnCambiarJ.addActionListener( this );
        
      
    }
    
    
    

	@Override
	public void actionPerformed( ActionEvent e )
    {
        if(e.getSource( )==btnNuevo)
        {
        	int tam = principal.darTamano();
            principal.nuevoTablero(tam);
            int dif = principal.darDificultad();
            principal.desordenar();
            repaint();
            nombre = JOptionPane.showInputDialog(principal,"Ingrese su nombre");
            principal.actualizarNombre(nombre);
            int jugadas = principal.darJugadas();
            principal.actualizar(jugadas);
            
            
            
        }
        else if(e.getSource( )==btnReiniciar)
        {
        	principal.reiniciar();
        	int dif = principal.darDificultad();
            principal.desordenar();
            repaint();
      
        }
        
        else if(e.getSource()== btnTop10)
        {
        	dialogTop = new JDialog(principal);  
            dialogTop.setLocationRelativeTo(principal);
            nombres = top10.darRegistros();
            rank10 = new JList();
            rank10 = new JList();
            JScrollPane scrollableTextArea = new JScrollPane(rank10);
            scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
            dialogTop.getContentPane().add(scrollableTextArea);
            rank10.setBorder(new TitledBorder("Rank"));
            dialogTop.setSize(350,250);
            dialogTop.setResizable(false);
            dialogTop.setVisible(true);
            
            //for (int i = 0; i < nombres.size(); i++)
            	
            	//rank10.add(nombres[i]);
            
            
            
   
        	
        }
        else if(e.getSource()== btnCambiarJ)
        {
        	
        }
        
        
    }




	public void agregarRegistro(int puntaje)
	{
		top10.agregarRegistro(nombre, puntaje);
		
	}
	

}
