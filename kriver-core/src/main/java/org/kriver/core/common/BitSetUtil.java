package org.kriver.core.common;

import java.util.BitSet;

public class BitSetUtil {
	public static byte[] bitSet2ByteArray(BitSet bitSet) {
		if(bitSet == null){
			return null;
		}
		byte[] bytes = new byte[bitSet.size() / 8];
		for (int i = 0; i < bitSet.size(); i++) {
			int index = i / 8;
			int offset = 7 - i % 8;
			bytes[index] |= (bitSet.get(i) ? 1 : 0) << offset;
		}
		return bytes;
	}

	public static BitSet byteArray2BitSet(byte[] bytes) {
		if(bytes == null || bytes.length == 0){
			return null;
		}
		BitSet bitSet = new BitSet(bytes.length * 8);
		int index = 0;
		for (int i = 0; i < bytes.length; i++) {
			for (int j = 7; j >= 0; j--) {
				bitSet.set(index++, (bytes[i] & (1 << j)) >> j == 1 ? true
						: false);
			}
		}
		return bitSet;
	}
}
