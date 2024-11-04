package com.example.stickareer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.stickareer.oauth2.OAuth2Client;

@SpringBootTest
@ActiveProfiles("test")
class StickareerApplicationTests {

	@MockBean
	private OAuth2Client oAuth2Client;

	@Test
	void contextLoads() {
	}

}
