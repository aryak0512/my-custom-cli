package com.aryak.cli;

import org.jline.utils.AttributedString;

import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class MyPromptProvider implements PromptProvider {

    @Override
    public AttributedString getPrompt() {
        return new AttributedString("aryak's-cli:> ");
    }

}
