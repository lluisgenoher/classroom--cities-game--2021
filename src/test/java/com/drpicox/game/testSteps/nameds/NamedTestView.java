package com.drpicox.game.testSteps.nameds;

import com.drpicox.game.ecs.EntityResponse;
import com.drpicox.game.testSteps.game.EntityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class NamedTestView {

    private final EntityTestView entityTestView;
    private final GameTestView gameTestView;
    private final NavigatorTestView navigatorTestView;

    public NamedTestView(EntityTestView entityTestView, GameTestView gameTestView, NavigatorTestView navigatorTestView) {
        this.entityTestView = entityTestView;
        this.gameTestView = gameTestView;
        this.navigatorTestView = navigatorTestView;
    }

    private String newName;

    public static Predicate<EntityResponse> byName(String name) {
        return e -> e.getOrDefault("name", "").equals(name);
    }

    public static Function<EntityResponse,String> toName() {
        return e -> (String) e.getOrDefault("name", "-without name-");
    }

    public String getNamedName() {
        return (String) entityTestView.getEntityProperty("name");
    }

    public void enterNewName(String newName) {
        this.newName = newName;
    }

    public void submitChangeCityName() {
        String entityId = navigatorTestView.peekId();

        var data = new HashMap<String, String>();
        data.put("newName", newName);

        gameTestView.post("/api/v1/nameds/" + entityId + "/name", data);
    }
}