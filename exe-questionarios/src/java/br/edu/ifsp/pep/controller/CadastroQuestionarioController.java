
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.OpcaoPerguntaDao;
import br.edu.ifsp.pep.dao.PerguntaDao;
import br.edu.ifsp.pep.dao.QuestionarioDao;
import br.edu.ifsp.pep.modelo.OpcaoPergunta;
import br.edu.ifsp.pep.modelo.Pergunta;
import br.edu.ifsp.pep.modelo.Questionario;
import br.edu.ifsp.pep.modelo.TipoPergunta;
import br.edu.ifsp.pep.util.Messages;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.time.LocalDateTime;


@Named
@ApplicationScoped
public class CadastroQuestionarioController {
       
    @Inject
    private QuestionarioDao questionarioDao;
    @Inject
    private PerguntaDao perguntaDao;
    @Inject 
    private OpcaoPerguntaDao opcaoPerguntaDao;
    
    public CadastroQuestionarioController() {
        System.out.println("Construtor para cadastro dos qeustionários iniciais");
    }

    public void cadastroQuestionario1(){
        //Cadastro do questionário
        try {
            Questionario q1 = new Questionario();
        
            q1.setTitulo("Questionário1");
            q1.setDescricao("Enquete sobre festa junina");
            q1.setDataAbertura(LocalDateTime.now());
            q1.setDataFechamento(q1.getDataAbertura().plusDays(30));
            
            questionarioDao.cadastrar(q1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
        //Cadastro das perguntas
        try {
            //pesquisa pelo nome do questionário
            Questionario tituloQuestionario = questionarioDao.findByName("Questionário1");
            Pergunta p1 = new Pergunta();
            Pergunta p2 = new Pergunta();
            Pergunta p3 = new Pergunta();
            Pergunta p4 = new Pergunta();
            Pergunta p5 = new Pergunta();
            
            p1.setTituloPergunta("Prefere pratos doces ou salgados?");
            p1.setTipoPergunta(TipoPergunta.Opcao);
            p1.setQuestionario(tituloQuestionario);  
            
            p2.setTituloPergunta("Prefere comidas ou bebidas?");
            p2.setTipoPergunta(TipoPergunta.Opcao);
            p2.setQuestionario(tituloQuestionario);
            
            p3.setTituloPergunta("Prefere dançar ou assistir?");
            p3.setTipoPergunta(TipoPergunta.Opcao);
            p3.setQuestionario(tituloQuestionario);
            
            p4.setTituloPergunta("Gosta de trabalhar nas barracas?");
            p4.setTipoPergunta(TipoPergunta.Opcao);
            p4.setQuestionario(tituloQuestionario);
            
            p5.setTituloPergunta("O que mais gosta nas festas juninas?");
            p5.setTipoPergunta(TipoPergunta.Livre);
            p5.setQuestionario(tituloQuestionario);
            
            perguntaDao.cadastrar(p1);
            perguntaDao.cadastrar(p2);
            perguntaDao.cadastrar(p3);
            perguntaDao.cadastrar(p4);
            perguntaDao.cadastrar(p5);           
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
        
        //Cadastro das opções das perguntas;
        try {
            //pesquisa pela pergunta
            Pergunta pergunta1 = perguntaDao.findByName("Prefere pratos doces ou salgados?");
            OpcaoPergunta op1P1 = new OpcaoPergunta();
            OpcaoPergunta op2P1 = new OpcaoPergunta();            
            op1P1.setOpcao("Doce");
            op1P1.setPergunta(pergunta1);
            op2P1.setOpcao("Salgado");
            op2P1.setPergunta(pergunta1);
            
            Pergunta pergunta2 = perguntaDao.findByName("Prefere comidas ou bebidas?");
            OpcaoPergunta op1P2 = new OpcaoPergunta();
            OpcaoPergunta op2P2 = new OpcaoPergunta();            
            op1P2.setOpcao("Comidas");
            op1P2.setPergunta(pergunta2);
            op2P2.setOpcao("Bebidas");
            op2P2.setPergunta(pergunta2);
            
            Pergunta pergunta3 = perguntaDao.findByName("Prefere dançar ou assistir?");
            OpcaoPergunta op1P3 = new OpcaoPergunta();
            OpcaoPergunta op2P3 = new OpcaoPergunta();            
            op1P3.setOpcao("Dançar");
            op1P3.setPergunta(pergunta3);
            op2P3.setOpcao("Assistir");
            op2P3.setPergunta(pergunta3);
            
            Pergunta pergunta4 = perguntaDao.findByName("Gosta de trabalhar nas barracas?");
            OpcaoPergunta op1P4 = new OpcaoPergunta();
            OpcaoPergunta op2P4 = new OpcaoPergunta();            
            op1P4.setOpcao("Sim");
            op1P4.setPergunta(pergunta4);
            op2P4.setOpcao("Não");
            op2P4.setPergunta(pergunta4);
            
            opcaoPerguntaDao.cadastrar(op1P1);
            opcaoPerguntaDao.cadastrar(op2P1);
            opcaoPerguntaDao.cadastrar(op1P2);
            opcaoPerguntaDao.cadastrar(op2P2);
            opcaoPerguntaDao.cadastrar(op1P3);
            opcaoPerguntaDao.cadastrar(op2P3);
            opcaoPerguntaDao.cadastrar(op1P4);
            opcaoPerguntaDao.cadastrar(op2P4);
            
            
            //pergunta 5 do questionário 1 é livre;            
        } catch (Exception e) {            
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }   
        
        Messages.addMessageSuccess("Questionário1 cadastrado!!");
    }
       
}