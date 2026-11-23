package com.example.projeto_tarefas.Controller;

import com.example.projeto_tarefas.dominio.Prioridade;
import com.example.projeto_tarefas.dominio.Status;
import com.example.projeto_tarefas.dominio.Tarefa;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CadrastroController {



        @FXML
        private DatePicker dataselect;

        @FXML
        private Label labeldescricao;

        @FXML
        private Label labelprioridade;

        @FXML
        private Label labeltarefa;

        @FXML
        private Label lbdataentrega;

        @FXML
        private TextField nometarefa;

        @FXML
        private AnchorPane principaltela;

        @FXML
        private ComboBox<?> prioridadesdp;

        @FXML
        private TextField textdecricao;

        @FXML
        private Label titulotarefa;


    public void info(String title, String message, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();

    }
    @FXML
    public void cadastroTarefa(ActionEvent event) throws IOException {
        String nome = nometarefa.getText();
        String descricao = textdecricao.getText();
        String data = dataselect.getValue().toString();
        String prioridade = prioridadesdp.getValue().toString();

        if (nome.trim().isEmpty() || descricao.trim().isEmpty() ||
                data.trim().isEmpty() || prioridade.trim().isEmpty()){
            info("Mensagem", "Preencha todos os campos ", Alert.AlertType.WARNING);
            return;
        }
    }


    public List<Tarefa> init(){
        return Arrays.asList(
                new Tarefa("PROJETO-POO", "projeto feito com javafx", "01/12/2026", Status.PENDENTE, Prioridade.MEDIA),
                new Tarefa("AVIII", "INTEGRAIS DEFINIDAS", "04/12/2026", Status.PENDENTE, Prioridade.ALTA),
                new Tarefa("PROJETO-ONG", "projeto feito com jS", "01/12/2026", Status.PENDENTE, Prioridade.MEDIA)
        );
    }

}
