package edu.esprit.stats;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import edu.esprit.locator.Locator;
import edu.letechno.session.IUniversitySession;
import edu.letechno.session.IUserSession;


public class jFree extends JFrame {

  private static final long serialVersionUID = 1L;

  public jFree(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // This will create the dataset 
        PieDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);
        //**********************
        ImageIcon icon = new ImageIcon("src/main/resources/favicon.png");
		this.setVisible(true);
		this.setResizable(false);
		this.setIconImage(icon.getImage());

    }
    
    
/**
     * Creates a sample dataset 
     */

    private  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Admin", usersession.getNumberOfUsersByRole("admin"));
        result.setValue("committee", usersession.getNumberOfUsersByRole("committee"));
        result.setValue("uniAdmin", usersession.getNumberOfUsersByRole("uniAdmin"));
        result.setValue("Learner", usersession.getNumberOfUsersByRole("user"));
        result.setValue("trainer",usersession.getNumberOfUsersByRole("trainer") );

        return result;
    }
    
    
/**
     * Creates a chart
     */

    private JFreeChart createChart(PieDataset dataset, String title) {
        
        JFreeChart chart = ChartFactory.createPieChart3D(title,          // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
        
    }
    
    IUserSession usersession = (IUserSession) Locator.lookup("UserSession",IUserSession.class);
    public static void main(String[] args) {
    	jFree demo = new jFree("Users Stast", "User number per Role");
        demo.pack();
        demo.setVisible(true);
    }
} 
