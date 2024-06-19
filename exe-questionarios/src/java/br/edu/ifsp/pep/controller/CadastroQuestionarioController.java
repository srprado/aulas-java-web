
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.OpcaoPerguntaDao;
import br.edu.ifsp.pep.dao.PerguntaDao;
import br.edu.ifsp.pep.dao.QuestionarioDao;
import br.edu.ifsp.pep.modelo.OpcaoPergunta;
import br.edu.ifsp.pep.modelo.Pergunta;
import br.edu.ifsp.pep.modelo.Questionario;
import br.edu.ifsp.pep.modelo.TipoPergunta;
import br.edu.ifsp.pep.util.Messages;
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
            
           
            
            perguntaDao.cadastrar(p1);
            perguntaDao.cadastrar(p2);
            perguntaDao.cadastrar(p3);
            perguntaDao.cadastrar(p4);
                      
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
    
    public void cadastroQuestionario2(){
        //Cadastro do questionário
        try {
            Questionario q2 = new Questionario();
        
            q2.setTitulo("Questionário2");
            q2.setDescricao("Enquete sobre a greve");
            q2.setDataAbertura(LocalDateTime.now());
            q2.setDataFechamento(q2.getDataAbertura().plusDays(30));
            
            questionarioDao.cadastrar(q2);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
        //Cadastro das perguntas
        try {
            //pesquisa pelo nome do questionário
            Questionario tituloQuestionario = questionarioDao.findByName("Questionário2");
            Pergunta p1 = new Pergunta();
            Pergunta p2 = new Pergunta();
            Pergunta p3 = new Pergunta();
            Pergunta p4 = new Pergunta();
                        
            p1.setTituloPergunta("Você sabe o que é uma greve?");
            p1.setTipoPergunta(TipoPergunta.Opcao);
            p1.setQuestionario(tituloQuestionario);  
            
            p2.setTituloPergunta("Você fica a par das redivindicações de uma greve?");
            p2.setTipoPergunta(TipoPergunta.Opcao);
            p2.setQuestionario(tituloQuestionario);
            
            p3.setTituloPergunta("Você é a favor de greve?");
            p3.setTipoPergunta(TipoPergunta.Opcao);
            p3.setQuestionario(tituloQuestionario);
            
            p4.setTituloPergunta("Você participa ativamente da greve?");
            p4.setTipoPergunta(TipoPergunta.Opcao);
            p4.setQuestionario(tituloQuestionario);
                        
            perguntaDao.cadastrar(p1);
            perguntaDao.cadastrar(p2);
            perguntaDao.cadastrar(p3);
            perguntaDao.cadastrar(p4);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }        
        //Cadastro das opções das perguntas;
        try {
            //pesquisa pela pergunta
            Pergunta pergunta1 = perguntaDao.findByName("Você sabe o que é uma greve?");
            OpcaoPergunta op1P1 = new OpcaoPergunta();
            OpcaoPergunta op2P1 = new OpcaoPergunta();    
            OpcaoPergunta op3P1 = new OpcaoPergunta(); 
            op1P1.setOpcao("Sim");
            op1P1.setPergunta(pergunta1);
            op2P1.setOpcao("Não");
            op2P1.setPergunta(pergunta1);
            op3P1.setOpcao("Abster");
            op3P1.setPergunta(pergunta1);
            
            Pergunta pergunta2 = perguntaDao.findByName("Você fica a par das redivindicações de uma greve?");
            OpcaoPergunta op1P2 = new OpcaoPergunta();
            OpcaoPergunta op2P2 = new OpcaoPergunta();
            OpcaoPergunta op3P2 = new OpcaoPergunta();            
            op1P2.setOpcao("Sim");
            op1P2.setPergunta(pergunta2);
            op2P2.setOpcao("Não");
            op2P2.setPergunta(pergunta2);
            op3P2.setOpcao("As vezes");
            op3P2.setPergunta(pergunta2);
            
            Pergunta pergunta3 = perguntaDao.findByName("Você é a favor de greve?");
            OpcaoPergunta op1P3 = new OpcaoPergunta();
            OpcaoPergunta op2P3 = new OpcaoPergunta();  
            OpcaoPergunta op3P3 = new OpcaoPergunta(); 
            op1P3.setOpcao("Sim");
            op1P3.setPergunta(pergunta3);
            op2P3.setOpcao("Não");
            op2P3.setPergunta(pergunta3);
            op3P3.setOpcao("Abster");
            op3P3.setPergunta(pergunta3);
            
            Pergunta pergunta4 = perguntaDao.findByName("Você participa ativamente da greve?");
            OpcaoPergunta op1P4 = new OpcaoPergunta();
            OpcaoPergunta op2P4 = new OpcaoPergunta();     
            OpcaoPergunta op3P4 = new OpcaoPergunta();  
            op1P4.setOpcao("Sim");
            op1P4.setPergunta(pergunta4);
            op2P4.setOpcao("Não");
            op2P4.setPergunta(pergunta4);
            op3P4.setOpcao("As vezes");
            op3P4.setPergunta(pergunta4);
            
            opcaoPerguntaDao.cadastrar(op1P1);
            opcaoPerguntaDao.cadastrar(op2P1);
            opcaoPerguntaDao.cadastrar(op3P1);            
            opcaoPerguntaDao.cadastrar(op1P2);
            opcaoPerguntaDao.cadastrar(op2P2);
            opcaoPerguntaDao.cadastrar(op3P2);            
            opcaoPerguntaDao.cadastrar(op1P3);
            opcaoPerguntaDao.cadastrar(op2P3);
            opcaoPerguntaDao.cadastrar(op3P3);            
            opcaoPerguntaDao.cadastrar(op1P4);
            opcaoPerguntaDao.cadastrar(op2P4);
            opcaoPerguntaDao.cadastrar(op3P4);            
        } catch (Exception e) {            
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }           
        Messages.addMessageSuccess("Questionário2 cadastrado!!");
    }
    
    public void cadastroQuestionario3(){
        //Cadastro do questionário
        try {
            Questionario q3 = new Questionario();
        
            q3.setTitulo("Questionário3");
            q3.setDescricao("Pesquisa de informações");
            q3.setDataAbertura(LocalDateTime.now());
            q3.setDataFechamento(q3.getDataAbertura().plusDays(30));
            
            questionarioDao.cadastrar(q3);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
        //Cadastro das perguntas
        try {
            //pesquisa pelo nome do questionário
            Questionario tituloQuestionario = questionarioDao.findByName("Questionário3");
            Pergunta p1 = new Pergunta();
            Pergunta p2 = new Pergunta();
            Pergunta p3 = new Pergunta();
            Pergunta p4 = new Pergunta();
            Pergunta p5 = new Pergunta();
                        
            p1.setTituloPergunta("Qual sua idade?");
            p1.setTipoPergunta(TipoPergunta.Opcao);
            p1.setQuestionario(tituloQuestionario);  
            
            p2.setTituloPergunta("Você trabalha?");
            p2.setTipoPergunta(TipoPergunta.Opcao);
            p2.setQuestionario(tituloQuestionario);
            
            p3.setTituloPergunta("Você estuda?");
            p3.setTipoPergunta(TipoPergunta.Opcao);
            p3.setQuestionario(tituloQuestionario);
            
            p4.setTituloPergunta("Qual a sua renda?");
            p4.setTipoPergunta(TipoPergunta.Opcao);
            p4.setQuestionario(tituloQuestionario);
            
            p5.setTituloPergunta("Qual seu gênero?");
            p5.setTipoPergunta(TipoPergunta.Opcao);
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
            Pergunta pergunta1 = perguntaDao.findByName("Qual sua idade?");
            OpcaoPergunta op1P1 = new OpcaoPergunta();
            OpcaoPergunta op2P1 = new OpcaoPergunta();    
            OpcaoPergunta op3P1 = new OpcaoPergunta(); 
            OpcaoPergunta op4P1 = new OpcaoPergunta();
            op1P1.setOpcao("Menor de 18");
            op1P1.setPergunta(pergunta1);
            op2P1.setOpcao("Entre 18 e 30");
            op2P1.setPergunta(pergunta1);
            op3P1.setOpcao("Entre 30 e 59");
            op3P1.setPergunta(pergunta1);
            op4P1.setOpcao("Maior que 60");
            op4P1.setPergunta(pergunta1);
            
            Pergunta pergunta2 = perguntaDao.findByName("Você trabalha?");
            OpcaoPergunta op1P2 = new OpcaoPergunta();
            OpcaoPergunta op2P2 = new OpcaoPergunta();           
            op1P2.setOpcao("Sim");
            op1P2.setPergunta(pergunta2);
            op2P2.setOpcao("Não");
            op2P2.setPergunta(pergunta2);
                        
            Pergunta pergunta3 = perguntaDao.findByName("Você estuda?");
            OpcaoPergunta op1P3 = new OpcaoPergunta();
            OpcaoPergunta op2P3 = new OpcaoPergunta();  
            op1P3.setOpcao("Sim");
            op1P3.setPergunta(pergunta3);
            op2P3.setOpcao("Não");
            op2P3.setPergunta(pergunta3);
            
            Pergunta pergunta4 = perguntaDao.findByName("Qual a sua renda?");
            OpcaoPergunta op1P4 = new OpcaoPergunta();
            OpcaoPergunta op2P4 = new OpcaoPergunta();     
            OpcaoPergunta op3P4 = new OpcaoPergunta();  
            op1P4.setOpcao("Menos de um salário mínimo");
            op1P4.setPergunta(pergunta4);
            op2P4.setOpcao("Entre um e três salários mínimo");
            op2P4.setPergunta(pergunta4);
            op3P4.setOpcao("Mais de três salários mínimo");
            op3P4.setPergunta(pergunta4);
            
            Pergunta pergunta5 = perguntaDao.findByName("Qual seu gênero?");
            OpcaoPergunta op1P5 = new OpcaoPergunta();
            OpcaoPergunta op2P5 = new OpcaoPergunta();     
            OpcaoPergunta op3P5 = new OpcaoPergunta();  
            op1P5.setOpcao("Feminino");
            op1P5.setPergunta(pergunta5);
            op2P5.setOpcao("Masculino");
            op2P5.setPergunta(pergunta5);
            op3P5.setOpcao("Outro");
            op3P5.setPergunta(pergunta5);                   
            
            opcaoPerguntaDao.cadastrar(op1P1);
            opcaoPerguntaDao.cadastrar(op2P1);
            opcaoPerguntaDao.cadastrar(op3P1);
            opcaoPerguntaDao.cadastrar(op4P1);
            
            opcaoPerguntaDao.cadastrar(op1P2);
            opcaoPerguntaDao.cadastrar(op2P2);
                        
            opcaoPerguntaDao.cadastrar(op1P3);
            opcaoPerguntaDao.cadastrar(op2P3);
                        
            opcaoPerguntaDao.cadastrar(op1P4);
            opcaoPerguntaDao.cadastrar(op2P4);
            opcaoPerguntaDao.cadastrar(op3P4);    
            
            opcaoPerguntaDao.cadastrar(op1P5);
            opcaoPerguntaDao.cadastrar(op2P5);
            opcaoPerguntaDao.cadastrar(op3P5);
        } catch (Exception e) {            
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }           
        Messages.addMessageSuccess("Questionário3 cadastrado!!");
    }
       
}