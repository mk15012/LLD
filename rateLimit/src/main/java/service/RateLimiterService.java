package service;

import algorithms.RateLimitter;
import algorithms.TokenBucket;
import entry.ThrotleRule;

import java.util.HashMap;

public class RateLimiterService {

    HashMap<String, ThrotleRule> clientRulesCache;
    HashMap<String, RateLimitter> rateLimiterHashMap;

    public RateLimiterService() {
        this.clientRulesCache = new HashMap<>();
        this.rateLimiterHashMap = new HashMap<>();
    }

    public boolean isRateLimitedUserRequest(String userId) {
        createUserIfNotTheir(userId);
        return rateLimiterHashMap.get(userId).allowRequest();
    }

    private void createUserIfNotTheir(String userId) {
        if (!clientRulesCache.containsKey(userId)) {
            ThrotleRule clientRules = new ThrotleRule();
            clientRulesCache.put(userId, clientRules);
        }
        if (!rateLimiterHashMap.containsKey(userId)) {
            ThrotleRule throtleRule = clientRulesCache.get(userId);
            RateLimitter rateLimiter = new TokenBucket(throtleRule.getBucketSize(), throtleRule.getRefillRate());
            rateLimiterHashMap.put(userId, rateLimiter);
        }
    }
}