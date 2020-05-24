package com.platzi.functional._04_functional;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLIArgumentsUtils {

    // Recibe los argumentos del CLI
    static void showHelp(CLIArguments cliArguments) {
        // El consumer itera todos esos argumentos.
        // Recibe un CLIArguments.
        Consumer<CLIArguments> consumerHelper = cliArguments1 -> {
            // Realiza una evaluacion.
            if(cliArguments1.isHelp()) {
                System.out.println("Manual solicitado");
            }
        };

        consumerHelper.accept(cliArguments);
    }

    static CLIArguments generateCLI() {
        Supplier<CLIArguments> generator = () -> new CLIArguments();

        return generator.get();
    }
}
