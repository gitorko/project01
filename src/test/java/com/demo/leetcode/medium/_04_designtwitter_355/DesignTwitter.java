package com.demo.leetcode.medium._04_designtwitter_355;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [355. Design Twitter - MEDIUM](https://leetcode.com/problems/design-twitter/)
 *
 * - SIMILAR_TO: [23. Merge k Sorted Lists - HARD](https://leetcode.com/problems/merge-k-sorted-lists/)
 *
 * https://www.youtube.com/watch?v=pNichitDD2E&ab_channel=NeetCode
 */
public class DesignTwitter {

    @Test
    public void test1() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        Assertions.assertEquals(Arrays.asList(5), twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        Assertions.assertEquals(Arrays.asList(6, 5), twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        Assertions.assertEquals(Arrays.asList(5), twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }

    @Test
    public void test2() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        Assertions.assertEquals(Arrays.asList(1), twitter.getNewsFeed(1));
        twitter.follow(2, 1);
        Assertions.assertEquals(Arrays.asList(1), twitter.getNewsFeed(2));
        twitter.unfollow(2, 1);
        Assertions.assertEquals(Collections.emptyList(), twitter.getNewsFeed(2));
    }

    /**
     * Time: O(10*k) for news feed, k is number of users they follow.
     */
    class Twitter {
        private int timeStamp;
        //[userId, list of [timestamp, tweetId]
        private Map<Integer, List<Tweet>> tweetMap;
        //[follower, set of followee]
        private Map<Integer, Set<Integer>> followMap;

        public Twitter() {
            timeStamp = 0;
            tweetMap = new HashMap<>();
            followMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            tweetMap.putIfAbsent(userId, new ArrayList<>());
            tweetMap.get(userId).add(new Tweet(timeStamp, tweetId));
            timeStamp++;
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> result = new ArrayList<>();
            //max heap
            PriorityQueue<Feed> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
            followMap.putIfAbsent(userId, new HashSet<>());
            //add self as follower
            followMap.get(userId).add(userId);
            for (Integer followee : followMap.get(userId)) {
                if (!tweetMap.getOrDefault(followee, Collections.emptyList()).isEmpty()) {
                    //get the tweets from each followee
                    int index = tweetMap.get(followee).size() - 1;
                    Tweet t = tweetMap.get(followee).get(index);
                    pq.add(new Feed(t.time, t.tweetId, followee, index - 1));
                }
            }
            while (!pq.isEmpty() && result.size() < 10) {
                Feed feed = pq.poll();
                result.add(feed.tweetId);
                if (feed.nextIndex >= 0) {
                    Tweet t = tweetMap.get(feed.followeeId).get(feed.nextIndex);
                    pq.add(new Feed(t.time, t.tweetId, feed.followeeId, feed.nextIndex - 1));
                }
            }
            return result;
        }

        public void follow(int followerId, int followeeId) {
            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followMap.get(followerId) != null) {
                followMap.get(followerId).remove(followeeId);
            }
        }

        class Tweet {
            int time;
            int tweetId;

            public Tweet(int time, int tweetId) {
                this.time = time;
                this.tweetId = tweetId;
            }
        }

        class Feed {
            int time;
            int tweetId;
            int followeeId;
            int nextIndex;

            public Feed(int time, int tweetId, int followeeId, int nextIndex) {
                this.time = time;
                this.tweetId = tweetId;
                this.followeeId = followeeId;
                this.nextIndex = nextIndex;
            }
        }
    }
}
