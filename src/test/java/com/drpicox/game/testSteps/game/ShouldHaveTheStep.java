package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.drpicox.game.testSteps.typeds.TypedTestView.byType;
import static com.drpicox.game.testSteps.nameds.NamedTestView.toName;
import static com.drpicox.game.testSteps.owneds.OwnedTestView.byOwner;
import static com.google.common.truth.Truth8.assertThat;

@Component
public class ShouldHaveTheStep extends AbstractPostLineStep {


    private final GameTestView gameTestView;

    public ShouldHaveTheStep(GameTestView gameTestView) {
        this.gameTestView = gameTestView;
    }

    @Override
    protected String getRegex() {
        return "\"([^\"]+)\" should have the \"([^\"]+)\" \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var playerName = match[1];
        var cityName = match[2];
        var type = match[3];

        var cityNames = gameTestView.streamEntities(byType(type).and(byOwner(playerName))).map(toName());
        assertThat(cityNames).contains(cityName);
    }
}