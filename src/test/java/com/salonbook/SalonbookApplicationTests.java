package com.salonbook;

import com.salonbook.entity.Bookings;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;

@SpringBootTest
class SalonbookApplicationTests {

    @Test
    void testBookingPost() {
        RestTemplate template = new RestTemplate();
        Bookings bookings = template.postForObject("http://localhost:8080/salon/bookings/create",
                new Bookings("2022-05-07", "Haircut", 1, 2), Bookings.class);
        assertNotNull(bookings);
        assertEquals(2,bookings.getUserId());
    }

}
