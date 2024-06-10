/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringsTests {
    @ParameterizedTest(name = "[{index}] \"{0}\" is a null or empty string")
    @NullSource
    @ValueSource(strings = { "" })
    public void isNullOrEmpty_withNullOrEmptyInput_shouldBeTrue(String input) {
        assertTrue(Strings.isNullOrEmpty(input));
    }

    @ParameterizedTest(name = "[{index}] \"{0}\" is not an empty string")
    @ValueSource(strings = { " ", "  ", "\n", "foo", "bar", "baz" })
    public void isNullOrEmpty_withNonEmptyInput_shouldBeFalse(String input) {
        assertFalse(Strings.isNullOrEmpty(input));
    }

    @ParameterizedTest(name = "[{index}] \"{0}\" is a null or blank string")
    @NullSource
    @ValueSource(strings = { "", " ", "  ", "\n" })
    public void isNullOrBlank_withNullOrBlankInput_shouldBeTrue(String input) {
        assertTrue(Strings.isNullOrBlank(input));
    }

    @ParameterizedTest(name = "[{index}] \"{0}\" is not a blank string")
    @ValueSource(strings = { "foo", "bar", "baz" })
    public void isNullOrBlank_withNonBlankInput_shouldBeFalse(String input) {
        assertFalse(Strings.isNullOrBlank(input));
    }

    @ParameterizedTest(name = "[{index}] \"{0}\" is a disallowed blank string")
    @NullSource
    @ValueSource(strings = { "", " ", "  ", "\n" })
    public void requireNonBlank_withNullOrBlankInput_shouldThrowException(String input) {
        var message = "input `" + input + "` must not be blank";
        assertThrowsExactly(IllegalArgumentException.class, () -> Strings.requireNonBlank(input, message), message);
    }

    @ParameterizedTest(name = "[{index}] \"{0}\" is not a blank string")
    @ValueSource(strings = { "foo", "bar", "baz" })
    public void requireNonBlank_withNonBlankInput_shouldPassThroughValue(String input) {
        var output = assertDoesNotThrow(() -> Strings.requireNonBlank(input, "input must not be blank"));
        assertEquals(input, output);
    }

    @ParameterizedTest(name = "[{index}] \"{0}\" in snake case should be \"{1}\"")
    @CsvSource({
        "camelCase, camel_case",
        "PascalCase, pascal_case",
        "snake_case, snake_case",
        "SHOUTY_SNAKE, shouty_snake",
        "kebab-case, kebab_case",
        "SHOUTY-KEBAB, shouty_kebab",
        "dot.separated, dot_separated",
        "colon:separated, colon_separated",
        "oneword, oneword",
        "Spaced out, spaced_out" })
    public void toSnakeCase_shouldReturnSnakeCaseOfInput(String input, String expected) {
        var output = Strings.toSnakeCase(input);
        assertEquals(expected, output);
    }

    @ParameterizedTest(name = "[{index}] \"{0}\" in camel case should be \"{1}\"")
    @CsvSource({
        "camelCase, camelCase",
        "PascalCase, pascalCase",
        "snake_case, snakeCase",
        "SHOUTY_SNAKE, shoutySnake",
        "kebab-case, kebabCase",
        "SHOUTY-KEBAB, shoutyKebab",
        "dot.separated, dotSeparated",
        "colon:separated, colonSeparated",
        "oneword, oneword",
        "Spaced out, spacedOut" })
    public void toCamelCase_shouldReturnCamelCaseOfInput(String input, String expected) {
        var output = Strings.toCamelCase(input);
        assertEquals(expected, output);
    }

    @ParameterizedTest(name = "[{index}] \"{0}\" in pascal case should be \"{1}\"")
    @CsvSource({
        "camelCase, CamelCase",
        "PascalCase, PascalCase",
        "snake_case, SnakeCase",
        "SHOUTY_SNAKE, ShoutySnake",
        "kebab-case, KebabCase",
        "SHOUTY-KEBAB, ShoutyKebab",
        "dot.separated, DotSeparated",
        "colon:separated, ColonSeparated",
        "oneword, Oneword",
        "Spaced out, SpacedOut" })
    public void toPascalCase_shouldReturnPascalCaseOfInput(String input, String expected) {
        var output = Strings.toPascalCase(input);
        assertEquals(expected, output);
    }
}
