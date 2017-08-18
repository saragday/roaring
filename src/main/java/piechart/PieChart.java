package piechart;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChart {

    // CREATE THE PIE CHART
    public static JPanel createPiePanel(String title, Map<String, Double> data, Map<String, Color> colorMap) {
        PieDataset pieDataset = createPieDataset(data);
        JFreeChart pieChart = createPieChart(pieDataset, title, colorMap);
        return new ChartPanel(pieChart);
    }

    // BUILD THE PIE CHART
    private static JFreeChart createPieChart(PieDataset dataset, String title, Map<String, Color> colorMap) {
        // title , data set, include legend
        JFreeChart chart = ChartFactory.createPieChart(title, dataset, true,  true, false );

//        setBase(chart);
//        setPlot(colorMap, chart);
//        setLegend(chart);

        return chart;
    }

    private static void setBase(JFreeChart chart) {
        chart.setBackgroundPaint(Color.white); // 背景色
        chart.setBorderVisible(false); // 不显示边框
    }

    private static void setPlot(Map<String, Color> colorMap, JFreeChart chart) {
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setOutlineVisible(false);
        plot.setBackgroundPaint(Color.white);
        plot.setBaseSectionOutlinePaint(Color.WHITE);// 图形边框颜色
        plot.setBaseSectionOutlineStroke(new BasicStroke(0.1f));// 图形边框粗细
        plot.setNoDataMessage("No data available");

        setLabel(plot);
        setSection(colorMap, plot);
    }

    private static void setLegend(JFreeChart chart) {
        // 图例
        chart.getLegend().setBorder(0, 0, 0, 0);
    }

    private static void setSection(Map<String, Color> colorMap, PiePlot plot) {
        // 设置扇区
        plot.setSectionOutlinesVisible(false);
        // 设置颜色
        if (colorMap != null && !colorMap.isEmpty()) {
            Set<Map.Entry<String, Color>> entries = colorMap.entrySet();
            for (Map.Entry<String, Color> entry : entries) {
                plot.setSectionPaint(entry.getKey(), entry.getValue());
            }
        }
    }

    private static void setLabel(PiePlot plot) {
        // 对饼图标签的设置
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{2}({1})", NumberFormat.getNumberInstance(), new DecimalFormat("0.0%")));
        // 设置扇区标签颜色
        plot.setLabelBackgroundPaint(Color.WHITE);
        plot.setLabelFont((new Font("宋体", Font.PLAIN, 12)));
    }

    // BUILD THE PIE CHART DATA SET
    private static PieDataset createPieDataset(Map<String, Double> data) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Set<Map.Entry<String, Double>> entries = data.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        return dataset;
    }

    private static void saveToFile(JFreeChart chart, String fileName, int width, int height) throws IOException {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(fileName);
            ChartUtilities.writeChartAsJPEG(fos, chart, width, height);
            fos.close();
            System.out.println("完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
