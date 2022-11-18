package com.ll.exam;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AppTest {
	@Test
	void text() {
		int rs = 10 + 20;
		assertThat(rs).isEqualTo(30);
	}

}
