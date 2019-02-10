package RandomCharacterMod.Patches;


import com.evacipated.cardcrawl.modthespire.lib.ByRef;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.trials.AbstractTrial;

import java.util.Random;

@SpirePatch(
    clz= CardCrawlGame.class,
    method="setupTrialPlayer"
)
public class SetupTrialPlayerPatch {
    private static Random charRandom = new Random();

    private static AbstractPlayer.PlayerClass[] VALUES = null;

    @SpireInsertPatch(
        rloc=0,
        localvars = {"chosenCharacter"}
    )
    public static void InsertPatch(CardCrawlGame __instance, AbstractTrial trial, @ByRef(type="com.megacrit.cardcrawl.characters.AbstractPlayer.PlayerClass") Object[] chosenCharacter)
    {
        if (RandomCharacterTrial.randomCharacter.get(trial))
        {
            if (VALUES == null)
            {
                VALUES = AbstractPlayer.PlayerClass.values();
            }

            chosenCharacter[0] = VALUES[charRandom.nextInt(VALUES.length)];
        }
    }
}
