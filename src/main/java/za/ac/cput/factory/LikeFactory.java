package za.ac.cput.factory;

import za.ac.cput.domain.user.Like;
import za.ac.cput.domain.user.UserProfile;

import java.time.LocalDateTime;

public class LikeFactory {
//    public static Like buildLike(String likeis, String likerid, String likedid, LocalDateTime liked_at) {
//        if (Helper.isNullOrEmpty(likeis) || Helper.isNullOrEmpty(likerid) || Helper.isNullOrEmpty(likedid) || Helper.isNullOrEmpty(String.valueOf(liked_at)))
//            return null;
//        return new Like.Builder().setLikeID(likeis).setLikerID(likerid).setLikedID(likedid).setLiked_at(liked_at).build();
//    }
//
//    public static Like buildLike(LocalDateTime liked_at) {
//        if (Helper.isNullOrEmpty(String.valueOf(liked_at)))
//            return null;
//        String likeis = Helper.generateId();
//        String likerid = Helper.generateId();
//        String likedid = Helper.generateId();
//        return new Like.Builder().setLikeID(likeis).setLikerID(likerid).setLikedID(likedid).setLiked_at(liked_at).build();
//
//    }

    public static Like buildLikeWithoutID(UserProfile liker, UserProfile likedProfile, LocalDateTime likedAt) {
        if (liker == null || likedProfile == null || likedAt == null)
            return null;

        return new Like.Builder()
                .setLiker(liker)
                .setLikedProfile(likedProfile)
                .setLikedAt(likedAt)
                .build();
    }
}
