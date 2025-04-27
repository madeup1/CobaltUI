package git.madeup.hook;

import git.madeup.input.keyboard.impl.KeyboardPressInput;

public interface IKeyboardHook
{
    void keyboardInput(KeyboardPressInput input);
}
