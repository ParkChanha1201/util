package com.chcraft.util;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TokenChangerTest {

	@Test
	public void test() {
		String origin = "[CN] is class name, [PP] is package path";

		Map<String, String> tokenReplacement = new HashMap<>();
		tokenReplacement.put("[CN]", "TESTDAYO");
		tokenReplacement.put("[PP]", "OKMIENEN");

		String changed = TokenChanger.replaceToken(origin, tokenReplacement);

		assertEquals(true, "TESTDAYO is class name, OKMIENEN is package path".equals(changed));
	}

}
