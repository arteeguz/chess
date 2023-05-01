package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

public class Timer {
    private Timeline timeline;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(0);

    public Timer(int minutes) {
        setTime(minutes * 60);
    }

    public void setTime(int seconds) {
        timeSeconds.set(seconds);
    }

    public IntegerProperty timeSecondsProperty() {
        return timeSeconds;
    }

    public void start() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            timeSeconds.set(timeSeconds.get() - 1);
            if (timeSeconds.get() == 0) {
                timeline.stop();
                // TODO: add logic for what happens when the timer runs out
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }
}
