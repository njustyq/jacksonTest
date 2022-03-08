/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package format.info;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Bon type.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BonType2 {

	BYTE("byte", (byte) 0x01),
	INT32("int32", (byte) 0x02),
	UINT32("uint32", (byte) 0x03),
	INT64("int64", (byte) 0x04),
	UINT64("uint64", (byte) 0x05),
	DOUBLE("double", (byte) 0x06),
	STRING("string", (byte) 0x07),
	BINARY("binary", (byte) 0x08),
	OBJECT("object", (byte) 0x09),
	ARRAY("array", (byte) 0x10),
	NIL("nil", (byte) 100),
	UNKNOWN("unknown", (byte) 0xFF);

	private static final String FIELD_TYPE = "type";

	@JsonProperty(FIELD_TYPE)
	private final String type;

	private final byte value;

	BonType2(String type, byte value) {
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	@JsonIgnore
	public byte getValue() {
		return value;
	}

	@JsonCreator
	public static BonType2 fromType(@JsonProperty(FIELD_TYPE) String type) {
		for (BonType2 bonType : BonType2.values()) {
			if (bonType.getType().equalsIgnoreCase(type)) {
				return bonType;
			}
		}

		return BonType2.UNKNOWN;
	}

	public static BonType2 fromValue(byte value) {
		switch (value) {
			case 0x01:
				return BYTE;
			case 0x02:
				return INT32;
			case 0x03:
				return UINT32;
			case 0x04:
				return INT64;
			case 0x05:
				return UINT64;
			case 0x06:
				return DOUBLE;
			case 0x07:
				return STRING;
			case 0x08:
				return BINARY;
			case 0x09:
				return OBJECT;
			case 0x10:
				return ARRAY;
			case 100:
				return NIL;
			default:
				return UNKNOWN;
		}
	}

	public static void main(String[] args) throws JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(BonType2.UNKNOWN);
		System.out.println(json);

		BonType2 s = objectMapper.readValue(json,BonType2.class);
		System.out.println(s.toString());
	}

}
