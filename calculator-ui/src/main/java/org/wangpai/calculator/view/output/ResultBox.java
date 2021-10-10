package org.wangpai.calculator.view.output;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;
import lombok.extern.slf4j.Slf4j;
import org.wangpai.calculator.model.universal.CentralDatabase;
import org.wangpai.calculator.model.universal.Function;
import org.wangpai.calculator.model.universal.Multithreading;
import org.wangpai.calculator.view.base.TextBox;

@Slf4j
public class ResultBox extends TextBox {
    @FXML
    private VBox textareaVBox;

    private TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var resultBox = this;
        // 懒执行
        Multithreading.execute(new Function() {
            @Override
            public void run() {
                log.info("开始初始化 ResultBox。时间：{}ms", System.currentTimeMillis() - CentralDatabase.startTime);

                ResultBoxLinker.linking(resultBox);

                Platform.runLater(() -> {
                    // 从 VBox 中取出 TextArea
                    var node = textareaVBox.getChildren().get(0);
                    if (node instanceof TextArea) {
                        resultBox.textArea = (TextArea) node;
                    }
                    resultBox.initSuperTextArea(resultBox.textArea);
                    resultBox.setFocusPriority(false);

                    log.info("ResultBox 初始化完成。时间：{}ms", System.currentTimeMillis() - CentralDatabase.startTime);
                });
            }
        });
    }

    /**
     * @since 2021-8-7
     */
    @Override
    public ResultBox setText(String msg) {
        super.setText(msg);
        this.setBarAtTheBottom(); // 将滚动条拨到最下
        return this;
    }

    /**
     * @since 2021-8-7
     */
    @Override
    public ResultBox append(String msg) {
        super.append(msg);
        this.setBarAtTheBottom(); // 将滚动条拨到最下
        return this;
    }
}
