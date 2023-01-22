package game;
import java.util.*;     // required for ArrayList
import gameobjects.*;
import globals.Direction;
import java.util.Scanner;


public class Game implements java.io.Serializable {
    Dice classDice = new Dice();
    DBSql db = new DBSql();

    boolean potionChoice = true;
    boolean describeRoomWithoutItems = true;

    boolean choseSkillPotion = false;
    boolean choseStrengthPotion = false;
    boolean choseFortunePotion = false;

    private ArrayList<Room> map; // the map - an ArrayList of Rooms
    private Actor player;  // the player - provides 'first-person perspective'


    List<String> commands = new ArrayList<>(Arrays.asList(
            "take", "drop", "look", "l", "i", "inventory",
            "n", "s", "e", "w", "open","use",
            "save", "load"));
    List<String> objects = new ArrayList<>(Arrays.asList("sword","potion", "shield",
            "paper", "pencil", "ring", "wombat", "box", "bow", "arrow", "skillpotion", "strengthpotion", "fortunepotion"));

    public Game() {
//todo her tilføjes items. - ikke færdig implementeret
       // System.out.println(db.createEnemy(1));
        this.map = new ArrayList<Room>();

        ThingList r0 = new ThingList();//nothing
        r0.add(new Treasure("SkillPotion", "Returns your skill to former heights", 0, 0, 0, 1, 0,0,0));
        r0.add(new Treasure("StrengthPotion", "Reforges your constitution, and returns your stamina", 0, 0, 0, 1, 0,0 ,0));
        r0.add(new Treasure("FortunePotion", "Even Felix Felicis didn't feel this lucky", 0, 0, 0, 0, 0, 1, 0));

        ThingList c278 = new ThingList();//nothing
        c278.add(new Treasure("bow", "A Old bow that seems to be broken", 0, 0, 0, 0, 0, 1, 0));

        ThingList r343 = new ThingList();//man mister 1 stamina hvis man går herind. Hver gang du går derind
        ThingList c71 = new ThingList();//hvis man taber sit luck check så skal man slås med en ork
        ThingList c301 = new ThingList();//nothing
        ThingList r82 = new ThingList();
        ThingList c208 = new ThingList();//nothing
        ThingList r397 = new ThingList();//Der er en box med items - slange, 1 bronze key 99 og en +1 luck
        ThingList j42 = new ThingList();//nothing
        ThingList c257 = new ThingList();//nothing
        ThingList r168 = new ThingList();//En battle hvor man får ting når man vinder, man bliver skudt, man beholder items hvis an overlever // CHEST
        ThingList j113 = new ThingList();//nothing
        ThingList c78 = new ThingList();//nothing
        ThingList r159 = new ThingList();//5 orker - hvis man vinder får man en thin leather case og hvis man åbner den får man en sindsyg bue og en sølv pil // du kan spise provisions derinde og får 1+ luck // test your luck hvis du prøve at leave uden at dræbe orker
        ThingList c285 = new ThingList();//nothing
        ThingList r36 = new ThingList();// gammel mand og hvis man IKKE slår ham ihjel får man +1 luck og information
        ThingList c314 = new ThingList();//nothing
        ThingList r155 = new ThingList();  //der er et shield hvis du tager det skal du fjerne 1 item fra inventory
        ThingList c300 = new ThingList();//nothing
        ThingList r102 = new ThingList();//man kan vælge om at angribe 2 goblins og hvis man vinder får man cheeese
        ThingList p303 = new ThingList(); //Two levers, if left, roll 1d6. If uneven, you cut your sword-hand, and -3 SKILL, -1 STAMINA, if even, -1 SKILL, -2 STAMINA
        //         If right, proceed

        ThingList playerlist = new ThingList();

        //Første room er room 0, derefter 1, 2 osv
        // Add Rooms to the map
        //                 Room( name,   description,                             N,        S,      E,      W )

        //0
        map.add(new Room("r0", " Dark, slimy walls with pools of water on the stone floor", Direction.NOEXIT, Direction.NOEXIT, 1, 3, r0, 1));//ændre treasure list
        //1
        map.add(new Room("c278", "A east-west corridor", Direction.NOEXIT, Direction.NOEXIT, 2, 0, c278, 1));// TC
        //2
        map.add(new Room("r343", "A 2 metre deep pit", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 1, r343, 2));//ændre TL
        //3
        map.add(new Room("c71", "A corridor with a turn that goes north", 4, Direction.NOEXIT, 0, Direction.NOEXIT, c71, 3));//tc, test your luck, muligt ec
        //4
        map.add(new Room("c301", "A corridor that goes north, with a room on the west wall", 6, Direction.NOEXIT, Direction.NOEXIT, 5, c301, 1));//tc, test your luck, muligt ec
        //5
        map.add(new Room("r82", "A small smelly room", Direction.NOEXIT, Direction.NOEXIT, 4, Direction.NOEXIT, r82, 4));//tc, test your luck, muligt ec
        //6
        map.add(new Room("c208", "A corridor with a turn that continues north", 8, 4, Direction.NOEXIT, 7, c208, 1));//tc, test your luck, muligt ec
        //7
        map.add(new Room("r397", " A small room with a stone floor and dirty walls", Direction.NOEXIT, Direction.NOEXIT, 2, Direction.NOEXIT, r397, 1));//tc
        //8
        map.add(new Room("j42", " A threeway junction", Direction.NOEXIT, 6, 11, 9, j42, 1));//tc
        //9
        map.add(new Room("c257", " A long corridor running west", Direction.NOEXIT, Direction.NOEXIT, 8, Direction.NOEXIT, c257, 1));//tc
        //10
        map.add(new Room("r168", "A big room with a large chair and a chest ", Direction.NOEXIT, Direction.NOEXIT, 9, Direction.NOEXIT, r168, 5));//tc
        //11
        map.add(new Room("j113", " A small room with a stone floor and dirty walls", 14, Direction.NOEXIT, 12, 8, j113, 1));//tc
        //12
        map.add(new Room("c78", " A corridor ending with a solid wooden door with metal hinges, sounds of pots and pans inside", Direction.NOEXIT, Direction.NOEXIT, 13, 11, c78, 1));//tc
        //13
        map.add(new Room("r159", " A large dinning room with 5 Orcs around it", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 12, r159, 5));//tc
        //14
        map.add(new Room("c285", " A corridor with a well-used door on the right hand, and a man creaming for help inside", 16, 11, 15, Direction.NOEXIT, c285, 1));//tc
        //15
        map.add(new Room("r36", " A nauseating stench, bones, rotting vegetation, and slime on the floor. A wild-haired old man rushes at you, screaming", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 14, r36, 1));//tc
        //16
        map.add(new Room("c314", " A north running corridor, door on the right, but no sound behind it", 18, 14, Direction.NOEXIT, 17, c314, 1));//tc
        //17
        map.add(new Room("r155", " A armoury room with various equipment, and a singe torch on the wall", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 16, r155, 1));//tc
        //18
        map.add(new Room("c300", " A north running corridor on the east wall is a door made of solid metal, with tortured screams coming from within.", 20, 16, 19, Direction.NOEXIT, c300, 1));//tc
        //19
        map.add(new Room("r102", " The door is unlocked: it's a torture chamber. Two small, hunchbacked creatures are torturing a dwarf", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 18, r102, 1));//tc
        //20
        map.add(new Room("p303", " An iron portcullis is blocking your path, on your right is two levers.", 21, 18, Direction.NOEXIT, Direction.NOEXIT, p303, 1));//tc

        // create player and place in Room 0 (i.e. the Room at 0 index of map)
        player = new Actor("player", "a loveable game-player", 0, 0, 0, 0, 0, 0, playerlist, map.get(0));
        Enemy orc = db.createEnemy(1);

    }

    //Checks scenario with a switch statement that affects fx. stats
    public void checkStatsBasedOnScenario() {
        int ChoiceForStatsSwitchGame = player.getRoom().ChoiseForStatsSwitch;

        switch (ChoiceForStatsSwitchGame) {
            case 1:
                //
                // For all rooms without skill, stamina or luck check
                break;

            case 2:
                //Room r343 aka pit. Player lose 1 stamina every time he/she enters
                System.out.println("You fell into the pit and loses 1 stamina!");
                player.setCurrentStamina(player.getCurrentStamina() - 1);
                System.out.println("Your current Stamina is " + player.getCurrentStamina());
                if (player.getCurrentStamina() <= 0) {
                    gameOver();
                }
                break;

            case 3:
                //Room c71 aka sentry post with goblin(its a orc) like creature - test you luck - if lucky goblin(orc) sleep and if unlucky goblin(orc) wake up
                roomc71Battle();
                //testYourLuck();
                break;

            case 4:
                //Room r82 player gets choice to kill orc, or take chest with test your luck
                break;

            case 5:
                //168 orc cheiftain + orc servant
                room168Battle();
                break;

            case 6:
                //for room 159 5 orker
                //go to switch 1
                break;

            case 7:
                //102 2 goblins
                break;
        }
    }

    public void roomc71Battle(){
        System.out.println("You encountered a 1 Orcs!");
        System.out.println("The Orc is in leather armor");
        Enemy enemy = db.createEnemy(1);
        battle(enemy);
    }

    public void room168Battle(){
        System.out.println("You encountered a 2 Orcs!");
        System.out.println("The first is a Man-sized, warfaced Orc Cheiftian with a nasty whip");
        System.out.println("The second is a whimpering Orc Servant that is smaller than a average orc and has a wooden stick\n");
        Enemy enemy = db.createEnemy(4);
        battle(enemy);
    }

    public void battle(Enemy enemy){
        boolean flee = false;
        System.out.println("You engage in combat against the enemy! Choose what you will do: ");

        while (player.getCurrentStamina() > 0 && enemy.getCurrentStamina() > 0 && !flee) {
            System.out.println("1: attack\n" +
                    "2: heal\n" +
                    "3: flee");

            Scanner input = new Scanner(System.in);
            try {
                int battle = input.nextInt();

                if ( battle > 0 && battle < 4 ){

                    switch (battle) {
                        case 1:
                            int playerAttackPower = 0;
                            int enemyAttackPower = 0;

                            classDice.setDiceCount(2);
                            playerAttackPower = player.getCurrentSkill() + classDice.Dice(0);
                            System.out.println("players attack Strength is " + playerAttackPower);
                            System.out.println();

                            classDice.setDiceCount(2);
                            enemyAttackPower = enemy.getCurrentSkill() + classDice.Dice(0);
                            System.out.println("enemy attack Strength is " + enemyAttackPower);
                            System.out.println();

                            if (playerAttackPower > enemyAttackPower) {
                                enemy.setCurrentStamina(enemy.getCurrentStamina() - 2);
                                System.out.println("You wounded the enemy and it takes 2 damage!" + " Enemy current Stamina: " + enemy.getCurrentStamina());

                            } else if (playerAttackPower < enemyAttackPower) {
                                player.setCurrentStamina(player.getCurrentStamina() - 2);
                                System.out.println("You got wounded by the enemy and takes 2 damage!" + " current Stamina: " + player.getCurrentStamina());
                                
                            } else if (playerAttackPower == enemyAttackPower) {
                                System.out.println("Both you and your enemy attack got blocked!");
                            }
                            if (player.getCurrentStamina() <= 0) {
                                System.out.println("You lost the battle against the enemy and died!\n");
                                gameOver();
                            }
                            if (enemy.getCurrentStamina() <= 0) {
                                System.out.println("You won the battle against the enemy and survived!");
                            }
                            break;

                        case 2:
                            System.out.println("heal!");
                            //use potion, either stamina, skill or luck potion
                            break;

                        case 3:
                            System.out.println("flee!");
                            flee = true;
                            player.setCurrentStamina(player.getCurrentStamina() - 2);
                            System.out.println("Due to fleeing your current stamina decreased by two. Current stamina: " + player.getCurrentStamina());
                            //take 2 dmg and return to r0
                            //player getMap(0) -2 stamina
                            playerFlee(getPlayer());
                            break;
                    }
                }
                else {
                    System.out.println("please input a number");
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void playerFlee(Actor anActor) {
        moveActorTo(anActor, map.get(0));
    }

    public void gameOver(){
            System.out.println(" _______                            _______                   \n" +
                    "|     __|.---.-.--------.-----.    |       |.--.--.-----.----.\n" +
                    "|    |  ||  _  |        |  -__|    |   -   ||  |  |  -__|   _|\n" +
                    "|_______||___._|__|__|__|_____|    |_______| \\___/|_____|__|");
        System.exit(0);
    }

    // player and chest
    public Actor getPlayer() {
        return player;
    }
    public void setPlayer(Actor aPlayer) {
        player = aPlayer;
    }


    // take and drop
    private void transferOb(Thing t, ThingList fromlist, ThingList tolist) {
        fromlist.remove(t);
        tolist.add(t);
    }

    //her bliver items fjernet fra rummet i starten af spillet ang. potions
    private void removeOb(ThingList removelist) {
        removelist.clear();
    }

    //Her bruger du dine items og potions
    private void useTheOb(Thing t, ThingList uselist) {

        //for potions
        if (t.getCharges() < 2) {
            System.out.println("you still got charges");
            if (choseSkillPotion == true) {
                t.setMaxSkill(player.getMaxSkill());
                player.setCurrentSkill(t.getMaxSkill());
                choseSkillPotion = false;
                System.out.println("skill = true");
                t.setCharges(t.getCharges()+1);
            } else if (choseStrengthPotion == true) {
                t.setMaxStamina(player.getMaxStamina());
                player.setCurrentStamina(t.getMaxStamina());
                choseStrengthPotion = false;
                System.out.println("Strength = true");
                t.setCharges(t.getCharges()+1);
            } else if (choseFortunePotion == true) {
                player.setMaxLuck(player.getMaxLuck()+1);
                t.setMaxLuck(player.getMaxLuck());
                player.setCurrentLuck(t.getMaxLuck());
                choseFortunePotion = false;
                System.out.println("Fortune = true");
                t.setCharges(t.getCharges()+1);
            }
            //charges for potions
        } if (t.getCharges() == 2){
            uselist.remove(t);
        }
        //todo andre items som shield

    }

    //her tager du dine items
    public String takeOb(String obname) {
        String retStr = "";
        Thing t = player.getRoom().getThings().thisOb(obname);

        if (obname.equals("")) {
            obname = "nameless object"; // if no object specified
        }
        if (t == null) {
            retStr = "There is no " + obname + " here!";
        } else if (potionChoice != true){
            transferOb(t, player.getRoom().getThings(), player.getThings());
            retStr = obname + " taken!";
        } else if  (potionChoice == true){
            transferOb(t, player.getRoom().getThings(), player.getThings());
            removeOb(player.getRoom().getThings());
            potionChoice = false;

            retStr = obname + " taken!";
        }
        return retStr;
    }

    //her dropper du dine items
    public String dropOb(String obname) {
        String retStr = "";
        Thing t = player.getThings().thisOb(obname);
        if (obname.equals("")) {
            retStr = "You'll have to tell me which object you want to drop!"; // if no object specified
        } else if (t == null) {
            retStr = "You haven't got one of those!";
        } else {
            transferOb(t, player.getThings(), player.getRoom().getThings());
            retStr = obname + " dropped!";
        }
        return retStr;
    }

    //her åbner du chests og boxes
    public String openOb(String obname) {

        //todo Chest system er ikke færdigt og denne klasse skal bruges til det
        String retStr = "";
        Thing t = player.getThings().thisOb(obname);
        if (obname.equals("")) {
            retStr = "You'll have to tell me which object you want to open!"; // if no object specified
        } else if (t == null) {
            retStr = "You haven't got one of those!";
        } else {
            transferOb(t, player.getThings(), player.getRoom().getThings());
            retStr = obname + " opened!";
        }
        return retStr;
    }

    //her bruger du dine items og derefter kalder use useTheOb
    public String useOb(String obname) {
        String retStr = "";
        Thing t = player.getThings().thisOb(obname);

        if (obname.equals("")) {
            obname = "nameless object"; // if no object specified
        }
        if (t == null) {
            retStr = "There is no " + obname + " here!";
        }
        else if (obname.equals("skillpotion")){
           // transferOb(t, treasureChest.getThings(), player.getRoom().getThings());
            choseSkillPotion = true;
            useTheOb(t, player.getThings());
        }
        else if (obname.equals("strengthpotion")){
            // transferOb(t, treasureChest.getThings(), player.getRoom().getThings());
            choseStrengthPotion = true;
            useTheOb(t, player.getThings());
        }
        else if (obname.equals("fortunepotion")){
            // transferOb(t, treasureChest.getThings(), player.getRoom().getThings());
            choseFortunePotion = true;
            useTheOb(t, player.getThings());
        }
        return retStr;
    }

    // move a the player to a Room
    public void moveActorTo(Actor p, Room aRoom) {
        p.setRoom(aRoom);
    }

    // move an Actor in direction 'dir'
    int moveTo(Actor anActor, Direction dir) {
        // return: Constant representing the room number moved to
        // or NOEXIT
        // try to move any Person (typically but not necessarily player)
        // in direction indicated by dir
        Room r = anActor.getRoom();
        int exit;

        switch (dir) {
            case NORTH:
                exit = r.getN();
                break;
            case SOUTH:
                exit = r.getS();
                break;
            case EAST:
                exit = r.getE();
                break;
            case WEST:
                exit = r.getW();
                break;
            default:
                exit = Direction.NOEXIT; // noexit - stay in same room
                break;
        }
        if (exit != Direction.NOEXIT) {
            moveActorTo(anActor, map.get(exit));
        }
        return exit;
    }

    public int movePlayerTo(Direction dir) {
        // return: Constant representing the room number moved to
        // or NOEXIT (see moveTo())
        //
        return moveTo(player, dir);
    }

    private void goN() {
        showRoomDescription(movePlayerTo(Direction.NORTH));
    }

    private void goS() {
        showRoomDescription(movePlayerTo(Direction.SOUTH));
    }

    private void goW() {
        showRoomDescription(movePlayerTo(Direction.WEST));
    }

    private void goE() {
        showRoomDescription(movePlayerTo(Direction.EAST));
    }

    private void look() {
        showStr("You are in the " + getPlayer().getRoom().describe());
    }

    private void showStr(String s) {
        System.out.println(s);
        System.out.println(" ");
        //Checks scenario that affects stats
        checkStatsBasedOnScenario();
    }

    private void showRoomDescription(int roomNumber) {
        // if roomNumber = NOEXIT, display a special message, otherwise
        // display text (e.g. name and description of room)
        String s;
        if (roomNumber == Direction.NOEXIT) {
            s = "No Exit!";
        }
        else if (describeRoomWithoutItems == true){
            Room r = getPlayer().getRoom();
            s = "You are in the " + r.describeRoomWithoutItems()
                    + "\nWhere do you want to go? [Enter n, s, w or e]?\n"
                    + "(or enter q to quit)";

            describeRoomWithoutItems = false;
        }
        else {
            Room r = getPlayer().getRoom();
            s = "You are in the " + r.describe();
        }
        showStr(s);
    }

    private void showInventory() {
        showStr("You have " + getPlayer().getThings().describeThings());
        //showStr("You have " + getPlayer().getThings().toString() );
    }

    private void intro() {
        String s;
        s = "The mountain looks menacing. The steep face looks to have been savaged by claws of some gargantuan beast.\n" +
                "Sharp rocky crags jut out at unnatural angles.\n" +
                "At the top of the mountain, is eerie red colored, which has given the mountain its name.\n" +
                "Across the clearing is a dark cave entrance\n";
        showStr(s);
    }

//virker, men skal bruges senere
    /*private void testYourLuck() {
        System.out.println("It's time to test your luck!");
        System.out.println("Remember, your current luck decreases each time you rely on it!");

        classDice.setDiceCount(2);
        if (classDice.Dice(0) <= player.getCurrentLuck()) {
            System.out.println("Lucky!");

        } else {
            System.out.println("Unlucky!");

        }
        player.setCurrentLuck(player.getCurrentLuck() - 1);
        System.out.println("Your current luck is " + player.getCurrentLuck());
    }*/

    public String processVerb(List<String> wordlist) {
        String verb;
        String msg = "";
        verb = wordlist.get(0);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        } else {
            switch (verb) {
                case "n":
                    goN();
                    break;
                case "s":
                    goS();
                    break;
                case "w":
                    goW();
                    break;
                case "e":
                    goE();
                    break;
                case "l":
                case "look":
                    look();
                    break;
                case "inventory":
                case "i":
                    showInventory();
                    break;
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    public String processVerbNoun(List<String> wordlist) {
        String verb;
        String noun;
        String msg = "";
        boolean error = false;
        verb = wordlist.get(0);
        noun = wordlist.get(1);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
            error = true;
        }
        if (!objects.contains(noun)) {
            msg += (noun + " is not a known noun!");
            error = true;
        }
        if (!error) {
            switch (verb) {
                case "take":
                    msg = takeOb(noun);
                    break;
                case "drop":
                    msg = dropOb(noun);
                    break;
                case "open":
                    msg = openOb(noun);
                    break;
                case "use":
                    msg = useOb(noun);
                    break;
                default:
                    msg += " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    public String parseCommand(List<String> wordlist) {
        String msg;
        if (wordlist.size() == 1) {
            msg = processVerb(wordlist);
        } else if (wordlist.size() == 2) {
            msg = processVerbNoun(wordlist);
        } else {
            msg = "Only 2 word commands allowed!";
        }
        return msg;
    }

    public List<String> wordList(String input) {
        String delims = " \t,.:;?!'\"\\";
        List<String> strlist = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        String t;

        while (tokenizer.hasMoreTokens()) {
            t = tokenizer.nextToken();
            strlist.add(t);
        }
        return strlist;
    }

    public void showIntro() {
        //title
        System.out.println("  ________            _       __           __           __            ____   _______           __                 __  ___                  __        _     \n" +
                " /_  __/ /_  ___     | |     / /___ ______/ /___  _____/ /__   ____  / __/  / ____(_)_______  / /_____  ____     /  |/  /___  __  ______  / /_____ _(_)___ \n" +
                "  / / / __ \\/ _ \\    | | /| / / __ `/ ___/ / __ \\/ ___/ //_/  / __ \\/ /_   / /_  / / ___/ _ \\/ __/ __ \\/ __ \\   / /|_/ / __ \\/ / / / __ \\/ __/ __ `/ / __ \\\n" +
                " / / / / / /  __/    | |/ |/ / /_/ / /  / / /_/ / /__/ ,<    / /_/ / __/  / __/ / / /  /  __/ /_/ /_/ / /_/ /  / /  / / /_/ / /_/ / / / / /_/ /_/ / / / / /\n" +
                "/_/ /_/ /_/\\___/     |__/|__/\\__,_/_/  /_/\\____/\\___/_/|_|   \\____/_/    /_/   /_/_/   \\___/\\__/\\____/ .___/  /_/  /_/\\____/\\__,_/_/ /_/\\__/\\__,_/_/_/ /_/ \n" +
                "                                                                                                    /_/                                                    ");

        ///intro med dice og stats
        intro();
        System.out.println("Lets roll your skill, stamina & luck stats! We'll start with skill");
        classDice.setDiceCount(1);
        player.setMaxSkill(classDice.Dice(6));
        player.setCurrentSkill(player.getMaxSkill());
        System.out.println("Added up result: " + (player.getMaxSkill()) + "\n");

        System.out.println("Then let's roll your stamina!");
        classDice.setDiceCount(2);
        player.setMaxStamina(classDice.Dice(12));
        player.setCurrentStamina(player.getMaxStamina());
        System.out.println("Added up result: " + (player.getMaxStamina()) + "\n");

        System.out.println("Last, but not least, your luck!");
        classDice.setDiceCount(1);
        player.setMaxLuck(classDice.Dice(6));
        player.setCurrentLuck(player.getMaxLuck());
        System.out.println("Added up result: " + (player.getMaxLuck()));

        System.out.println(" ");
        System.out.println("Your current skill is: " + player.getMaxSkill() + "\nYour current Stamina is: " + player.getMaxStamina() + "\nYour current Luck is: " + player.getMaxLuck());
        System.out.println(" ");

        showRoomDescription(0);

        //potion options
        System.out.println("Before you explore further into the dungeon, you must take a potion of your choice. Choose wisely, for the ones you don't chose, will disappear!");
        System.out.println("the Potion of Skill! Returns your skill to former heights!");
        System.out.println("the Potion of Strength! Reforges your constitution, and returns your stamina!");
        System.out.println("the Potion of Fortune! Even Felix Felicis didn't feel this lucky!" );
        System.out.println("No Potion? for the brave and the foolish alike! \n");
    }

    public String runCommand(String inputstr) {
        List<String> wordlist;
        String s = " _______                            _______                   \n" +
                "|     __|.---.-.--------.-----.    |       |.--.--.-----.----.\n" +
                "|    |  ||  _  |        |  -__|    |   -   ||  |  |  -__|   _|\n" +
                "|_______||___._|__|__|__|_____|    |_______| \\___/|_____|__|";
        String lowstr = inputstr.trim().toLowerCase();
        if (!lowstr.equals("q")) {
            if (lowstr.equals("")) {
                s = "You must enter a command";
            } else {
                wordlist = wordList(lowstr);
                s = parseCommand(wordlist);
            }
        }
        return s;
    }
}