package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.OpcaoPerguntaDao;
import br.edu.ifsp.pep.dao.PerguntaDao;
import br.edu.ifsp.pep.dao.RespostaDao;
import br.edu.ifsp.pep.dao.TokenDao;
import br.edu.ifsp.pep.modelo.OpcaoPergunta;
import br.edu.ifsp.pep.modelo.Pergunta;
import br.edu.ifsp.pep.modelo.Pessoa;
import br.edu.ifsp.pep.modelo.Questionario;
import br.edu.ifsp.pep.modelo.Resposta;
import br.edu.ifsp.pep.modelo.Token;
import br.edu.ifsp.pep.util.Messages;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@SessionScoped
public class RespostaController implements Serializable {

    private Questionario questionarioSelecionado;
    private List<Pergunta> perguntas;
    //armazena as opções de resposta conforme o id da pergunta
    private Map<Integer, List<OpcaoPergunta>> opcoesRespostas;
    //armazena as respostas do usuario confome o id da pergunta
    private Map<Integer, OpcaoPergunta> respostas;
    private Token token = new Token();
    
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    @Inject
    private PessoaController pessoaController;
    @Inject
    private PerguntaDao perguntaDao;
    @Inject
    private OpcaoPerguntaDao opcaoPerguntaDao;
    @Inject
    private RespostaDao respostaDao;
    @Inject
    private TokenDao tokenDao;
    
    public static String gerarToken(int length) {
        StringBuilder t = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            t.append(CHARACTERS.charAt(randomIndex));
        }
        return t.toString();
    }
    
    private Pessoa pessoaLogada() {
        return pessoaController.getPessoaLogada();
    }
    
    
    
    public void selecionar() {
        Pessoa pessoaLogada = pessoaLogada();
        List<Token> consulta = tokenDao.findToken(pessoaLogada, questionarioSelecionado);

        if ((questionarioSelecionado != null)) {
            if (!consulta.isEmpty()) {
                Messages.addMessageError("Esse questionário já foi respondido pelo usuário '" + pessoaLogada.getNome() + "'");
            } else {
                //acha as perguntas pelo id do questionário
                perguntas = perguntaDao.findPerguntasById(questionarioSelecionado.getIdQuestionario());
                if (perguntas.isEmpty()) {
                    Messages.addMessageError("Esse questionário não possui perguntas");
                } else {
                    inicializarRespostas();
                    carregarOpcoesRespostaByPergunta();
                }
            }
        } else {
            Messages.addMessageError("Selecione um questionário.");
            perguntas = new ArrayList<>();//limpar a lista de perguntas se nenhum questionário estiver selecionado
            opcoesRespostas = new HashMap<>();
            respostas = new HashMap<>();
        }
    }
    
    private void inicializarRespostas() {
        respostas = new HashMap<>();
        //colocando os id das perguntas na lista, para depois colocar as respostas, é tipo o dicionário em python
        for (Pergunta p : perguntas) {
            respostas.put(p.getIdPergunta(), null);
        }

    }

    private void carregarOpcoesRespostaByPergunta() {
        opcoesRespostas = new HashMap<>();
        for (Pergunta p : perguntas) {
            List<OpcaoPergunta> opcoes = opcaoPerguntaDao.findOpcoesByPergunta(p.getIdPergunta());
            opcoesRespostas.put(p.getIdPergunta(), opcoes);
        }
    }

    
    
    public void enviarRespostas() {
        System.out.println("Enviando respostas...");
        LocalDateTime dataAtual = LocalDateTime.now();
        if(dataAtual.isAfter(questionarioSelecionado.getDataFechamento())) {
            Messages.addMessageError("Esse questionário não pode receber mais respostas.");
        } else {
            try {
                Pessoa pessoaLogada = pessoaLogada();
                //em resposats ta o Id das perguntas
                for (Map.Entry<Integer, OpcaoPergunta> entry : respostas.entrySet()) {
                    Resposta resposta = new Resposta();
                    resposta.setFk_pergunta_resposta(perguntaDao.findById(entry.getKey()));
                    resposta.setRespostaOp(entry.getValue());
                    resposta.setFk_pessoa_resposta(pessoaLogada);

                    respostaDao.cadastrar(resposta);    
                    String tkn = gerarToken(5);
                    token.setChave(tkn);
                    token.setStatus(true);
                    token.setFk_pessoa_token(pessoaLogada);
                    token.setFk_questionario_token(questionarioSelecionado);
                    tokenDao.cadastrar(token);                    
                }
                Messages.addMessageSuccess("Resposta enviada.");
                Messages.addMessageSuccess("Token adicionado");
            } catch (Exception e) {
                e.printStackTrace();
                Messages.addMessageError("Erro ao enviar respostas.");
            }

        }

    }

    public Questionario getQuestionarioSelecionado() {
        return questionarioSelecionado;
    }

    public void setQuestionarioSelecionado(Questionario questionarioSelecionado) {
        this.questionarioSelecionado = questionarioSelecionado;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public Map<Integer, List<OpcaoPergunta>> getOpcoesRespostas() {
        return opcoesRespostas;
    }

    public void setOpcoesRespostas(Map<Integer, List<OpcaoPergunta>> opcoesRespostas) {
        this.opcoesRespostas = opcoesRespostas;
    }

    public Map<Integer, OpcaoPergunta> getRespostas() {
        return respostas;
    }

    public void setRespostas(Map<Integer, OpcaoPergunta> respostas) {
        this.respostas = respostas;
    }

}
