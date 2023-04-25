package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class PanelNorte extends JPanel  implements ActionListener
{
	
	private JLabel etiquetaImagen;
	
	private VentanaPrincipal principal;
    private JButton[] btnCalificacion;
    private JLabel tamano;
    private JLabel dificultad;
    private JComboBox opcionesTamano;
    private String[] opTamano;
    private JRadioButton opcionDif1;
    private JRadioButton opcionDif2;
    private JRadioButton opcionDif3;
    private String seleccionado;
    private int intSeleccionado;
    private int intSeleccionadoD;
    
    public PanelNorte(VentanaPrincipal ventanaPrincipal)
    {
    
        principal= ventanaPrincipal;
        setLayout( new GridLayout( 1,3 ) );
        setBackground(new Color(126, 205, 250));
        
        tamano = new JLabel("Tamaño: ");
		tamano.setOpaque(true);
		tamano.setBackground(new Color(126, 205, 250));
		add(tamano); 
	
		String opTamano[] = {"3X3", "5X5", "7X7"};
		opcionesTamano = new JComboBox(opTamano);
		add(opcionesTamano);

		
		dificultad = new JLabel("Dificultad: ");
		dificultad.setOpaque(true);
		add(dificultad);
		dificultad.setBackground(new Color(126, 205, 250));
		
		opcionDif1 = new JRadioButton("Facil");
		add(opcionDif1);
		
		opcionDif2 = new JRadioButton("Medio");
		add(opcionDif2);

		opcionDif3 = new JRadioButton("Dificil");
		add(opcionDif3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(opcionDif1);bg.add(opcionDif2);bg.add(opcionDif3);
			
	
		
		
        
        
        
        

    }
    
    public int darTamano()
    {
    	seleccionado  = (String)opcionesTamano.getSelectedItem();
    	if (seleccionado.equals("3X3")) 
    	{
			intSeleccionado = 3;
		}
    	
    	else if (seleccionado.equals("5X5"))
    	{
    		intSeleccionado = 5;
    	}
    	
    	else
    	{	
    		intSeleccionado = 7;
    	}
    	
    	return intSeleccionado;
    }
    
    public int darDificultad() 
    {
    	if (opcionDif1.isSelected()) 
    	{
			intSeleccionadoD = 1;
		}
    	
    	else if (opcionDif2.isSelected())
    	{
    		intSeleccionadoD = 2;
    	}
    	
    	else
    	{	
    		intSeleccionadoD = 3;
    	}
    	
    	return intSeleccionadoD;

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
    
    
    
       
    
}
