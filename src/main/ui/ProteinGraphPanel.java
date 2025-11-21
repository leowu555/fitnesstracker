package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// This is a panel that displays a bar graph that allows users to see their weekly protein intake visually,
// from Sunday to Saturday
public class ProteinGraphPanel extends JPanel {
    private List<Integer> dailyProtein;

    // EFFECTS: Sets the List of protein values and repaints the graph
    public void setDailyProtein(List<Integer> protein) {
        this.dailyProtein = protein;
        repaint();
    }

    // EFFECTS: Draws the protein bar graph on the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (dailyProtein == null) {
            g.drawString("No data. Please log your protein intake", 15, 40);
            return;
        }
        drawProteinGraph(g);
    }

    // EFFECTS: Draws the protein graph by looking through the data
    // and generating each bar for each day
    private void drawProteinGraph(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        int margin = 50;
        int barWidth = (width - 2 * margin) / 7;
        int maxBarHeight = height - 2 * margin;
        int max = 0;
        for (int value : dailyProtein) {
            if (value > max) {
                max = value;
            }
        }
        String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
        for (int i = 0; i < 7; i++) {
            int intHeight = (int) ((double) dailyProtein.get(i) / max * maxBarHeight);
            int x = margin + i * barWidth;
            int y = height - margin - intHeight;
            g.setColor(Color.GREEN);
            g.fillRect(x, y, barWidth - 10, intHeight);
            g.setColor(Color.BLACK);
            g.drawString(days[i], x + 5, height - margin + 15);
            g.drawString(dailyProtein.get(i) + "g", x + 5, y - 5);
        }
    }
}
