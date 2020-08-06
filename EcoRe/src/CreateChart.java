import java.awt.*;
import javax.swing.*;

public class CreateChart {
	
	double weight;
	double money;
	int emptyNum;
	int itemNum;
	JFrame frame_;
	JPanel headpanel;
	
	public CreateChart(String frameName, double weight, double money, int emptyNum, int itemNum) {
    	this.weight = weight;
    	this.money = money;
    	this.emptyNum = emptyNum;
    	this.itemNum = itemNum;
		frame_ = new JFrame(frameName);
		JButton closebutt = new JButton("close");
		
		headpanel = new JPanel();
		CloseChart closeAL = new CloseChart(frame_);
		closebutt.addActionListener(closeAL);
		headpanel.add(closebutt);
		
		NewChart chart = new NewChart();
    	chart.setBackground(Color.WHITE);
    	frame_.setLayout(new BorderLayout());
    	frame_.add(headpanel,BorderLayout.PAGE_END);
    	frame_.add(chart, BorderLayout.CENTER);
    	frame_.setSize(600,300);
		frame_.setLocationRelativeTo(null);
		frame_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_.setVisible(true);
    }
		
	class  NewChart extends JPanel {
		int HEIGHT = 250;
		int offsetY = 14;
		Font font = new Font("Times", Font.PLAIN, 14);

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			HEIGHT = (int) (getHeight());
			int width = getWidth();
			int w80 = (int) (width * 0.8);
			int w20 = (int) (width * 0.2);
			int uw = w80 / 4;
			int gap = w20 / 5;

			int bottom = getHeight() - 20;
			int rectH = (int) (weight);
			String str;
			g.setFont(font);
			g.setColor(Color.RED);
			g.fillRect(gap, bottom - rectH, uw, rectH);
			g.setColor(Color.BLACK);
			str = "Total Weight: " + weight + " lb";
			g.drawString(str, gap, bottom - rectH - offsetY);

			rectH = (int) (money);
			g.setColor(Color.BLUE);
			g.fillRect(gap * 2 + uw, bottom - rectH, uw, rectH);
			g.setColor(Color.BLACK);
			str = " Issued money: $" + money;
			g.drawString(str, gap * 2 + uw, bottom - rectH - offsetY);
			
			rectH = (int) (emptyNum * 10);
			g.setColor(Color.YELLOW);
			g.fillRect(gap * 3 + uw * 2, bottom - rectH, uw, rectH);
			g.setColor(Color.BLACK);
			str = "No. of emptied time: " + emptyNum;
			g.drawString(str, gap * 3 + uw * 2, bottom - rectH - offsetY);
			
			rectH = (int) (itemNum * 10);
			g.setColor(Color.GREEN);
			g.fillRect(gap * 4 + uw * 3, bottom - rectH, uw, rectH);
			g.setColor(Color.BLACK);
			str = "  No. of items: " + itemNum;
			g.drawString(str, gap * 4 + uw * 3, bottom - rectH - offsetY);

			int x1, x2, y1, y2;
			x1 = gap / 2;
			y1 = bottom;
			x2 = width - gap / 2;
			y2 = y1;
			g.setColor(Color.BLACK);
			g.drawLine(x1, y1, x2, y2);
		}
	}
}
