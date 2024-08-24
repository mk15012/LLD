import service.RateLimiterService;

public class RateLimitApplication {

    public static void main(String[] args) throws InterruptedException {

        RateLimiterService rateLimiterService = new RateLimiterService();

        for (int i = 0; i < 10; i++) {
            System.out.println("Request for client 1 : " + rateLimiterService.isRateLimitedUserRequest("client1"));
            System.out.println("Request for client 2 : " + rateLimiterService.isRateLimitedUserRequest("client2"));
            System.out.println("Request for client 3 : " + rateLimiterService.isRateLimitedUserRequest("client3"));
            System.out.println("Request for client 4 : " + rateLimiterService.isRateLimitedUserRequest("client4"));
            System.out.println("Request for client 5 : " + rateLimiterService.isRateLimitedUserRequest("client5"));
        }

    }
}
