package RandomCharacterMod.Patches;


import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.screens.custom.CustomModeScreen;
import com.megacrit.cardcrawl.trials.CustomTrial;

import java.util.ArrayList;

@SpirePatch(
        clz= CustomModeScreen.class,
        method="addNonDailyMods"
)
public class CustomModeScreenPatch {
    @SpireInsertPatch(
            rloc=1,
            localvars={"modId"}
    )
    public static void Insert(CustomModeScreen __instance, CustomTrial trial, ArrayList<String> modIds, String modId)
    {
        if ("randomCharMod:RandomCharacter".equals(modId)) {
            // Enable random character flag
            RandomCharacterTrial.randomCharacter.set(trial, true);
        }
    }
}