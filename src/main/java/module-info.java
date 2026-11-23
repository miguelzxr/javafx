module com.example.projeto_tarefas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.projeto_tarefas to javafx.fxml;
    exports com.example.projeto_tarefas;
}