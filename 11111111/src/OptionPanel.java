

import javax.swing.JOptionPane;

public class OptionPanel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nKilkist = Integer.parseInt(JOptionPane.showInputDialog("ʳ������ ��������: "));
		int masChastot [] = new int[nKilkist];
		int masElement [] = new int[nKilkist];
		int i = 0;
		for (;i<nKilkist;i++){
		
			masElement [i] = Integer.parseInt(JOptionPane.showInputDialog("�������� "+(i+1)+" ��������: "));
			masChastot [i] = Integer.parseInt(JOptionPane.showInputDialog("������� ����������� "+(i+1)+" ��������: "));
			
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
		
		JOptionPane.showMessageDialog(null, "������� ��i��� ��������� �������: "+x);
		
	}
 
}

