package simulation.Dialogs;

public class EnglishLetterSelectDialog extends AbstractDialog <Character> {

    public EnglishLetterSelectDialog(String title, String error) {
        super(title, error);
    }

    @Override
    protected boolean isTypeValid(String input) {
        return input.length() == 1;
    }

    @Override
    protected Character parseInput(String input) {
        return input.charAt(0);
    }

    @Override
    protected boolean isAllowed(Character result) {
        result = Character.toLowerCase(result);
        return result == 't' || result == 's' || result == 'p' || result == 'r' || result == 'q';
    }

    @Override
    public Character input() {
        while (true) {
            showTitle();
            String input = scanner.nextLine();

            if (isTypeValid(input)) {
                Character result = parseInput(input);
                if (isAllowed(result)) {
                    return result;
                }
            }
            showError();
        }
    }

}
