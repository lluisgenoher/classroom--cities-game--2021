package com.drpicox.game.testSteps.owneds;

import com.drpicox.game.ecs.EntityResponse;
import com.drpicox.game.testSteps.game.EntityTestView;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class OwnedTestView {

    private final EntityTestView entityTestView;

    public OwnedTestView(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    public static Predicate<EntityResponse> byOwner(String ownerName) {
        return e -> e.getOrDefault("ownerName", "").equals(ownerName);
    }

    public String getOnwerName() {
        return (String) entityTestView.getEntityProperty("ownerName");
    }
}