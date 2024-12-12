package menu.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;
import menu.view.OutputView;

public abstract class InputViewTemplate<T> {

    public T readOnce(Object... headerArgs) {
        printHeader(headerArgs);
        String input = Console.readLine();
        return bind(input);
    }

    public T readUntilSuccess(Object... headerArgs) {
        return readUntilSuccess(() -> readOnce(headerArgs));
    }

    protected T readUntilSuccess(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    protected abstract void printHeader(Object... args);

    protected abstract T bind(String userInput);
}