package RandomCharacterMod.Patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireField;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.trials.CustomTrial;

@SpirePatch(
        clz=CustomTrial.class,
        method=SpirePatch.CLASS
)
public class RandomCharacterTrial {
    public static SpireField<Boolean> randomCharacter = new SpireField<>(() -> false);
}
