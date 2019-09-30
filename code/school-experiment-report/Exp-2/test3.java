import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/*
    Bug 说明：
    当成语出现 DOuble WoRd 时，比如：人无完人 etc.
    此时 给用户的词语库将有 两个 "人" 字。
    而已知干扰字库并无和成语库重复的字，
    由此可知两个 "人" 字（两个字的词语）必为最终成语答案正确选项。
*/

public class test3 {
    public static void main(String[] args) {
        System.out.println("-- Test3 : Guessing the Idioms --");

        String[] idioms = { "心灰意冷", "百口莫辩", "执子之手", "与子偕老", "相濡以沫", "甜言蜜语", "朝思暮想", "心照不宣", "全力以赴", "来日方长" };
        String[] chars = { "王", "成", "一", "次", "有", "点", "久", "先", "说", "抱", "欠", "身", "羽", "多", "瓜", "位", "出", "机",
                "生", "时" };

        // new a object for Game
        Game game = new Game(idioms, chars);
        // Game running conditions
        game.detection();
    
        // Game goes on judgment
        int choose = 0;
        
        Scanner input = new Scanner(System.in);
        while (game.gameGoesOn()) {
            game.init();
            game.gameRunsTimeAddOne();
            boolean[] guessWordIndex = { false, false, false, false, false, false, false, false, false, false };
            System.out.println("\n游戏次数记录：<第" + game.getGameRunsTime() + "次>\n---");

            // get word
            char[] words = game.getWords();

            System.out.println("四字成语中包含的汉字如下：");
            for (int i = 0; i < game.getTotalWordNum(); i++) {
                System.out.print((i+1) + "." + words[i] + "; ");
            }
            System.out.println();

            // A time game
            game.showCurrentWord();
            System.out.print("剩余猜测次数为" + game.getRemainChance() + "次，请输入你的猜测：");
            boolean firstShow = false;
            while (! game.passGameDetection()) {
                if (game.remainChance()) {
                    if (firstShow) {
                        System.out.print("剩余猜测次数为" + game.getRemainChance() + "次，请再输入你的猜测：");
                    }
                    firstShow = true;
                    int guessNum = input.nextInt();
                    
                    // input instruction error
                    while (guessNum > game.getTotalWordNum() || guessNum <= 0) {
                        System.out.print("(序号错误，请重新输入1-" + game.getTotalWordNum() + ")：");
                        guessNum = input.nextInt();
                    }

                    // guess word
                    String guessWord = String.valueOf(words[guessNum-1]);
                    // guess right index
                    int guessRightIndex = -1;
                    // set guess index
                    
                    if (! guessWordIndex[guessNum - 1]) {
                        guessWordIndex[guessNum - 1] = true;
                    } else {
                        guessRightIndex = -2;
                    }
                    for (int i = 0; i < game.getIdiomWordNum(); i++) {
                        if (guessWord.equals(String.valueOf(game.getIdiom().charAt(i))) && ! game.ifWordGuessRight(i)) {
                            game.wordGuessRight(i);
                            guessRightIndex = i;
                        }
                    }
                    if (guessRightIndex != -1 && guessRightIndex != -2) {
                        game.showCurrentWord();
                        System.out.println("恭喜你，“" + game.getIdiom().charAt(guessRightIndex) + "”字在成语中的位置是：" + (guessRightIndex + 1));
                    } else if (guessRightIndex == -1) {
                        game.useOneChance();
                        System.out.print("对不起，“" + guessWord + "”字不在成语中，");
                    } else if (guessRightIndex == -2) {
                        game.useOneChance();
                        System.out.print("对不起，“" + guessWord + "”字你已经猜过了，");
                    }

                }
                
                // still have chance
                if (game.remainChance()) {
                    if (game.passGameDetection()) {
                        System.out.println("太棒了！你一共猜错了" + game.getUseChance() + "次，已经猜出了整个成语！");
                        game.gamePassTimeAddOne();
                    }
                } else {
                    System.out.println("，并且你已经Game Over了！");
                    game.passGame(true);
                    game.gameFailTimeAddOne();
                }
            }
            
            System.out.print("\n是否继续游戏？1.是 2.否（程序将直接退出）\n指令：");
            choose = input.nextInt();

            // input instruction error
            while (choose != 1 && choose != 2) {
                System.out.print("错误提醒：输入指令错误，请重新输入（1.是 2.否）\n指令：");
                choose = input.nextInt(); 
            }
            // game goes on judge
            if (choose == 2) {
                System.out.println("您一共进行了" + game.getGameRunsTime() + "次游戏，其中" + game.getGamePassTime() + "次游戏成功，" + game.getGameFailTime() + "次游戏失败（游戏已成功退出！）");
                game.exit();
            }

        }
        input.close();
    }
}

/**
 * Game
 */
class Game {
    // idiom Array
    private String[] idioms;
    // disrupted character Array
    private String[] chars;
    // the number of idiom's word
    private final int idiomWordNum = 4;
    // the number of distractions char
    private int disCharWordNum = 6;
    // the number of all(idiom's word and distractions char)
    private int totalWordNum = idiomWordNum + disCharWordNum;
    // current number of runs of the game
    private int gameRunsTime = 0;
    // current pass times of the game 
    private int gamePassTime = 0;
    // current fail times of the game
    private int gameFailTime = 0;
    // word guess right or not
    private boolean[] wordGuessRight = { false, false, false, false };

    // from idioms(String[]) choose one idiom(String)
    private String idiom;
    // from Chars choose char[]
    private char[] disChar = new char[disCharWordNum];
    // idiom's word and char[]'s word make up words[]
    private char[] words = new char[totalWordNum];

    // pass game or not
    private boolean passGame = false;
    // game chance
    private final int gameChance = 6;
    private int gameUseChance = 0;
    private int gameRemainChance = gameChance - gameUseChance;  

    // if game goes on
    private boolean gameGoesOn = true;

    // init Game
    public Game(String[] idioms, String[] chars) {
        this.idioms = idioms;
        this.chars = chars;
    }

    public void init() {
        for (int i = 0; i < idiomWordNum; i++) {
            wordGuessRight[i] = false;
        }
        gameUseChance = 0;
        gameRemainChance = gameChance - gameUseChance;
        passGame = false;
        getRandomDisChar();
        getRandomIdiom();
    }

    // word of idioms/chars rationality detection
    public void detection() {
        // extract chars' word
        HashSet<String> wordSet = new HashSet<>();
        for (String charWord : chars) {
            wordSet.add(charWord);
        }
        if (wordSet.size() != chars.length) {
            System.out.println("WARNING！！！错误提示：干扰数字项内部重复。\n（后台数据需要重新处理，程序已进行强制退出！）");
            System.exit(0);
        }
        for (String idiom : idioms) {
            // extract idioms' word
            for (int i = 0; i < idiom.length(); i++) {
                if (wordSet.contains(String.valueOf(idiom.charAt(i)))) {
                    System.out.println("WARNING！！！错误提示：干扰数字项出现在成语 <" + idiom + "> 之中，具体字为 <" + idiom.charAt(i) + "> 。\n（后台数据需要重新处理，程序已进行强制退出！）");
                    System.exit(0);
                }
            }
        }
    }

    // get disrupted character number
    public int getCharsWordNum() {
        return chars.length;
    }

    // get idiom number
    public int getIdiomWordNum() {
        return idiomWordNum;
    }

    // get total word number
    public int getTotalWordNum() {
        return totalWordNum;
    }

    // get random idiom from idioms
    public String getRandomIdiom() {
        Random random = new Random();
        idiom = idioms[random.nextInt(idioms.length)];
        return idiom;
    }

    // get idiom
    public String getIdiom() {
        try {
            return idiom;
        } catch (Exception e) {
            getRandomIdiom();
            return idiom;
        }
    }

    // get random char[] from chars
    public char[] getRandomDisChar() {
        // chars random index set
        HashSet<Integer> charIndexSet = new HashSet<>();
        int[] charIndex = new int[disCharWordNum];
        Random random = new Random();
        int index = 0;
        while (charIndexSet.size() != disCharWordNum) {
            index = random.nextInt(chars.length);
            if (!charIndexSet.contains(index)) {
                charIndex[charIndexSet.size()] = index;
                charIndexSet.add(index);
            }
        }
        for (int i = 0; i < disCharWordNum; i++) {
            disChar[i] = chars[charIndex[i]].charAt(0);
        }

        return disChar;
    }

    // get words[]
    public char[] getWords() {
        try {
            // character array
            for (int i = 0; i < totalWordNum; i++) {
                if (i < disCharWordNum) {
                    words[i] = disChar[i];    
                } else {
                    words[i] = idiom.charAt(i-disCharWordNum);
                }
            }
        } catch (Exception e) {
            getRandomIdiom();
            getRandomDisChar();
            // character array
            for (int i = 0; i < totalWordNum; i++) {
                if (i < disCharWordNum) {
                    words[i] = disChar[i];
                } else {
                    words[i] = idiom.charAt(i - disCharWordNum);
                }
            }
        }
        // disrupted character array
        String[] stringWords = new String[words.length];
        for (int i = 0; i < totalWordNum; i++) {
            stringWords[i] = String.valueOf(words[i]);
        }
        List<String> list = Arrays.asList(stringWords);
        Collections.shuffle(list);

        for (int i = 0; i < totalWordNum; i++) {
            words[i] = stringWords[i].charAt(0);
        }

        return words;
    }

    // get game runs time
    public int getGameRunsTime() {
        return gameRunsTime;
    }

    // game runs time + 1
    public void gameRunsTimeAddOne() {
        gameRunsTime += 1;
    }

    // get game pass time
    public int getGamePassTime() {
        return gamePassTime;
    }

    // game pass time + 1
    public void gamePassTimeAddOne() {
        gamePassTime += 1;
    }

    // get game fail time
    public int getGameFailTime() {
        return gameFailTime;
    }

    // game fail time + 1
    public void gameFailTimeAddOne() {
        gameFailTime += 1;
    }

    // pass game or not
    public void passGame(boolean ifPass) {
        passGame = ifPass;
    }

    // pass game detection
    public boolean passGameDetection() {
        if (passGame) {
            return true;
        } else {
            for (boolean gr : wordGuessRight) {
                if (! gr) {
                    return false;
                }
            }
        }
        return true;
    }

    // game use one chance
    public void useOneChance() {
        gameUseChance += 1;
        gameRemainChance -= 1;
    }

    // return game used chance
    public int getUseChance() {
        return gameUseChance;
    }

    // return game remain chance
    public int getRemainChance() {
        return gameRemainChance;
    }

    // if remain chance
    public boolean remainChance() {
        if (gameRemainChance > 0) {
            return true;
        } else {
            return false;
        }
    }

    // set word guess right index
    public void wordGuessRight(int index) {
        wordGuessRight[index] = true;
    }

    // if word guess right
    public boolean ifWordGuessRight(int index) {
        return wordGuessRight[index];
    }

    // show the current guess [○○○○]
    public void showCurrentWord() {
        System.out.print("[");
        for (int i = 0; i < idiomWordNum; i++) {
            if (wordGuessRight[i]) {
                System.out.print(idiom.charAt(i));
            } else {
                System.out.print("○");
                passGame = false;
            }
        }
        System.out.println("]");
    }

    // if game still goes on
    public boolean gameGoesOn() {
        return gameGoesOn;
    }

    // exit the game
    public void exit() {
        gameGoesOn = false;
    }

}