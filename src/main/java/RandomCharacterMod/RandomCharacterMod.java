package RandomCharacterMod;

import basemod.BaseMod;
import basemod.interfaces.AddCustomModeModsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.RunModStrings;
import com.megacrit.cardcrawl.screens.custom.CustomMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@SpireInitializer
public class RandomCharacterMod implements AddCustomModeModsSubscriber, EditStringsSubscriber {
    public static final Logger logger = LogManager.getLogger(RandomCharacterMod.class.getSimpleName());

    public RandomCharacterMod()
    {
        logger.info("Subscribing to BaseMod hooks");
        BaseMod.subscribe(this);
    }


    @SuppressWarnings("unused")
    public static void initialize() {
        logger.info("Initializing Random Character Mod.");
        new RandomCharacterMod();
    }

    @Override
    public void receiveEditStrings() {
        String lang = Settings.language.name().toLowerCase();

        switch (Settings.language)
        {
            case RUS: //put all cases that are implemented here
            case SPA:
            case POL:
                BaseMod.loadCustomStringsFile(RunModStrings.class, assetPath("localization/" + lang + "/RunModStrings.json"));
                break;
            default:
                BaseMod.loadCustomStringsFile(RunModStrings.class, assetPath("localization/eng/RunModStrings.json"));
                break;
        }
    }

    @Override
    public void receiveCustomModeMods(List<CustomMod> list)
    {
        list.add(new CustomMod("randomCharMod:RandomCharacter", "b", false));
    }

    public static String assetPath(String path)
    {
        return "RandomCharacterMod/" + path;
    }
}
