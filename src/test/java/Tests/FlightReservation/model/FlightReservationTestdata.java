package Tests.FlightReservation.model;

public record FlightReservationTestdata( String firstName,
         String lastName,
         String email,
         String password,
         String street,
         String city,
         String zip,
         String passengersCount,
         String expectedPrice) {
}
