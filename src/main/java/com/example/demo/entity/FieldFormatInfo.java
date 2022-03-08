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

package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import format.info.BasicFormatInfo;
import format.info.FormatInfoDeserializer;
import format.info.FormatInfoSerializer;

import java.io.Serializable;
import java.util.Objects;

/**
 * The format information for a table field.
 */
public class FieldFormatInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String FIELD_NAME = "name";
    private static final String FIELD_FORMAT = "format";


    /**
     * The name of the field.
     */
    @JsonProperty(FIELD_NAME)
    private String name;

    /**
     * The format of the field.
     */
    @JsonProperty(FIELD_FORMAT)
    @JsonSerialize(using = FormatInfoSerializer.class)
    private BasicFormatInfo<?> format;

    @JsonCreator
    public FieldFormatInfo(
        @JsonProperty(FIELD_NAME)
            String name,
        @JsonProperty(FIELD_FORMAT)
        @JsonDeserialize(using = FormatInfoDeserializer.class)
            BasicFormatInfo<?> format
    ) {
        this.name = name;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BasicFormatInfo<?> getFormat() {
        return format;
    }

    public void setFormat(BasicFormatInfo<?> format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FieldFormatInfo that = (FieldFormatInfo) o;
        return Objects.equals(name, that.name) &&
            Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, format);
    }

    @Override
    public String toString() {
        return "FieldFormatInfo{" +
            "name='" + name + '\'' +
            ", format=" + format +
            '}';
    }
}
