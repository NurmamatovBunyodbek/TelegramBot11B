package uz.bunyodbek;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    private MyBotService myBotService= new MyBotService();

    private Cars cars= new Cars();

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()){

            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            String firstName = update.getMessage().getChat().getFirstName();
            String lastName = update.getMessage().getChat().getLastName();

            info(chatId,text,firstName,lastName);

//            if (text.equals("/start")){
//                SendMessage sendMessage = new SendMessage();
//                sendMessage.setText(" Xush kelibsiz ");
//                sendMessage.setChatId(chatId);
//                try {
//                    execute(sendMessage);
//                } catch (TelegramApiException e) {
//                    throw new RuntimeException(e);
//                }
//            }


            if (text.equals("/start")){
                try {
                    execute(myBotService.sendMessage(chatId));
                    execute(myBotService.sendMessageReply(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (text.equals("/photo")){
                try {
                    execute(myBotService.sendPhoto(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (text.equals("/document")){
                try {
                    execute(myBotService.sendDocument(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }

            if (text.equals("/location")){
                try {
                    execute(myBotService.sendLocation(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (text.equals("inline")){
                try {
                    execute(myBotService.sendMessageInline(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (text.equals("cars")){
                try {
                    execute(cars.sendPhoto(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }



        }else if (update.hasCallbackQuery()){
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();

            Long chatId = callbackQuery.getMessage().getChatId();
            System.out.println(data);

            /*if (data.equals("inlineButtonid")){
                try {
                    execute(myBotService.sendMessageReply(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }*/
           /* if (data.equals("inlineButtonid")){

                EditMessageReplyMarkup editMessageReplyMarkup = new EditMessageReplyMarkup();
                editMessageReplyMarkup.setChatId(chatId);
                editMessageReplyMarkup.setMessageId(callbackQuery.getMessage().getMessageId());
                editMessageReplyMarkup.setReplyMarkup(myBotService.sendMessageEdit(chatId));

                try {
                    execute(editMessageReplyMarkup);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }*/


            if (data.equals("inlineButtonid")){
                EditMessageText editMessageText = new EditMessageText();
                editMessageText.setChatId(chatId);
                editMessageText.setMessageId(callbackQuery.getMessage().getMessageId());
                editMessageText.setText("Malumot o'zgardi");

                try {
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("yashilId")){
                EditMessageMedia editMessageMedia = new EditMessageMedia();
                editMessageMedia.setChatId(chatId);
                editMessageMedia.setMessageId(callbackQuery.getMessage().getMessageId());
                editMessageMedia.setMedia(new InputMediaPhoto("https://images.app.goo.gl/YmHYfFBhVAG9HYp58"));
                try {
                    execute(editMessageMedia);
                    execute(cars.Buttons(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }




        }




    }

    @Override
    public String getBotUsername() {
        return "javatelegramBot11BBot";
    }

    @Override
    public String getBotToken() {
        return "7958317763:AAE83Vm2Pgmuup3DizemzsRB87YpDQyp5oI";
    }

    public void info(Long chatId , String text , String firstName , String lastName){

        System.out.println(" ChatID : "+  chatId +
                "\n" + " Text " + text + "\n" + " Firstname " + firstName + "\n" + " LastName "+ lastName);

    }


}
