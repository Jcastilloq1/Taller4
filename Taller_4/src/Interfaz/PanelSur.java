package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Tablero;

public class PanelSur extends JPanel
{
	
	private JLabel jugadasLabel;
	private JLabel jugador;
	private JButton btn1;	
	private JTextField jds;	
	private VentanaPrincipal principal;
	private Tablero tablero;
	private int jugadas;
	private String result;
	private JTextField jugs;
	
	public PanelSur(VentanaPrincipal principal)
	{
		this.principal=principal;
		this.tablero = tablero;
		
		setLayout( new GridLayout( 1,4 ) );
		
		jugadasLabel = new JLabel("Jugadas: ");
		jugadasLabel.setOpaque(true);
		add(jugadasLabel);
		
		jugadas = principal.darJugadas();
		jds= new JTextField();
		jds.setEditable(false);
		result = String.valueOf(jugadas);  
	    jds.setText(result);  
		add(jds);
        
        jugador =new JLabel( "Jugador: ");
        add(jugador);
        
        jugs= new JTextField();
        jugs.setEditable(false);
		add(jugs);
        
      
		
		
	}
	public void actualizarCantidadJugadas(int cantJugadas)
	{
		jds.setText(cantJugadas+"");
		
	}
	public void actualizarNombre(String nombre) 
	{
		jugs.setText(nombre);
		
	}
	
	

}
