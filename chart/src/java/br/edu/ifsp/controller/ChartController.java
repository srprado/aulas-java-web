
package br.edu.ifsp.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;



@Named
@RequestScoped
public class ChartController {
    
    private BarChartModel barModel;
    private BarChartModel barModel2;

    @PostConstruct
    public void init(){
        createBarModel();
    }
       
    
    public void createBarModel() {
        barModel = new BarChartModel();
        ChartData data = new ChartData();
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Cartão de crédito");
        
//        Lista2
        BarChartDataSet barDataSet2 = new BarChartDataSet();
        barDataSet2.setLabel("Mercado");

//        eixo y
        List<Number> values = new ArrayList<>();
        values.add(65);
        values.add(59);
        values.add(80);
        values.add(81);
        values.add(56);
        values.add(55);
        values.add(40);
        barDataSet.setData(values);
       
//        eixo x
        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        data.setLabels(labels);
        barModel.setData(data);
       
        //barra 1
        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 99, 132, 0.2)");
        barDataSet.setBackgroundColor(bgColor);
        
        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 99, 132)");
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1);
        data.addChartDataSet(barDataSet);
        
//      Lista2/barras2
        List<String> bgColor2 = new ArrayList<>();
        bgColor.add("rgba(200, 99, 100, 0.2)");
        bgColor.add("rgba(200, 99, 100, 0.2)");
        bgColor.add("rgba(200, 99, 100, 0.2)");
        bgColor.add("rgba(200, 99, 100, 0.2)");
        bgColor.add("rgba(200, 99, 100, 0.2)");
        bgColor.add("rgba(200, 99, 100, 0.2)");
        bgColor.add("rgba(200, 99, 100, 0.2)");
        barDataSet2.setBackgroundColor(bgColor2);        

        List<String> borderColor2 = new ArrayList<>();
        borderColor.add("rgb(200, 99, 100)");
        borderColor.add("rgb(200, 99, 100)");
        borderColor.add("rgb(200, 99, 100)");
        borderColor.add("rgb(200, 99, 100)");
        borderColor.add("rgb(200, 99, 100)");
        borderColor.add("rgb(200, 99, 100)");
        borderColor.add("rgb(200, 99, 100)");
        barDataSet2.setBorderColor(borderColor2);
        barDataSet2.setBorderWidth(1);

        data.addChartDataSet(barDataSet);
        data.addChartDataSet(barDataSet2);
        
         //Options
        BarChartOptions options = new BarChartOptions();
//        options.setMaintainAspectRatio(false);
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Despesas por Mês");
        title.setFontSize(24);
        options.setTitle(title);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("bottom");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("italic");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(16);
        legend.setLabels(legendLabels);
        options.setLegend(legend);
        
        // disable animation
        Animation animation = new Animation();
        animation.setDuration(0);
        options.setAnimation(animation);

        barModel.setOptions(options); 
        
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public BarChartModel getBarModel2() {
        return barModel2;
    }

    public void setBarModel2(BarChartModel barModel2) {
        this.barModel2 = barModel2;
    }
    
    

    
    
}