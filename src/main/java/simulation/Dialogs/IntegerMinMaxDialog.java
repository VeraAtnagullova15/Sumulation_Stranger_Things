package simulation.Dialogs;

public class IntegerMinMaxDialog extends AbstractDialog <Integer> {
    private final int min;
    private final int max;

    public IntegerMinMaxDialog(String title, String error, int min, int max) {
        super(title, error);
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer input() {
        while (true) {
            showTitle();
            String input = scanner.nextLine();

            if (isTypeValid(input)){
                int result = parseInput(input);
                if (isAllowed(result)) {
                    return result;
                }
            }
            showError();
        }
    }

    @Override
    protected boolean isTypeValid(String input) {
        try {
            int result = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected Integer parseInput(String input) {
        return Integer.parseInt(input);
    }

    @Override
    protected boolean isAllowed(Integer result) {
        return result >= min && result <= max;
    }
}
