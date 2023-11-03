package com.example.javafx_tlotr.view;

import com.example.javafx_tlotr.controller.GameController;
import com.example.javafx_tlotr.model.beasts.Beast;
import com.example.javafx_tlotr.model.beasts.beastsTypes.Goblin;
import com.example.javafx_tlotr.model.beasts.beastsTypes.Orc;
import com.example.javafx_tlotr.model.heroes.Hero;
import com.example.javafx_tlotr.model.heroes.heroesTypes.Elf;
import com.example.javafx_tlotr.model.heroes.heroesTypes.Hobbit;
import com.example.javafx_tlotr.model.heroes.heroesTypes.Human;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameView {

    public Image backgroundHeroes;
    public Image backgroundBeasts;
    public Image backgroundFight;
    private final List<Hero> heroesArmy = new ArrayList<>();
    private final List<Beast> beastsArmy = new ArrayList<>();
    @FXML
    private Button addBeast;
    @FXML
    private Button addHero;
    @FXML
    private Spinner<Integer> beastArmor;
    @FXML
    private Spinner<Integer> beastLife;
    @FXML
    private ListView<Beast> beastListView;
    @FXML
    private TextField beastName;
    @FXML
    private Button beastUp;
    @FXML
    private Button beastDown;
    @FXML
    private Button removeBeast;
    @FXML
    private ChoiceBox<String> beastsTypes;
    @FXML
    private TextArea fightAreaText;
    private final List<String> fightLog = new ArrayList<>();
    @FXML
    private Spinner<Integer> heroArmor;
    @FXML
    private Spinner<Integer> heroLife;
    @FXML
    private ListView<Hero> heroListView;
    @FXML
    private TextField heroName;
    @FXML
    private Button heroUp;
    @FXML
    private Button heroDown;
    @FXML
    private Button removeHero;
    @FXML
    private ChoiceBox<String> heroesTypes;
    @FXML
    private Pane window;
    @FXML
    private Pane paneBeasts;
    @FXML
    private Pane paneHeroes;
    @FXML
    private Pane paneFight;

    @FXML
    void initialize() {

        fightAreaText.setText("\n" + "     Q u e   c o m i e n c e   l a   b a t a l l a . . . " + "🎲 \n" + "\n");
        fightAreaText.setStyle("-fx-control-inner-background:  #B3BFA3;" + "-fx-opacity: 0.9;" + "-fx-border-color: #000000;");

        SpinnerValueFactory<Integer> beastArmorFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 60, 10);
        beastArmor.setValueFactory(beastArmorFactory);
        beastArmor.setEditable(true);
        SpinnerValueFactory<Integer> beastLifeFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 300, 20);
        beastLife.setValueFactory(beastLifeFactory);
        beastLife.setEditable(true);

        SpinnerValueFactory<Integer> heroArmorFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 60, 10);
        heroArmor.setValueFactory(heroArmorFactory);
        heroArmor.setEditable(true);
        SpinnerValueFactory<Integer> heroLifeFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 300, 20);
        heroLife.setValueFactory(heroLifeFactory);
        heroLife.setEditable(true);

        beastsTypes.getItems().addAll("Orco", "Trasgo");
        heroesTypes.getItems().addAll("Elfo", "Hobbit", "Humano");


        backgroundHeroes = new Image(Objects.requireNonNull(getClass().getResource("/beastsImage.jpg").toExternalForm()));
        paneHeroes.setStyle("-fx-background-image: url('" + backgroundHeroes.getUrl() + "');" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: cover;" + "-fx-border-color:  #eee8d9;");
        heroLife.setStyle("-fx-control-inner-background:   #EEE8D9;" + "-fx-border-color: #000000;");
        heroArmor.setStyle("-fx-control-inner-background:   #EEE8D9;" + "-fx-border-color: #000000;");

        backgroundBeasts = new Image(Objects.requireNonNull(getClass().getResource("/heroesImage.jpg").toExternalForm()));
        paneBeasts.setStyle("-fx-background-image: url('" + backgroundBeasts.getUrl() + "');" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: cover;" + "-fx-background-position: right center;" + "-fx-border-color:  #eee8d9;");
        beastLife.setStyle("-fx-control-inner-background:   #EEE8D9;" + "-fx-border-color: #000000;");
        beastArmor.setStyle("-fx-control-inner-background:   #EEE8D9;" + "-fx-border-color: #000000;");

        backgroundFight = new Image(Objects.requireNonNull(getClass().getResource("/middleEarthImage.jpg").toExternalForm()));
        paneFight.setStyle("-fx-background-image: url('" + backgroundFight.getUrl() + "');" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: cover;" + "-fx-border-color:  #eee8d9;");
    }

    @FXML
    void onClickAddBeast(ActionEvent event) {
        String name = beastName.getText();
        int armor = beastArmor.getValue();
        int life = beastLife.getValue();
        String type = beastsTypes.getValue();

        Beast newBeast = new Beast(name, life, armor);

        boolean warning = false;
        if (newBeast.getName().isBlank() || newBeast.getName() == null) {
            warning = true;
            beastName.setStyle("-fx-background-color: #EEE8D9;" + "-fx-border-color: red; -fx-border-width: 3px");
            showAlert("Rellena el nombre", "Por favor, introduce un nombre para la bestia.");
            newBeast = null;
            return;

        } else {
            beastName.setStyle("-fx-background-color: #EEE8D9;" + "-fx-border-color: black; -fx-border-width: 1px");
        }

        if (type == null || type.isBlank()) {
            warning = true;
            beastsTypes.setStyle("-fx-background-color: #EEE8D9;" + "-fx-border-color: red; -fx-border-width: 3px");
            showAlert("Elige un tipo", "Por favor, selecciona un tipo para la bestia.");
            newBeast = null;
            return;

        } else {
            beastsTypes.setStyle("-fx-background-color: #EEE8D9;" + "-fx-border-color: black; -fx-border-width: 1px");
        }

        if (newBeast.getName() != null && type != null) {
            if ("Orco".equals(type)) {
                newBeast = new Orc(name, life, armor);
            } else if ("Trasgo".equals(type)) {
                newBeast = new Goblin(name, life, armor);
            }
            beastsArmy.add(newBeast);
            String newBeastInfo = newBeast.toString();
            beastListView.getItems().setAll(beastsArmy);
        }
        beastName.clear();
        beastArmor.getValueFactory().setValue(0);
        beastLife.getValueFactory().setValue(0);
        beastsTypes.getSelectionModel().clearSelection();
    }

    @FXML
    void onClickAddHero(ActionEvent event) {
        String name = heroName.getText();
        int armor = heroArmor.getValue();
        int life = heroLife.getValue();
        String type = heroesTypes.getValue();

        Hero newHero = new Hero(name, life, armor);

        boolean warning = false;
        if (newHero.getName().isBlank() || newHero.getName() == null) {
            warning = true;
            heroName.setStyle("-fx-background-color: #EEE8D9;" + "-fx-border-color: red; -fx-border-width: 3px");
            showAlert("Rellena el nombre", "Por favor, introduce un nombre para el héroe.");
            newHero = null;
            return;

        } else {
            heroName.setStyle("-fx-background-color: #EEE8D9;" + "-fx-border-color: black; -fx-border-width: 1px");
        }

        if (type == null || type.isBlank()) {
            warning = true;
            heroesTypes.setStyle("-fx-background-color: #EEE8D9;" + "-fx-border-color: red; -fx-border-width: 3px");
            showAlert("Elige un tipo", "Por favor, selecciona un tipo para el héroe.");
            newHero = null;
            return;

        } else {
            heroesTypes.setStyle("-fx-background-color: #EEE8D9;" + "-fx-border-color: black; -fx-border-width: 1px");
        }

        if (newHero.getName() != null && type != null) {
            if ("Elfo".equals(type)) {
                newHero = new Elf(name, life, armor);
            } else if ("Hobbit".equals(type)) {
                newHero = new Hobbit(name, life, armor);
            } else if ("Humano".equals(type)) {
                newHero = new Human(name, life, armor);
            }
            heroesArmy.add(newHero);
            String newHeroInfo = newHero.toString();
            heroListView.getItems().setAll(heroesArmy);
        }
        heroName.clear();
        heroArmor.getValueFactory().setValue(0);
        heroLife.getValueFactory().setValue(0);
        heroesTypes.getSelectionModel().clearSelection();
    }

    @FXML
    void onClickBeastDown(ActionEvent event) {
        int selectedIndex = beastListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < beastsArmy.size() - 1) {
            Collections.swap(beastsArmy, selectedIndex, selectedIndex + 1);
            beastListView.getItems().setAll(beastsArmy);
            beastListView.getSelectionModel().select(selectedIndex + 1);
        }
    }

    @FXML
    void onClickBeastUp(ActionEvent event) {
        int selectedIndex = beastListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex > 0) {
            Collections.swap(beastsArmy, selectedIndex, selectedIndex - 1);
            beastListView.getItems().setAll(beastsArmy);
            beastListView.getSelectionModel().select(selectedIndex - 1);
        }
    }

    @FXML
    void onClickFight(ActionEvent event) {

        setListViewsDisabled(true);

        List<Hero> initialHeroesArmy = new ArrayList<>(heroesArmy);
        List<Beast> initialBeastsArmy = new ArrayList<>(beastsArmy);

        new Thread(() -> {
            GameController gameController = new GameController(heroesArmy, beastsArmy);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            System.setOut(ps);

            gameController.play();

            String fightOutput = baos.toString();
            fightLog.add(fightOutput);

            String[] lines = fightOutput.split("\n");

            for (String line : lines) {
                Platform.runLater(() -> {
                    fightAreaText.appendText(line + "\n");
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Platform.runLater(() -> {
                heroesArmy.clear();
                heroesArmy.addAll(initialHeroesArmy);
                beastsArmy.clear();
                beastsArmy.addAll(initialBeastsArmy);
                beastListView.getItems().setAll(beastsArmy);
                heroListView.getItems().setAll(heroesArmy);
                setListViewsDisabled(false);
                showWinnerAlert(gameController.getWinner());
            });

        }).start();
    }

    private void setListViewsDisabled(boolean disabled) {
        addHero.setDisable(disabled);
        addBeast.setDisable(disabled);
        heroUp.setDisable(disabled);
        heroDown.setDisable(disabled);
        removeHero.setDisable(disabled);
        beastUp.setDisable(disabled);
        beastDown.setDisable(disabled);
        removeBeast.setDisable(disabled);
    }

    @FXML
    void onClickHeroDown(ActionEvent event) {
        int selectedIndex = heroListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < heroesArmy.size() - 1) {
            Collections.swap(heroesArmy, selectedIndex, selectedIndex + 1);
            heroListView.getItems().setAll(heroesArmy);
            heroListView.getSelectionModel().select(selectedIndex + 1);
        }
    }

    @FXML
    void onClickHeroUp(ActionEvent event) {
        int selectedIndex = heroListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex > 0) {
            Collections.swap(heroesArmy, selectedIndex, selectedIndex - 1);
            heroListView.getItems().setAll(heroesArmy);
            heroListView.getSelectionModel().select(selectedIndex - 1);
        }
    }

    @FXML
    void onClickRemoveBeast(ActionEvent event) {
        Beast selectedBeast = beastListView.getSelectionModel().getSelectedItem();
        if (selectedBeast != null) {
            beastsArmy.remove(selectedBeast);
            beastListView.getItems().setAll(beastsArmy);
        }
    }

    @FXML
    void onClickRemoveHero(ActionEvent event) {
        Hero selectedHero = heroListView.getSelectionModel().getSelectedItem();
        if (selectedHero != null) {
            heroesArmy.remove(selectedHero);
            heroListView.getItems().setAll(heroesArmy);
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showWinnerAlert(String winner) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("¡Fin de la partida!");
        alert.setHeaderText(null);
        alert.setContentText("¡VICTORIA DE " + winner.toUpperCase() + "!");
        alert.showAndWait();
    }
}
