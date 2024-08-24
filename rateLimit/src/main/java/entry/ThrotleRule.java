package entry;

import static constants.RateLimitConstant.MAX_BUCKET_SIZE;
import static constants.RateLimitConstant.REFILL_RATE;

public class ThrotleRule {
    public long bucketSize;
    public double refillRate;

    public ThrotleRule() {
        this.bucketSize = MAX_BUCKET_SIZE;
        this.refillRate = REFILL_RATE;
    }

    public ThrotleRule(long bucketSize, long refillRate) {
        this.bucketSize = bucketSize;
        this.refillRate = refillRate;
    }

    public long getBucketSize() {
        return bucketSize;
    }

    public double getRefillRate() {
        return refillRate;
    }
}