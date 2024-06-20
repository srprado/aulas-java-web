package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PerguntaDao;
import br.edu.ifsp.pep.dao.QuestionarioDao;
import br.edu.ifsp.pep.dao.RespostaDTO;
import br.edu.ifsp.pep.dao.RespostaDao;
import br.edu.ifsp.pep.modelo.Pergunta;
import br.edu.ifsp.pep.modelo.Questionario;
import br.edu.ifsp.pep.util.Messages;
import com.mysql.cj.protocol.Message;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
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
@ViewScoped
public class AnaliseController implements Serializable{

    private Questionario questionarioSelecionado;
    private BarChartModel barModel;
    private List<BarChartModel> ListaBarModel;

    @Inject
    private QuestionarioDao questionarioDao;
    @Inject
    private PerguntaDao perguntadao;
    @Inject
    private RespostaDao respostadao;

    @PostConstruct
    public void init() {
        createBarModel();
    }

    public void selecionar() {
        System.out.println(questionarioSelecionado.getTitulo());
    }

    public void createBarModel() {
        ListaBarModel = new ArrayList<>();

        if (questionarioSelecionado != null) {
            List<Pergunta> perguntas = perguntadao.findPerguntasById(questionarioSelecionado.getIdQuestionario());
            if(perguntas.isEmpty()){
                Messages.addMessageWarning("Esse Questionário não possui perguntas.");
            }
            else{
                for (Pergunta p : perguntas) {
                
                barModel = new BarChartModel();
                ChartData data = new ChartData();

                BarChartDataSet barDataSet = new BarChartDataSet();
                barDataSet.setLabel(p.getTituloPergunta());

                //rótulos das opções List<String> 
                List<String> labels = new ArrayList<>();
                //quantidade das opções
                List<Number> values = new ArrayList<>();

                for (RespostaDTO resDto : respostadao.findByQuestionDTO(p.getIdPergunta())) {
                    labels.add(resDto.getOpcaoPergunta().getOpcao());
                    values.add(resDto.getQuantidade());

                }//for resposta
                //eixo Y
                barDataSet.setData(values);
                //eixo X
                data.setLabels(labels);
                barModel.setData(data);
                
                List<String> bgColor = new ArrayList<>();
                bgColor.add("rgba(255, 99, 132, 0.2)");
                
                barDataSet.setBackgroundColor(bgColor);

                List<String> borderColor = new ArrayList<>();
                borderColor.add("rgb(255, 99, 132)");
                
                barDataSet.setBorderColor(borderColor);
                barDataSet.setBorderWidth(1);

                data.addChartDataSet(barDataSet);

                barModel.setData(data);

                //Options
                BarChartOptions options = new BarChartOptions();
                //options.setMaintainAspectRatio(false);
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
                title.setText(p.getTituloPergunta());
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
                ListaBarModel.add(barModel);
            }
            }//else pergunta
        }//if questionário nulp
    }//método

    public List<Questionario> listarQuestionarios() {
        return questionarioDao.findAll();
    }

    public Questionario getQuestionarioSelecionado() {
        return questionarioSelecionado;
    }

    public void setQuestionarioSelecionado(Questionario questionarioSelecionado) {
        this.questionarioSelecionado = questionarioSelecionado;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public List<BarChartModel> getListaBarModel() {
        if(ListaBarModel.isEmpty()){
        System.out.println("LISTA VAZIA");
        }
        return ListaBarModel;
    }

    public void setListaBarModel(List<BarChartModel> ListaBarModel) {
        this.ListaBarModel = ListaBarModel;
    }
}
