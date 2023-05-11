import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"Aatrox", "Ahri", "Akali", "Alistar", "Amumu", "Anivia", "Annie", "Aphelios", "Ashe", "Aurelion Sol", "Azir", "Bard","BelVeth", "Blitzcrank", "Brand", "Braum",
                "Caitlyn", "Camille", "Cassiopeia", "ChoGath", "Corki", "Darius", "Diana", "Dr. Mundo", "Draven", "Ekko", "Elise", "Evelynn", "Ezreal", "Fiddlesticks", "Fiora",
                "Fizz", "Galio", "Gangplank", "Garen", "Gnar", "Gragas", "Graves", "Gwen", "Hecarim", "Heimerdinger", "Illaoi", "Irelia", "Ivern", "Janna", "Jarvan IV", "Jax",
                "Jayce", "Jhin", "Jinx","KSante", "KaiSa", "Kalista", "Karma", "Karthus", "Kassadin", "Katarina", "Kayle", "Kayn", "Kennen", "KhaZix", "Kindred", "Kled", "KogMaw",
                "LeBlanc", "Lee Sin", "Leona", "Lillia", "Lissandra", "Lucian", "Lulu", "Lux", "Malphite", "Malzahar", "Maokai", "Master Yi", "Miss Fortune", "Mordekaiser",
                "Morgana", "Nami", "Nasus", "Nautilus", "Neeko", "Nidalee", "Nilah","Nocturne", "Nunu", "Olaf", "Orianna", "Ornn", "Pantheon", "Poppy", "Pyke", "Qiyana", "Quinn",
                "Rakan", "Rammus", "RekSai", "Rell", "Renekton","Renata Glasc", "Rengar", "Riven", "Rumble", "Ryze", "Samira", "Sejuani", "Senna", "Seraphine", "Sett", "Shaco", "Shen",
                "Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sona", "Soraka", "Swain", "Sylas", "Syndra", "Tahm Kench", "Taliyah", "Talon", "Taric", "Teemo", "Thresh",
                "Tristana", "Trundle", "Tryndamere", "Twisted Fate", "Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar", "VelKoz", "Vi", "Viego", "Viktor", "Vladimir",
                "Volibear", "Warwick", "Wukong", "Xayah", "Xerath", "Xin Zhao", "Yasuo", "Yone", "Yorick", "Yuumi", "Zac", "Zed", "Ziggs", "Zilean", "Zoe","Zeri", "Zyra"};
        String selectedWord = words[random.nextInt(words.length)];

        char[] guessedWord = new char[selectedWord.length()];
        for (int i = 0; i < selectedWord.length(); i++) {
            guessedWord[i] = '-';
        }

        boolean wordGuessed = false;
        int startingScore = 100;
        int incorrectGuessPenalty = 10;
        int totalScore = startingScore;

        System.out.println("League of Legends Şampiyon Tahmin oyununa hoşgeldiniz.");

        while (!wordGuessed) {
            System.out.println("Tahmin etmek için bir harf girin: ");
            String userInput = scanner.next();

            if (userInput.length() != 1) {
                System.out.println("Lütfen sadece tek bir harf girin.");
                continue;
            }

            char guessedLetter = Character.toLowerCase(userInput.charAt(0));
            boolean letterFound = false;

            for (int i = 0; i < selectedWord.length(); i++) {
                if (Character.toLowerCase(selectedWord.charAt(i)) == guessedLetter) {
                    guessedWord[i] = guessedLetter;
                    letterFound = true;
                }
            }

            if (!letterFound) {
                totalScore -= incorrectGuessPenalty;
                System.out.println("Yanlış tahmin! -" + incorrectGuessPenalty + " puan. Toplam puanınız: " + totalScore);
            } else {
                System.out.println("Doğru harf tahmin ettiniz, devam edin ve cevabı bulmaya çalışın.");
            }

            if (totalScore > 0) {
                System.out.println("Şampiyon Adı : " + String.valueOf(guessedWord));
                System.out.println("Toplam puanınız: " + totalScore);
            }

            if (String.valueOf(guessedWord).equals(selectedWord.toLowerCase())) {
                System.out.println("Tebrikler! Şampiyonu doğru tahmin ettiniz.");
                System.out.println("Kazandığınız puan: " + totalScore);
                break;
            } else if (totalScore == 0) {
                int remainingAttempts = 3;
                for (int i = 0; i < 3; i++) {
                    System.out.println("Bu turdan puan alamayacaksınız. Cevabı tahmin etmeniz için " + remainingAttempts + " hakkınız kaldı.");
                    System.out.println("Şampiyon Adı : " + String.valueOf(guessedWord));
                    System.out.println("Lütfen bir harf girin: ");
                    userInput = scanner.next();

                    if (userInput.length() != 1) {
                        System.out.println("Lütfen sadece tek bir harf girin.");
                        i--;
                        remainingAttempts--;
                        continue;
                    }

                    guessedLetter = Character.toLowerCase(userInput.charAt(0));
                    letterFound = false;

                    for (int j = 0; j < selectedWord.length(); j++) {
                        if (Character.toLowerCase(selectedWord.charAt(j)) == guessedLetter) {
                            guessedWord[j] = guessedLetter;
                            letterFound = true;
                        }
                    }

                    if (letterFound) {
                        System.out.println("Doğru harf tahmin ettiniz, devam edin ve cevabı bulmaya çalışın.");
                        System.out.println("Şampiyon Adı : " + String.valueOf(guessedWord));
                        break;
                    } else {
                        remainingAttempts--;
                        System.out.println("Yanlış tahmin! Kalan tahmin hakkınız: " + remainingAttempts);
                    }
                }

                if (remainingAttempts == 0) {
                    totalScore -= 50;
                    System.out.println("Harf tahmin hakkınızı doldurdunuz ve şampiyonu bulamadınız. -50 puan. Toplam puanınız: " + totalScore);
                    break;
                }
            }
        }
    }
}
