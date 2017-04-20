

import javax.swing.JOptionPane;

public class OptionPanel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nKilkist = Integer.parseInt(JOptionPane.showInputDialog("Кількість елементів: "));
		int masChastot [] = new int[nKilkist];
		int masElement [] = new int[nKilkist];
		int i = 0;
		for (;i<nKilkist;i++){
		
			masElement [i] = Integer.parseInt(JOptionPane.showInputDialog("Значення "+(i+1)+" елемента: "));
			masChastot [i] = Integer.parseInt(JOptionPane.showInputDialog("Частота повторенння "+(i+1)+" елемента: "));
			
		}
		
		int s = 0;
		for(int j = 0;j<=nKilkist-1;j++){
			s=s+(masElement[j]*masChastot[j]);
		}
		int z = 0;
		for(int j = 0;j<=nKilkist-1;j++){
			z+=masChastot[j];
		}
		double x = (double)(s/z);
		
		x=(double)(1/x);
		
		JOptionPane.showMessageDialog(null, "Точкова оцiнка параметру дорівнює: "+x);
		
	}
 
}

