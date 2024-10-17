package uz.bunyodbek;

import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyBotService {

    // faqat methodlar yoziladi

    public SendMessage sendMessage(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Xush kelibsiz ");
        return sendMessage;
    }

    public SendPhoto sendPhoto(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://images.app.goo.gl/iuiDjXUprdSNKbTq7"));

        // sendPhoto.setPhoto(new InputFile(new File("C:\\Users\\PDP Junior Sergeli\\Pictures\\Screenshots\\12.png")));

        sendPhoto.setCaption("Bu siz google dan olgan rasm ");
        sendPhoto.setParseMode(ParseMode.HTML);

        return sendPhoto;
    }

    public SendDocument sendDocument(Long chatId){

        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        sendDocument.setDocument(new InputFile(new File("C:\\Users\\PDP Junior Sergeli\\Downloads\\Telegram Desktop\\Akvarium.pdf")));
        sendDocument.setCaption("Bu sizning faylingiz ");

        return sendDocument;
    }

    public SendLocation sendLocation(Long chatId){
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);
        sendLocation.setLatitude(41.2685416);
        sendLocation.setLongitude(69.2231923);
        return sendLocation;
    }

    public SendMessage sendMessageReply(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(" Manzilingizni jo'nating ");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();

        KeyboardButton button = new KeyboardButton();
        button.setText("Share Location");
        button.setRequestLocation(true);
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;

    }

    public SendMessage sendMessageInline(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Tanlang ");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row= new ArrayList<>();
        List<List<InlineKeyboardButton>> rowList= new ArrayList<>();


        InlineKeyboardButton button = new InlineKeyboardButton();

        button.setText("|InlineButton");
        button.setCallbackData("inlineButtonid");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;

    }


    public InlineKeyboardMarkup sendMessageEdit(Long chatId){
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(chatId);
        sendMessage.setText("O'zgartirildi ");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row= new ArrayList<>();
        List<List<InlineKeyboardButton>> rowList= new ArrayList<>();

        InlineKeyboardButton button = new InlineKeyboardButton();

        button.setText("Video");
        button.setCallbackData("videoid");
        row.add(button);

        rowList.add(row);

        row= new ArrayList<>();
        button= new InlineKeyboardButton();
        button.setText("Photo");
        button.setCallbackData("photoId");
        row.add(button);
        rowList.add(row);


        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;

    }










}
