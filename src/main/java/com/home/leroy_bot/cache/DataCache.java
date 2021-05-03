package com.home.leroy_bot.cache;


import com.home.leroy_bot.botapi.BotState;
import com.home.leroy_bot.botapi.handlers.fillingprofile.UserProfileData;

public interface DataCache {
    void setUsersCurrentBotState(long userId, BotState botState);

    BotState getUsersCurrentBotState(long userId);

    UserProfileData getUserProfileData(long userId);

    void saveUserProfileData(long userId, UserProfileData userProfileData);
}
