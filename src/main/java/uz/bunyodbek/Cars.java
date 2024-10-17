package uz.bunyodbek;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class Cars {


    public SendPhoto sendPhoto(Long chatId) {

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://images.app.goo.gl/o6rVM6tXt2wBzQDs7"));
        sendPhoto.setCaption(" Ranglardan birini tanlang ");


        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> row = new ArrayList<>();

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();


        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Sariq");
        button.setCallbackData("sariqId");
        row.add(button);
        rowList.add(row);


        button = new InlineKeyboardButton();

        button.setText("Qora");
        button.setCallbackData("qoraId");
        row.add(button);

        button = new InlineKeyboardButton();
        button.setText("Qizil");
        button.setCallbackData("qizilId");
        row.add(button);

        button = new InlineKeyboardButton();
        button.setText("Yashil");
        button.setCallbackData("yashilId");
        row.add(button);


        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public InlineKeyboardMarkup sendPhotoYashil(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://images.app.goo.gl/YmHYfFBhVAG9HYp58"));

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> row = new ArrayList<>();

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();


        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Sariq");
        button.setCallbackData("sariqId");
        row.add(button);
        rowList.add(row);


        button = new InlineKeyboardButton();

        button.setText("Qora");
        button.setCallbackData("qoraId");
        row.add(button);

        button = new InlineKeyboardButton();
        button.setText("Qizil");
        button.setCallbackData("qizilId");
        row.add(button);

        button = new InlineKeyboardButton();
        button.setText("Yashil");
        button.setCallbackData("yashilId");
        row.add(button);


        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public SendMessage Buttons(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(" Ranglardan birini tanlang ");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> row = new ArrayList<>();

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();


        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Sariq");
        button.setCallbackData("sariqId");
        row.add(button);
        rowList.add(row);


        button = new InlineKeyboardButton();

        button.setText("Qora");
        button.setCallbackData("qoraId");
        row.add(button);

        button = new InlineKeyboardButton();
        button.setText("Qizil");
        button.setCallbackData("qizilId");
        row.add(button);

        button = new InlineKeyboardButton();
        button.setText("Yashil");
        button.setCallbackData("yashilId");
        row.add(button);


        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

}
