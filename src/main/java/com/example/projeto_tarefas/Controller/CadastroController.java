package com.example.projeto_tarefas.Controller;

import com.example.projeto_tarefas.dominio.Prioridade;
import com.example.projeto_tarefas.dominio.Status;
import com.example.projeto_tarefas.dominio.Tarefa;
import com.example.projeto_tarefas.dominio.TarefasServicos;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class CadastroController {

    @FXML
    private AnchorPane principaltela;

    @FXML
    private TextField nometarefa;

    @FXML
    private ComboBox<Prioridade> prioridadesdp;

    @FXML
    private DatePicker dataselect;

    @FXML
    private TextField textdecricao;

    @FXML
    private Label titulotarefa;

    @FXML
    private Label labeltarefa;

    @FXML
    private Label labelprioridade;

    @FXML
    private Label lbdataentrega;

    @FXML
    private Label labeldescricao;

    private final TarefasServicos tarefasServicos = new TarefasServicos();

    @FXML
    public void initialize() {
        prioridadesdp.setItems(FXCollections.observableArrayList(Prioridade.values()));
    }

    @FXML
    public void salvarTarefa(ActionEvent event) throws IOException {
        String nome = nometarefa.getText();
        String descricao = textdecricao.getText();
        LocalDate data = dataselect.getValue();
        Prioridade prioridade = prioridadesdp.getValue();

        if (nome.isBlank() || descricao.isBlank() || data == null || prioridade == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cadastro");
            alert.setContentText("Todos os campos são obrigatórios");
            alert.show();
            return;
        }


        Tarefa novaTarefa = new Tarefa("PROJETO","javafx","01/12/26",Status.PENDENTE,Prioridade.ALTA);
        Tarefa novaTarefai = new Tarefa("PROJETO","javafx","01/12/26",Status.PENDENTE,Prioridade.ALTA);
        Tarefa novaTarefaii = new Tarefa("PROJETO","javafx","01/12/26",Status.PENDENTE,Prioridade.ALTA);
        tarefasServicos.adicionar(novaTarefa);
        tarefasServicos.adicionar(novaTarefai);
        tarefasServicos.adicionar(novaTarefaii);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro");
        alert.setContentText("Tarefa cadastrada com sucesso!");
        alert.showAndWait();

        abrirListaTarefas(event);
    }

    private void abrirListaTarefas(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/projeto_tarefas/lista-tarefas.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
