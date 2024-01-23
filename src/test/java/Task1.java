import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Task1 {

    protected final String SEARCH_INPUT =  "Я люблю тестування";
    protected final HashMap<String, String[]> DICTIONARY_MAP = new HashMap<>();
    protected final String INPUT_LOCATOR = "textarea";
    protected final String OUTPUT_LOCATOR = "span.ryNqvb";
    protected final int THREAD_SLEEP = 4000;

    @BeforeClass
    public void setTestValues() {
        DICTIONARY_MAP.put("English", new String[]{
                        "https://translate.google.com/?sl=uk&tl=en&op=translate",
                        "I love testing"});
        DICTIONARY_MAP.put("Spanish", new String[]{
                        "https://translate.google.com/?sl=uk&tl=es&op=translate",
                        "Me encanta las pruebas"});
        DICTIONARY_MAP.put("Polish", new String[]{
                        "https://translate.google.com/?sl=uk&tl=pl&op=translate",
                        "Uwielbiam testowanie"});
        DICTIONARY_MAP.put("Portuguese", new String[]{
                        "https://translate.google.com/?sl=uk&tl=pt&op=translate",
                        "Eu amo testar"});
        DICTIONARY_MAP.put("Romanian", new String[]{
                        "https://translate.google.com/?sl=uk&tl=ro&op=translate",
                        "Îmi place testarea"});
        DICTIONARY_MAP.put("Japanese", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=ja&op=translate",
                        "テストが大好きです"});
        DICTIONARY_MAP.put("Italian", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=it&op=translate",
                        "Adoro i test"});
        DICTIONARY_MAP.put("Serbian", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=sr&op=translate",
                        "Волим тестирање"});
        DICTIONARY_MAP.put("German", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=de&op=translate",
                        "Ich liebe es zu testen"});
        DICTIONARY_MAP.put("Slovak", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=sk&op=translate",
                        "Milujem testovanie"});
        DICTIONARY_MAP.put("Netherland", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=nl&op=translate",
                        "Ik hou van testen"});
        DICTIONARY_MAP.put("Sweden", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=sv&op=translate",
                        "Jag älskar att testa"});
        DICTIONARY_MAP.put("Turkish", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=tr&op=translate",
                        "Testi seviyorum"});
        DICTIONARY_MAP.put("Iceland", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=is&op=translate",
                        "Ég elska að prófa"});
        DICTIONARY_MAP.put("Greek", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=el&op=translate",
                        "Λατρεύω τις δοκιμές"});
        DICTIONARY_MAP.put("Thai", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=th&op=translate",
                        "ฉันรักการทดสอบ"});
        DICTIONARY_MAP.put("Georgian", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=ka&op=translate",
                        "მე მიყვარს ტესტირება"});
        DICTIONARY_MAP.put("Nepal", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=ne&op=translate",
                        "मलाई परीक्षण मन पर्छ"});
        DICTIONARY_MAP.put("Mongolia", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=mn&op=translate",
                        "Би туршилтанд дуртай"});
        DICTIONARY_MAP.put("Estonia", new String[]{
                        "https://translate.google.com/?hl=uk&sl=uk&tl=et&op=translate",
                        "Ma armastan testimist"});

    }

    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }

    @Test
    public void checkUaToEnTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("English")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("English")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToSpTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Spanish")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Spanish")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToPlTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Polish")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Polish")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToPtTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Portuguese")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Portuguese")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToRoTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Romanian")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Romanian")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToJaTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Japanese")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Japanese")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToItTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Italian")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Italian")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToSrTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Serbian")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Serbian")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToDeTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("German")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("German")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToSkTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Slovak")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Slovak")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToNlTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Netherland")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Netherland")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToSwTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Sweden")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Sweden")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToTrTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Turkish")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Turkish")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToIsTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Iceland")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Iceland")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToElTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Greek")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Greek")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToThTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Thai")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Thai")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToKaTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Georgian")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Georgian")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToNeTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Nepal")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Nepal")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToMnTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Mongolia")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Mongolia")[1]));
        Thread.sleep(3000);
    }

    @Test
    public void checkUaToEtTranslate() throws InterruptedException {
        Selenide.open(DICTIONARY_MAP.get("Estonia")[0]);
        Selenide.$(INPUT_LOCATOR).setValue(SEARCH_INPUT).pressEnter();
        Thread.sleep(3000);
        Selenide.$(OUTPUT_LOCATOR).shouldHave(Condition.text(DICTIONARY_MAP.get("Estonia")[1]));
        Thread.sleep(3000);
    }
}