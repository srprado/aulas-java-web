
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PerguntaDao;
import br.edu.ifsp.pep.dao.QuestionarioDao;
import br.edu.ifsp.pep.modelo.Pergunta;
import br.edu.ifsp.pep.modelo.Questionario;
import br.edu.ifsp.pep.util.Messages;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;


@Named
@ApplicationScoped
public class QuestionarioController{
    
    private Questionario questionario = new Questionario();
    private Questionario questionarioSelecionado;
    
    
    @Inject
    private QuestionarioDao questionariodao;
    @Inject
    private PerguntaDao perguntaDao;

    public QuestionarioController() {
    }
            
    public void cadastrarQuestionario() {
        try {
            questionariodao.cadastrar(questionario);
            Messages.addMessageSuccess("Questionário cadastrado!");
            limparCampos();
            this.questionario = new Questionario();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
    }
    
    public List<Questionario> listarQuestionarios(){
       return questionariodao.findAll();
    }
        
    public void limparCampos(){
        this.questionario = null;       
    }    
    
    public List<Pergunta> listarPerguntas(Integer idQuestionario) {
        System.out.println("LISTA DE PERGUNTAS");
        try {
            if (questionarioSelecionado == null) {
                System.out.println("erro ao retornar questionário");
            } else {
                System.out.println(idQuestionario);
                System.out.println(perguntaDao.findPerguntasById(idQuestionario));
            }                       
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
        return null;
        
    }
    
    public List<String> listarPerguntasAndOpcao(Integer idQuestionario) {
        System.out.println("LISTA DE PERGUNTAS e opçao");
        if (questionarioSelecionado == null) {
            System.out.println("erro ao retornar perguntas do questionário");
        } else {
            System.out.println(idQuestionario);
            
        }
        return null;
    }
    
    public String paginaListarPerguntas(){
        return "listarPerguntas.xhtml";
    }
    
    public String voltarParaQuestionario(){
        return "listarQuestionarios.xhtml";
    }
    
    public void excluir() {
        System.out.println("BOTÃO ACIONADOs");
        System.out.println(questionarioSelecionado);
        try {
            questionariodao.excluir(questionarioSelecionado);
            Messages.addMessageSuccess("Questionário excluido!");  
            questionarioSelecionado = null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());            
        }
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public Questionario getQuestionarioSelecionado() {
        return questionarioSelecionado;
    }

    public void setQuestionarioSelecionado(Questionario questionarioSelecionado) {
        this.questionarioSelecionado = questionarioSelecionado;
    }      
    
}
