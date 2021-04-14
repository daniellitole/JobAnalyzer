/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orangeCoastTestingPackage;

/**
 *
 * @author Test
 */
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.*;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
public class MultiLineChart extends JFrame{

    private List<String> orderedData;
    private List<Integer> minutes;
    private double averageMovingRange;
    private double upperControlLimit;
    private double lowerControlLimit; 
    private int[] movingRanges;
    private JFreeChart chart;
    private int colorComboBoxIndex;
    
    public MultiLineChart(List orderedData, List minutes, int[] movingRanges, boolean saveChart, int colorComboBoxIndex) {
        super("Job Analyzer");
        setIcon();
        this.orderedData = orderedData; 
        this.minutes = minutes;
        this.movingRanges = movingRanges;
        this.colorComboBoxIndex = colorComboBoxIndex;
        calculateAverageMovingRange();
        calculateControlLimits();
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
        customizeChart();
        
        int width = 640;
        int height = 480;
        setSize(width, height);
        //Saveing file if checked
        if(saveChart) {
            String userName = System.getProperty("user.name");
            String destination = "C:/Users/" + userName + "/jobGraph.png";
            File imageFile = new File(destination);
            try{
                ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
            } catch(IOException e) {
                System.out.println(e);
            }
        }
        //Customizing chart
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        

    }
    
    public MultiLineChart() {
        
    }
    
    private void calculateAverageMovingRange() {
        int sumMovingRange = 0;
        for(int num : movingRanges) {
            sumMovingRange += num;
        }
        averageMovingRange = (double) sumMovingRange / movingRanges.length;
    }
    
    private void calculateControlLimits() {
        int totalTime = 0;
        for(int i = 0; i < minutes.size(); i++) {
            totalTime += minutes.get(i);
        }
        double averageTime = (totalTime * 1.0) / (minutes.size() * 1.0); 
        upperControlLimit = averageTime + ((3.0 * averageMovingRange) / 1.128);
        lowerControlLimit = averageTime - ((3.0 * averageMovingRange) / 1.128);
    }
    
    private JPanel createChartPanel() {
        String chartTitle = "Time per job";
        String categoryAxisLabel = "Jobs";
        String valueAxisLabel = "Time in minutes";

        CategoryDataset dataset = createDataset();

        chart = ChartFactory.createLineChart(chartTitle,
                categoryAxisLabel, valueAxisLabel, dataset);

        return new ChartPanel(chart);
    }
    
    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String series1 = "Upper Control Limit";
        String series2 = "DATA";
        String series3 = "Lower Control Limit";


        //Adding Upper control limit
        for(int i = 0; i < minutes.size(); i++) {
            dataset.addValue(upperControlLimit, series1, orderedData.get(i).split("--")[0]);
        }
        
        //Adding Lower control limit
        for(int i = 0; i < minutes.size(); i++) {
            dataset.addValue(lowerControlLimit, series3, orderedData.get(i).split("--")[0]);
        }
        
        //Adding DATA
        for(int i = 0; i < minutes.size(); i++) {
            dataset.addValue(minutes.get(i), series2, orderedData.get(i).split("--")[0]);
        }
        
        //Adding Date Lines
        if(colorComboBoxIndex <= 2) {
            for(int i = 0; i < minutes.size(); i++) {
                dataset.addValue(1530, "3 Days", orderedData.get(i).split("--")[0]);
                dataset.addValue(2550, "5 Days", orderedData.get(i).split("--")[0]);
            } 
        } else {
            for(int i = 0; i < minutes.size(); i++) {
                dataset.addValue(510, "1 Day", orderedData.get(i).split("--")[0]);
            }
        }

        return dataset;
    }
    
    private void customizeChart() {   // here we make some customization
        AbstractCategoryItemRenderer renderer = (AbstractCategoryItemRenderer) chart.getCategoryPlot().getRenderer();
        BasicStroke strokeDashed = new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, new float[] {6.0f, 6.0f}, 0.0f);

        if(colorComboBoxIndex == 3) {
            renderer.setSeriesPaint(3, new Color(255, 0, 0));
            renderer.setSeriesStroke(3, strokeDashed);
        } else if(colorComboBoxIndex <= 2) {
            renderer.setSeriesPaint(3, new Color(0, 255, 0));
            renderer.setSeriesPaint(4, new Color(0, 255, 0));
            renderer.setSeriesStroke(3, strokeDashed);
            renderer.setSeriesStroke(4, strokeDashed);
        }
        renderer.setSeriesPaint(2, new Color(0, 0, 255));
        renderer.setSeriesPaint(0, new Color(255, 0, 255));
        renderer.setSeriesPaint(1, new Color(255, 0, 255));
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MultiLineChart().setVisible(true);
            }
        });
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("graphIcon.png")));
    }
}
