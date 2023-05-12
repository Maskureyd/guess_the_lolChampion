import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"Aatrox", "Ahri", "Akali", "Akshan", "Alistar", "Amumu", "Anivia", "Annie", "Aphelios", "Ashe",
                "Aurelion Sol", "Azir", "Bard", "BelVeth", "Blitzcrank", "Brand", "Braum", "Caitlyn", "Camille",
                "Cassiopeia", "ChoGath", "Corki", "Darius", "Diana", "Dr Mundo", "Draven", "Ekko", "Elise", "Evelynn",
                "Ezreal", "Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank", "Garen", "Gnar", "Gragas", "Graves",
                "Gwen", "Hecarim", "Heimerdinger", "Illaoi", "Irelia", "Ivern", "Janna", "Jarvan IV", "Jax", "Jayce",
                "Jhin", "Jinx", "KSante", "KaiSa", "Kalista", "Karma", "Karthus", "Kassadin", "Katarina", "Kayle",
                "Kayn", "Kennen", "KhaZix", "Kindred", "Kled", "KogMaw", "LeBlanc", "Lee Sin", "Leona", "Lillia",
                "Lissandra", "Lucian", "Lulu", "Lux", "Malphite", "Malzahar", "Maokai", "Master Yi", "Miss Fortune",
                "Mordekaiser", "Morgana", "Nami", "Nasus", "Nautilus", "Neeko", "Nidalee", "Nilah", "Nocturne", "Nunu",
                "Olaf", "Orianna", "Ornn", "Pantheon", "Poppy", "Pyke", "Qiyana", "Quinn", "Rakan", "Rammus", "RekSai",
                "Rell", "Renata Glasc", "Renekton", "Rengar", "Riven", "Rumble", "Ryze", "Samira", "Sejuani", "Senna",
                "Seraphine", "Sett", "Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sona", "Soraka",
                "Swain", "Sylas", "Syndra", "Tahm Kench", "Taliyah", "Talon", "Taric", "Teemo", "Thresh", "Tristana",
                "Trundle", "Tryndamere", "Twisted Fate", "Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar",
                "VelKoz", "Vex", "Vi", "Viego", "Viktor", "Vladimir", "Volibear", "Warwick", "Wukong", "Xayah", "Xerath",
                "Xin Zhao", "Yasuo", "Yone", "Yorick", "Yuumi", "Zac", "Zed", "Zeri", "Ziggs", "Zilean", "Zoe", "Zyra"};
        String selectedWord = words[random.nextInt(words.length)];
        int hintNumber = Arrays.asList(words).indexOf(selectedWord);
        String[] hints = {"Karanlık", "Tilki", "Gizli", "Diriltici", "Boynuz", "Hüzün", "Buz", "Cadı", "Silahşör",
                "Okçu", "Ejderha", "Kum", "Müzisyen", "Hiçlik", "Robot", "Alev", "Kalkan", "Nişancı", "Bacak", "Yılan",
                "Hiçlik", "Pilot", "Baltalı", "Ay", "Deli", "Gösteriş", "Zaman", "Örümcek", "Suikastçı", "Kaşif",
                "Korku", "Dövüş", "Deniz", "Taş", "Korsan", "Şövalye", "Vahşi", "Sarhoş", "Kovboy", "Bez Bebek",
                "Süvari", "Dahi", "Tanrı", "Bıçak", "Ağaç", "Rüzgar", "Asil", "Gizemli", "Bilimkurgu", "Obsesif",
                "Çılgın", "Saldırgan", "Gizemli", "İntikam", "Dengeli", "Hayalet", "Hiçlik", "Suikastçı", "Adalet",
                "İkili Kişilik", "Elektrik", "Çekirge", "Kurt ve Kuzu", "Deli", "Bulldog", "Sahtekar", "Kör", "Güneş",
                "Uyku", "Buz", "Silah", "Pıtırcık", "Işık", "Kaya", "Hiçlik", "Ağaç", "Kılıç", "Silah", "Zırh",
                "Karanlık", "Su", "Köpek", "Astronot", "Kamuflaj", "Panther", "Neşeli", "Kabus", "Yeti", "Öfkeli",
                "Robot", "Cehennem", "Savaşçı", "Çekiç", "Suikastçı", "Element", "Kartal", "Dansçı", "Zırhlı",
                "Hiçlik", "Zırh", "Büyücü", "Timsah", "Avcı", "Kılıç", "Mekanik", "Büyücü", "Keskin", "Soğuk",
                "Ruh", "Müzik", "Dövüşçü", "Palyaço", "Ninja", "Ejderha", "Zehir", "Ölümsüz", "Bumerang", "Akrep",
                "Sihir", "İyileştirici", "Kuzgun", "Devrim", "Güç", "Yamyam", "Toprak", "Bıçak", "Yakut", "Mantar",
                "Zincir", "Bomba", "Troll", "Öfkeli", "Büyücü", "Fare", "Hayvan", "Makine", "Okçu", "Avcı", "Büyücü",
                "Göz", "Gölge", "Yumruk", "Mahvolmuş", "Dahi", "Kan", "Ayı", "Kurt", "Maymun", "Kuş", "Enerji",
                "Savaşçı", "Rüzgar", "Kılıç", "Mezar", "Kedi", "Jöle", "Ninja", "Elektrik", "Patlayıcı", "Zaman",
                "Rüya", "Bitki"};
        String selectedHint = hints[hintNumber];
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
            System.out.println("İpucu: " + selectedHint);
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
            } else if (String.valueOf(guessedWord).equals(selectedWord.toLowerCase())) {
                System.out.println("Tebrikler, " + selectedWord + " cevabını buldunuz!");
                System.out.println("Kazandığınız puan: " + totalScore);
                break;
            } else {
                System.out.println("Doğru harf tahmin ettiniz, devam edin ve cevabı bulmaya çalışın.");
            }

            if (totalScore > 0) {
                System.out.println("Şampiyon Adı : " + String.valueOf(guessedWord));
                System.out.println("Toplam puanınız: " + totalScore);

            }

            if (totalScore == 0) {
                int remainingAttempts = 3;
                for (int i = 0; i < 3; i++) {
                    System.out.println("Bu turdan puan alamayacaksınız. Cevabı tahmin etmeniz için " + remainingAttempts + " hakkınız kaldı.");
                    System.out.println("İpucu: " + selectedHint);
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

                    int correctGuessCount = 0;

                    for (int j = 0; j < selectedWord.length(); j++) {
                        if (Character.toLowerCase(selectedWord.charAt(j)) == guessedLetter) {
                            guessedWord[j] = guessedLetter;
                            letterFound = true;
                            correctGuessCount++;
                        }
                    }

                    if (letterFound) {
                        System.out.println("Doğru harf tahmin ettiniz, devam edin ve cevabı bulmaya çalışın.");
                        System.out.println("Şampiyon Adı : " + String.valueOf(guessedWord));

                        if (correctGuessCount == selectedWord.length()) {
                            System.out.println("Tebrikler, " + selectedWord + " cevabını buldunuz!");
                            break;
                        }
                    } else {
                        remainingAttempts--;
                        System.out.println("Yanlış tahmin! Kalan tahmin hakkınız: " + remainingAttempts);
                        if (remainingAttempts == 0) {
                            System.out.println("Tahmin hakkınız kalmadı. Doğru cevap: " + selectedWord);
                            break;
                        }
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
