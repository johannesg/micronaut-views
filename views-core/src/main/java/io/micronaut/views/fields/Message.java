/*
 * Copyright 2017-2023 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.views.fields;

import io.micronaut.core.annotation.NonNull;

import java.util.Objects;

public interface Message {

    /**
     *
     * @return The code
     */
    String getCode();

    /**
     *
     * @return The default message to use if no other message is found
     */
    String getDefaultMessage();


    @NonNull
    static Message of(@NonNull String code, @NonNull String defaultMessage) {
        return new SimpleMessage(code, defaultMessage);
    }
}
