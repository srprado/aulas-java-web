
package br.edu.ifsp.controller;

import br.edu.ifsp.dao.VendaDTO;
import br.edu.ifsp.dao.VendasDAO;
import br.edu.ifsp.modelo.Vendas;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
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
public class VendasController {
    
    private BarChartModel barModel;
    private Vendas vendas;
    private List<Vendas> vendasMes = new ArrayList<>();
    
    @Inject 
    private VendasDAO vendasDao;
    

    @PostConstruct
    public void init(){
        createBarModel();
    }   
        
    public void createBarModel() {
        barModel = new BarChartModel();
        ChartData data = new ChartData();
        
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Valores por mês");
        
        //valores por mês
        List<Number> values = new ArrayList<>();
        //valores do labels
        List<String> labels = new ArrayList<>();
        
        //criar uma variável para passar o ano
        for (VendaDTO vendaDTO: vendasDao.findByMonthDTO(2024)){
            values.add(vendaDTO.getValor());
            labels.add(Integer.toString(vendaDTO.getMes()));           
        }         

        //eixo Y
        barDataSet.setData(values);
        
        //Eixo X        
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
        
       
        //adiciona a legenda ao gráfico
        data.addChartDataSet(barDataSet);         

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
    
    public void vendasMes(){
//        System.out.println(vendasDao.findAll());   

//        for(Object[] obj: vendasDao.findByMonth()){
//            System.out.println(obj[0]);
//            System.out.println(obj[1]);
//        
//        }
          
          for(VendaDTO vendaDTO: vendasDao.findByMonthDTO(2024)){
              System.out.println(vendaDTO);          
          }

    }
    


    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }
    
    
    
}
