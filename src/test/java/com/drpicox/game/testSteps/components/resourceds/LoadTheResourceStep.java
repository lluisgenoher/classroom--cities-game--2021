package com.drpicox.game.testSteps.components.resourceds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.PrettyKey;
import org.springframework.stereotype.Component;

@Component
public class LoadTheResourceStep extends AbstractPostLineStep {

    private final ResourcedTestView resourcedTestView;

    public LoadTheResourceStep(ResourcedTestView resourcedTestView) {
        this.resourcedTestView = resourcedTestView;
    }

    @Override
    protected String getRegex() {
        return "Load the resource \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var resource = PrettyKey.getKey(match[1]);

        resourcedTestView.load(resource);
    }
}