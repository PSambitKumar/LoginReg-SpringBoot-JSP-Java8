package com.sambit.Utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 17/10/2022 - 8:32 PM
 */
public class GenerateUUID {
	private static long get64LeastSignificantBitsForVersion1() {
		Random random = new Random();
		long random63BitLong = random.nextLong() & 0x3FFFFFFFFFFFFFFFL;
		long variant3BitFlag = 0x8000000000000000L;
		return random63BitLong + variant3BitFlag;
	}

	private static long get64MostSignificantBitsForVersion1() {
		LocalDateTime start = LocalDateTime.of(1582, 10, 15, 0, 0, 0);
		Duration duration = Duration.between(start, LocalDateTime.now());
		long seconds = duration.getSeconds();
		long nanos = duration.getNano();
		long timeForUuidIn100Nanos = seconds * 10000000 + nanos * 100;
		long least12SignificantBitOfTime = (timeForUuidIn100Nanos & 0x000000000000FFFFL) >> 4;
		long version = 1 << 12;
		return
			   (timeForUuidIn100Nanos & 0xFFFFFFFFFFFF0000L) + version + least12SignificantBitOfTime;
	}

	public static String getUUID() {
		long mostSignificantBits = get64MostSignificantBitsForVersion1();
		long leastSignificantBits = get64LeastSignificantBitsForVersion1();
		return String.format("%016X%016X", mostSignificantBits, leastSignificantBits);
	}

	private static String getUUIDForVersion4() {
		Random random = new Random();
		long random64BitLong = random.nextLong();
		long variant3BitFlag = 0x8000000000000000L;
		long version4BitFlag = 0x4000000000000000L;
		return String.format("%016X%016X", random64BitLong + variant3BitFlag + version4BitFlag, random64BitLong);
	}

	private static UUID getUUIDForVersion4UsingUUIDClass() {
		return UUID.randomUUID();
	}

	public static void main(String[] args) {
		System.out.println(getUUID());
		System.out.println(getUUIDForVersion4());
		System.out.println(getUUIDForVersion4UsingUUIDClass());
	}
}
