package zinogre.pascal.mhwpc.Shared;

import java.util.ArrayList;
import java.util.Arrays;

import zinogre.pascal.mhwpc.R;

public class Globals {

    public static final ArrayList<Integer> MAX = new ArrayList<>(Arrays.asList(1, 5, 7, 3, 7, 5, 3, 1, 3, 5, 3));
    public static final ArrayList<String> ATTACKSKILLS = new ArrayList<>(Arrays.asList(
            "Affinity Sliding", "Agitator", "Attack Boost", "Critical Boost", "Critical Eye",
            "Heroics", "Maximum Might", "Non-elemental Boost", "Peak Performance", "Resentment",
            "Weakness Exploit"));
    public static final ArrayList<String> WEAPONS = new ArrayList<>(Arrays.asList("Great Sword",
            "Sword and Shield", "Dual Blades", "Long Sword", "Hammer", "Hunting Horn", "Lance",
            "Gunlance", "Switch Axe", "Charge Blade", "Insect Glaive", "Bow", "Light Bowgun",
            "Heavy Bowgun"));
    public static final ArrayList<String> SHARPNESS = new ArrayList<>(Arrays.asList("Yellow",
            "Green", "Blue", "White"));
    public static final int FragmentContainer = R.id.fragment_container;
}
