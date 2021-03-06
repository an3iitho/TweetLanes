/*
 * Copyright (C) 2013 Chris Lacy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tweetalib.android.model;

import org.appdotnet4j.model.AdnUser;
import org.tweetalib.android.TwitterManager.ProfileImageSize;
import org.twitter4j.User;

public class TwitterUser {
	
	public TwitterUser(User user) {
		mId = user.getId();
		mScreenName = user.getScreenName();
		mName = user.getName();
		mDescription = user.getDescription();
		if (user.getLocation() != null && user.getLocation().equals("") == false) {
			mLocation = user.getLocation();
		}
		if (user.getURL() != null) {
			mUrl = user.getURL().toString();
		}
		
		mStatusesCount = user.getStatusesCount();
		mFriendsCount = user.getFriendsCount();
		mFollowersCount = user.getFollowersCount();
		mFavoritesCount = user.getFavouritesCount();
		mListedCount = user.getListedCount();
		mVerified = user.isVerified();
		mProtected = user.isProtected();
	}
	
	public TwitterUser(AdnUser user) {
		mId = user.mId;
		mScreenName = user.mUserName;
		mName = user.mName;
		mFollowersCount = user.mFollowersCount;
		mFriendsCount = user.mFollowingCount;
		mStatusesCount = user.mPostCount;
		mProfileImageUrl = user.mAvatarUrl;
		mCoverImageUrl = user.mCoverUrl;
		mDescription = user.mDescription;
	}

	public TwitterUser(TwitterUser user) {
		mId = user.getId();
		mScreenName = user.getScreenName();
		mName = user.getName();
		mDescription = user.getDescription();
		mLocation = user.getLocation();
		mUrl = user.getUrl();
		
		mStatusesCount = user.getStatusesCount();
		mFriendsCount = user.getFriendsCount();
		mFollowersCount = user.getFollowersCount();
		mFavoritesCount = user.getFavoritesCount();
		mListedCount = user.getListedCount();
		mVerified = user.getVerified();
		mProtected = user.getProtected();
	}

	public long		getId()				{ return mId; }
	public String 	getScreenName()		{ return mScreenName; }
	public String	getName()			{ return mName; }
	public String	getDescription()	{ return mDescription; }
	public String 	getCoverImageUrl()	{ return mCoverImageUrl; }
	public String	getLocation()		{ return mLocation; }
	public String	getUrl()			{ return mUrl; }
	public int		getStatusesCount()	{ return mStatusesCount; }
	public int		getFriendsCount()	{ return mFriendsCount; }
	public int 		getFollowersCount()	{ return mFollowersCount; }
	public int		getFavoritesCount()	{ return mFavoritesCount; }
	public int		getListedCount()	{ return mListedCount; }
	public boolean	getVerified()		{ return mVerified; }
	public boolean 	getProtected()		{ return mProtected; }
	
	public String 	getProfileImageUrl(ProfileImageSize size) {
		if (mProfileImageUrl != null) {
			return mProfileImageUrl;
		}	
		return getProfileImageUrl(mScreenName, size);
	}
	
	public static String getProfileImageUrl(String screenName, ProfileImageSize size) {
		return "https://api.twitter.com/1/users/profile_image/" + screenName + "?size=" + size.toString().toLowerCase();
	}
	
	private long 	mId;
	private String 	mScreenName;
	private String 	mName;
	private String 	mDescription;
	private String 	mProfileImageUrl;
	private String  mCoverImageUrl;
	private String	mLocation;
	private String	mUrl;
	private int 	mStatusesCount;
	private int 	mFriendsCount;
	private int		mFollowersCount;
	private int		mFavoritesCount;
	private int		mListedCount;
	private boolean	mVerified;
	private boolean mProtected; 
	
}
