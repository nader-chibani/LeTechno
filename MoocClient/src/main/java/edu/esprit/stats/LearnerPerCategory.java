package edu.esprit.stats;

import java.util.List;

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
import edu.letechno.entity.Category;
import edu.letechno.session.ICategorySession;
import edu.letechno.session.IUniversitySession;
import edu.letechno.session.IUserSession;


public class LearnerPerCategory extends JFrame {

  private static final long serialVersionUID = 1L;

  public LearnerPerCategory(String applicationTitle, String chartTitle) {
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
        //***************
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
        List<Category> l = categorysession.getCategories();
        for(int i=0; i<l.size();i++)
        result.setValue(l.get(i).getCategoryName(), categorysession.getNumberLearnersByCategory(l.get(i).getCategoryName()));

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
    
    ICategorySession categorysession = (ICategorySession) Locator.lookup("CategorySession",ICategorySession.class);
    public static void main(String[] args) {
    	LearnerPerCategory demo = new LearnerPerCategory("Category", "Learners number per category");
        demo.pack();
        demo.setVisible(true);
    }
} 
