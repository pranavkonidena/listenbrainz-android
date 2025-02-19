package org.listenbrainz.android.repository.preferences

import kotlinx.coroutines.flow.Flow
import org.listenbrainz.android.model.Playable
import org.listenbrainz.android.model.UiMode
import org.listenbrainz.android.util.LinkedService

interface AppPreferences {
    
    suspend fun themePreference(): UiMode
    
    fun themePreferenceFlow(): Flow<UiMode>
    
    suspend fun setThemePreference(value: UiMode)
    
    /**
     *
     * [PermissionStatus.NOT_REQUESTED] -> permission not requested even once.
     *
     * [PermissionStatus.GRANTED]-> permission granted.
     *
     * [PermissionStatus.DENIED_ONCE] -> permission is denied once, user can be asked for permission again.
     *
     * [PermissionStatus.DENIED_TWICE] -> permission is denied twice and cannot be asked again. User need to go to settings to enable the permission.*/
    var permissionsPreference: String?

    /** Blacklist for ListenService.*/
    suspend fun getListeningBlacklist(): List<String>
    
    fun getListeningBlacklistFlow(): Flow<List<String>>
    
    suspend fun setListeningBlacklist(value: List<String>)
    
    /** Music Apps in users device registered by listenService.*/
    suspend fun getListeningApps(): List<String>
    
    fun getListeningAppsFlow(): Flow<List<String>>
    
    suspend fun setListeningApps(value: List<String>)

    var onboardingCompleted: Boolean
    
    suspend fun logoutUser()

    val version: String
    
    var currentPlayable : Playable?
    
    /* Login related preferences */
    fun getLoginStatusFlow(): Flow<Int>
    
    suspend fun isUserLoggedIn() : Boolean
    
    /****ListenBrainz User Token:** User has to manually fill this token.*/
    suspend fun getLbAccessToken(): String
    
    fun getLbAccessTokenFlow(): Flow<String>
    
    suspend fun setLbAccessToken(value: String)
    
    fun getUsernameFlow(): Flow<String>
    
    suspend fun getUsername(): String
    
    suspend fun setUsername(value: String?)
    
    val refreshToken: String?
    
    var linkedServices: List<LinkedService>

    val isNotificationServiceAllowed: Boolean

    var submitListens: Boolean
    
    /* BrainzPlayer Preferences */
    
    /** Used to tell the user that they don't have any albums on their device. */
    var albumsOnDevice: Boolean
    
    /** Used to tell the user that they don't have any songs on their device. */
    var songsOnDevice: Boolean
}