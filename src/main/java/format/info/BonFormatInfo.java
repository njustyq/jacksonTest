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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * The format information for data types.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(name = "int32", value = IntFormatInfo.class),
//	@JsonSubTypes.Type(name = "string", value = StringFormatInfo.class)
	@JsonSubTypes.Type(name = "string", value = StringFormatInfo.class),
	@JsonSubTypes.Type(name = "int", value = IntFormatInfo.class)
})
public interface BonFormatInfo extends Serializable {

	/**
	 * Returns the type represented by this format.
	 *
	 * @return the type represented by this format.
	 */
	@JsonIgnore
	TypeInfo getTypeInfo();
}
