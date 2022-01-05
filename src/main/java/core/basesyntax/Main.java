package core.basesyntax;

import core.basesyntax.exception.AuthenticationException;
import core.basesyntax.lib.Injector;
import core.basesyntax.model.CinemaHall;
import core.basesyntax.model.Movie;
import core.basesyntax.model.MovieSession;
import core.basesyntax.model.ShoppingCart;
import core.basesyntax.model.User;
import core.basesyntax.security.AuthenticationService;
import core.basesyntax.service.CinemaHallService;
import core.basesyntax.service.MovieService;
import core.basesyntax.service.MovieSessionService;
import core.basesyntax.service.OrderService;
import core.basesyntax.service.ShoppingCartService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static final Injector injector = Injector.getInstance("core.basesyntax");

    public static void main(String[] args) {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);

        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);
        System.out.println(movieService.get(fastAndFurious.getId()));
        movieService.getAll().forEach(System.out::println);

        CinemaHall firstCinemaHall = new CinemaHall();
        firstCinemaHall.setCapacity(100);
        firstCinemaHall.setDescription("first hall with capacity 100");

        CinemaHall secondCinemaHall = new CinemaHall();
        secondCinemaHall.setCapacity(200);
        secondCinemaHall.setDescription("second hall with capacity 200");

        CinemaHallService cinemaHallService =
                (CinemaHallService) injector.getInstance(CinemaHallService.class);
        cinemaHallService.add(firstCinemaHall);
        cinemaHallService.add(secondCinemaHall);

        System.out.println(cinemaHallService.getAll());
        System.out.println(cinemaHallService.get(firstCinemaHall.getId()));

        MovieSession tomorrowMovieSession = new MovieSession();
        tomorrowMovieSession.setCinemaHall(firstCinemaHall);
        tomorrowMovieSession.setMovie(fastAndFurious);
        tomorrowMovieSession.setShowTime(LocalDateTime.now().plusDays(1L));

        MovieSession yesterdayMovieSession = new MovieSession();
        yesterdayMovieSession.setCinemaHall(firstCinemaHall);
        yesterdayMovieSession.setMovie(fastAndFurious);
        yesterdayMovieSession.setShowTime(LocalDateTime.now().minusDays(1L));

        MovieSessionService movieSessionService =
                (MovieSessionService) injector.getInstance(MovieSessionService.class);
        movieSessionService.add(tomorrowMovieSession);
        movieSessionService.add(yesterdayMovieSession);

        System.out.println(movieSessionService.get(yesterdayMovieSession.getId()));
        System.out.println(movieSessionService.findAvailableSessions(
                fastAndFurious.getId(), LocalDate.now()));

        AuthenticationService authService
                = (AuthenticationService) injector.getInstance(AuthenticationService.class);
        authService.register("bob123@gmail.com", "bob_password");
        User bob;
        try {
            bob = authService.login("bob123@gmail.com", "bob_password");
            System.out.println(bob);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        ShoppingCartService shoppingCartService
                = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        shoppingCartService.addSession(tomorrowMovieSession, bob);
        System.out.println(shoppingCartService.getByUser(bob));
        shoppingCartService.addSession(yesterdayMovieSession, bob);
        ShoppingCart bobShoppingCart = shoppingCartService.getByUser(bob);
        System.out.println(bobShoppingCart);

        OrderService orderService = (OrderService) injector.getInstance(OrderService.class);
        orderService.completeOrder(bobShoppingCart);
        orderService.getOrdersHistory(bob).forEach(System.out::println);
    }
}
