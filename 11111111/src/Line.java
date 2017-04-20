import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JColorChooser;

public class Line extends Frame {
	private static final long serialVersionUID = 1L;

	public Line(String s) {
		super(s);
		ScrollPane pane = new ScrollPane();
		pane.setSize(550, 550);
		add(pane, BorderLayout.CENTER);
		Act scr = new Act(this, 500, 500);
		pane.add(scr);
		Panel p = new Panel();
		add(p, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}
		});

		pack();
		setVisible(true);

	}

	public static void main(String[] args) {
		new Line("Line");
	}

}

@SuppressWarnings("serial")
class Act extends Component implements ActionListener, MouseListener, MouseMotionListener {
	int lastX, lastY, w, h, diametr = 10;
	Color currColor = Color.black;
	Frame f;
	Graphics g;

	public Act(Frame frame, int width, int height) {
		f = frame;
		w = width;
		h = height;
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	public Dimension getPreferredSize() {
		return new Dimension(w, h);
	}

	public void actionPerformed(ActionEvent event) {
		String s = event.getActionCommand();
		repaint();
	}

	public void mousePressed(MouseEvent e) {
		if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) == 0)
			return;
		lastX = e.getX();
		lastY = e.getY();
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		part1c(lastX, lastY, e.getX(), e.getY());
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void part1(int x, int y) {
		double k = (double) x / y;
		g = getGraphics();
		g.setColor(Color.BLACK);

		if (x > y) {
			part2(k, 1, 0, x, y);
		} else
			part2(k, 0, 1, x, y);

	}

	public void part2(double k, int xn, int yn, int x, int y) {
		if (xn == x && yn == y) {
			System.out.println(xn + "  " + yn + "aaaa ");
			return;
		}

		double f;
		if (yn == 0 && xn != 0) {
			f = Integer.MAX_VALUE;
		} else
			f = (double) xn / yn;

		if (k < f) {
			part2(k, xn, yn + 1, x, y);
		} else if (k > f) {
			part2(k, xn + 1, yn, x, y);
		} else if (k == f) {
			part2(k, xn + 1, yn + 1, x, y);
		}
		g.fillRect(xn, yn, 1, 1);
		// System.out.println(xn + " " + yn);
	}

	public void part1c(int x, int y, int x1, int y1) {
		int r = x1 - x;
		g = getGraphics();
		g.setColor(Color.BLACK);

		part2c(r, r, 0, x1, y1);
	}

	public void part2c(int r, int x, int y, int x1, int y1) {
		if (x == 0) {
			g.fillRect(x + x1, y + y1, 1, 1);
			return;
		}

		g.fillRect(x + x1, y + y1, 1, 1);
		g.fillRect(-x + x1, y + y1, 1, 1);
		g.fillRect(x + x1, -y + y1, 1, 1);
		g.fillRect(-x + x1, -y + y1, 1, 1);

		if (x >= y) {
			if ((double) Math.sqrt(x * x + y * y) > r)
				x--;
			y++;
		} else {
			if ((double) Math.sqrt(x * x + y * y) > r)
				y--;
			x--;
			y++;
		}

		// y++;

		part2c(r, x, y, x1, y1);
	}

}
