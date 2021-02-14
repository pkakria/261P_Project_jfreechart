package test_261P;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CompassPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.PieDataset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoverageTest {
    @Test
    public void testCoverageCompassPlotSetSeriesNeedle(){

        boolean pass = false;
        CompassPlot p1 = new CompassPlot(new DefaultValueDataset(15.0));
        CompassPlot p2 = new CompassPlot(new DefaultValueDataset(15.0));
        p1.setSeriesNeedle(0,0);
        p2.setSeriesNeedle(0,0);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,1);
        p2.setSeriesNeedle(0,1);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,2);
        p2.setSeriesNeedle(0,2);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,3);
        p2.setSeriesNeedle(0,3);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,4);
        p2.setSeriesNeedle(0,4);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,5);
        p2.setSeriesNeedle(0,5);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,6);
        p2.setSeriesNeedle(0,6);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,7);
        p2.setSeriesNeedle(0,7);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,8);
        p2.setSeriesNeedle(0,8);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,9);
        p2.setSeriesNeedle(0,9);
        assertTrue(p1.equals(p2));

        try{
            p1.setSeriesNeedle(0,100);
       }catch (IllegalArgumentException ex) {
        pass = true;
       }
        assertTrue(pass);
    }
    @Test
    public void testCoverageChartFrame(){
        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        data.setValue("Apple", 60);
        data.setValue("Qualcomm", 45);
        data.setValue("Amazon", 35);
        try {
            ChartFrame cf = new ChartFrame("My Title", ChartFactory.createPieChart("myChart", data));
            Assertions.assertNotNull(cf);
        }catch(Exception e){
            Assertions.fail("should not throw exception");
        }
        try {
            ChartFrame cf = new ChartFrame("My Title", ChartFactory.createPieChart("myChart", data), true);
            Assertions.assertNotNull(cf);
            JFreeChart chartObj = cf.getChartPanel().getChart();
            Assertions.assertNotNull(chartObj);
            PiePlot<String> plot = ((PiePlot<String>)chartObj.getPlot());
            Assertions.assertEquals(plot.getDataset(), data);
            Assertions.assertEquals(chartObj.getTitle().getText(), "myChart");
        }catch(Exception e){
            Assertions.fail("should not throw exception");
        }

    }


    /**
     * Coverage test on ChartFactory Class method
     * (OG coverage by line 52% 282/536, by branch 27% 10/37)
     * -----------------------------------
     * tested method: createPieChart with 10 arguments including "locale"
     * (Line308 - Line385),  Uncovered Line Count: 46
     */
    @Test
    public void testCoverageCreatePieChartBranchPath1() {
        // Branch path 1 - Two datasets both have values in the same key, all boolean arguments are true
        DefaultPieDataset<String> newData = new DefaultPieDataset<>();
        newData.setValue("Wealth", 50);
        newData.setValue("Health", 80);
        newData.setValue("Happiness", 90);

        DefaultPieDataset<String> oldData = new DefaultPieDataset<>();
        oldData.setValue("Wealth", 80);
        oldData.setValue("Health", 35);
        oldData.setValue("Happiness", 1);

        Locale locale = new Locale("en", "US");

        JFreeChart jc = ChartFactory.createPieChart(
                "Current Life Balance vs Previous Life Balance",
                newData,    // dataset
                oldData,    // previous dataset
                10,
                true,
                true,
                true,
                locale,     // Locale
                true,
                true
        );

        assertEquals("Current Life Balance vs Previous Life Balance", jc.getTitle().getText());
    }

    @Test
    public void testCoverageCreatePieChartBranchPath2() {
        // Branch path 2 - One dataset doesn't have value in the same key of the other, all boolean arguments are false
        DefaultPieDataset<String> newData = new DefaultPieDataset<>();
        newData.setValue("Wealth", 50);
        newData.setValue("Health", 80);
        newData.setValue("Freedom", 70);
        newData.setValue("Happiness", 90);

        DefaultPieDataset<String> oldData = new DefaultPieDataset<>();
        oldData.setValue("Wealth", 80);
        oldData.setValue("Health", 35);
        oldData.setValue("Freedom", null);
        oldData.setValue("Happiness", 1);

        Locale locale = new Locale("en", "US");

        JFreeChart jc = ChartFactory.createPieChart(
                "Current Life Balance vs Previous Life Balance",
                newData,    // dataset
                oldData,    // previous dataset
                10,
                false,
                false,
                false,
                locale,     // Locale
                false,
                false
        );

        assertEquals("Current Life Balance vs Previous Life Balance", jc.getTitle().getText());
    }

    @Test
    public void testCoverageCreatePieChartBranchPath3() {
        // Branch path 3 - One dataset doesn't have value in the same key of the other,
        // arguments: percentDiffForMaxScale 70, greenForIncrease true, showDifference true,
        // others false
        DefaultPieDataset<String> newData = new DefaultPieDataset<>();
        newData.setValue("Wealth", 50);
        newData.setValue("Health", 80);
        newData.setValue("Freedom", 70);
        newData.setValue("Happiness", 90);

        DefaultPieDataset<String> oldData = new DefaultPieDataset<>();
        oldData.setValue("Wealth", 80);
        oldData.setValue("Health", 35);
        oldData.setValue("Freedom", null);
        oldData.setValue("Happiness", 1);

        Locale locale = new Locale("en", "US");

        JFreeChart jc = ChartFactory.createPieChart(
                "Current Life Balance vs Previous Life Balance",
                newData,    // dataset
                oldData,    // previous dataset
                70,
                true,
                false,
                false,
                locale,     // Locale
                false,
                true
        );

        assertEquals("Current Life Balance vs Previous Life Balance", jc.getTitle().getText());
    }

    @Test
    public void testCoverageCreatePieChartBranchPath4() {
        // Branch path 4 - One dataset doesn't have value in the same key of the other,
        // arguments: percentDiffForMaxScale 70, subTitle true, showDifference true,
        // others false
        DefaultPieDataset<String> newData = new DefaultPieDataset<>();
        newData.setValue("Wealth", 50);
        newData.setValue("Health", 80);
        newData.setValue("Freedom", 70);
        newData.setValue("Happiness", 90);

        DefaultPieDataset<String> oldData = new DefaultPieDataset<>();
        oldData.setValue("Wealth", 80);
        oldData.setValue("Health", 35);
        oldData.setValue("Freedom", null);
        oldData.setValue("Happiness", 1);

        Locale locale = new Locale("en", "US");

        JFreeChart jc = ChartFactory.createPieChart(
                "Current Life Balance vs Previous Life Balance",
                newData,    // dataset
                oldData,    // previous dataset
                70,
                false,
                false,
                false,
                locale,     // Locale
                true,
                true
        );

        assertEquals("Current Life Balance vs Previous Life Balance", jc.getTitle().getText());
    }

}
