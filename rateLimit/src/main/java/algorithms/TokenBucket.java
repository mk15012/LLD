package algorithms;

public class TokenBucket implements RateLimitter {

    private final long maxBucketSize;
    private final double refillRate;
    private double currentBucketSize;
    private long lastRefillTimeStamp;

    public TokenBucket(long maxBucketSize, double refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        currentBucketSize = maxBucketSize;
        lastRefillTimeStamp = System.nanoTime();
    }

    @Override
    public synchronized boolean allowRequest() {
        refill();
        if (currentBucketSize >= 1) {
            currentBucketSize -= 1;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        double tokensToAdd = (now - lastRefillTimeStamp) * refillRate / 1e9;
        System.out.print("Before refilled : " + currentBucketSize + ", ");
        currentBucketSize = Math.min(currentBucketSize + tokensToAdd, maxBucketSize);
        System.out.println("After refilled : " + currentBucketSize);
        lastRefillTimeStamp = now;
    }
}
