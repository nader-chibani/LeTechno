package edu.esprit.stats;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;

import edu.esprit.locator.Locator;
import edu.letechno.entity.Category;
import edu.letechno.session.ICategorySession; 

public class IncomeStats extends ApplicationFrame
{
   public IncomeStats( String applicationTitle , String chartTitle )
   {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Category",            
         "Income",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   private CategoryDataset createDataset( )
   {
      final String fiat = "FIAT";        
      final String audi = "AUDI";        
      final String ford = "FORD";        
      final String speed = "Speed";        
      final String millage = "Millage";        
      final String userrating = "User Rating";        
      final String safety = "safety";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  
      
      List<Category> l = categorysession.getCategories();
      
      for(int i=0; i<l.size();i++)
      dataset.addValue( categorysession.getIncomeByCategory(l.get(i).getCategoryName()) , l.get(i).getCategoryName() , l.get(i).getCategoryName() );        

      return dataset; 
   }
   public static void main( String[ ] args )
   {
	   IncomeStats chart = new IncomeStats("Car Usage Statistics", "Which car do you like?");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
   
   ICategorySession categorysession = (ICategorySession) Locator.lookup("CategorySession",ICategorySession.class);
   
}